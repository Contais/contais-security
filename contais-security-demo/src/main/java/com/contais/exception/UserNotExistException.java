package com.contais.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Contais
 * @version 1.0
 * @description com.contais.exception
 * @date 2018/8/19
 */
@Getter
@Setter
public class UserNotExistException extends RuntimeException{

    private String id;

    public UserNotExistException(String id) {
        super("user not exception");
        this.id = id;
    }
}
