package com.zhijie.zmall.sso.service.impl;

import com.zhijie.zmall.commons.pojo.ZmallResult;
import com.zhijie.zmall.commons.util.JsonUtils;
import com.zhijie.zmall.sso.condition.UserQO;
import com.zhijie.zmall.sso.dao.JedisClient;
import com.zhijie.zmall.sso.dao.UserDao;
import com.zhijie.zmall.sso.enums.UserAccountTypeEnum;
import com.zhijie.zmall.sso.model.UserVO;
import com.zhijie.zmall.sso.service.UserService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * @Description: UserService 实现类
 * @author: sangaizhi
 * @date: 2017-03-28 22:51:09
 */
@Service
public class UserServiceImpl implements UserService {


    @Value("${REDIS_USER_INFO_SESSION_KEY}")
    private String REDIS_USER_INFO_SESSION_KEY;

    @Value("${REDIS_USER_INFO_SESSION_EXPIRE}")
    private Integer REDIS_USER_INFO_SESSION_EXPIRE;

    @Autowired
    private JedisClient jedisClient;

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public UserVO getById(Long id) {
        if (id == null) {
            return null;
        }
        return userDao.getById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public UserVO getByCondition(UserQO qo) {
        if (qo == null) {
            return null;
        }
        return userDao.getByCondition(qo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserVO> queryList(UserQO qo) {
        if (qo == null) {
            return null;
        }
        return userDao.queryList(qo);
    }

    @Override
    @Transactional(readOnly = true)
    public long count(UserQO qo) {
        if (qo == null) {
            return 0;
        }
        return userDao.count(qo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserVO> queryPage(UserQO qo) {
        if (qo == null) {
            return null;
        }
        return userDao.queryPage(qo);
    }

    @Override
    public int save(UserVO vo) {
        if (vo == null) {
            return 0;
        }
        vo.setPassword(DigestUtils.md5DigestAsHex(vo.getPassword().getBytes()));
        vo.setCreateTime(new Date());
        vo.setLastModifyTime(new Date());
        return userDao.save(vo);
    }

    @Override
    public int saveBatch(List<UserVO> voList) {
        if (CollectionUtils.isEmpty(voList)) {
            return 0;
        }
        for (UserVO vo : voList) {
            vo.setPassword(DigestUtils.md5DigestAsHex(vo.getPassword().getBytes()));
            vo.setCreateTime(new Date());
            vo.setLastModifyTime(new Date());
        }
        return userDao.saveBatch(voList);
    }

    @Override
    public int updateById(UserVO vo) {
        if (vo == null) {
            return 0;
        }
        return userDao.updateById(vo);
    }

    @Override
    public int deleteById(Long id) {
        if (id == null) {
            return 0;
        }
        return userDao.deleteById(id);
    }

    @Override
    public int deleteBatchByIds(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        return userDao.deleteBatchByIds(ids);
    }

    @Override
    @Transactional(readOnly = true)
    public UserVO getDetailById(Long id) {
        if (id == null) {
            return null;
        }
        return userDao.getDetailById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public UserVO getDetailByCondition(UserQO qo) {
        if (qo == null) {
            return null;
        }
        return userDao.getDetailByCondition(qo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserVO> queryDetailList(UserQO qo) {
        if (qo == null) {
            return null;
        }
        return userDao.queryDetailList(qo);
    }

    @Override
    @Transactional(readOnly = true)
    public long countDetail(UserQO qo) {
        if (qo == null) {
            return 0;
        }
        return userDao.countDetail(qo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserVO> queryDetailPage(UserQO qo) {
        if (qo == null) {
            return null;
        }
        return userDao.queryDetailPage(qo);
    }

    @Override
    public ZmallResult checkUserData(String param, Short type) {
        UserQO userQO = new UserQO();
        if (Objects.equals(type, UserAccountTypeEnum.EMAIL.getValue())) {
            userQO.setEmail(param);
        } else if (Objects.equals(type, UserAccountTypeEnum.NAME.getValue())) {
            userQO.setName(param);
        } else if (Objects.equals(type, UserAccountTypeEnum.PHONE.getValue())) {
            userQO.setPhone(param);
        }
        List<UserVO> list = this.queryList(userQO);
        if (CollectionUtils.isEmpty(list)) {
            return ZmallResult.ok(true);
        }
        return ZmallResult.ok(false);
    }

    @Override
    public ZmallResult userLogin(String username, String password, Short userAccountType) {
        if(null == userAccountType){
            userAccountType = UserAccountTypeEnum.NAME.getValue();
        }
        UserQO userQO = new UserQO();
        if(Objects.equals(userAccountType, UserAccountTypeEnum.NAME.getLabel())){
            userQO.setName(username);
        }else if(Objects.equals(userAccountType, UserAccountTypeEnum.PHONE.getLabel())){
            userQO.setPhone(username);
        }else if(Objects.equals(userAccountType, UserAccountTypeEnum.EMAIL.getLabel())){
            userQO.setEmail(username);
        }
        userQO.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        List<UserVO> list = this.queryList(userQO);
        if(CollectionUtils.isEmpty(list)){
            return ZmallResult.build(400, "用户名或密码错误");
        }
        UserVO user = list.get(0);
        // TODO 应考虑用户重复登录的情况，避免遭受恶意登录造成redis缓存无效用户数据
        //生成 token
        String token = UUID.randomUUID().toString();
        user.setPassword(null);
        jedisClient.set(REDIS_USER_INFO_SESSION_KEY + ":" + token, JsonUtils.objectToJson(user));
        jedisClient.expire(REDIS_USER_INFO_SESSION_KEY + ":" + token, REDIS_USER_INFO_SESSION_EXPIRE);
        return ZmallResult.ok(token);
    }

    @Override
    public ZmallResult getUserByToken(String token) {
        String userInfoJson = jedisClient.get(REDIS_USER_INFO_SESSION_KEY + ":" + token);
        if (StringUtils.isBlank(userInfoJson)) {
            return ZmallResult.build(400, "次session已经过期，请重新登录");
        }
        // 更新过期时间
        jedisClient.expire(REDIS_USER_INFO_SESSION_KEY + ":" + token, REDIS_USER_INFO_SESSION_EXPIRE);
        return ZmallResult.ok(JsonUtils.jsonToPojo(userInfoJson, UserVO.class));
    }

    @Override
    public ZmallResult userLogout(String token) {
        jedisClient.del(REDIS_USER_INFO_SESSION_KEY + ":" + token);
        return ZmallResult.ok();
    }
}
