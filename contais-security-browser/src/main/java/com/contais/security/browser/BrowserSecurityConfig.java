package com.contais.security.browser;

import com.contais.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author Contais
 * @version 1.0
 * @description com.contais.security.browser
 * @date 2018/9/24
 * WebSecurityConfigurerAdapter 适配器
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private AuthenticationSuccessHandler contaisAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler contaisAuthenticationFailureHandler;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //用表单登录做一个身份认证,使用请求必须要身份认证以后才可使用
//        http.httpBasic()
        http.formLogin()                //使用表单登录
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form")
                .successHandler(contaisAuthenticationSuccessHandler)
                .failureHandler(contaisAuthenticationFailureHandler)
                .and()
                .authorizeRequests()    //对请求做一个授权
                .antMatchers("/authentication/require",
                        securityProperties.getBrowser().getLoginPage()).permitAll()
                .anyRequest()           //任何请求
                .authenticated()       //都需要身份认证
                .and()
                .csrf().disable();
    }
}
