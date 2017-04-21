package com.zhijie.zmall.category.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: ProductCategoryVO 值对象
 * @author: sangaizhi
 * @date: 2017-03-22 21:56:59
 */
public class ProductCategoryVO implements Serializable {

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
     * 编辑时间 
     */
    private Date editTime;
    /**
     * 创建人员ID 
     */
    private Long createUserId;
    /**
     * 编辑人员ID 
     */
    private Long editUserId;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getParentId() {
        return this.parentId;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setState(Short state) {
        this.state = state;
    }

    public Short getState() {
        return this.state;
    }
    public void setSort(Short sort) {
        this.sort = sort;
    }

    public Short getSort() {
        return this.sort;
    }
    public void setBoolParent(Short boolParent) {
        this.boolParent = boolParent;
    }

    public Short getBoolParent() {
        return this.boolParent;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return this.createTime;
    }
    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    public Date getEditTime() {
        return this.editTime;
    }
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Long getCreateUserId() {
        return this.createUserId;
    }
    public void setEditUserId(Long editUserId) {
        this.editUserId = editUserId;
    }

    public Long getEditUserId() {
        return this.editUserId;
    }
}

