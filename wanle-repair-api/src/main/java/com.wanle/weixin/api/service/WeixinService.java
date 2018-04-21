package com.wanle.weixin.api.service;

import com.wanle.vo.ResultVo;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;

public interface WeixinService {


    void weixinAccess(ServletInputStream inputStream, ServletOutputStream outputStream, String signature, String timestamp, String nonce, String echostr);


    void Oauth2Authorize(String redirectUri,boolean snsapiUserinfo, String state);

    ResultVo getWeiXinLogin(String code);
}
