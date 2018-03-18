package com.wanle.repair.api.service;

import com.wanle.domain.Address;

import java.util.List;

public interface AddressService {

    public List<Address> selectAllByUserId(Long userId);

    int addAddress(Address address);

    int updateById(Address address);

    int deleteById(int id);
}
