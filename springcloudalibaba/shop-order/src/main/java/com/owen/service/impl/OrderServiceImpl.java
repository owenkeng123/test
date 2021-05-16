package com.owen.service.impl;


import com.owen.dao.OrderDao;
import com.owen.domain.Order;
import com.owen.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public void createOrder(Order order){
    orderDao.save(order);
    }
}
