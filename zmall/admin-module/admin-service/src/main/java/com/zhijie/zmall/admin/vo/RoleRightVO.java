package com.zhijie.zmall.admin.vo;

import java.io.Serializable;

/**
 * @Description: RoleRightVO 值对象
 * @author: sangaizhi
 * @date: 2017-01-10 23:27:51
 */
public class RoleRightVO implements Serializable {

    /**
     * 主键 
     */
    private Long id;
    /**
     * 角色id 
     */
    private Long roleId;
    /**
     * 权限id 
     */
    private Long rightId;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getRoleId() {
        return this.roleId;
    }
    public void setRightId(Long rightId) {
        this.rightId = rightId;
    }

    public Long getRightId() {
        return this.rightId;
    }
}

