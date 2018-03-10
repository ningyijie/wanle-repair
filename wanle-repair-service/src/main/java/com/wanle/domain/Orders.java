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

  private Integer userId;


  /**订单号**/

  private Long orderNo;


  /**手机型号**/

  private Integer phoneId;


  /**维修 id  维修关联**/

  private Integer repairId;


  /**价格**/

  private BigDecimal prices;




  public void setId(Long id) {     this.id = id;
  }


  public Long getId() {     return this.id;
  }


  public void setUserId(Integer userId) {     this.userId = userId;
  }


  public Integer getUserId() {     return this.userId;
  }


  public void setOrderNo(Long orderNo) {     this.orderNo = orderNo;
  }


  public Long getOrderNo() {     return this.orderNo;
  }


  public void setPhoneId(Integer phoneId) {     this.phoneId = phoneId;
  }


  public Integer getPhoneId() {     return this.phoneId;
  }


  public void setRepairId(Integer repairId) {     this.repairId = repairId;
  }


  public Integer getRepairId() {     return this.repairId;
  }


  public void setPrices(BigDecimal prices) {     this.prices = prices;
  }


  public BigDecimal getPrices() {     return this.prices;
  }

}
