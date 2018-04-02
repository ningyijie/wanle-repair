package com.wanle.weixin.api.controller;

import com.wanle.utils.TokenSingleton;
import com.wanle.vo.Message;
import com.wanle.vo.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import weixin.popular.api.MenuAPI;
import weixin.popular.bean.BaseResult;
import weixin.popular.bean.menu.Button;
import weixin.popular.bean.menu.MenuButtons;

import javax.servlet.http.HttpServletRequest;


/**
 * class_name: MenuController
 * package: com.wanle.weixin.api.controller
 * describe: TODO 微信菜单控制
 * creat_user: ningyijie@finupgroup.com
 * creat_date: 2018/3/25
 * creat_time: 上午11:14
 **/
@RestController
@Api(value = "微信公众号菜单管理",protocols = "JSON",tags = "微信公众号菜单管理")
public class MenuController {

    @Autowired
    private TokenSingleton tokenSingleton;



    @RequestMapping(value = "/api/v1/weixin/createWeixinMenu", method = { RequestMethod.POST})
    @ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResponseVo.class) })
    @ApiOperation(value = "创建菜单", httpMethod = "POST", response = String.class, notes = "微信登录验证")
    public ResponseVo createWeixinMenu(HttpServletRequest request, @RequestBody Button[] button){
        MenuButtons menuButtons=new MenuButtons();
        menuButtons.setButton(button);
        BaseResult result=MenuAPI.menuCreate( tokenSingleton.getAccessToken(), menuButtons);
        return new ResponseVo(Message.Success,result);
    }

}
