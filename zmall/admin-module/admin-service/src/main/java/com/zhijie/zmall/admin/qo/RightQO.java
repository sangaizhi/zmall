package com.zhijie.zmall.admin.qo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: RightQO 查询对象
 * @author: sangaizhi
 * @date: 2017-01-10 23:16:18
 */
public class RightQO implements Serializable {

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
    public Long getCode() {
        return this.code;
    }
    
    public void setCode(Long code) {
        this.code = code;
    }
    public Integer getPos() {
        return this.pos;
    }
    
    public void setPos(Integer pos) {
        this.pos = pos;
    }
    public Long getUrl() {
        return this.url;
    }
    
    public void setUrl(Long url) {
        this.url = url;
    }
    public Long getModuleId() {
        return this.moduleId;
    }
    
    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }
    public Long getIconClass() {
        return this.iconClass;
    }
    
    public void setIconClass(Long iconClass) {
        this.iconClass = iconClass;
    }
    public Integer getOrderNumber() {
        return this.orderNumber;
    }
    
    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }
    public Short getType() {
        return this.type;
    }
    
    public void setType(Short type) {
        this.type = type;
    }
    public Long getParentId() {
        return this.parentId;
    }
    
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    public Short getCommon() {
        return this.common;
    }
    
    public void setCommon(Short common) {
        this.common = common;
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
