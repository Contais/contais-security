package com.contais.security.core.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Contais
 * @version 1.0
 * @description com.contais.security.core
 * @date 2018/9/26
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "contais.security")
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

}
