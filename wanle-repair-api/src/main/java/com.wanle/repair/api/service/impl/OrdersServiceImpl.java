package com.wanle.repair.api.service.impl;

import com.wanle.dao.OrdersDao;
import com.wanle.domain.Orders;
import com.wanle.repair.api.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;
    @Override
    public int addOrders(Orders orders) {

        return ordersDao.insertSelective(orders);
    }
}
