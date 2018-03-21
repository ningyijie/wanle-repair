package com.wanle.repair.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wanle.dao.OrdersDao;
import com.wanle.domain.Orders;
import com.wanle.repair.api.service.OrdersService;
import com.wanle.utils.CommonQueryBean;
import com.wanle.vo.Message;
import com.wanle.vo.ResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class OrdersServiceImpl implements OrdersService {

    private Logger logger= LoggerFactory.getLogger(OrdersServiceImpl.class);

    @Autowired
    private OrdersDao ordersDao;
    @Override
    public int addOrders(Orders orders) {
        generateOrderNo(orders);
        return ordersDao.insertSelective(orders);
    }

    @Override
    public ResponseVo selectByUserId(Long userId) {
        try {
            if(userId!=null){
                Orders orders=new Orders();
                orders.setUserId(userId);
                List<Orders> ordersList=ordersDao.list(orders);
                return new ResponseVo(Message.Success,ordersList);
            }
            return new ResponseVo(Message.NoResult);
        } catch (Exception e) {
            logger.error("用户userId={}查询订单信息失败",userId,e);
            return new ResponseVo(Message.UnKnowError);
        }
    }

    @Override
    public ResponseVo selectAllOrders(Orders orders, CommonQueryBean commonQueryBean) {
        List<Orders> ordersList=ordersDao.list4Page(orders,commonQueryBean);
        return new ResponseVo(Message.Success,ordersList);
    }

    @Override
    public ResponseVo updateOrders(Orders orders) {
        int i=ordersDao.updateByPrimaryKeySelective(orders);
        if(i>0){
            return new ResponseVo(Message.Success);
        }
        return new ResponseVo(Message.UnKnowError,"更新用户订单信息失败");
    }

    public void generateOrderNo(Orders orders){
        logger.info("userId={} 生成订单号入参:{}",orders.getUserId(), JSONObject.toJSONString(orders));
        //生成订单号，年月日8位+userID(6位，不足补全0)+随机6位数
        String round=String.valueOf(new Random().nextInt(999999) + 100000);
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYYYMMdd");
        //userId 补全
        String userId = String.format("%06d", orders.getUserId());
        String orederNo=simpleDateFormat.format(new Date())+userId+round;
        logger.info("userId={} 生成订单号为：{}",orederNo);
        orders.setOrderNo(orederNo);
    }

}
