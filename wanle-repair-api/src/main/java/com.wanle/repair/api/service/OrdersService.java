package com.wanle.repair.api.service;

import com.wanle.domain.Orders;
import com.wanle.utils.CommonQueryBean;
import com.wanle.vo.ResponseVo;

import java.util.List;

public interface OrdersService {

    public int addOrders(Orders orders);

    ResponseVo selectByUserId(Long userId);

    ResponseVo selectAllOrders(Orders orders,CommonQueryBean commonQueryBean);

    ResponseVo updateOrders(Orders orders);
}
