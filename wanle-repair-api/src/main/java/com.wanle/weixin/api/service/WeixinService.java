package com.wanle.weixin.api.service;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;

public interface WeixinService {


    public void weiLogin(ServletInputStream inputStream, ServletOutputStream outputStream,String signature, String timestamp,String nonce, String echostr);
}
