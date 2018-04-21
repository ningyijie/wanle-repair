package com.wanle.weixin.api.service;

import com.wanle.vo.ResultVo;
import com.wanle.weixin.UnifiedOrderRequest;
import weixin.popular.bean.paymch.MchPayNotify;

import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;

public interface WeixinPayService {

    //初始化微信支付 --调用统一支付接口
    ResultVo toPayInit(UnifiedOrderRequest unifiedOrderRequest);

    void payMchNotify(String xmlData,HttpServletResponse response);
}
