package com.wanle.api.service.impl;

import com.wanle.api.service.PhoneRepairTypeService;
import com.wanle.dao.ConsumableDao;
import com.wanle.dao.PhoneRepairTypeDao;
import com.wanle.dao.RepairTypeDao;
import com.wanle.domain.Consumable;
import com.wanle.domain.PhoneRepairType;
import com.wanle.domain.RepairType;
import com.wanle.vo.RepairTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * Created by ningyijie on 2018/3/4.
 */
@Service
public class PhoneRepairTypeServiceImpl implements PhoneRepairTypeService {

    private static Logger LOGGER = LoggerFactory.getLogger(PhoneRepairTypeServiceImpl.class);


    @Autowired
    private PhoneRepairTypeDao phoneRepairTypeDao;
    @Autowired
    private RepairTypeDao repairTypeDao;
    @Autowired
    private ConsumableDao consumableDao;

    @Override
    public List<RepairTree> getRepaairTypeByPhoneAndColor(PhoneRepairType phoneRepairType) {
        //根据手机 id 和颜色得到所有维修信息
        PhoneRepairType phoneRepairTypes= phoneRepairTypeDao.selectByCondition(phoneRepairType);
        if(phoneRepairTypes!=null && phoneRepairTypes.getRepairId()!=null) {
            List<Long> longIds=new ArrayList<>();
            for(String id: Arrays.asList(phoneRepairTypes.getRepairId().split(","))){
                longIds.add(Long.valueOf(id));
            }
            //根据 repairId 得到维修列表返回
            List<RepairType> repairTypeList=repairTypeDao.selectByIds(longIds);

           List<RepairTree> repairTreeList= combineRepairType(repairTypeList,phoneRepairType);

            return repairTreeList;

        }
        return null;


    }

    /**
     * method_name: combineRepairType
     * param: [repairTypeList]
     * describe: TODO 组装所有维修类型
     * creat_user: ningyijie@finupgroup.com
     * creat_date: 2018/3/5
     * creat_time: 下午2:53
     **/
    public List combineRepairType(List<RepairType> repairTypeList,PhoneRepairType phoneRepairType){

        Map<Long,RepairTree> repairTreeMap=new HashMap<>();
        //组装返回对的列表类型
        if (repairTypeList != null && repairTypeList.size() > 0) {
            for (RepairType repairType : repairTypeList) {
                if (repairType != null) {
                    if (!repairTreeMap.containsKey(repairType.getPid())) {
                        //所有维修类型全部是二级分类，所以查询出一级分类,一级分类才加入 map
                        RepairType repairTypeRoot = repairTypeDao.selectByPrimaryKey(repairType.getPid());
                        repairTreeMap.put(repairType.getPid(), new RepairTree(repairTypeRoot.getId(), repairTypeRoot.getRepairName()));
                    }
                    RepairTree repairTreeNode = repairTreeMap.get(repairType.getPid());
                    //子节点中，需要关联查询硬件价格
                    repairTreeNode.addChildren(new RepairTree(repairType.getId(), repairType.getRepairName(),getConsumableList(repairType,phoneRepairType)));
                    repairTreeMap.put(repairType.getPid(), repairTreeNode);

                }
            }
        }
        LOGGER.info(repairTreeMap.toString());
        return Arrays.asList(repairTreeMap.values().toArray());
    }

    /**
     * 获取耗材信息
     * 根据 phoneId，repairId，colorId 获取指定耗材和其价格
     */
    public List<Consumable> getConsumableList(RepairType repairType, PhoneRepairType phoneRepairType){
        Consumable consumableParam=new Consumable();
        consumableParam.setPhoneId(phoneRepairType.getPhoneId());
        consumableParam.setRepairId(repairType.getId());
        List<Consumable> consumableList=consumableDao.list(consumableParam);
        List<Consumable> consumableResult=null;
       if(consumableList!=null && consumableList.size()>0) {
           consumableResult=new ArrayList<>();
           for (Consumable consumable : consumableList) {
               if ((consumable.getColor() == null || phoneRepairType.getColorId()==null) ||(consumable!=null && phoneRepairType.getColorId().contains(consumable.getColor()))){
                   consumableResult.add(consumable);
               }


           }
       }

        return consumableResult;
    }
}
