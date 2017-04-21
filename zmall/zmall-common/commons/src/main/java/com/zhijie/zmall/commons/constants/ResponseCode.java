package com.zhijie.zmall.commons.constants;

/**
 * 响应状态
 */
public enum ResponseCode {
    SUCCESS(200, "操作成功"),
    ERROR(500, "服务器错误"),
    UNKNOWN_ACCOUNT(20001, "账户不存在"),
    FORBIDDEN_ACCOUNT(20002, "账户已禁用"),
    PASSWORD_INCORRECT(20003, "密码错误"),
    VERIFY_CAPTCHA_ERROR(20004, "验证码错误,请重新刷新并滑动验证码!"),
    UNAUTHORIZED(20005, "无操作权限"),
    CAN_NOT_EDIT(20006, "该条记录无法编辑"),
    UNAUTHENTICATED(20007, "未登录"),
    FORBIDDEN_IP(20008, "非法请求"),
    NOT_FOUND_URL(20009, "url不存在"),
    PARAM_FORMAT_ERROR(30001, "参数格式错误"),
    MISSING_PARAMETER(30002, "缺少参数"),
    NAME_ALREADY_EXIST(30003, "该名称已存在"),
    DATA_NOT_EXIST(30004, "该记录不存在"),
    LOGIN_NAME_ALREADY_EXIST(30005, "该登录名已存在"),
    CODE_ALREADY_EXIST(30006, "该编码已存在"),
    FULLNAME_ALREADY_EXIST(30007, "该全称已存在");

    private int code;
    private String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ResponseCode{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
