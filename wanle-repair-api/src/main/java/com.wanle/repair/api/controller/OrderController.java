package com.wanle.repair.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;
import com.wanle.domain.Orders;
import com.wanle.domain.PhoneRepairType;
import com.wanle.repair.api.service.OrdersService;
import com.wanle.utils.CommonQueryBean;
import com.wanle.vo.Message;
import com.wanle.vo.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api(value = "订单管理",protocols = "JSON",tags = "订单管理")
public class OrderController {

    private Logger logger= LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrdersService ordersService;

    @RequestMapping(path = "/api/v1/order/addOrder", method = { RequestMethod.POST})
    @ApiOperation(value = "添加订单", httpMethod = "POST", response = String.class, notes = "添加订单")
    public ResponseVo addOrder(HttpServletRequest request, @RequestBody Orders orders) {
        logger.info("添加订单，入参{}", JSONObject.toJSONString(orders));
        Preconditions.checkNotNull(orders, "param cannot null");
        Preconditions.checkNotNull(orders.getUserId(), "userId cannot null");
        Preconditions.checkNotNull(orders.getAddressId(), "addressId cannot null");
        int i=ordersService.addOrders(orders);
        if(i>0){
            logger.info("添加订单成功，出参{}",JSONObject.toJSONString(orders));
            return new ResponseVo(Message.Success);
        }
        return new ResponseVo(Message.NoResult);
    }

    @RequestMapping(path = "/api/v1/order/selectOrdersByUserId", method = { RequestMethod.POST})
    @ApiOperation(value = "查看用户订单", httpMethod = "POST", response = String.class, notes = "查看用户订单")
    public ResponseVo selectOrdersByUserId(HttpServletRequest request, @RequestParam(value = "userId") Long userId) {
        logger.info("查询userId={}的订单信息", userId);
        Preconditions.checkNotNull(userId, "param cannot null");
        return ordersService.selectByUserId(userId);
    }

    @RequestMapping(path = "/api/v1/order/selectAllOrders", method = { RequestMethod.POST})
    @ApiOperation(value = "查看所有订单", httpMethod = "POST", response = String.class, notes = "查看所有订单")
    public ResponseVo selectAllOrders(HttpServletRequest request, @RequestBody Orders orders, @RequestBody CommonQueryBean commonQueryBean) {
        Preconditions.checkNotNull(orders, "param cannot null");
        return ordersService.selectAllOrders(orders,commonQueryBean);
    }

    @RequestMapping(path = "/api/v1/order/updateOrders", method = { RequestMethod.POST})
    @ApiOperation(value = "更新用户订单信息", httpMethod = "POST", response = String.class, notes = "更新用户订单信息")
    public ResponseVo updateOrders(HttpServletRequest request,@RequestBody Orders orders) {
        Preconditions.checkNotNull(orders, "param cannot null");
        return ordersService.updateOrders(orders);
    }
}
