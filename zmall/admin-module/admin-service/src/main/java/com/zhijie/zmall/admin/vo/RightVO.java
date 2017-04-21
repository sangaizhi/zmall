package com.zhijie.zmall.admin.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: RightVO 值对象
 * @author: sangaizhi
 * @date: 2017-01-10 23:16:18
 */
public class RightVO implements Serializable {

    /**
     * 主键 
     */
    private Long id;
    /**
     * 权限名称 
     */
    private String name;
    /**
     * 权限代码 
     */
    private Long code;
    /**
     * 权限组 
     */
    private Integer pos;
    /**
     * 权限链接 
     */
    private Long url;
    /**
     * 所属模块的诶对 
     */
    private Long moduleId;
    /**
     * 图标的类名 
     */
    private Long iconClass;
    /**
     * 序号 
     */
    private Integer orderNumber;
    /**
     * 类型 
     */
    private Short type;
    /**
     * 父节点的id 
     */
    private Long parentId;
    /**
     * 是否是通用 
     */
    private Short common;
    /**
     * 描述 
     */
    private String remark;
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
    public void setCode(Long code) {
        this.code = code;
    }

    public Long getCode() {
        return this.code;
    }
    public void setPos(Integer pos) {
        this.pos = pos;
    }

    public Integer getPos() {
        return this.pos;
    }
    public void setUrl(Long url) {
        this.url = url;
    }

    public Long getUrl() {
        return this.url;
    }
    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public Long getModuleId() {
        return this.moduleId;
    }
    public void setIconClass(Long iconClass) {
        this.iconClass = iconClass;
    }

    public Long getIconClass() {
        return this.iconClass;
    }
    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getOrderNumber() {
        return this.orderNumber;
    }
    public void setType(Short type) {
        this.type = type;
    }

    public Short getType() {
        return this.type;
    }
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getParentId() {
        return this.parentId;
    }
    public void setCommon(Short common) {
        this.common = common;
    }

    public Short getCommon() {
        return this.common;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return this.remark;
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

