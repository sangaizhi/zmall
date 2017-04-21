/**
 * 文件名称: LogTemplate
 * 系统名称: zmall
 * 模块名称:
 * 软件版权:
 * 功能说明:
 * 系统版本: 1.0.0.0
 * 开发人员: sangaizhi
 * 开发时间: 2017/4/15 22:23
 * 审核人员:
 * 相关文档:
 * 修改记录:
 * 修改日期:
 * 修改人员：
 * 修改说明：
 */
package com.zhijie.zmall.commons.constants;

/**
 * @name LogTemplate
 * @author sangaizhi
 * @date 2017/4/15  22:23
 * @version 1.0
 */
/**
 * 日志模板
 */
public class LogTemplate {


    /**
     * 错误日志模板 [ZAMLL][说明](参数json)
     */
    public final static String LOG_ERROR_MODEL = "[ZAMLL][{}]({})";

    /**
     * 业务异常日志模板 [ZAMLL][说明](参数json)
     */
    public final static String LOG_EXCEPTION_MODEL = "[ZAMLL][{}]({})";

    /**
     * 删除业务日志模板 [ZAMLL][说明](参数json)
     */
    public final static String LOG_EXCEPTION_MODEL_DELETE = "[ZAMLL][DELETE][{}]({})";

    /**
     * 新增业务日志模板 [ZAMLL][ADD][说明](参数json)
     */
    public final static String LOG_INFO_MODEL_ADD = "[ZAMLL][ADD][{}]({})";

    /**
     * 修改业务日志模板 [ZAMLL][UPDATE][说明](参数json)
     */
    public final static String LOG_INFO_MODEL_UPDATE = "[ZAMLL][UPDATE][{}][old]({})[new]({})";

    /**
     * 业务流日志模板 [ZAMLL][说明](参数json)
     */
    public final static String LOG_INFO_MODEL_BUSSINESS = "[ZAMLL][{}]({})";

    /**
     * 业务起始日志模板 [ZAMLL][说明][start](参数json)
     */
    public final static String LOG_INFO_MODEL_BUSSINESS_START = "[ZAMLL][{}][start]({})";

    /**
     * 业务结束日志模板 [ZAMLL][说明][end](参数json)
     */
    public final static String LOG_INFO_MODEL_BUSSINESS_END = "[ZAMLL][{}][end]({})";
}