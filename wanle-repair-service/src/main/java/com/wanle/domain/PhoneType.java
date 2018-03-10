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

  /**手机图标**/
  private String phoneIcon;


  /**颜色**/

  private String colorId;




  public void setId(Long id) { 
    this.id = id;
  }


  public Long getId() { 
    return this.id;
  }


  public void setPhoneName(String phoneName) { 
    this.phoneName = phoneName;
  }


  public String getPhoneName() { 
    return this.phoneName;
  }


  public void setPhoneType(String phoneType) { 
    this.phoneType = phoneType;
  }


  public String getPhoneType() { 
    return this.phoneType;
  }


  public void setPhoneImg(String phoneImg) { 
    this.phoneImg = phoneImg;
  }


  public String getPhoneImg() { 
    return this.phoneImg;
  }


  public void setColorId(String colorId) { 
    this.colorId = colorId;
  }


  public String getColorId() { 
    return this.colorId;
  }

  public String getPhoneIcon() {
    return phoneIcon;
  }

  public void setPhoneIcon(String phoneIcon) {
    this.phoneIcon = phoneIcon;
  }
}
