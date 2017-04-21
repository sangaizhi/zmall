/**
 * 文件名称: BusinessRuntimeException
 * 系统名称: workspace
 * 模块名称:
 * 功能说明:
 * 系统版本: 1.0.0.0
 * 开发人员: sangaizhi
 * 开发时间: 2017/2/24 22:41
 * 审核人员:
 * 相关文档:
 * 修改记录:
 * 修改日期:
 * 修改人员：
 * 修改说明：
 */
package com.zhijie.zmall.commons.exception;

import java.util.Map;

/**
 * @Name BusinessRuntimeException
 * @Author sangaizhi
 * @Date 2017/2/24  22:41
 * @Version 1.0
 */
public class BusinessRuntimeException extends RuntimeException{

    private static final long serialVersionUID = -4453231439181616823L;

    /**
     * 错误编码
     */
    private String errCode;

    /**
     * 错误信息
     */
    private String errMsg;

    /**
     * 需要传递的错误信息
     */
    private Map<String, Object> errMap;

    public BusinessRuntimeException(String errCode, String errMsg, Map<String, Object> errMap) {
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.errMap = errMap;
    }

    public BusinessRuntimeException(String errCode, String errMsg) {
        this(errCode, errMsg, (Map<String, Object>)null);
    }

    /**
     * @Title:BusinessRuntimeException
     * @Description:上层异常传递
     * @param errCode
     * @param errMsg
     * @param errMap
     * @param throwable 上层异常
     */
    public BusinessRuntimeException(String errCode, String errMsg, Map<String, Object> errMap, Throwable throwable) {
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.errMap = errMap;
    }

    /**
     * @Title:BusinessRuntimeException
     * @Description:上层异常传递
     * @param errCode
     * @param errMsg
     * @param throwable 上层异常
     */
    public BusinessRuntimeException(String errCode, String errMsg, Throwable throwable) {
        this(errCode, errMsg, (Map<String, Object>)null, throwable);
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Map<String, Object> getErrMap() {
        return errMap;
    }

    public void setErrMap(Map<String, Object> errMap) {
        this.errMap = errMap;
    }
}
