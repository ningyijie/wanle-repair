package com.wanle.repair.api.controller;

import com.wanle.domain.User;
import com.wanle.repair.api.service.UserService;
import com.wanle.vo.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/api/v1/user/userRegister", method = { RequestMethod.POST ,RequestMethod.GET})
    @ApiOperation(value = "用户注册", httpMethod = "POST", response = String.class, notes = "用户注册")
    public ResponseVo userRegister(HttpServletRequest request, @RequestBody User user) {
        return userService.userRegister(user);

    }

    @RequestMapping(path = "/api/v1/user/userLogin", method = { RequestMethod.POST ,RequestMethod.GET})
    @ApiOperation(value = "用户登录", httpMethod = "POST", response = String.class, notes = "用户登录")
    public ResponseVo userLogin(HttpServletRequest request, @RequestBody User user) {
        return userService.userLogin(user);

    }

    @RequestMapping(path = "/api/v1/user/sendEmailCode", method = { RequestMethod.POST ,RequestMethod.GET})
    @ApiOperation(value = "获取邮箱验证码", httpMethod = "POST", response = String.class, notes = "获取邮箱验证码")
    public ResponseVo sendEmailCode(HttpServletRequest request, @RequestParam(value = "email") String email) {

        return userService.sendUserEamilCode(email);

    }
}
