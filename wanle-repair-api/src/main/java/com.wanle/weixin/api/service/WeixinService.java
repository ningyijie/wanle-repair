package com.wanle.weixin.api.service;

import com.wanle.vo.ResponseVo;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;

public interface WeixinService {


    void weiLogin(ServletInputStream inputStream, ServletOutputStream outputStream,String signature, String timestamp,String nonce, String echostr);


    void Oauth2Authorize(String redirectUri,boolean snsapiUserinfo, String state);

    ResponseVo getWeiXinLogin(String code);
}
