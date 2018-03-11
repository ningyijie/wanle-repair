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




  public void setId(Long id) { 
  }


  public Long getId() { 
  }


  public void setUserId(Integer userId) { 
  }


  public Integer getUserId() { 
  }


  public void setOrderNo(Long orderNo) { 
  }


  public Long getOrderNo() { 
  }


  public void setPhoneId(Integer phoneId) { 
  }


  public Integer getPhoneId() { 
  }


  public void setRepairId(Integer repairId) { 
  }


  public Integer getRepairId() { 
  }


  public void setPrices(BigDecimal prices) { 
  }


  public BigDecimal getPrices() { 
  }

}