package com.wanle.domain;



/**
 * 
 *  手机型号表
 * 
 **/
public class PhoneType implements java.io.Serializable {


  private static final long serialVersionUID = 1L;


  /****/

  private Long id;


  /**手机品牌**/

  private String phoneName;


  /**手机型号**/

  private String phoneType;


  /**手机图片**/

  private String phoneImg;


  /**颜色**/

  private Integer colorId;




  public void setId(Long id) { 
  }


  public Long getId() { 
  }


  public void setPhoneName(String phoneName) { 
  }


  public String getPhoneName() { 
  }


  public void setPhoneType(String phoneType) { 
  }


  public String getPhoneType() { 
  }


  public void setPhoneImg(String phoneImg) { 
  }


  public String getPhoneImg() { 
  }


  public void setColorId(Integer colorId) { 
  }


  public Integer getColorId() { 
  }

}