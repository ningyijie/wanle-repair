package com.wanle.repair.api.controller;

import com.wanle.domain.Address;
import com.wanle.repair.api.service.AddressService;
import com.wanle.vo.Message;
import com.wanle.vo.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Api(value = "收货地址管理",produces = "JSON",tags = "收货地址管理")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @RequestMapping(path = "/api/v1/address/addAddress", method = { RequestMethod.POST ,RequestMethod.GET})
    @ApiOperation(value = "添加用户收货地址", httpMethod = "POST", response = String.class, notes = "添加用户收货地址")
    public ResponseVo addAddress(HttpServletRequest request, @RequestBody Address address) {
       int i= addressService.addAddress(address);
       if(i>0){
           return new ResponseVo(Message.Success,address);
       }
        return new ResponseVo(Message.NoResult);
    }

    @RequestMapping(path = "/api/v1/address/getAllAddressByUserId", method = { RequestMethod.POST ,RequestMethod.GET})
    @ApiOperation(value = "根据用户 userId查询收货地址", httpMethod = "POST", response = String.class, notes = "根据用户 userId查询收货地址")
    public ResponseVo getAllAddressByUserId(HttpServletRequest request, @RequestParam(value = "userId") Long userId) {
        List<Address> addressList= addressService.selectAllByUserId(userId);
        if(addressList!=null){
            return new ResponseVo(Message.Success,addressList);
        }
        return new ResponseVo(Message.NoResult);
    }

    @RequestMapping(path = "/api/v1/address/updateAddressById", method = { RequestMethod.POST ,RequestMethod.GET})
    @ApiOperation(value = "更新用户收货地址" , httpMethod = "POST", response = String.class, notes = "更新用户收货地址")
    public ResponseVo updateAddressById(HttpServletRequest request, @RequestParam(value = "id") int id,@RequestBody Address address) {
        address.setId(id);
        int i=addressService.updateById(address);
        if(i>0){
            return new ResponseVo(Message.Success);
        }
        return new ResponseVo(Message.NoResult);
    }

    @RequestMapping(path = "/api/v1/address/deleteAddressById", method = { RequestMethod.POST ,RequestMethod.GET})
    @ApiOperation(value = "删除收货地址" , httpMethod = "POST", response = String.class, notes = "删除收货地址")
    public ResponseVo deleteAddressById(HttpServletRequest request,  @RequestParam(value = "id") int id) {
        int i=addressService.deleteById(id);
        if(i>0){
            return new ResponseVo(Message.Success);
        }
        return new ResponseVo(Message.NoResult);
    }
}
