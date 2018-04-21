package com.wanle.repair.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wanle.dao.OrderEmailConfigDao;
import com.wanle.dao.OrdersDao;
import com.wanle.domain.OrderEmailConfig;
import com.wanle.domain.Orders;
import com.wanle.repair.api.service.OrdersService;
import com.wanle.utils.Bean2MapUtil;
import com.wanle.utils.CommonQueryBean;
import com.wanle.utils.MailUtil;
import com.wanle.utils.TokenSingleton;
import com.wanle.vo.Message;
import com.wanle.vo.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import weixin.popular.api.MessageAPI;
import weixin.popular.bean.message.message.TextMessage;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

@Service
public class OrdersServiceImpl implements OrdersService {

    private Logger logger= LoggerFactory.getLogger(OrdersServiceImpl.class);

    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private MailUtil mailUtil;
    @Autowired
    private TokenSingleton tokenSingleton;
    @Autowired
    private OrderEmailConfigDao orderEmailConfigDao;


    @Override
    public int addOrders(Orders orders) {
        generateOrderNo(orders);
        //发送通知
        sendNotice(orders);
        return ordersDao.insertSelective(orders);
    }

    @Override
    public ResultVo selectByUserId(Long userId) {
        try {
            if(userId!=null){
                Orders orders=new Orders();
                orders.setUserId(userId);
                List<Orders> ordersList=ordersDao.list(orders);
                return new ResultVo(Message.Success,ordersList);
            }
            return new ResultVo(Message.NoResult);
        } catch (Exception e) {
            logger.error("用户userId={}查询订单信息失败",userId,e);
            return new ResultVo(Message.UnKnowError);
        }
    }

    @Override
    public ResultVo selectAllOrders(Orders orders, CommonQueryBean commonQueryBean) {
        List<Orders> ordersList=ordersDao.list4Page(orders,commonQueryBean);
        return new ResultVo(Message.Success,ordersList);
    }

    @Override
    public ResultVo updateOrders(Orders orders) {
        int i=ordersDao.updateByPrimaryKeySelective(orders);
        if(i>0){
            return new ResultVo(Message.Success);
        }
        return new ResultVo(Message.UnKnowError,"更新用户订单信息失败");
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
        logger.info("userId={} 生成订单号为：{}",orders.getUserId(),orederNo);
        orders.setOrderNo(orederNo);
    }

    public void pushWeixinNotice(OrderEmailConfig orderEmailConfig, Map<String,Object> map){
        try {
            if(orderEmailConfig!=null && orderEmailConfig.getWxPushPerson()!=null && orderEmailConfig.getWxPushTemplate()!=null) {
                String[] tos=orderEmailConfig.getWxPushPerson().split(",");
                String content=orderEmailConfig.getWxPushTemplate();
                logger.info("订单微信推送,推送人:{},模板信息:{},map 入参为：{}",tos,content,map);
                //模板数据填充
                for (Object s : map.keySet()) {
                    content = content.replaceAll("\\$\\{".concat(s.toString()).concat("\\}"), map.get(s.toString()).toString());
                }
                logger.info("订单微信推送,推送内容:{}",content);
                for(String to:tos) {
//                    TextMessage textMessage2 = new TextMessage("openId 列表群发文本消息");
//                    textMessage2.setTouser("oztlns9n1gt0HcNSxx_N45QRcZjw");
//                    TextMessage.Text text = new TextMessage.Text();
//                    text.setContent("测试");
//                    textMessage2.setText(text);
                    TextMessage textMessage=new TextMessage(to,content);
                    MessageAPI.messageCustomSend(tokenSingleton.getAccessToken(), textMessage);
                }
            }else{
                logger.info("微信推送模板信息为空");
            }
        } catch (Exception e) {
           logger.error("推送微信消息失败",e);
        }
    }

    public void sendNotice(Orders orders){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        FutureTask<String> futureTask =
                new FutureTask<>(new Callable<String>() {//使用Callable接口作为构造参数
                    @Override
                    public String call() {
                        logger.info("查询邮件模板 id={},订单信息为：{}",1, JSONObject.toJSONString(orders));
                        Map<String,Object> map=Bean2MapUtil.beanToMap(orders);
                        OrderEmailConfig orderEmailConfig= orderEmailConfigDao.selectByPrimaryKey(1);
                        if(orderEmailConfig!=null){
                        //发送信息
                        logger.info("用户下定单，向配置用户发送邮件");
                        mailUtil.sendHtmlTemplateMail(orderEmailConfig, map);
                        logger.info("用户下订单，向指定用户推送微信消息");
                        pushWeixinNotice(orderEmailConfig,map);
                        }else{
                            logger.info("id={},邮件模板不存在",1);
                        }
                        return "ok";
                    }
                });
        executor.execute(futureTask);


    }

}
