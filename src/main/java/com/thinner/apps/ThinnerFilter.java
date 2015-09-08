package com.thinner.apps;

import com.google.common.base.Strings;
import com.thinner.apps.service.UserService;
import com.thinner.apps.utils.HttpInputStreamUtil;
import com.thinner.apps.utils.JacksonUtil;
import com.thinner.apps.utils.StringUtil;
import com.thinner.apps.web.Request.ThinnerRequest;
import com.thinner.apps.web.bean.User;
import com.thinner.apps.web.response.FailResponse;
import com.thinner.apps.web.response.IResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by caoqitong on 8/16/15.
 */
public class ThinnerFilter implements Filter {
  @Autowired
  UserService userService;

  Logger logger = LoggerFactory.getLogger(ThinnerFilter.class);

  /**
   * 用户登录验证过滤器
   * 获取requestBody
   * 通过token验证user
   *
   * @param request
   * @param response
   * @param chain
   * @throws IOException
   * @throws ServletException
   */

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    ServletRequest requestWrapper = new RequestWrapper(httpServletRequest);
    String contextPath = httpServletRequest.getRequestURI();
    if (contextPath.equalsIgnoreCase("/api/user/login")) {
      chain.doFilter(requestWrapper, response);
      return;
    }
    if (contextPath.indexOf("/api") == 0) {
      String body = HttpInputStreamUtil.getBodyString(requestWrapper);
      if (Strings.isNullOrEmpty(body)) {
        response.getWriter().write(JacksonUtil.objToJson(new FailResponse(IResponse.REQUEST_BODY_NULL)));
        logger.error(StringUtil.formatLog("thinnerRequest body is empty"));
        return;
      }
      User user;
      ThinnerRequest thinnerRequest;
      /**
       * 验证用户thinnerRequest及token内容是否合法
       */
      try {
        thinnerRequest = JacksonUtil.jsonToObj(body, ThinnerRequest.class);
        if (thinnerRequest == null) {
          response.getWriter().write(JacksonUtil.objToJson(new FailResponse(IResponse.THINNER_NULL)));
          logger.error(StringUtil.formatLog("thinnerRequest is invalid", body));
          return;
        }
        String token = thinnerRequest.getToken();
        if (token == null) {
          response.getWriter().write(JacksonUtil.objToJson(new FailResponse(IResponse.TOKEN_NULL)));
          logger.error(StringUtil.formatLog("thinnerRequest.token is null", body));
          return;
        }
        user = userService.getUserByToken(token);
        if (user == null) {
          response.getWriter().write(JacksonUtil.objToJson(new FailResponse(IResponse.INVALID_TOKEN)));
          logger.error(StringUtil.formatLog("can not get user from token", token, body));
          return;
        }
      } catch (Exception e) {
        response.getWriter().write(JacksonUtil.objToJson(new FailResponse(IResponse.INVALID_TOKEN)));
        logger.error(StringUtil.formatLog("requestContent is invalid", body, e));
        return;
      }
    }
    chain.doFilter(requestWrapper, response);
    return;
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void destroy() {

  }

}