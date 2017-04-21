package com.zhijie.zmall.commons.constants;

import java.math.BigDecimal;

/**
 * 常用常量：包含日志模板
 */


public class Constants
{
    /**
     * 全局的金额保留小数位数
     */
    public final static int BIGDECIMAL_AMOUNT_SCALE = 2;
    
    /**
     * 全局的金额保留小数方式（向上四舍五入）
     */
    public final static int BIGDECIMAL_AMOUNT_ROUND = BigDecimal.ROUND_HALF_UP;
    
    /**
     * 错误日志模板 [zmall][说明](参数json)
     */
    public final static String LOG_ERROR_MODEL = "[zmall][{}]({})";
    
    /**
     * 业务异常日志模板 [zmall][说明](参数json)
     */
    public final static String LOG_EXCEPTION_MODEL = "[zmall][{}]({})";
    
    /**
     * 删除业务日志模板 [zmall][说明](参数json)
     */
    public final static String LOG_EXCEPTION_MODEL_DELETE = "[zmall][DELETE][{}]({})";
    
    /**
     * 新增业务日志模板 [zmall][ADD][说明](参数json)
     */
    public final static String LOG_INFO_MODEL_ADD = "[zmall][ADD][{}]({})";
    
    /**
     * 修改业务日志模板 [zmall][UPDATE][说明](参数json)
     */
    public final static String LOG_INFO_MODEL_UPDATE = "[zmall][UPDATE][{}][old]({})[new]({})";
    
    /**
     * 业务流日志模板 [zmall][说明](参数json)
     */
    public final static String LOG_INFO_MODEL_BUSSINESS = "[zmall][{}]({})";
    
    /**
     * 业务起始日志模板 [zmall][说明][start](参数json)
     */
    public final static String LOG_INFO_MODEL_BUSSINESS_START = "[zmall][{}][start]({})";
    
    /**
     * 业务结束日志模板 [zmall][说明][end](参数json)
     */
    public final static String LOG_INFO_MODEL_BUSSINESS_END = "[zmall][{}][end]({})";
    
    /** 系统运行环境 */
    public enum SYSTEM_ENVIRONMENT
    {
        /** 开发环境 */
        dev,
        /** 测试环境 */
        test,
        /** 用户验收环境，即体验环境 */
        uat,
        /** 生产环境 */
        product;
    }
}
