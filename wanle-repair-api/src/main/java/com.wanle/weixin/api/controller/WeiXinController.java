package com.wanle.weixin.api.controller;


import com.wanle.repair.api.controller.PhoneTypeController;
import com.wanle.utils.TokenSingleton;
import com.wanle.vo.Message;
import com.wanle.vo.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jdk.nashorn.internal.parser.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
    public ResponseVo getOauthWeb(HttpServletRequest request, @RequestParam(value = "userId") Long userId) {
        logger.info("获取access_token 信息");
        String accessToken =tokenSingleton.getAccessToken();
        return new ResponseVo(Message.Success,accessToken);
    }
}