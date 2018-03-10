package com.wanle.api.service;

import com.wanle.domain.PhoneRepairType;
import com.wanle.vo.RepairTree;

import java.util.List;

/**
 * Created by ningyijie on 2018/3/4.
 */
public interface PhoneRepairTypeService {

     List<RepairTree> getRepaairTypeByPhoneAndColor(PhoneRepairType phoneRepairType);
}
