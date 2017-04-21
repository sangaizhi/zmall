package com.zhijie.zmall.boss.security.shiro;

import com.zhijie.zmall.commons.constants.LogTemplate;
import com.zhijie.zmall.commons.constants.ResponseCode;
import com.zhijie.zmall.commons.pojo.ZmallResult;
import com.zhijie.zmall.commons.util.JsonUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 权限过滤器
 */
public class ShiroAuthorizationFilter extends AuthorizationFilter {
    private  Logger logger = LoggerFactory.getLogger(ShiroAuthorizationFilter.class);

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        HttpServletResponse response1 = (HttpServletResponse) response;
        Subject subject = getSubject(request, response);
        if (subject.getPrincipal() == null) {
            //未登录跳转至登陆页面
            saveRequest(request);
            if (((HttpServletRequest) request).getHeader("Accept").contains("application/json")) {
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json;charset=UTF-8");
                ZmallResult result = ZmallResult.build(ResponseCode.UNAUTHENTICATED.getCode(), ResponseCode.UNAUTHENTICATED.getMsg());
                response.getWriter().append(JsonUtils.objectToJson(result));
                response.getWriter().flush();
                response.getWriter().close();
            } else {
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;charset=UTF-8");
                ((HttpServletResponse) response).sendRedirect("/");
            }
        } else {
            //已登录未授权
            if (((HttpServletRequest) request).getHeader("Accept").contains("application/json")) {
                logger.info(LogTemplate.LOG_INFO_MODEL_BUSSINESS,"授权认证未通过", ((HttpServletRequest) request).getRequestURL());
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json;charset=UTF-8");
                ZmallResult result = ZmallResult.build(ResponseCode.UNAUTHENTICATED.getCode(), ResponseCode.UNAUTHENTICATED.getMsg());
                response.getWriter().append(JsonUtils.objectToJson(result));
                response.getWriter().flush();
                response.getWriter().close();
            } else {
                logger.info(LogTemplate.LOG_INFO_MODEL_BUSSINESS,"授权认证未通过", ((HttpServletRequest) request).getRequestURL());
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;charset=UTF-8");
                ((HttpServletResponse) response).sendRedirect("/error/unAuthorization");
            }
        }
        return false;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        Subject subject = getSubject(request, response);
        String[] perms = (String[]) mappedValue;
        boolean isPermitted = true;
        if (perms != null && perms.length > 0) {
            if (perms.length == 1) {
                if (!subject.isPermitted(perms[0])) {
                    logger.info(LogTemplate.LOG_INFO_MODEL_BUSSINESS,"授权认证未通过", ((HttpServletRequest) request).getRequestURL());
                    isPermitted = false;
                }
            } else {
                if (!subject.isPermittedAll(perms)) {
                    logger.info(LogTemplate.LOG_INFO_MODEL_BUSSINESS,"授权认证未通过", ((HttpServletRequest) request).getRequestURL());
                    isPermitted = false;
                }
            }
        }
        return isPermitted;
    }
}
