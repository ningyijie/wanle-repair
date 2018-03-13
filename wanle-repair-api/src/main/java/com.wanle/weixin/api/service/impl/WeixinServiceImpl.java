package com.wanle.weixin.api.service.impl;

import com.wanle.weixin.api.service.WeixinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import weixin.popular.bean.message.EventMessage;
import weixin.popular.bean.xmlmessage.XMLMessage;
import weixin.popular.bean.xmlmessage.XMLTextMessage;
import weixin.popular.support.ExpireKey;
import weixin.popular.support.expirekey.DefaultExpireKey;
import weixin.popular.util.SignatureUtil;
import weixin.popular.util.XMLConverUtil;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

@Service
public class WeixinServiceImpl implements WeixinService {

    private Logger logger= LoggerFactory.getLogger(WeixinServiceImpl.class);

    //重复通知过滤
    @Autowired
    private static ExpireKey expireKey = new DefaultExpireKey();

    @Value("${weixin.loginToken}")
    private  String  loginToken;



    /**
     * 微信对接登录验证
     * @param inputStream
     * @param outputStream
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     */
    @Override
    public void weiLogin(ServletInputStream inputStream, ServletOutputStream outputStream, String signature, String timestamp, String nonce, String echostr) {
        //首次请求申请验证,返回echostr
        if(echostr!=null){
            logger.info("微信验证登录--首次申请验证，直接返回:echostr={}",echostr);
            outputStreamWrite(outputStream,echostr);
            return;
        }

        logger.info("微信登录认证--开始验证请求签名");
        //验证请求签名
        if(!signature.equals(SignatureUtil.generateEventMessageSignature(loginToken,timestamp,nonce))){
            logger.info("微信登录认证--The request signature is invalid");
            return;
        }

        logger.info("微信登录认证--请求流处理入参{}",inputStream);
        if(inputStream!=null){
            //转换XML
            EventMessage eventMessage = XMLConverUtil.convertToObject(EventMessage.class,inputStream);
            logger.info("");
            String key = eventMessage.getFromUserName() + "__"
                    + eventMessage.getToUserName() + "__"
                    + eventMessage.getMsgId() + "__"
                    + eventMessage.getCreateTime();
            logger.info("微信登录认证key={}",key);
            if(expireKey.exists(key)){
                //重复通知不作处理
                return;
            }else{
                expireKey.add(key);
            }

            //创建回复
            XMLMessage xmlTextMessage = new XMLTextMessage(
                    eventMessage.getFromUserName(),
                    eventMessage.getToUserName(),
                    "你好");
            //回复
            xmlTextMessage.outputStreamWrite(outputStream);
            return;
        }
        outputStreamWrite(outputStream,"");


    }



    /**
     * 数据流输出
     * @param outputStream
     * @param text
     * @return
     */
    private boolean outputStreamWrite(OutputStream outputStream, String text){
        try {
            outputStream.write(text.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
