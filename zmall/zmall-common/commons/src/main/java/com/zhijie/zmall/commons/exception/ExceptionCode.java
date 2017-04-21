/**
 * 文件名称: ExceptionCode
 * 系统名称: zmall
 * 模块名称:
 * 软件版权:
 * 功能说明:
 * 系统版本: 1.0.0.0
 * 开发人员: sangaizhi
 * 开发时间: 2017/4/16 22:41
 * 审核人员:
 * 相关文档:
 * 修改记录:
 * 修改日期:
 * 修改人员：
 * 修改说明：
 */
package com.zhijie.zmall.commons.exception;

/**
 * @author sangaizhi
 * @version 1.0
 * @name ExceptionCode
 * @date 2017/4/16  22:41
 */
public enum ExceptionCode {

    INCORRECT_NAME_PASSWORD("0","用户名密码错误"),
    ACCOUNT_WAS_LOCKED("1", "账号被锁定"),
    ACCOUNT_WAS_DISABLED("2", "账号被禁用"),
    ;
    private String code;
    private String message;

    ExceptionCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}


