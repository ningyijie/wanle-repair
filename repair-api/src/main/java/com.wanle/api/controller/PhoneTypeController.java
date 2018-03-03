package com.wanle.api.controller;

import com.wanle.api.service.PhoneService;
import com.wanle.domain.PhoneType;
import com.wanle.vo.Message;
import com.wanle.vo.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * class_name: PhoneTypeController
 * package: com.wanle.api.controller
 * describe: TODO 手机品牌和型号管理
 * creat_user: ningyijie@finupgroup.com
 * creat_date: 2018/3/2
 * creat_time: 上午10:30
 **/
@RestController
@Api(value = "获取手机分类信息",protocols = "JSON",tags = "")
public class PhoneTypeController {
    @Autowired
    private PhoneService phoneService;

    @RequestMapping(value = "/api/v1/phoneType/getAllPhoneType", method = { RequestMethod.POST })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResponseVo.class) })
    @ApiOperation(value = " 获取手机列表", httpMethod = "POST", response = String.class, notes = "正常还款")
    public ResponseVo getAllPhoneType(HttpServletRequest request) {
        List<PhoneType> phoneTypeList=phoneService.getAllPhoneTypeByCondition();
        return new ResponseVo(Message.Success,phoneTypeList);
    }

}
