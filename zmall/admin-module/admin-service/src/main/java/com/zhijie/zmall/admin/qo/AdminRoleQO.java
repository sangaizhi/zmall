package com.zhijie.zmall.admin.qo;

import java.io.Serializable;

/**
 * @Description: AdminRoleQO 查询对象
 * @author: sangaizhi
 * @date: 2017-03-31 21:37:44
 */
public class AdminRoleQO implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 管理员id
     */
    private Long adminId;

    /**
     * 角色id
     */
    private Long roleId;

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public Long getAdminId() {
        return this.adminId;
    }
    
    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }
    public Long getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
