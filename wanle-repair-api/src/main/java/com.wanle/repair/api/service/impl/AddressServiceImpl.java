package com.wanle.repair.api.service.impl;

import com.wanle.dao.AddressDao;
import com.wanle.domain.Address;
import com.wanle.repair.api.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao addressDao;

    @Override
    public List<Address> selectAllByUserId(Long userId) {
        Address address=new Address();
        address.setUserId(userId);
        List<Address> list=addressDao.list(address);
        return list;
    }

    @Override
    public int addAddress(Address address) {
       return addressDao.insertSelective(address);
    }

    @Override
    public int updateById(Address address) {
        return addressDao.updateByPrimaryKeySelective(address);
    }

    @Override
    public int deleteById(int id) {
        return addressDao.deleteByPrimaryKey(id);
    }
}
