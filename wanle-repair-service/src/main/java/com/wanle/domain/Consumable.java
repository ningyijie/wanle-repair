package com.wanle.domain;

import io.swagger.annotations.ApiModelProperty;import java.math.BigDecimal;
import java.util.Date;


/**
 * 
 * 耗材表
 * 
 **/
public class Consumable implements java.io.Serializable {


  private static final long serialVersionUID = 1L;


  @ApiModelProperty("")

  private Long id;


  @ApiModelProperty("机型外键")

  private Integer phoneId;


  @ApiModelProperty("维修类型 id")

  private Long repairId;


  @ApiModelProperty("耗材名称")

  private String name;


  @ApiModelProperty("剩余")

  private Integer remain;


  @ApiModelProperty("颜色")

  private String color;


  @ApiModelProperty("零售价")

  private BigDecimal price;


  @ApiModelProperty("会员价")

  private BigDecimal memPrice;


  @ApiModelProperty("活动、促销 价格")

  private BigDecimal activityPrice;


  @ApiModelProperty("成本价")

  private BigDecimal costPrice;


  @ApiModelProperty("创建时间")

  private Date createTime;


  @ApiModelProperty("更新时间")

  private Date updateTime;




  public void setId(Long id) {     this.id = id;
  }


  public Long getId() {     return this.id;
  }


  public void setPhoneId(Integer phoneId) {     this.phoneId = phoneId;
  }


  public Integer getPhoneId() {     return this.phoneId;
  }


  public void setRepairId(Long repairId) {     this.repairId = repairId;
  }


  public Long getRepairId() {     return this.repairId;
  }


  public void setName(String name) {     this.name = name;
  }


  public String getName() {     return this.name;
  }


  public void setRemain(Integer remain) {     this.remain = remain;
  }


  public Integer getRemain() {     return this.remain;
  }


  public void setColor(String color) {     this.color = color;
  }


  public String getColor() {     return this.color;
  }


  public void setPrice(BigDecimal price) {     this.price = price;
  }


  public BigDecimal getPrice() {     return this.price;
  }


  public void setMemPrice(BigDecimal memPrice) {     this.memPrice = memPrice;
  }


  public BigDecimal getMemPrice() {     return this.memPrice;
  }


  public void setActivityPrice(BigDecimal activityPrice) {     this.activityPrice = activityPrice;
  }


  public BigDecimal getActivityPrice() {     return this.activityPrice;
  }


  public void setCostPrice(BigDecimal costPrice) {     this.costPrice = costPrice;
  }


  public BigDecimal getCostPrice() {     return this.costPrice;
  }


  public void setCreateTime(Date createTime) {     this.createTime = createTime;
  }


  public Date getCreateTime() {     return this.createTime;
  }


  public void setUpdateTime(Date updateTime) {     this.updateTime = updateTime;
  }


  public Date getUpdateTime() {     return this.updateTime;
  }

}
