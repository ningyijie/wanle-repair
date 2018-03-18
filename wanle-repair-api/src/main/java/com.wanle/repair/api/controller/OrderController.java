package com.wanle.repair.api.controller;

import com.wanle.domain.Orders;
import com.wanle.domain.PhoneRepairType;
import com.wanle.repair.api.service.OrdersService;
import com.wanle.vo.Message;
import com.wanle.vo.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api(value = "订单管理",protocols = "JSON",tags = "订单管理")
public class OrderController {


    @Autowired
    private OrdersService ordersService;

    @RequestMapping(path = "/api/v1/order/addOrder", method = { RequestMethod.POST})
    @ApiOperation(value = "添加订单", httpMethod = "POST", response = String.class, notes = "添加订单")
    public ResponseVo addOrder(HttpServletRequest request, @RequestBody Orders orders) {
        int i=ordersService.addOrders(orders);
        if(i>0){
            return new ResponseVo(Message.Success);
        }
        return new ResponseVo(Message.NoResult);
    }
}
