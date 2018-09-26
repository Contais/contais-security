package com.contais.security.core;

import com.contais.security.core.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Contais
 * @version 1.0
 * @description com.contais.security.core.properties
 * @date 2018/9/26
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {
}
