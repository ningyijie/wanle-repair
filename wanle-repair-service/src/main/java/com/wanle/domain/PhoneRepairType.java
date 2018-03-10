package com.wanle.domain;



/**
 * 
 * 手机维修类型表
 * 
 **/
public class PhoneRepairType implements java.io.Serializable {


  private static final long serialVersionUID = 1L;


  /****/

  private Integer id;


  /****/

  private Integer phoneId;


  /****/

  private String repairId;


  /****/

  private String colorId;




  public void setId(Integer id) { 
    this.id = id;
  }


  public Integer getId() { 
    return this.id;
  }


  public void setPhoneId(Integer phoneId) { 
    this.phoneId = phoneId;
  }


  public Integer getPhoneId() { 
    return this.phoneId;
  }


  public void setRepairId(String repairId) { 
    this.repairId = repairId;
  }


  public String getRepairId() { 
    return this.repairId;
  }


  public String getColorId() {
    return colorId;
  }

  public void setColorId(String colorId) {
    this.colorId = colorId;
  }
}
