package com.zhijie.zmall.admin.vo;

import com.zhijie.zmall.commons.util.PageUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: RoleVO 值对象
 * @author: sangaizhi
 * @date: 2017-03-31 21:35:22
 */
public class RoleVO extends PageUtil implements Serializable {

    private static final long serialVersionUID = -5398004032931664084L;
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

    public AdminVO getCreateUser() {
        return createUser;
    }

    public void setCreateUser(AdminVO createUser) {
        this.createUser = createUser;
    }

    public AdminVO getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(AdminVO modifyUser) {
        this.modifyUser = modifyUser;
    }
}

