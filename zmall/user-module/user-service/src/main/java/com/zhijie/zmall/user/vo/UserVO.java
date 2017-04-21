package com.zhijie.zmall.user.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: UserVO 值对象
 * @author: sangaizhi
 * @date: 2017-01-06 23:36:41
 */
public class UserVO implements Serializable {

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
     * 密码盐 
     */
    private String passwordSalt;
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
     * 用户等级，参考t_grade的id列 
     */
    private Long gradeId;
    /**
     * 状态 
     */
    private Short status;
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
    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getPasswordSalt() {
        return this.passwordSalt;
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
    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Long getGradeId() {
        return this.gradeId;
    }
    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getStatus() {
        return this.status;
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
}

