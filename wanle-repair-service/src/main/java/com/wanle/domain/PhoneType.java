package com.wanle.domain;


import io.swagger.annotations.ApiModelProperty;

public class PhoneType implements java.io.Serializable {


  private static final long serialVersionUID = 1L;


  @ApiModelProperty("")

  private Long id;


  @ApiModelProperty("手机品牌")

  private String phoneName;


  @ApiModelProperty("手机型号")

  private String phoneType;


  @ApiModelProperty("手机图片")

  private String phoneImg;

  @ApiModelProperty("手机图标")
  private String phoneIcon;


  @ApiModelProperty("颜色")

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
