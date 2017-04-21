/**
 * 文件名称: LoginController
 * 系统名称: zmall
 * 模块名称:
 * 软件版权:
 * 功能说明:
 * 系统版本: 1.0.0.0
 * 开发人员: sangaizhi
 * 开发时间: 2017/4/16 18:20
 * 审核人员:
 * 相关文档:
 * 修改记录:
 * 修改日期:
 * 修改人员：
 * 修改说明：
 */
package com.zhijie.zmall.boss.controller;

import com.zhijie.zmall.admin.service.AdminService;
import com.zhijie.zmall.boss.service.JedisService;
import com.zhijie.zmall.boss.service.WebAdminService;
import com.zhijie.zmall.commons.constants.AccountTypeEnum;
import com.zhijie.zmall.commons.pojo.ZmallResult;
import com.zhijie.zmall.commons.util.CookieUtils;
import com.zhijie.zmall.commons.util.UUIDUitl;
import com.zhijie.zmall.commons.util.validate.RegularUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sangaizhi
 * @version 1.0
 * @name LoginController
 * @date 2017/4/16  18:20
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private WebAdminService webAdminService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private ResourceBundleMessageSource messageSource;

    @Autowired
    private JedisService jedisService;

    @RequestMapping("/loginPage")
    public static String loginPage(String redirectUrl, Model model) {
        model.addAttribute("redirectUrl", redirectUrl);
        return "login";
    }

    @RequestMapping("/login")
    @ResponseBody
    public ZmallResult login(@RequestParam("account") String account, @RequestParam("password") String password,@RequestParam("redirectUrl") String redirectUrl,  HttpServletRequest request, HttpServletResponse response) {
        if (StringUtils.isBlank(account)) {
            return ZmallResult.build(404, messageSource.getMessage("admin.name.empty", null, request.getLocale()));
        }
        if (StringUtils.isBlank(password)) {
            return ZmallResult.build(404, messageSource.getMessage("admin.password.empty", null, request.getLocale()));
        }
        if (!(RegularUtil.checkPhone(account) || RegularUtil.checkEmail(account))) {
            return ZmallResult.build(404, messageSource.getMessage("admin.account.error", null, request.getLocale()));
        }
        Short type;
        if (RegularUtil.checkEmail(account)) {
            type = AccountTypeEnum.EMAIL.getValue();
        } else if (RegularUtil.checkPhone(account)) {
            type = AccountTypeEnum.PHONE.getValue();
        } else {
            return ZmallResult.build(404, messageSource.getMessage("admin.account.error", null, request.getLocale()));
        }
        try{

            ZmallResult zmallResult = webAdminService.adminLogin(account, type, password);
            if(zmallResult.getStatus() == 200){
                String token = UUIDUitl.generateUpperString(32);
                CookieUtils.setCookie(request, response, "ZMALL_ADMIN_TOKEN", token);
                return  zmallResult;
            }else{
                return  zmallResult;
            }
        }catch (Exception e){
            e.printStackTrace();
            return  ZmallResult.build(500, "登录失败");
        }
    }
}
