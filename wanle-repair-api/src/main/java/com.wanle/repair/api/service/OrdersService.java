package com.wanle.repair.api.service;

import com.wanle.domain.Orders;
import com.wanle.utils.CommonQueryBean;
import com.wanle.vo.ResultVo;

public interface OrdersService {

    public int addOrders(Orders orders);

    ResultVo selectByUserId(Long userId);

    ResultVo selectAllOrders(Orders orders, CommonQueryBean commonQueryBean);

    ResultVo updateOrders(Orders orders);
}
