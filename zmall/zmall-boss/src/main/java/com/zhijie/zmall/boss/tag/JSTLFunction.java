/**
 * 文件名称: JSTLFunction
 * 系统名称: zmall
 * 模块名称:
 * 软件版权:
 * 功能说明:
 * 系统版本: 1.0.0.0
 * 开发人员: sangaizhi
 * 开发时间: 2017/4/8 23:44
 * 审核人员:
 * 相关文档:
 * 修改记录:
 * 修改日期:
 * 修改人员：
 * 修改说明：
 */
package com.zhijie.zmall.boss.tag;

import com.zhijie.zmall.commons.constants.EnableDisableEnum;

import java.util.Objects;

/**
 * @author sangaizhi
 * @version 1.0
 * @name JSTLFunction
 * @date 2017/4/8  23:44
 */
public class JSTLFunction {


    public static String getEnableDisableLabel(Short status) {
        if (status == null) {
            return "";
        } else if (Objects.equals(status, EnableDisableEnum.ENABLE.getLabel())) {
            return "可用";
        } else if (Objects.equals(status, EnableDisableEnum.DISABLE.getLabel())) {
            return "禁用";
        } else {
            return "";
        }
    }

}
