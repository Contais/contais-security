package com.contais.security.browser;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Contais
 * @version 1.0
 * @description com.contais.security.browser
 * @date 2018/9/24
 * WebSecurityConfigurerAdapter 适配器
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter{

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //用表单登录做一个身份认证,使用请求必须要身份认证以后才可使用
//        http.httpBasic()
        http.formLogin()                //使用表单登录
                .and()
                .authorizeRequests()    //对请求做一个授权
                .anyRequest()           //任何请求
                .authenticated();       //都需要身份认证
    }
}
