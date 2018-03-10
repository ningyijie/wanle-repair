package com.wanle.domain;



/**
 * 
 *  维修类型
 * 
 **/
public class RepairType implements java.io.Serializable {


  private static final long serialVersionUID = 1L;


  /****/

  private Long  id;


  /**维修一级分类**/

  private String repairName;


  /**父级 id**/

  private Long  pid;



  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getPid() {
    return pid;
  }

  public void setPid(Long pid) {
    this.pid = pid;
  }

  public void setRepairName(String repairName) {
    this.repairName = repairName;
  }


  public String getRepairName() { 
    return this.repairName;
  }




}
