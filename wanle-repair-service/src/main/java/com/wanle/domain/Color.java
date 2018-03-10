package com.wanle.domain;



/**
 * 
 * 颜色表
 * 
 **/
public class Color implements java.io.Serializable {


  private static final long serialVersionUID = 1L;


  /****/

  private Long id;


  /**颜色**/

  private String color;




  public void setId(Long id) {     this.id = id;
  }


  public Long getId() {     return this.id;
  }


  public void setColor(String color) {     this.color = color;
  }


  public String getColor() {     return this.color;
  }

}
