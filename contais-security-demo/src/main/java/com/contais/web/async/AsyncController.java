package com.contais.web.async;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;


/**
 * @author Contais
 * @version 1.0
 * @description com.contais.async
 * @date 2018/9/24
 */
@RestController
public class AsyncController {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private MockQueue mockQueue;
    @Autowired
    private DeferredResultHolder deferredResultHolder;

    /**
     * 2018-09-24 10:33:27.945  INFO 8456 --- [nio-8080-exec-1] com.contais.web.async.AsyncController    : 主线程开始...
     * 2018-09-24 10:33:27.947  INFO 8456 --- [nio-8080-exec-1] com.contais.web.async.AsyncController    : 主线程结束...
     * 2018-09-24 10:33:27.947  INFO 8456 --- [      Thread-35] com.contais.web.async.MockQueue          : 接收到下单请求, 72262784
     * 2018-09-24 10:33:28.948  INFO 8456 --- [      Thread-35] com.contais.web.async.MockQueue          : 下单请求处理完毕, 72262784
     * 2018-09-24 10:33:29.020  INFO 8456 --- [      Thread-23] com.contais.web.async.QueueListener      : 返回订单处理结果, 72262784
     * @return
     * @throws Exception
     */
    @RequestMapping("/order")
    public DeferredResult<String> order() throws Exception {

        logger.info("主线程开始...");

        String orderNumber = RandomStringUtils.randomNumeric(8);
        mockQueue.setPlaceOrder(orderNumber);

        DeferredResult<String> result = new DeferredResult<>();
        deferredResultHolder.getMap().put(orderNumber, result);

        logger.info("主线程结束...");

        return result;
    }

    /**
     * 2018-09-24 10:12:43.135  INFO 13212 --- [nio-8080-exec-2] com.contais.async.AsyncController        : 主线程开始...
     * 2018-09-24 10:12:43.136  INFO 13212 --- [nio-8080-exec-2] com.contais.async.AsyncController        : 主线程结束...
     * 2018-09-24 10:12:43.141  INFO 13212 --- [      MvcAsync1] com.contais.async.AsyncController        : 副线程开始...
     * 2018-09-24 10:12:44.141  INFO 13212 --- [      MvcAsync1] com.contais.async.AsyncController        : 副线程结束...
     * @return
     * @throws Exception
     */
//    @RequestMapping("/order")
//    public Callable<String> order() throws Exception {
//
//        logger.info("主线程开始...");
//
//        Callable<String> result = new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                logger.info("副线程开始...");
//                Thread.sleep(1000);
//                logger.info("副线程结束...");
//                return "success";
//            }
//        };
//
//        logger.info("主线程结束...");
//
//        return result;
//    }

    /**
     * 2018-09-24 10:12:43.135  INFO 13212 --- [nio-8080-exec-2] com.contais.async.AsyncController        : 主线程开始...
     * 2018-09-24 10:12:43.136  INFO 13212 --- [nio-8080-exec-2] com.contais.async.AsyncController        : 主线程结束...
     * @return
     * @throws Exception
     */
//    @RequestMapping("/order")
//    public String order() throws Exception {
//        logger.info("主线程开始...");
//        Thread.sleep(1000);
//        logger.info("主线程结束...");
//        return "success";
//    }

}
