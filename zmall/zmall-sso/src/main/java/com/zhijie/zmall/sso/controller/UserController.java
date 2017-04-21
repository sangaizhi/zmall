/**
 * 文件名称: UserController
 * 系统名称: workspace
 * 模块名称:
 * 功能说明:
 * 系统版本: 1.0.0.0
 * 开发人员: sangaizhi
 * 开发时间: 2017/3/16 22:14
 * 审核人员:
 * 相关文档:
 * 修改记录:
 * 修改日期:
 * 修改人员：
 * 修改说明：
 */
package com.zhijie.zmall.sso.controller;

import com.zhijie.zmall.commons.pojo.ZmallResult;
import com.zhijie.zmall.commons.util.CookieUtils;
import com.zhijie.zmall.commons.util.ExceptionUtil;
import com.zhijie.zmall.sso.enums.UserAccountTypeEnum;
import com.zhijie.zmall.sso.model.UserVO;
import com.zhijie.zmall.sso.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * 用户controller
 *
 * @Name UserController
 * @Author sangaizhi
 * @Date 2017/3/28  22:14
 * @Version 1.0
 */
@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/check/{param}/{type}", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public Object check(@PathVariable String param, @PathVariable Short type, String callback) {
        //参数校验
        ZmallResult result = null;
        if (StringUtils.isBlank(param)) {
            result = ZmallResult.build(400, "校验内容不能为空");
        }
        if (null == type) {
            result = ZmallResult.build(400, "校验内容类型不能为空");
        }
        if (!Objects.equals(UserAccountTypeEnum.NAME.getValue(), type)
                && !Objects.equals(UserAccountTypeEnum.PHONE.getValue(), type)
                && !Objects.equals(UserAccountTypeEnum.EMAIL.getValue(), type)) {
            result = ZmallResult.build(400, "校验内容类型错误");
        }
        if (null != result) {
            if (StringUtils.isNotBlank(callback)) {
                MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
                mappingJacksonValue.setJsonpFunction(callback);
                return mappingJacksonValue;
            }
            return result;
        }

        try {
            result = userService.checkUserData(param, type);
        } catch (Exception e) {
            e.printStackTrace();
            result = ZmallResult.build(500, ExceptionUtil.getStackTrace(e));
        }
        if (StringUtils.isNotBlank(callback)) {
            MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
            mappingJacksonValue.setJsonpFunction(callback);
            return mappingJacksonValue;
        } else {
            return result;
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ZmallResult register(UserVO user) {
        if (null == user) {
            return ZmallResult.build(400, "请填写用户信息");
        }
        if (StringUtils.isBlank(user.getName())) {
            return ZmallResult.build(400, "用户名不能为空");
        }
        ZmallResult result = userService.checkUserData(user.getName(), UserAccountTypeEnum.NAME.getValue());
        if (!(boolean) result.getData()) {
            return ZmallResult.build(400, "用户名已被占用");
        }
        if (StringUtils.isBlank(user.getPhone())) {
            return ZmallResult.build(400, "电话不能为空");
        }
        result = userService.checkUserData(user.getPhone(), UserAccountTypeEnum.PHONE.getValue());
        if (!(boolean) result.getData()) {
            return ZmallResult.build(400, "电话已被占用");
        }
        if (StringUtils.isNotBlank(user.getEmail())) {
            result = userService.checkUserData(user.getEmail(), UserAccountTypeEnum.EMAIL.getValue());
            if (!(boolean) result.getData()) {
                return ZmallResult.build(400, "邮箱已被占用");
            }
        }
        if (StringUtils.isBlank(user.getPassword())) {
            return ZmallResult.build(400, "密码不能为空");
        }
        try {
             userService.save(user);
            return ZmallResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ZmallResult.build(500, ExceptionUtil.getStackTrace(e));
        }
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ZmallResult login(String username, String password,Short type, HttpServletRequest request, HttpServletResponse response) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return ZmallResult.build(400, "用户名和密码不能为空");
        }
        try {
            ZmallResult result = userService.userLogin(username, password, type);
            //设置cookie
            CookieUtils.setCookie(request, response, "ZMALL_TOKEN", (String) result.getData());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return ZmallResult.build(500, ExceptionUtil.getStackTrace(e));
        }
    }

    @RequestMapping(value = "/token/{token}")
    @ResponseBody
    public Object getUserInfoByToken(@PathVariable String token, String callback) {

        if (StringUtils.isBlank(token)) {
            return ZmallResult.build(400, "获取用户信息失败");
        }
        ZmallResult result = null;
        try {
            result = userService.getUserByToken(token);
        } catch (Exception e) {
            e.printStackTrace();
            result = ZmallResult.build(500, ExceptionUtil.getStackTrace(e));
        }
        if (StringUtils.isNotBlank(callback)) {
            MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
            mappingJacksonValue.setJsonpFunction(callback);
            return mappingJacksonValue;
        } else {
            return result;
        }

    }

    @RequestMapping(value = "/logout/{token}")
    @ResponseBody
    public Object logout(@PathVariable String token, String callback) {
        ZmallResult result = null;
        if (StringUtils.isBlank(token)) {
            return ZmallResult.build(400, "参数不合法");
        }
        try {
            result = userService.userLogout(token);
        }catch (Exception e){
            result = ZmallResult.build(500, ExceptionUtil.getStackTrace(e));
        }
        if(StringUtils.isNotBlank(callback)){
            MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
            mappingJacksonValue.setJsonpFunction(callback);
            return mappingJacksonValue;
        } else {
            return result;
        }
    }


}
