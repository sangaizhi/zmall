package com.zhijie.zmall.boss.security.shiro;

import com.zhijie.zmall.commons.constants.ResponseCode;
import com.zhijie.zmall.commons.pojo.ZmallResult;
import com.zhijie.zmall.commons.util.JsonUtils;
import org.apache.shiro.web.filter.authc.PassThruAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录认证过滤器
 */
public class ShiroAuthenticationFilter extends PassThruAuthenticationFilter {
    private static Logger logger = LoggerFactory.getLogger(ShiroAuthorizationFilter.class);

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (isLoginRequest(request, response)) {
            return true;
        } else {
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
                ((HttpServletResponse) response).sendRedirect("/hunt-admin");
            }
            return false;
        }
    }
}
