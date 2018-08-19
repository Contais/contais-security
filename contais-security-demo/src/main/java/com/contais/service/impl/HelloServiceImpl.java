package com.contais.service.impl;

import com.contais.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @author Contais
 * @version 1.0
 * @description com.contais.service.impl
 * @date 2018/8/19
 */
@Service
public class HelloServiceImpl implements HelloService{

    @Override
    public String greeting(String name) {
        System.out.println(name);
        return "Hi~ " + name;
    }
}
