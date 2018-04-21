package com.wanle.admin.api;

import com.google.common.base.Preconditions;
import com.wanle.domain.User;
import com.wanle.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.runtime.RecompilableScriptFunctionData;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "后台用户管理",protocols = "JSON",tags = "后台用户管理")
@RequestMapping(value = "/api/vi/userAdmin",method = RequestMethod.POST)
public class UserAdminController {

    @RequestMapping(path = "/userLogin", method = { RequestMethod.POST})
    @ApiOperation(value = "用户登录", httpMethod = "POST", response = String.class, notes = "用户登录")
    public ResultVo userLogin(@RequestBody User user){
        Preconditions.checkNotNull(user,"params is not null");
        Preconditions.checkNotNull(user.getPassword(),"password is not null");
        return null;
    }
}
