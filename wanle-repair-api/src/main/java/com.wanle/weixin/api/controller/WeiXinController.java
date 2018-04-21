package com.wanle.weixin.api.controller;


import com.google.common.base.Preconditions;
import com.wanle.repair.api.controller.PhoneTypeController;
import com.wanle.utils.TokenSingleton;
import com.wanle.vo.Message;
import com.wanle.vo.ResultVo;
import com.wanle.weixin.api.service.WeixinService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * class_name: WeiXinController
 * package: com.wanle.repair.api.controller
 * describe: TODO 微信接口
 * creat_user: ningyijie@finupgroup.com
 * creat_date: 2018/3/11
 * creat_time: 下午10:15
 **/
@RestController
@Api(value = "微信对接控制类",protocols = "JSON",tags = "微信对接控制类")
public class WeiXinController {

    private Logger logger= LoggerFactory.getLogger(PhoneTypeController.class);
    @Autowired
    private TokenSingleton tokenSingleton;
    @Autowired
    private WeixinService weixinService;





    @Value("${weixin.secret}")
    private  String secret;

    @RequestMapping(value = "/api/v1/weixin/loginWeixin", method = { RequestMethod.GET ,RequestMethod.POST})
    @ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultVo.class) })
    @ApiOperation(value = "微信接入验证验证", httpMethod = "GET", response = String.class, notes = "微信接入验证验证")
    public void weixinAccess(HttpServletRequest request,HttpServletResponse response) throws IOException {
        logger.info("===微信接入===");
        ServletInputStream inputStream = request.getInputStream();
        ServletOutputStream outputStream = response.getOutputStream();
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        Preconditions.checkNotNull(signature, "signature cannot null");
        Preconditions.checkNotNull(timestamp, "timestamp cannot empty");
        Preconditions.checkNotNull(nonce, "nonce cannot empty");
        weixinService.weixinAccess(inputStream,outputStream,signature,timestamp,nonce,echostr);

    }





    @RequestMapping(value = "/api/v1/weixin/getAccessToken", method = { RequestMethod.GET })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultVo.class) })
    @ApiOperation(value = " 获取access_token 信息", httpMethod = "GET", response = String.class, notes = "获取access_token 信息")
    public ResultVo getAllPhoneType(HttpServletRequest request) {
        logger.info("获取access_token 信息");
        String accessToken =tokenSingleton.getAccessToken();
        return new ResultVo(Message.Success,accessToken);
    }

    @RequestMapping(value = "/api/v1/weixin/getOauth2Authorize", method = { RequestMethod.GET })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultVo.class) })
    @ApiOperation(value = "微信网页授权获取 code 并跳转页面", httpMethod = "GET", response = String.class, notes = "微信网页授权获取 code 并跳转页面")
    public ResultVo getOauth2Authorize(HttpServletRequest request, @RequestParam(value = "redirectUri") String redirectUri, @RequestParam(value = "snsapiUserinfo") boolean snsapiUserinfo, @RequestParam(value = "state") String state) {
        logger.info("微信网页授权登录开始,获取 code");
        weixinService.Oauth2Authorize(redirectUri,snsapiUserinfo,state);
        return null;
    }


    @RequestMapping(value = "/api/v1/weixin/getWeiXinUserMsg", method = { RequestMethod.GET })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultVo.class) })
    @ApiOperation(value = "微信网页获取用户信息", httpMethod = "GET", response = String.class, notes = "微信网页获取用户信息")
    public ResultVo getWeiXinUserMsg(HttpServletRequest request, @RequestParam(value = "code") String code) throws IOException {
        logger.info("微信网页登录--接收到的 code：{}",code);
        return weixinService.getWeiXinLogin(code);
    }


    @RequestMapping(value = "/api/v1/weixin/responseHtml", method = { RequestMethod.GET })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultVo.class) })
    @ApiOperation(value = " 微信授权封装", httpMethod = "GET", response = String.class, notes = "微信授权封装")
    public void responseHtml(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //1、微信网页授权，获取 code
        String code = request.getParameter("code");
        logger.info("code={}",code);

        //2、根据 code 获取用户信息
        response.sendRedirect("http://193.112.50.108:8080/dist");
    }

}
