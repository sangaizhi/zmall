package com.zhijie.zmall.category.qo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: ProductCategoryQO 查询对象
 * @author: sangaizhi
 * @date: 2017-03-22 21:56:59
 */
public class ProductCategoryQO implements Serializable {

    /**
     * 商品主键ID
     */
    private Long id;

    /**
     * 父分类ID
     */
    private Long parentId;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 分类状态，0：可用，1：不可用
     */
    private Short state;

    /**
     * 排序序号
     */
    private Short sort;

    /**
     * 是否是父分类，0 不是，1 是
     */
    private Short boolParent;

    
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
     * 编辑时间
     */
    private Date editTime;
    
    /**
     * 编辑时间
     */
    private Date editTimeBegin;

    /**
     * 编辑时间
     */
    private Date editTimeEnd;

    /**
     * 创建人员ID
     */
    private Long createUserId;

    /**
     * 编辑人员ID
     */
    private Long editUserId;

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public Long getParentId() {
        return this.parentId;
    }
    
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Short getState() {
        return this.state;
    }
    
    public void setState(Short state) {
        this.state = state;
    }
    public Short getSort() {
        return this.sort;
    }
    
    public void setSort(Short sort) {
        this.sort = sort;
    }
    public Short getBoolParent() {
        return this.boolParent;
    }
    
    public void setBoolParent(Short boolParent) {
        this.boolParent = boolParent;
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
    
    public Date getEditTime() {
        return this.editTime;
    }
    
    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }  
    
    public Date getEditTimeBegin() {
        return this.editTimeBegin;
    }
    
    public void setEditTimeBegin(Date editTimeBegin) {
        this.editTimeBegin = editTimeBegin;
    }    
    
    public Date getEditTimeEnd() {
        return this.editTimeEnd;
    }
    
    public void setEditTimeEnd(Date editTimeEnd) {
        this.editTimeEnd = editTimeEnd;
    }
    
    public Long getCreateUserId() {
        return this.createUserId;
    }
    
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }
    public Long getEditUserId() {
        return this.editUserId;
    }
    
    public void setEditUserId(Long editUserId) {
        this.editUserId = editUserId;
    }
}
