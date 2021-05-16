package com.owen.controller;

import com.alibaba.fastjson.JSON;
import com.owen.domain.Product;
import com.owen.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ProductController {
    @Autowired
    public ProductService productService;
    @RequestMapping("/product/{pid}")
    public Product product(@PathVariable("pid") Integer pid) {
        log.info("next product{}", pid);
        Product product = productService.findByPid(pid);
        log.info("success,{}", JSON.toJSONString(product));
        return product;

    }
}


