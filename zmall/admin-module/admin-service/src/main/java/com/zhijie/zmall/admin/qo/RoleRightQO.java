package com.zhijie.zmall.admin.qo;

import java.io.Serializable;

/**
 * @Description: RoleRightQO 查询对象
 * @author: sangaizhi
 * @date: 2017-01-10 23:27:51
 */
public class RoleRightQO implements Serializable {

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

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public Long getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    public Long getRightId() {
        return this.rightId;
    }
    
    public void setRightId(Long rightId) {
        this.rightId = rightId;
    }
}
