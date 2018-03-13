package com.wanle.repair.api.controller;

import com.google.common.base.Preconditions;
import com.wanle.repair.api.service.PhoneRepairTypeService;
import com.wanle.domain.PhoneRepairType;
import com.wanle.vo.Message;
import com.wanle.vo.RepairTree;
import com.wanle.vo.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * class_name: RepairTypeController
 * package: com.wanle.repair.api.controller
 * describe: TODO 维修分类
 * creat_user: ningyijie@finupgroup.com
 * creat_date: 2018/3/4
 * creat_time: 下午2:54
 **/
@RestController
@Api(value = "获取手机维修信息",protocols = "JSON",tags = "")
public class PhoneRepairTypeController {

    @Autowired
    private PhoneRepairTypeService phoneRepairTypeService;


    @RequestMapping(path = "/api/v1/repairType/getRepairType", method = { RequestMethod.POST ,RequestMethod.GET})
    @ApiOperation(value = " 根据手机获取维修列表", httpMethod = "POST", response = String.class, notes = "根据手机获取维修列表")
    public ResponseVo getAllPhoneType(HttpServletRequest request,@RequestBody PhoneRepairType phoneRepairType) {
        Preconditions.checkNotNull(phoneRepairType, "phoneRepairType cannot null");
        Preconditions.checkNotNull(phoneRepairType.getPhoneId(), "phoneId cannot empty");
        Preconditions.checkNotNull(phoneRepairType.getColorId(), "colorId cannot empty");

        List<RepairTree> repairTreeList= phoneRepairTypeService.getRepaairTypeByPhoneAndColor(phoneRepairType);
       if(repairTreeList==null) {
           return new ResponseVo(Message.NoResult, null);
       }else{
           return new ResponseVo(Message.Success,repairTreeList);
       }
    }
}
