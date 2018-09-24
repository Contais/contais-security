package com.contais.web.async;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Contais
 * @version 1.0
 * @description com.contais.web.async
 * @date 2018/9/24
 */
@Component
@Getter
@Setter
public class DeferredResultHolder {
    private Map<String, DeferredResult<String>> map = new HashMap<>();
}
