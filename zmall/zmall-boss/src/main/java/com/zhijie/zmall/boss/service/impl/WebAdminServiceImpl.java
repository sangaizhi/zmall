/**
 * 文件名称: AdminServiceImpl
 * 系统名称: zmall
 * 模块名称:
 * 软件版权:
 * 功能说明:
 * 系统版本: 1.0.0.0
 * 开发人员: sangaizhi
 * 开发时间: 2017/4/6 22:31
 * 审核人员:
 * 相关文档:
 * 修改记录:
 * 修改日期:
 * 修改人员：
 * 修改说明：
 */

package com.zhijie.zmall.boss.service.impl;
import com.zhijie.zmall.admin.qo.AdminQO;
import com.zhijie.zmall.admin.service.AdminRoleService;
import com.zhijie.zmall.admin.service.AdminService;
import com.zhijie.zmall.admin.vo.AdminRoleVO;
import com.zhijie.zmall.admin.vo.AdminVO;
import com.zhijie.zmall.boss.redis.RedisCache;
import com.zhijie.zmall.boss.service.WebAdminService;
import com.zhijie.zmall.commons.constants.AccountTypeEnum;
import com.zhijie.zmall.commons.constants.AdminStatusEnum;
import com.zhijie.zmall.commons.constants.Constants;
import com.zhijie.zmall.commons.constants.EnableDisableEnum;
import com.zhijie.zmall.commons.exception.BusinessRuntimeException;
import com.zhijie.zmall.commons.pojo.ZmallResult;
import com.zhijie.zmall.commons.util.JsonUtils;
import com.zhijie.zmall.commons.util.validate.RegularUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.*;

/**
 * @author sangaizhi
 * @version 1.0
 * @name AdminServiceImpl
 * @date 2017/4/6  22:31
 */
@Service
public class WebAdminServiceImpl implements WebAdminService {

    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminRoleService adminRoleService;

    @Value("${ADMIN_LOCKED}")
    private String ADMIN_LOCKED; //锁定的key

    @Value("${ADMIN_LOCKED_TIME_LENGTH}")
    private String ADMIN_LOCKED_TIME_LENGTH; //锁定时间

    @Value("${ADMIN_FAIL_TIMES}")
    private String ADMIN_FAIL_TIMES; //失败次数

    @Value("${ADMIN_FAIL_TIMES_TO_LOCKED}")
    private String ADMIN_FAIL_TIMES_TO_LOCKED; //失败多少次会被锁定

    @Value("${ADMIN_INFO_SESSION_KEY}")
    private String ADMIN_INFO_SESSION_KEY; //admin 信息

    @Value("${ADMIN_INFO_SESSION_EXPIRE}")
    private String ADMIN_INFO_SESSION_EXPIRE; // admin 信息过期时长

    @Autowired
    private RedisCache redisCache;

    private Logger logger = LoggerFactory.getLogger(WebAdminServiceImpl.class);

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int save(AdminVO adminVO, List<Long> roleIds) {
        adminVO.setCreateTime(new Date());
        adminVO.setLastModifyTime(new Date());
        adminVO.setState(EnableDisableEnum.ENABLE.getValue());
        adminVO.setStatus(AdminStatusEnum.NOT_ACTIVATED.getValue());
        adminVO.setPassword(DigestUtils.md5DigestAsHex(adminVO.getPassword().getBytes()));
        int result = adminService.save(adminVO);
        if (null == adminVO.getId() && result > 0) {
            logger.error(Constants.LOG_EXCEPTION_MODEL, "新增管理员失败", JsonUtils.objectToJson(adminVO));
            throw new BusinessRuntimeException("", "新增管理员失败");
        }
        Long adminId = adminVO.getId();
        List<AdminRoleVO> adminRoleVOList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(roleIds)) {
            for (Long roleId : roleIds) {
                AdminRoleVO adminRoleVO = new AdminRoleVO();
                adminRoleVO.setAdminId(adminId);
                adminRoleVO.setRoleId(roleId);
                adminRoleVOList.add(adminRoleVO);
            }
        }
        if (CollectionUtils.isNotEmpty(adminRoleVOList)) {
            adminRoleService.saveBatch(adminRoleVOList);
        }
        return result;
    }

    @Override
    public AdminVO getAdminByEmailOrPhone(String account, Short type) {
        AdminQO adminQO = new AdminQO();
        if(Objects.equals(type, AccountTypeEnum.PHONE.getValue())){
            adminQO.setPhone(account);
        }else if(Objects.equals(type, AccountTypeEnum.EMAIL.getLabel())){
            adminQO.setEmail(account);
        }else{
            return  null;
        }
        List<AdminVO> adminVOList = adminService.queryList(adminQO);
        return CollectionUtils.isNotEmpty(adminVOList) ? adminVOList.get(0) : null;
    }

    @Override
    public Boolean checkAdminByAccount(String account, String password, Short type) {
        AdminQO adminQO = new AdminQO();
        if(RegularUtil.checkEmail(account)){
            adminQO.setEmail(account);
        }else if(RegularUtil.checkPhone(account)){
            adminQO.setPhone(account);
        }else{
            return false;
        }
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        adminQO.setPassword(md5Password);
        List<AdminVO> adminVOList = adminService.queryList(adminQO);
        return CollectionUtils.isNotEmpty(adminVOList);
    }

    @Override
    public ZmallResult adminLogin(String account,Short type, String password) {
        AdminVO adminVO = this.getAdminByEmailOrPhone(account, type);
        if (null == adminVO) {
            return ZmallResult.build(404, "用户名或密码错误");
        }
        Short state = adminVO.getState();
        if (Objects.equals(state, EnableDisableEnum.DISABLE.getValue())) {
            return ZmallResult.build(404, "账号被禁用");
        }
        AdminVO lockAdmin = redisCache.getCache(ADMIN_LOCKED + ":" + adminVO.getId(), AdminVO.class);
        if (null != lockAdmin) {
            return ZmallResult.build(404, "登录失败次数过多，已被锁定");
        }
        boolean valid = this.checkAdminByAccount(account, password, type);
        if (valid) {
            // 登录成功
            redisCache.deleteCache(ADMIN_LOCKED + ":" + adminVO.getId());
            redisCache.deleteCache(ADMIN_FAIL_TIMES + ":" + adminVO.getId());
            String token = UUID.randomUUID().toString();
            redisCache.putCacheWithExpireTime(ADMIN_INFO_SESSION_KEY + ":" + token, JsonUtils.objectToJson(adminVO), Long.valueOf(ADMIN_INFO_SESSION_EXPIRE));
            return ZmallResult.build(200, token);
        } else {
            // 登录失败
            Integer failTimes = redisCache.getCache(ADMIN_FAIL_TIMES + ":" + adminVO.getId(), Integer.class);
            if (null == failTimes) {
                redisCache.putCacheWithExpireTime(ADMIN_FAIL_TIMES + ":" + adminVO.getId(), 1, Long.valueOf(ADMIN_LOCKED_TIME_LENGTH));
            }else{
                int failtimes = failTimes;
                failtimes++;
                redisCache.putCacheWithExpireTime(ADMIN_FAIL_TIMES + ":" + adminVO.getId(), 1, Long.valueOf(ADMIN_LOCKED_TIME_LENGTH));
                int maxFailTimes = Integer.valueOf(ADMIN_FAIL_TIMES_TO_LOCKED);
                if(failtimes > maxFailTimes){
                    redisCache.put(ADMIN_LOCKED + ":" + adminVO.getId(), JsonUtils.objectToJson(adminVO));
                }
            }
            return ZmallResult.build(500, "用戶名或密码错误");
        }
    }

}
