package com.wanle.api.service;

import com.wanle.domain.PhoneType;

import java.util.List;

/**
 * Created by ningyijie on 2018/3/3.
 */
public interface PhoneService {

    List<PhoneType> getAllPhoneTypeByCondition();
}
