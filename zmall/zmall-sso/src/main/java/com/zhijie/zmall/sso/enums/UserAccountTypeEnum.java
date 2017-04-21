/**
 * 文件名称: AccountTypeEnum
 * 系统名称: workspace
 * 模块名称:
 * 功能说明:
 * 系统版本: 1.0.0.0
 * 开发人员: sangaizhi
 * 开发时间: 2017/3/16 21:48
 * 审核人员:
 * 相关文档:
 * 修改记录:
 * 修改日期:
 * 修改人员：
 * 修改说明：
 */
package com.zhijie.zmall.sso.enums;


public enum UserAccountTypeEnum {

    NAME((short) 1, "姓名"),
    PHONE((short) 2, "电话"),
    EMAIL((short) 3, "邮箱");

    private Short value;
    private String label;

    UserAccountTypeEnum(Short value, String label) {
        this.value = value;
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Short getValue() {
        return value;
    }

    public void setValue(Short value) {
        this.value = value;
    }
}