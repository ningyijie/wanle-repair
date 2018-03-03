package com.wanle.api.service;

import com.wanle.dao.PhoneTypeDao;
import com.wanle.domain.PhoneType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ningyijie on 2018/3/3.
 */
@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneTypeDao phoneTypeDao;

    @Override
    public List<PhoneType> getAllPhoneTypeByCondition() {
        phoneTypeDao.selectByPrimaryKey(1L);
        List<PhoneType> phoneTypeList=phoneTypeDao.list(new PhoneType());
        return phoneTypeList;
    }
}
