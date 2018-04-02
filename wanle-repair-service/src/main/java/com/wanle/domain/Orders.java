package com.wanle.domain;

import java.math.BigDecimal;


/**
 * 
 *  订单表
 * 
 **/
public class Orders implements java.io.Serializable {


  private static final long serialVersionUID = 1L;


  /****/

  private Long id;


  /**用户 id**/

  private Long userId;


  /**订单号**/

  private String orderNo;


  /**手机型号**/

  private Integer phoneId;


  /**维修 id  维修关联**/

  private Integer repairId;


  /**价格**/

  private BigDecimal prices;


  /**收货地址**/

  private Integer addressId;


  /**备注**/

  private String remark;


  /**订单类型，1、上门  2、到店**/

  private Integer type;


  /**预约时间**/

  private String appointmentTime;




  public void setId(Long id) { 
    this.id = id;
  }


  public Long getId() { 
    return this.id;
  }


  public void setUserId(Long userId) { 
    this.userId = userId;
  }


  public Long getUserId() { 
    return this.userId;
  }


  public String getOrderNo() {
    return orderNo;
  }

  public void setOrderNo(String orderNo) {
    this.orderNo = orderNo;
  }

  public void setPhoneId(Integer phoneId) {
    this.phoneId = phoneId;
  }


  public Integer getPhoneId() { 
    return this.phoneId;
  }


  public void setRepairId(Integer repairId) { 
    this.repairId = repairId;
  }


  public Integer getRepairId() { 
    return this.repairId;
  }


  public void setPrices(BigDecimal prices) { 
    this.prices = prices;
  }


  public BigDecimal getPrices() { 
    return this.prices;
  }


  public void setAddressId(Integer addressId) { 
    this.addressId = addressId;
  }


  public Integer getAddressId() { 
    return this.addressId;
  }


  public void setRemark(String remark) { 
    this.remark = remark;
  }


  public String getRemark() { 
    return this.remark;
  }


  public void setType(Integer type) { 
    this.type = type;
  }


  public Integer getType() { 
    return this.type;
  }


  public void setAppointmentTime(String appointmentTime) { 
    this.appointmentTime = appointmentTime;
  }


  public String getAppointmentTime() { 
    return this.appointmentTime;
  }

}
