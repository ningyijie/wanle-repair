package com.wanle.weixin.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;
import com.wanle.vo.ResultVo;
import com.wanle.weixin.UnifiedOrderRequest;
import com.wanle.weixin.api.service.WeixinPayService;
import com.wanle.weixin.api.service.WeixinService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import weixin.popular.api.PayMchAPI;
import weixin.popular.bean.paymch.Unifiedorder;
import weixin.popular.bean.paymch.UnifiedorderResult;
import weixin.popular.util.StreamUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * class_name: WeixinPayController
 * package: com.wanle.weixin.api.controller
 * describe: TODO
 * creat_user: ningyijie@finupgroup.com
 * creat_date: 2018/4/14
 * creat_time: 下午6:29
 **/
@RestController
@Api(value = "微信支付控制类",protocols = "JSON",tags = "微信支付")
public class WeixinPayController {

    private static Logger logger= LoggerFactory.getLogger(WeixinPayController.class);

    @Autowired
    private WeixinPayService weixinPayService;

    @RequestMapping(value = "/api/v1/weixin/toPayInit", method = {RequestMethod.POST})
    @ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultVo.class) })
    @ApiOperation(value = "支付初始化--调用统一支付接口", httpMethod = "POST", response = String.class, notes = "支付初始化--调用统一支付接口")
    public ResultVo toPayInit(HttpServletRequest request, @RequestBody UnifiedOrderRequest unifiedOrderRequest) {
        logger.info("调用微信支付初始化统一接口，入参:{}", JSONObject.toJSONString(unifiedOrderRequest));
        Preconditions.checkNotNull(unifiedOrderRequest, "param cannot null");
        Preconditions.checkNotNull(unifiedOrderRequest.getBody(), "body cannot null");
        Preconditions.checkNotNull(unifiedOrderRequest.getOut_trade_no(), "out_trade_no cannot null");
        Preconditions.checkNotNull(unifiedOrderRequest.getTotal_fee(), "total_fee cannot null");
        Preconditions.checkNotNull(unifiedOrderRequest.getNotify_url(), "notify_url cannot null");
        Preconditions.checkNotNull(unifiedOrderRequest.getTrade_type(), "trade_type cannot null");
        return weixinPayService.toPayInit(unifiedOrderRequest);
    }

    @RequestMapping(value = "/api/v1/weixin/payMchNotify", method = {RequestMethod.POST})
    @ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultVo.class) })
    @ApiOperation(value = "支付初始化--回调地址", httpMethod = "POST", response = String.class, notes = "支付初始化--回调地址")
    public void payMchNotify(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String xmlData = StreamUtils.copyToString(request.getInputStream(), Charset.forName("utf-8"));

        weixinPayService.payMchNotify(xmlData,response);
    }
}
