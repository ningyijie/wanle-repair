package com.wanle.domain;



/**
 * 
 * 
 * 
 **/
public class User implements java.io.Serializable {


  private static final long serialVersionUID = 1L;


  /**自增长 id**/

  private Long id;


  /**微信唯一 id**/

  private String wxId;


  /**性别 ：0 女  1 男**/

  private Integer wxSex;


  /**微信昵称**/

  private String wxName;


  /**微信省份**/

  private String wxProvince;


  /**微信城市**/

  private String wxCity;


  /**关注状态：1 关注  2  取消关注**/

  private Integer state;


  /**身份证号**/

  private String idNo;


  /**手机号**/

  private String mobile;




  public void setId(Long id) { 
  }


  public Long getId() { 
  }


  public void setWxId(String wxId) { 
  }


  public String getWxId() { 
  }


  public void setWxSex(Integer wxSex) { 
  }


  public Integer getWxSex() { 
  }


  public void setWxName(String wxName) { 
  }


  public String getWxName() { 
  }


  public void setWxProvince(String wxProvince) { 
  }


  public String getWxProvince() { 
  }


  public void setWxCity(String wxCity) { 
  }


  public String getWxCity() { 
  }


  public void setState(Integer state) { 
  }


  public Integer getState() { 
  }


  public void setIdNo(String idNo) { 
  }


  public String getIdNo() { 
  }


  public void setMobile(String mobile) { 
  }


  public String getMobile() { 
  }

}