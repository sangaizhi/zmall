/**
 * 文件名称: AdminController
 * 系统名称: zmall
 * 模块名称:
 * 软件版权:
 * 功能说明:
 * 系统版本: 1.0.0.0
 * 开发人员: sangaizhi
 * 开发时间: 2017/4/6 22:30
 * 审核人员:
 * 相关文档:
 * 修改记录:
 * 修改日期:
 * 修改人员：
 * 修改说明：
 */
package com.zhijie.zmall.boss.controller;

import com.zhijie.zmall.admin.qo.AdminQO;
import com.zhijie.zmall.admin.qo.RoleQO;
import com.zhijie.zmall.admin.service.AdminService;
import com.zhijie.zmall.admin.service.RoleService;
import com.zhijie.zmall.admin.vo.AdminVO;
import com.zhijie.zmall.admin.vo.RoleVO;
import com.zhijie.zmall.boss.service.WebAdminService;
import com.zhijie.zmall.commons.constants.AccountTypeEnum;
import com.zhijie.zmall.commons.constants.Constants;
import com.zhijie.zmall.commons.exception.BusinessRuntimeException;
import com.zhijie.zmall.commons.pojo.ZmallResult;
import com.zhijie.zmall.commons.util.ExceptionUtil;
import com.zhijie.zmall.commons.util.JsonUtils;
import com.zhijie.zmall.commons.util.PageUtil;
import com.zhijie.zmall.commons.util.validate.RegularUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author sangaizhi
 * @version 1.0
 * @name AdminController
 * @date 2017/4/6  22:30
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private WebAdminService webAdminService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private RoleService roleService;

    @Autowired
    private ResourceBundleMessageSource messageSource;

    private Logger logger = LoggerFactory.getLogger(AdminController.class);

    @RequestMapping("/add")
    public String add(Model model,HttpServletRequest request) {
        RoleQO roleQO = new RoleQO();
        List<RoleVO> list = roleService.queryList(roleQO);
        model.addAttribute("roleList", list);
        return "add-admin";
    }


    @RequestMapping("/check")
    @ResponseBody
    public Boolean check(String account, Short type) {
        if (StringUtils.isBlank(account)) {
            return false;
        }
        if (null == type) {
            return false;
        }
        AdminQO adminQO = new AdminQO();
        if (Objects.equals(type, AccountTypeEnum.PHONE.getValue())) {
            adminQO.setPhone(account);
        } else if (Objects.equals(type, AccountTypeEnum.EMAIL.getValue())) {
            adminQO.setEmail(account);
        }
        List<AdminVO> list = adminService.queryList(adminQO);
        return CollectionUtils.isEmpty(list);
    }

    @RequestMapping(value = "/addSubmit", produces = MediaType.APPLICATION_JSON_VALUE+"; charset=utf-8")
    @ResponseBody
    public ZmallResult addSubmit(AdminVO admin, Long[] roleIds, HttpServletRequest request) {
        ZmallResult zmallResult = ZmallResult.ok();
        if (null == admin) {
            return ZmallResult.build(500, messageSource.getMessage("admin.name.empty", null, request.getLocale()));
        }
        if (StringUtils.isBlank(admin.getName())) {
            return ZmallResult.build(500, messageSource.getMessage("admin.name.empty", null, request.getLocale()));
        }
        if (StringUtils.isBlank(admin.getPhone())) {
            return ZmallResult.build(500, messageSource.getMessage("admin.phone.empty", null, request.getLocale()));
        }
        if (!RegularUtil.checkPhone(admin.getPhone())) {
            return ZmallResult.build(500, messageSource.getMessage("phone.regex.not.match", null, request.getLocale()));
        }
        if (StringUtils.isBlank(admin.getEmail())) {
            return ZmallResult.build(500, messageSource.getMessage("admin.email.empty", null, request.getLocale()));
        }
        if (!RegularUtil.checkEmail(admin.getEmail())) {
            return ZmallResult.build(500, messageSource.getMessage("email.regex.not.match", null, request.getLocale()));
        }
        if (StringUtils.isBlank(admin.getPassword())) {
            admin.setPassword("123456");
        }
        try {
            List roles = new ArrayList();
            if(roleIds != null || roleIds.length > 0){
                roles = Arrays.asList(roleIds);
            }
            webAdminService.save(admin, roles);
            return ZmallResult.ok();
        } catch (BusinessRuntimeException e) {
            e.printStackTrace();
            logger.error(Constants.LOG_EXCEPTION_MODEL, "新增管理员失败", JsonUtils.objectToJson(admin));
            return ZmallResult.build(500, e.getErrMsg());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(Constants.LOG_EXCEPTION_MODEL, "新增管理员失败", JsonUtils.objectToJson(admin));
            return ZmallResult.build(500, ExceptionUtil.getStackTrace(e));
        }
    }

    @RequestMapping("/list")
    public String list(AdminQO condition, PageUtil page, HttpServletRequest request, Model model) {
        if (null == condition) {
            condition = new AdminQO();
        }
        if (null == page) {
            page = new PageUtil();
        }
        condition.setStartPosition(page.getStartPosition());
        condition.setPageSize(page.getPageSize());
        List<AdminVO> list = adminService.queryDetailPage(condition);
        Long count = adminService.count(condition);
        condition.setRecordCount(count);
        page.setRecordCount(count);
        model.addAttribute("list", list);
        model.addAttribute("page", page);
        model.addAttribute("condition", condition);
        return "list-admin";
    }
}
