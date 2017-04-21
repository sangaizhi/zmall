package com.zhijie.zmall.sso.controller;/**
 * 文件名称: PageController
 * 系统名称: workspace
 * 模块名称:
 * 软件版权: 深圳中云创科技有限公司
 * 功能说明:
 * 系统版本: 1.0.0.0
 * 开发人员: sangaizhi
 * 开发时间: 2017/3/18 14:55
 * 审核人员:
 * 相关文档:
 * 修改记录:
 * 修改日期:
 * 修改人员：
 * 修改说明：
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Name PageController
 * @Author sangaizhi
 * @Date 2017/3/18  14:55
 * @Version 1.0
 */
@Controller
@RequestMapping("/page")
public class PageController {

    /**
     * 展示其他页面
     *
     * @throws
     * @Title: showPage
     */
    @RequestMapping("/register")
    public String showPage() {
        return "register";
    }

    @RequestMapping("/login")
    public String showLogin(String redirectUrl, Model model) {
        model.addAttribute("redirectUrl", redirectUrl);
        return "login";
    }
}
