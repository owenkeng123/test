package com.owen.service;

import com.owen.domain.Product;

public interface ProductService {
    Product findByPid(Integer pid);
}
