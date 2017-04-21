/**
 * 文件名称: AdminStatusEnum
 * 系统名称: zmall
 * 模块名称:
 * 软件版权:
 * 功能说明:
 * 系统版本: 1.0.0.0
 * 开发人员: sangaizhi
 * 开发时间: 2017/4/6 22:40
 * 审核人员:
 * 相关文档:
 * 修改记录:
 * 修改日期:
 * 修改人员：
 * 修改说明：
 */
package com.zhijie.zmall.commons.constants;

/**
 * 管理员状态
 */
public enum AdminStatusEnum {
    NOT_ACTIVATED("NOT_ACTIVATED", "未激活", (short) 0),
    ACTIVATED("ACTIVATED", "已激活", (short) 1),
    LOCKED("LOCKED", "已锁定", (short) 2),
    NORMAL("NORMAL", "正常", (short) 3);

    private String label;
    private String name;
    private Short value;

    AdminStatusEnum(String label, String name, Short value) {
        this.label = label;
        this.name = name;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getValue() {
        return value;
    }

    public void setValue(Short value) {
        this.value = value;
    }
}
