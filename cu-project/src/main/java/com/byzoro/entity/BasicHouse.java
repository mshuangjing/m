package com.byzoro.entity;

import java.io.Serializable;

/**
 * basic_house
 * @author 
 */
public class BasicHouse implements Serializable {
    /**
     * 自增主健
     */
    private Long id;

    /**
     * 机房id，全局唯一
     */
    private String houseId;

    /**
     * 机房名称
     */
    private String houseName;

    /**
     * IDC/ISP许可证号
     */
    private String idcId;

    /**
     * 机房性质。见10.4
     */
    private Integer houseType;

    /**
     * 机房所在省或者直辖市
     */
    private Integer province;

    /**
     * 机房所市或者区
     */
    private Integer city;

    /**
     * 机房所有县
     */
    private Integer county;

    /**
     * 机房地址
     */
    private String houseAddr;

    /**
     * 邮编
     */
    private String houseZip;

    /**
     * 机房网络安全责任人姓名
     */
    private String houseOfficerName;

    /**
     * 机房网络安全责任人证件类型见10.3
     */
    private Integer houseOfficerIdtype;

    /**
     * 机房网络安全责任人证件号码
     */
    private String houseOfficerId;

    /**
     * 机房网络安全责任人固定电话
     */
    private String houseOfficerTel;

    /**
     * 机房网络安全责任人移动电话
     */
    private String houseOfficerMobile;

    /**
     * 机房网络安全责任人邮箱
     */
    private String houseOfficerEmail;

    /**
     * 0不变，1新增，2修改，3删除
     */
    private Boolean status;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getIdcId() {
        return idcId;
    }

    public void setIdcId(String idcId) {
        this.idcId = idcId;
    }

    public Integer getHouseType() {
        return houseType;
    }

    public void setHouseType(Integer houseType) {
        this.houseType = houseType;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getCounty() {
        return county;
    }

    public void setCounty(Integer county) {
        this.county = county;
    }

    public String getHouseAddr() {
        return houseAddr;
    }

    public void setHouseAddr(String houseAddr) {
        this.houseAddr = houseAddr;
    }

    public String getHouseZip() {
        return houseZip;
    }

    public void setHouseZip(String houseZip) {
        this.houseZip = houseZip;
    }

    public String getHouseOfficerName() {
        return houseOfficerName;
    }

    public void setHouseOfficerName(String houseOfficerName) {
        this.houseOfficerName = houseOfficerName;
    }

    public Integer getHouseOfficerIdtype() {
        return houseOfficerIdtype;
    }

    public void setHouseOfficerIdtype(Integer houseOfficerIdtype) {
        this.houseOfficerIdtype = houseOfficerIdtype;
    }

    public String getHouseOfficerId() {
        return houseOfficerId;
    }

    public void setHouseOfficerId(String houseOfficerId) {
        this.houseOfficerId = houseOfficerId;
    }

    public String getHouseOfficerTel() {
        return houseOfficerTel;
    }

    public void setHouseOfficerTel(String houseOfficerTel) {
        this.houseOfficerTel = houseOfficerTel;
    }

    public String getHouseOfficerMobile() {
        return houseOfficerMobile;
    }

    public void setHouseOfficerMobile(String houseOfficerMobile) {
        this.houseOfficerMobile = houseOfficerMobile;
    }

    public String getHouseOfficerEmail() {
        return houseOfficerEmail;
    }

    public void setHouseOfficerEmail(String houseOfficerEmail) {
        this.houseOfficerEmail = houseOfficerEmail;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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
        BasicHouse other = (BasicHouse) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getHouseId() == null ? other.getHouseId() == null : this.getHouseId().equals(other.getHouseId()))
            && (this.getHouseName() == null ? other.getHouseName() == null : this.getHouseName().equals(other.getHouseName()))
            && (this.getIdcId() == null ? other.getIdcId() == null : this.getIdcId().equals(other.getIdcId()))
            && (this.getHouseType() == null ? other.getHouseType() == null : this.getHouseType().equals(other.getHouseType()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getCounty() == null ? other.getCounty() == null : this.getCounty().equals(other.getCounty()))
            && (this.getHouseAddr() == null ? other.getHouseAddr() == null : this.getHouseAddr().equals(other.getHouseAddr()))
            && (this.getHouseZip() == null ? other.getHouseZip() == null : this.getHouseZip().equals(other.getHouseZip()))
            && (this.getHouseOfficerName() == null ? other.getHouseOfficerName() == null : this.getHouseOfficerName().equals(other.getHouseOfficerName()))
            && (this.getHouseOfficerIdtype() == null ? other.getHouseOfficerIdtype() == null : this.getHouseOfficerIdtype().equals(other.getHouseOfficerIdtype()))
            && (this.getHouseOfficerId() == null ? other.getHouseOfficerId() == null : this.getHouseOfficerId().equals(other.getHouseOfficerId()))
            && (this.getHouseOfficerTel() == null ? other.getHouseOfficerTel() == null : this.getHouseOfficerTel().equals(other.getHouseOfficerTel()))
            && (this.getHouseOfficerMobile() == null ? other.getHouseOfficerMobile() == null : this.getHouseOfficerMobile().equals(other.getHouseOfficerMobile()))
            && (this.getHouseOfficerEmail() == null ? other.getHouseOfficerEmail() == null : this.getHouseOfficerEmail().equals(other.getHouseOfficerEmail()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getHouseId() == null) ? 0 : getHouseId().hashCode());
        result = prime * result + ((getHouseName() == null) ? 0 : getHouseName().hashCode());
        result = prime * result + ((getIdcId() == null) ? 0 : getIdcId().hashCode());
        result = prime * result + ((getHouseType() == null) ? 0 : getHouseType().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getCounty() == null) ? 0 : getCounty().hashCode());
        result = prime * result + ((getHouseAddr() == null) ? 0 : getHouseAddr().hashCode());
        result = prime * result + ((getHouseZip() == null) ? 0 : getHouseZip().hashCode());
        result = prime * result + ((getHouseOfficerName() == null) ? 0 : getHouseOfficerName().hashCode());
        result = prime * result + ((getHouseOfficerIdtype() == null) ? 0 : getHouseOfficerIdtype().hashCode());
        result = prime * result + ((getHouseOfficerId() == null) ? 0 : getHouseOfficerId().hashCode());
        result = prime * result + ((getHouseOfficerTel() == null) ? 0 : getHouseOfficerTel().hashCode());
        result = prime * result + ((getHouseOfficerMobile() == null) ? 0 : getHouseOfficerMobile().hashCode());
        result = prime * result + ((getHouseOfficerEmail() == null) ? 0 : getHouseOfficerEmail().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", houseId=").append(houseId);
        sb.append(", houseName=").append(houseName);
        sb.append(", idcId=").append(idcId);
        sb.append(", houseType=").append(houseType);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", county=").append(county);
        sb.append(", houseAddr=").append(houseAddr);
        sb.append(", houseZip=").append(houseZip);
        sb.append(", houseOfficerName=").append(houseOfficerName);
        sb.append(", houseOfficerIdtype=").append(houseOfficerIdtype);
        sb.append(", houseOfficerId=").append(houseOfficerId);
        sb.append(", houseOfficerTel=").append(houseOfficerTel);
        sb.append(", houseOfficerMobile=").append(houseOfficerMobile);
        sb.append(", houseOfficerEmail=").append(houseOfficerEmail);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}