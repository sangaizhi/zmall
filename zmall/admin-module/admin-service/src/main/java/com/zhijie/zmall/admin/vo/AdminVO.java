package com.zhijie.zmall.admin.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @Description: AdminVO 值对象
 * @author: sangaizhi
 * @date: 2017-03-30 22:12:01
 */
public class AdminVO implements Serializable {

    private static final long serialVersionUID = -5179963752241724092L;
    /**
     * 主键id 
     */
    private Long id;
    /**
     * 用户名 
     */
    private String name;
    /**
     * 手机号 
     */
    private String phone;
    /**
     * 邮箱 
     */
    private String email;
    /**
     * 密码 
     */
    private String password;
    /**
     * 备注 
     */
    private String remark;
    /**
     * 0:启用，1：禁用，2删除 
     */
    private Short state;
    /**
     * 用户头像地址 
     */
    private String userImg;
    /**
     * 状态 
     */
    private Short status;

    private Short locked;
    /**
     * 创建时间 
     */
    private Date createTime;
    /**
     * 修改时间 
     */
    private Date lastModifyTime;
    /**
     * 创建人的id 
     */
    private Long createUserId;
    /**
     * 最后修改人的id 
     */
    private Long lastModifyUserId;

    // ================扩展字段
    private AdminVO createUser;

    private AdminVO modifyUser;

    private Set<Long> roleIdSet;

    private Set<RoleVO> roleSet;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return this.phone;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return this.remark;
    }
    public void setState(Short state) {
        this.state = state;
    }

    public Short getState() {
        return this.state;
    }
    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getUserImg() {
        return this.userImg;
    }
    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getStatus() {
        return this.status;
    }

    public Short getLocked() {
        return locked;
    }

    public void setLocked(Short locked) {
        this.locked = locked;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return this.createTime;
    }
    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public Date getLastModifyTime() {
        return this.lastModifyTime;
    }
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Long getCreateUserId() {
        return this.createUserId;
    }
    public void setLastModifyUserId(Long lastModifyUserId) {
        this.lastModifyUserId = lastModifyUserId;
    }

    public Long getLastModifyUserId() {
        return this.lastModifyUserId;
    }

    public AdminVO getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(AdminVO modifyUser) {
        this.modifyUser = modifyUser;
    }

    public AdminVO getCreateUser() {
        return createUser;
    }

    public void setCreateUser(AdminVO createUser) {
        this.createUser = createUser;
    }

    public Set<Long> getRoleIdSet() {
        return roleIdSet;
    }

    public void setRoleIdSet(Set<Long> roleIdSet) {
        this.roleIdSet = roleIdSet;
    }

    public Set<RoleVO> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<RoleVO> roleSet) {
        this.roleSet = roleSet;
    }
}

