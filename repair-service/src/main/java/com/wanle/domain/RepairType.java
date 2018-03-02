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


  /**手机类型外键**/

  private Integer phoneId;


  /**维修一级分类**/

  private String firstType;


  /**维修二级分类**/

  private String secondeType;


  /**耗材id**/

  private Integer consumableId;


  /****/

  private String description;


  /**颜色**/

  private String color;


  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setPhoneId(Integer phoneId) {
    this.phoneId = phoneId;
  }


  public Integer getPhoneId() { 
    return this.phoneId;
  }


  public void setFirstType(String firstType) { 
    this.firstType = firstType;
  }


  public String getFirstType() { 
    return this.firstType;
  }


  public void setSecondeType(String secondeType) { 
    this.secondeType = secondeType;
  }


  public String getSecondeType() { 
    return this.secondeType;
  }


  public void setConsumableId(Integer consumableId) { 
    this.consumableId = consumableId;
  }


  public Integer getConsumableId() { 
    return this.consumableId;
  }


  public void setDescription(String description) { 
    this.description = description;
  }


  public String getDescription() { 
    return this.description;
  }


  public void setColor(String color) { 
    this.color = color;
  }


  public String getColor() { 
    return this.color;
  }

}
