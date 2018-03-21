package com.wanle.domain;


import io.swagger.annotations.ApiModelProperty;


public class Consumable implements java.io.Serializable {


  private static final long serialVersionUID = 1L;


  @ApiModelProperty("")

  private Long  id;


  @ApiModelProperty("机型外键")

  private Integer phoneId;


  @ApiModelProperty("")

  private Long repairId;


  @ApiModelProperty("耗材名称")

  private String name;


  @ApiModelProperty("剩余")

  private Integer remain;


  @ApiModelProperty("颜色")

  private String color;


  @ApiModelProperty("售价")

  private Integer price;


  @ApiModelProperty("官方售价")

  private Integer priceOnline;


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


  public Long getRepairId() {
    return repairId;
  }

  public void setRepairId(Long repairId) {
    this.repairId = repairId;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getName() { 
    return this.name;
  }


  public void setRemain(Integer remain) { 
    this.remain = remain;
  }


  public Integer getRemain() { 
    return this.remain;
  }


  public void setColor(String color) { 
    this.color = color;
  }


  public String getColor() { 
    return this.color;
  }


  public void setPrice(Integer price) { 
    this.price = price;
  }


  public Integer getPrice() { 
    return this.price;
  }


  public void setPriceOnline(Integer priceOnline) { 
    this.priceOnline = priceOnline;
  }


  public Integer getPriceOnline() { 
    return this.priceOnline;
  }

}
