/**
 * 文件名称: EnableDisableEnum
 * 系统名称: zmall
 * 模块名称:
 * 软件版权: 深圳中云创科技有限公司
 * 功能说明:
 * 系统版本: 1.0.0.0
 * 开发人员: sangaizhi
 * 开发时间: 2017/3/28 21:34
 * 审核人员:
 * 相关文档:
 * 修改记录:
 * 修改日期:
 * 修改人员：
 * 修改说明：
 */
package com.zhijie.zmall.commons.constants;

/**
 * @Name EnableDisableEnum
 * @Author sangaizhi
 * @Date 2017/3/28  21:34
 * @Version 1.0
 */
public enum  EnableDisableEnum {

    ENABLE("ENABLE","启用",(short)0),
    DISABLE("DISABLE","禁用",(short)1)
    ;
    private String label;
    private String name;
    private Short value;

    EnableDisableEnum(String label, String name, Short value) {
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
