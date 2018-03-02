package com.wanle.domain;



/**
 * 
 * 耗材表
 * 
 **/
public class Consumable implements java.io.Serializable {


  private static final long serialVersionUID = 1L;


  /****/

  private Long  id;


  /**机型外键**/

  private Integer phoneId;


  /**耗材名称**/

  private String name;


  /**剩余**/

  private Integer remain;


  /**颜色**/

  private String color;


  /**售价**/

  private Integer price;


  /**官方售价**/

  private Integer priceOnline;


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
