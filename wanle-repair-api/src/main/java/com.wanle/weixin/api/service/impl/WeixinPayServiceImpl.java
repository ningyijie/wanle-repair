package com.wanle.weixin.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wanle.vo.Message;
import com.wanle.vo.ResultVo;
import com.wanle.weixin.UnifiedOrderRequest;
import com.wanle.weixin.api.controller.WeixinPayController;
import com.wanle.weixin.api.service.WeixinPayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import weixin.popular.api.PayMchAPI;
import weixin.popular.bean.paymch.MchBaseResult;
import weixin.popular.bean.paymch.MchPayNotify;
import weixin.popular.bean.paymch.Unifiedorder;
import weixin.popular.bean.paymch.UnifiedorderResult;
import weixin.popular.support.ExpireKey;
import weixin.popular.support.expirekey.DefaultExpireKey;
import weixin.popular.util.PayUtil;
import weixin.popular.util.SignatureUtil;
import weixin.popular.util.XMLConverUtil;

import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.io.IOException;
import java.util.Map;


@Service
public class WeixinPayServiceImpl implements WeixinPayService {

    private static Logger logger= LoggerFactory.getLogger(WeixinPayServiceImpl.class);

    @Value("${weixin.pay.appid}")
    private String weixinPayAppid;

    @Value("${weixin.pay.machid}")
    private String weixinPayMchid;

    @Value("${weixin.pay.key}")
    private String weixinPayKey;

    // 重复通知过滤
    private static ExpireKey expireKey = new DefaultExpireKey();

    @Override
    public ResultVo toPayInit(UnifiedOrderRequest unifiedOrderRequest) {
        Unifiedorder unifiedorder=new Unifiedorder();
        BeanUtils.copyProperties(unifiedOrderRequest,unifiedorder);
        unifiedorder.setAppid(weixinPayAppid);
        unifiedorder.setAttach(weixinPayMchid);
        logger.info("调用统一支付接口,入参：{}", JSONObject.toJSONString(unifiedorder));
        UnifiedorderResult unifiedorderResult = PayMchAPI.payUnifiedorder(unifiedorder,weixinPayKey);
        logger.info("调用统一支付接口，出参:{}",JSONObject.toJSONString(unifiedOrderRequest));
        if(unifiedorderResult.getSign_status() !=null && unifiedorderResult.getSign_status()){
            String json = PayUtil.generateMchPayJsRequestJson(unifiedorderResult.getPrepay_id(), weixinPayAppid, weixinPayKey);
            return new ResultVo(Message.Success,json);

        }
        return new ResultVo(Message.ParamError);
    }

    @Override
    public void payMchNotify(String xmlData,HttpServletResponse response) {
        try {
            // 将XML转为MAP,确保所有字段都参与签名验证
            Map<String, String> mapData = XMLConverUtil.convertToMap(xmlData);
            // 转换数据对象
            MchPayNotify payNotify = XMLConverUtil.convertToObject(MchPayNotify.class, xmlData);
            // 已处理 去重
            if (expireKey.exists("WX_PAY_NOTIFY" + payNotify.getTransaction_id())) {
                MchBaseResult baseResult = new MchBaseResult();
                baseResult.setReturn_code("SUCCESS");
                baseResult.setReturn_msg("OK");
                response.getOutputStream().write(XMLConverUtil.convertToXML(baseResult).getBytes());
                return;
            }
            // 签名验证
            if (SignatureUtil.validateSign(mapData, weixinPayKey)) {
                // @since 2.8.5
                payNotify.buildDynamicField(mapData);

                expireKey.add("WX_PAY_NOTIFY" + payNotify.getTransaction_id(), 60);
                MchBaseResult baseResult = new MchBaseResult();
                baseResult.setReturn_code("SUCCESS");
                baseResult.setReturn_msg("OK");
                response.getOutputStream().write(XMLConverUtil.convertToXML(baseResult).getBytes());
            } else {
                MchBaseResult baseResult = new MchBaseResult();
                baseResult.setReturn_code("FAIL");
                baseResult.setReturn_msg("ERROR");
                response.getOutputStream().write(XMLConverUtil.convertToXML(baseResult).getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
