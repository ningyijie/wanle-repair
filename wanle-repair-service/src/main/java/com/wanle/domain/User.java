package com.wanle.domain;

import java.io.Serializable;

public class User implements Serializable {
    private Long id;

    private String wxId;

    private Integer wxSex;

    private String wxName;

    private String wxProvince;

    private String wxCity;

    private Integer state;

    private String idNo;

    private String mobile;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWxId() {
        return wxId;
    }

    public void setWxId(String wxId) {
        this.wxId = wxId == null ? null : wxId.trim();
    }

    public Integer getWxSex() {
        return wxSex;
    }

    public void setWxSex(Integer wxSex) {
        this.wxSex = wxSex;
    }

    public String getWxName() {
        return wxName;
    }

    public void setWxName(String wxName) {
        this.wxName = wxName == null ? null : wxName.trim();
    }

    public String getWxProvince() {
        return wxProvince;
    }

    public void setWxProvince(String wxProvince) {
        this.wxProvince = wxProvince == null ? null : wxProvince.trim();
    }

    public String getWxCity() {
        return wxCity;
    }

    public void setWxCity(String wxCity) {
        this.wxCity = wxCity == null ? null : wxCity.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo == null ? null : idNo.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getWxId() == null ? other.getWxId() == null : this.getWxId().equals(other.getWxId()))
            && (this.getWxSex() == null ? other.getWxSex() == null : this.getWxSex().equals(other.getWxSex()))
            && (this.getWxName() == null ? other.getWxName() == null : this.getWxName().equals(other.getWxName()))
            && (this.getWxProvince() == null ? other.getWxProvince() == null : this.getWxProvince().equals(other.getWxProvince()))
            && (this.getWxCity() == null ? other.getWxCity() == null : this.getWxCity().equals(other.getWxCity()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getIdNo() == null ? other.getIdNo() == null : this.getIdNo().equals(other.getIdNo()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getWxId() == null) ? 0 : getWxId().hashCode());
        result = prime * result + ((getWxSex() == null) ? 0 : getWxSex().hashCode());
        result = prime * result + ((getWxName() == null) ? 0 : getWxName().hashCode());
        result = prime * result + ((getWxProvince() == null) ? 0 : getWxProvince().hashCode());
        result = prime * result + ((getWxCity() == null) ? 0 : getWxCity().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getIdNo() == null) ? 0 : getIdNo().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", wxId=").append(wxId);
        sb.append(", wxSex=").append(wxSex);
        sb.append(", wxName=").append(wxName);
        sb.append(", wxProvince=").append(wxProvince);
        sb.append(", wxCity=").append(wxCity);
        sb.append(", state=").append(state);
        sb.append(", idNo=").append(idNo);
        sb.append(", mobile=").append(mobile);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}