package com.zhijie.zmall.boss.controller;/**
 * 文件名称: ApplicationCtr
 * 系统名称: zmall
 * 模块名称:
 * 软件版权: 深圳中云创科技有限公司
 * 功能说明:
 * 系统版本: 1.0.0.0
 * 开发人员: sangaizhi
 * 开发时间: 2017/3/23 22:49
 * 审核人员:
 * 相关文档:
 * 修改记录:
 * 修改日期:
 * 修改人员：
 * 修改说明：
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Name ApplicationCtr
 * @Author sangaizhi
 * @Date 2017/3/23  22:49
 * @Version 1.0
 */
@Controller
public class ApplicationCtr {

    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return "hello, zmall boss";
    }
}
