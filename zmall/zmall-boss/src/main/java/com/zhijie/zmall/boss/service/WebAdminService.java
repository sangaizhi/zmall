/**
 * 文件名称: WebAdminService
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
package com.zhijie.zmall.boss.service;

import com.zhijie.zmall.admin.vo.AdminVO;
import com.zhijie.zmall.commons.pojo.ZmallResult;

import java.util.List;

/**
 * @Name WebAdminService
 * @Author sangaizhi
 * @Date 2017/4/6  22:31
 * @Version 1.0
 */
public interface WebAdminService {

    /**
     * 保存管理员信息
     * @param adminVO 管理员
     * @return
     */
    int save(AdminVO adminVO,List<Long> roleIds);



    /**
     * 根据管理员邮箱或者电话查询管理员
     * @param account
     * @param type
     * @return
     */
    AdminVO getAdminByEmailOrPhone(String account, Short type);

    /**
     * 通过管理员账号核对管理员密码
     * @param account 账号
     * @param password 密码
     * @param type 账号类型
     * @return
     */
    Boolean checkAdminByAccount(String account, String password, Short type);



    ZmallResult adminLogin(String account,Short type, String password);


}
