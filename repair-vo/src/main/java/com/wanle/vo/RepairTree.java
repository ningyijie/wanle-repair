package com.wanle.vo;

import com.wanle.domain.Consumable;

import java.util.ArrayList;
import java.util.List;

/**
 * class_name: RepairTree
 * package: com.wanle.vo
 * describe: TODO
 * creat_user: ningyijie@finupgroup.com
 * creat_date: 2018/3/5
 * creat_time: 下午2:03
 **/
public class RepairTree {
    private  Long treeId;//树的主键
    private  String treeName;//  树的名称
    private List<Consumable> consumableList;//对应耗材信息
    private List<RepairTree> nodes;//子树

    public RepairTree(Long treeId , String treeName)  {
       this.treeId=treeId;
       this.treeName=treeName;

    }
    public RepairTree(Long treeId , String treeName,List<Consumable> consumableList)  {
       this.treeId=treeId;
       this.treeName=treeName;
       this.consumableList=consumableList;

    }

    public void addChildren(RepairTree treeItem) {
        if (nodes == null)
            nodes = new ArrayList<RepairTree>();
        nodes.add(treeItem);
    }

    public Long getTreeId() {
        return treeId;
    }

    public void setTreeId(Long treeId) {
        this.treeId = treeId;
    }

    public String getTreeName() {
        return treeName;
    }

    public void setTreeName(String treeName) {
        this.treeName = treeName;
    }

    public List<RepairTree> getNodes() {
        return nodes;
    }

    public void setNodes(List<RepairTree> nodes) {
        this.nodes = nodes;
    }

    public List<Consumable> getConsumableList() {
        return consumableList;
    }

    public void setConsumableList(List<Consumable> consumableList) {
        this.consumableList = consumableList;
    }
}
