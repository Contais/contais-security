package com.contais.security.browser.authentication;

import com.contais.security.core.properties.LoginType;
import com.contais.security.core.properties.SecurityProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Contais
 * @version 1.0
 * @description com.contais.security.browser.authentication
 * @date 2018/9/26
 */
@Component("contaisAuthenticationSuccessHandler")
public class ContaisAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        logger.info("登录成功");

        if (LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())){
            //如果配置了登录处理方式是JSON
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(authentication));
        } else {
            //如果配置了登录处理方式不是JSON,调用父类的处理方式:REDIRECT(Spring默认处理方式是跳转到一个错误页面)
            super.onAuthenticationSuccess(request, response, authentication);
        }

    }
}
