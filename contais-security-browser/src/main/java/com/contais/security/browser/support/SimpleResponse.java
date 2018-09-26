package com.contais.security.browser.support;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Contais
 * @version 1.0
 * @description com.contais.security.browser.support
 * @date 2018/9/26
 */
@Setter
@Getter
public class SimpleResponse implements Serializable{

    private Object content;

    public SimpleResponse(Object content) {
        this.content = content;
    }
}
