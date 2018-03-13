package com.wanle.weixin.api.controller;


import com.google.common.base.Preconditions;
import com.wanle.repair.api.controller.PhoneTypeController;
import com.wanle.utils.TokenSingleton;
import com.wanle.vo.Message;
import com.wanle.vo.ResponseVo;
import com.wanle.weixin.api.service.WeixinService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jdk.nashorn.internal.parser.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import weixin.popular.api.SnsAPI;
import weixin.popular.bean.message.EventMessage;
import weixin.popular.bean.xmlmessage.XMLMessage;
import weixin.popular.bean.xmlmessage.XMLTextMessage;
import weixin.popular.support.ExpireKey;
import weixin.popular.support.expirekey.DefaultExpireKey;
import weixin.popular.util.SignatureUtil;
import weixin.popular.util.XMLConverUtil;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/**
 * class_name: WeiXinController
 * package: com.wanle.repair.api.controller
 * describe: TODO 微信接口
 * creat_user: ningyijie@finupgroup.com
 * creat_date: 2018/3/11
 * creat_time: 下午10:15
 **/
@RestController
@Api(value = "微信对接控制类",protocols = "JSON",tags = "")
public class WeiXinController {

    private Logger logger= LoggerFactory.getLogger(PhoneTypeController.class);
    @Autowired
    private TokenSingleton tokenSingleton;
    @Autowired
    private WeixinService weixinService;


    @Value("${weixn.appid}")
    private  String appid;

    @Value("${weixin.secret}")
    private  String secret;

    @RequestMapping(value = "/api/v1/weixin/loginWeixin", method = { RequestMethod.GET ,RequestMethod.POST})
    @ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResponseVo.class) })
    @ApiOperation(value = "微信登录验证", httpMethod = "GET", response = String.class, notes = "微信登录验证")
    public void loginWeixin(HttpServletRequest request,HttpServletResponse response) throws IOException {
        logger.info("微信验证登录开始");
        ServletInputStream inputStream = request.getInputStream();
        ServletOutputStream outputStream = response.getOutputStream();
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        Preconditions.checkNotNull(signature, "signature cannot null");
        Preconditions.checkNotNull(timestamp, "timestamp cannot empty");
        Preconditions.checkNotNull(nonce, "nonce cannot empty");
//        Preconditions.checkNotNull(echostr, "echostr cannot empty");
        weixinService.weiLogin(inputStream,outputStream,signature,timestamp,nonce,echostr);

    }




    @RequestMapping(value = "/api/v1/weixin/getAccessToken", method = { RequestMethod.GET })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResponseVo.class) })
    @ApiOperation(value = " 获取access_token 信息", httpMethod = "GET", response = String.class, notes = "获取access_token 信息")
    public ResponseVo getAllPhoneType(HttpServletRequest request) {
        logger.info("获取access_token 信息");
        String accessToken =tokenSingleton.getAccessToken();
        return new ResponseVo(Message.Success,accessToken);
    }

    @RequestMapping(value = "/api/v1/weixin/getOauthWeb", method = { RequestMethod.GET })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResponseVo.class) })
    @ApiOperation(value = "微信网页授权", httpMethod = "GET", response = String.class, notes = "微信网页授权")
    public ResponseVo getOauthWeb(HttpServletRequest request, @RequestParam(value = "redirectUri") String redirectUri) {
        logger.info("微信网页授权登录开始,获取 code");
//        SnsAPI.connectOauth2Authorize(appid,redirectUri);
//        return new ResponseVo(Message.Success,accessToken);
    }
}
