package com.owen.controller;

import com.alibaba.fastjson.JSON;
import com.owen.domain.Order;
import com.owen.domain.Product;
import com.owen.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private OrderService orderService;

//    下单
    @RequestMapping("/order/prod/{pid}")
    public Order order(@PathVariable("pid") Integer pid){
        log.info("search order info{}",pid);
        Product product=restTemplate.getForObject(
                "http://localhost:8081/product/"+pid,Product.class);
        log.info("result{}"+ JSON.toJSONString(product));

//        下单（创建订单）
        Order order=new Order();
        order.setUid(1);
        order.setUsername("test");
        order.setPid(product.getPid());
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);

        orderService.createOrder(order);

        return order;



    }

}
