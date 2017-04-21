package com.zhijie.zmall.admin.qo;

import com.zhijie.zmall.commons.util.PageUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: RoleQO 查询对象
 * @author: sangaizhi
 * @date: 2017-03-31 21:35:22
 */
public class RoleQO extends PageUtil implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 备注
     */
    private String remark;

    
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
    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
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
