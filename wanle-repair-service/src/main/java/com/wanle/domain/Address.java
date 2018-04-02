package com.wanle.domain;


import io.swagger.annotations.ApiModelProperty;

public class Address implements java.io.Serializable {


  private static final long serialVersionUID = 1L;

  

  private Integer id;


  @ApiModelProperty("用户id")

  private Long userId;


  @ApiModelProperty("地址")

  private String address;


  @ApiModelProperty("联系电话")

  private String mobile;


  @ApiModelProperty("联系人")

  private String name;




  public void setId(Integer id) { 
    this.id = id;
  }


  public Integer getId() { 
    return this.id;
  }


  public void setUserId(Long userId) { 
    this.userId = userId;
  }


  public Long getUserId() { 
    return this.userId;
  }


  public void setAddress(String address) { 
    this.address = address;
  }


  public String getAddress() { 
    return this.address;
  }


  public void setMobile(String mobile) { 
    this.mobile = mobile;
  }


  public String getMobile() { 
    return this.mobile;
  }


  public void setName(String name) { 
    this.name = name;
  }


  public String getName() { 
    return this.name;
  }

}
