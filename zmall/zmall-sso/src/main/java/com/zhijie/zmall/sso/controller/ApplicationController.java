package com.zhijie.zmall.sso.controller;/**
 * 文件名称: ApplicationController
 * 系统名称: zmall
 * 模块名称:
 * 软件版权:
 * 功能说明:
 * 系统版本: 1.0.0.0
 * 开发人员: sangaizhi
 * 开发时间: 2017/3/30 23:20
 * 审核人员:
 * 相关文档:
 * 修改记录:
 * 修改日期:
 * 修改人员：
 * 修改说明：
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @name ApplicationController
 * @author sangaizhi
 * @date 2017/3/30  23:20
 * @version 1.0
 */
@Controller
public class ApplicationController {

    @RequestMapping("/")
    public String index(){
        return "login";
    }
}
