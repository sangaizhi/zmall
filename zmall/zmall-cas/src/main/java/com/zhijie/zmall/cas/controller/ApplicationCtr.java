/**
 * 文件名称: ApplicationCtr
 * 系统名称: zmall
 * 模块名称:
 * 软件版权:
 * 功能说明:
 * 系统版本: 1.0.0.0
 * 开发人员: sangaizhi
 * 开发时间: 2017/4/13 21:13
 * 审核人员:
 * 相关文档:
 * 修改记录:
 * 修改日期:
 * 修改人员：
 * 修改说明：
 */
package com.zhijie.zmall.cas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @name ApplicationCtr
 * @author sangaizhi
 * @date 2017/4/13  21:13
 * @version 1.0
 */
@Controller
public class ApplicationCtr {


    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }
}
