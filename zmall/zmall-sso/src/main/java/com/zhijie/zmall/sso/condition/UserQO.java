package com.zhijie.zmall.sso.condition;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: UserQO 查询对象
 * @author: sangaizhi
 * @date: 2017-03-28 22:51:09
 */
public class UserQO implements Serializable {

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
     * 创建时间
     */
    private Date createTimeBegin;

    /**
     * 创建时间
     */
    private Date createTimeEnd;

    
    /**
     * 修改时间
     */
    private Date lastModifyTime;
    
    /**
     * 修改时间
     */
    private Date lastModifyTimeBegin;

    /**
     * 修改时间
     */
    private Date lastModifyTimeEnd;

    /**
     * 创建人的id
     */
    private Long createUserId;

    /**
     * 最后修改人的id
     */
    private Long lastModifyUserId;

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPasswordSalt() {
        return this.passwordSalt;
    }
    
    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }
    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public Short getState() {
        return this.state;
    }
    
    public void setState(Short state) {
        this.state = state;
    }
    public String getUserImg() {
        return this.userImg;
    }
    
    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }
    public Long getGradeId() {
        return this.gradeId;
    }
    
    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }
    public Short getStatus() {
        return this.status;
    }
    
    public void setStatus(Short status) {
        this.status = status;
    }
    public Date getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }  
    
    public Date getCreateTimeBegin() {
        return this.createTimeBegin;
    }
    
    public void setCreateTimeBegin(Date createTimeBegin) {
        this.createTimeBegin = createTimeBegin;
    }    
    
    public Date getCreateTimeEnd() {
        return this.createTimeEnd;
    }
    
    public void setCreateTimeEnd(Date createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }
    
    public Date getLastModifyTime() {
        return this.lastModifyTime;
    }
    
    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }  
    
    public Date getLastModifyTimeBegin() {
        return this.lastModifyTimeBegin;
    }
    
    public void setLastModifyTimeBegin(Date lastModifyTimeBegin) {
        this.lastModifyTimeBegin = lastModifyTimeBegin;
    }    
    
    public Date getLastModifyTimeEnd() {
        return this.lastModifyTimeEnd;
    }
    
    public void setLastModifyTimeEnd(Date lastModifyTimeEnd) {
        this.lastModifyTimeEnd = lastModifyTimeEnd;
    }
    
    public Long getCreateUserId() {
        return this.createUserId;
    }
    
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }
    public Long getLastModifyUserId() {
        return this.lastModifyUserId;
    }
    
    public void setLastModifyUserId(Long lastModifyUserId) {
        this.lastModifyUserId = lastModifyUserId;
    }
}
