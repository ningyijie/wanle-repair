package com.wanle.weixin.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wanle.domain.User;
import com.wanle.vo.Message;
import com.wanle.vo.ResponseVo;
import com.wanle.weixin.api.service.WeiXinUserService;
import com.wanle.weixin.api.service.WeixinService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import weixin.popular.api.SnsAPI;
import weixin.popular.bean.message.EventMessage;
import weixin.popular.bean.sns.SnsToken;
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

    @Value("${weixn.appid}")
    private  String appid;

    @Value("${weixin.secret}")
    private  String secret;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WeiXinUserService weiXinUserService;



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
    public void weixinAccess(ServletInputStream inputStream, ServletOutputStream outputStream, String signature, String timestamp, String nonce, String echostr) {
        //首次请求申请验证,返回echostr
        if(echostr!=null){
            logger.info("微信验证登录--首次申请验证，直接返回:echostr={}",echostr);
            outputStreamWrite(outputStream,echostr);
            return;
        }

        logger.info("微信接入认证--开始验证请求签名");
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
     * 微信接入消息处理
     */
    public void weixinMessageHandle(){

    }

    /**
     * 网页授权
     * 1 第一步：用户同意授权，获取code

     2 第二步：通过code换取网页授权access_token

     3 第三步：刷新access_token（如果需要）

     4 第四步：拉取用户信息(需scope为 snsapi_userinfo)
     * @param redirectUri
     * @param snsapiUserinfo
     * @param state
     */
    @Override
    public void Oauth2Authorize(String redirectUri, boolean snsapiUserinfo, String state) {
       //获取 code
        String getCodeUrl=SnsAPI.connectOauth2Authorize(appid,redirectUri,snsapiUserinfo,state);
        logger.info("获取用户 oauth2Authorize 的 code，url={}",getCodeUrl);
        JSONObject code=restTemplate.getForObject(getCodeUrl,JSONObject.class);
        logger.info("获取用户 oauth2Authorize 的 code,出参={}",code);

    }

    /**
     * 根据 code 获取 网页 access_token  然后获取 openId
     * @param code
     * @return
     */
    @Override
    public ResponseVo getWeiXinLogin(String code) {
        logger.info("用户同意授权");
        try {
            if(!"".equals(code)){
                //获取网页授权 access_token
               SnsToken token=SnsAPI.oauth2AccessToken(appid,secret,code);
               logger.info("通过 code 获取网页 access_token ,结果：{}",JSONObject.toJSONString(token));
               if(token==null || StringUtils.isEmpty(token.getAccess_token()) || StringUtils.isEmpty(token.getOpenid()) ){
                   return new ResponseVo(Message.NoResult,token);
               }
               logger.info("通过网页 accesss_token 获取用户信息");
               User user=weiXinUserService.getUserByOauthToken(token.getAccess_token(),token.getOpenid());
               logger.info("获取到用户信息:{}",JSONObject.toJSONString(user));

                return new ResponseVo(Message.Success,user);
            }
        } catch (Exception e) {
            logger.error("查询用户网页access_token 并获取用户信息失败",e);
            return new ResponseVo(Message.UnKnowError);
        }
        return new ResponseVo(Message.NoResult);
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
