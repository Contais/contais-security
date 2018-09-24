package com.contais.web.async;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Contais
 * @version 1.0
 * @description com.contais.web.async
 * @date 2018/9/24
 */
@Setter
@Getter
@Component
public class MockQueue {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private String placeOrder;
    private String completeOrder;

    public void setPlaceOrder(String placeOrder) throws Exception {
        new Thread(() -> {
            logger.info("接收到下单请求, " + placeOrder);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.completeOrder = placeOrder;
            logger.info("下单请求处理完毕, " + placeOrder);
        }).start();

    }

    public void setCompleteOrder(String completeOrder) {
        this.completeOrder = completeOrder;
    }
}
