package com.wanle.repair.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;
import com.wanle.domain.User;
import com.wanle.repair.api.service.UserService;
import com.wanle.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * class_name: UserController
 * package: com.wanle.repair.api.controller
 * describe: TODO 用户信息
 * creat_user: ningyijie@finupgroup.com
 * creat_date: 2018/3/15
 * creat_time: 下午7:45
 **/
@RestController
@Api(value = "用户管理",protocols = "JSON",tags = "用户管理")
public class UserController {

    private static Logger logger= LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/api/v1/user/userRegister", method = { RequestMethod.POST ,RequestMethod.GET})
    @ApiOperation(value = "用户注册", httpMethod = "POST", response = String.class, notes = "用户注册")
    public ResultVo userRegister(HttpServletRequest request, @RequestBody User user) {
        logger.info("用户注册，入参{}", JSONObject.toJSONString(user));
        Preconditions.checkNotNull(user, "param cannot null");
        Preconditions.checkNotNull((user.getEmail()!=null || user.getMobile()!=null), "email or mobile cannot null");
        Preconditions.checkNotNull(user.getPassword(), "password cannot null");
        return userService.userRegister(user);

    }

    @RequestMapping(path = "/api/v1/user/userLogin", method = { RequestMethod.POST ,RequestMethod.GET})
    @ApiOperation(value = "用户登录", httpMethod = "POST", response = String.class, notes = "用户登录")
    public ResultVo userLogin(HttpServletRequest request, @RequestBody User user) {
        logger.info("用户登录，入参{}",JSONObject.toJSONString(user));
        Preconditions.checkNotNull(user, "param cannot null");
        Preconditions.checkNotNull((user.getEmail()!=null || user.getMobile()!=null), "email or mobile cannot null");
        Preconditions.checkNotNull(user.getPassword(), "password cannot null");
        return userService.userLogin(user);

    }

    @RequestMapping(path = "/api/v1/user/sendEmailCode", method = { RequestMethod.POST ,RequestMethod.GET})
    @ApiImplicitParam(name = "email", value = "邮箱号", required = true, dataType = "String")
    @ApiOperation(value = "获取邮箱验证码", httpMethod = "POST", response = String.class, notes = "获取邮箱验证码")
    public ResultVo sendEmailCode(HttpServletRequest request, @RequestParam(value = "email") String email) {
        logger.info("获取用户邮箱验证码，入参{}",email);
        return userService.sendUserEamilCode(email);

    }
}
