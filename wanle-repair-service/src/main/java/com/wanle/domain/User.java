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




  public void setId(Long id) {     this.id = id;
  }


  public Long getId() {     return this.id;
  }


  public void setWxId(String wxId) {     this.wxId = wxId;
  }


  public String getWxId() {     return this.wxId;
  }


  public void setWxSex(Integer wxSex) {     this.wxSex = wxSex;
  }


  public Integer getWxSex() {     return this.wxSex;
  }


  public void setWxName(String wxName) {     this.wxName = wxName;
  }


  public String getWxName() {     return this.wxName;
  }


  public void setWxProvince(String wxProvince) {     this.wxProvince = wxProvince;
  }


  public String getWxProvince() {     return this.wxProvince;
  }


  public void setWxCity(String wxCity) {     this.wxCity = wxCity;
  }


  public String getWxCity() {     return this.wxCity;
  }


  public void setState(Integer state) {     this.state = state;
  }


  public Integer getState() {     return this.state;
  }


  public void setIdNo(String idNo) {     this.idNo = idNo;
  }


  public String getIdNo() {     return this.idNo;
  }


  public void setMobile(String mobile) {     this.mobile = mobile;
  }


  public String getMobile() {     return this.mobile;
  }

}
