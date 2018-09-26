package com.contais.security.core.properties;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Contais
 * @version 1.0
 * @description com.contais.security.core.properties
 * @date 2018/9/26
 */
@Getter
@Setter
public class BrowserProperties {

    //默认登录页面
    private String loginPage = "/contais-signIn.html";

    //默认登录处理方式:JSON
    private LoginType loginType = LoginType.JSON;

}
