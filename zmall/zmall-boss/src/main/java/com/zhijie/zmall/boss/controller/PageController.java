package com.zhijie.zmall.boss.controller;/**
 * 文件名称: PageController
 * 系统名称: zmall
 * 模块名称:
 * 软件版权:
 * 功能说明:
 * 系统版本: 1.0.0.0
 * 开发人员: sangaizhi
 * 开发时间: 2017/3/30 22:33
 * 审核人员:
 * 相关文档:
 * 修改记录:
 * 修改日期:
 * 修改人员：
 * 修改说明：
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sangaizhi
 * @version 1.0
 * @name PageController
 * @date 2017/3/30  22:33
 */
@Controller
public class PageController {

    @RequestMapping("/{page}")
    public String page(@PathVariable String page) {
        return page;
    }
}
