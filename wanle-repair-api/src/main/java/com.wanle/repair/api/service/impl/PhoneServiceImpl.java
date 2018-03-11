package com.wanle.repair.api.service.impl;

import com.wanle.repair.api.service.PhoneService;
import com.wanle.dao.PhoneTypeDao;
import com.wanle.domain.PhoneType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by ningyijie on 2018/3/3.
 */
@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneTypeDao phoneTypeDao;

    @Override
    public Map getAllPhoneTypeByCondition() {
        List<PhoneType> phoneTypeList=phoneTypeDao.list(new PhoneType());
        //按品牌组合
        //group by price
        Map<String, List<PhoneType>> groupByPriceMap =
                phoneTypeList.stream().collect(Collectors.groupingBy(PhoneType::getPhoneName));
        return groupByPriceMap;
    }
}
