package com.owen.service.impl;

import com.owen.dao.ProductDao;
import com.owen.domain.Product;
import com.owen.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    public Product findByPid(Integer pid){
        return  productDao.findById(pid).get();
    }

}
