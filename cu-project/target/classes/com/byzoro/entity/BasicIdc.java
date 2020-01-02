package com.byzoro.entity;

import java.io.Serializable;

/**
 * basic_idc
 * @author 
 */
public class BasicIdc implements Serializable {
    /**
     * 自增主健
     */
    private Long id;

    /**
     * IDC/ISP许可证号
     */
    private String idcId;

    /**
     * 经营者名称
     */
    private String idcName;

    /**
     * 经营者通信地址
     */
    private String idcAddr;

    /**
     * 经营者通信邮编
     */
    private String idcZip;

    /**
     * 企业法人
     */
    private String idcCorp;

    /**
     * 网络信息安全责任人姓名
     */
    private String idcOfficerName;

    /**
     * 网络安全信息责任人证件类型见10.3
     */
    private Integer idcOfficerIdtype;

    /**
     * 网络信息安全责任人证件号码
     */
    private String idcOfficerId;

    /**
     * 网络信息安全责任人固定电话
     */
    private String idcOfficerTel;

    /**
     * 网络信息安全责任人移动电话
     */
    private String idcOfficerMobile;

    /**
     * 网络信息安全责任人邮箱
     */
    private String idcOfficerEmail;

    /**
     * 应急联系人姓名
     */
    private String idcEmergencyName;

    /**
     * 应急联系人证件类型见10.3
     */
    private Integer idcEmergencyIdtype;

    /**
     * 应急联系人证件号码
     */
    private String idcEmergencyId;

    /**
     * 应急联系人固定电话
     */
    private String idcEmergencyTel;

    /**
     * 应急联系人移动电话
     */
    private String idcEmergencyMobile;

    /**
     * 应急联系人邮箱
     */
    private String idcEmergencyEmail;

    /**
     * 0.不变，1.新增，2修改，3删除
     */
    private Boolean idcStatus;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdcId() {
        return idcId;
    }

    public void setIdcId(String idcId) {
        this.idcId = idcId;
    }

    public String getIdcName() {
        return idcName;
    }

    public void setIdcName(String idcName) {
        this.idcName = idcName;
    }

    public String getIdcAddr() {
        return idcAddr;
    }

    public void setIdcAddr(String idcAddr) {
        this.idcAddr = idcAddr;
    }

    public String getIdcZip() {
        return idcZip;
    }

    public void setIdcZip(String idcZip) {
        this.idcZip = idcZip;
    }

    public String getIdcCorp() {
        return idcCorp;
    }

    public void setIdcCorp(String idcCorp) {
        this.idcCorp = idcCorp;
    }

    public String getIdcOfficerName() {
        return idcOfficerName;
    }

    public void setIdcOfficerName(String idcOfficerName) {
        this.idcOfficerName = idcOfficerName;
    }

    public Integer getIdcOfficerIdtype() {
        return idcOfficerIdtype;
    }

    public void setIdcOfficerIdtype(Integer idcOfficerIdtype) {
        this.idcOfficerIdtype = idcOfficerIdtype;
    }

    public String getIdcOfficerId() {
        return idcOfficerId;
    }

    public void setIdcOfficerId(String idcOfficerId) {
        this.idcOfficerId = idcOfficerId;
    }

    public String getIdcOfficerTel() {
        return idcOfficerTel;
    }

    public void setIdcOfficerTel(String idcOfficerTel) {
        this.idcOfficerTel = idcOfficerTel;
    }

    public String getIdcOfficerMobile() {
        return idcOfficerMobile;
    }

    public void setIdcOfficerMobile(String idcOfficerMobile) {
        this.idcOfficerMobile = idcOfficerMobile;
    }

    public String getIdcOfficerEmail() {
        return idcOfficerEmail;
    }

    public void setIdcOfficerEmail(String idcOfficerEmail) {
        this.idcOfficerEmail = idcOfficerEmail;
    }

    public String getIdcEmergencyName() {
        return idcEmergencyName;
    }

    public void setIdcEmergencyName(String idcEmergencyName) {
        this.idcEmergencyName = idcEmergencyName;
    }

    public Integer getIdcEmergencyIdtype() {
        return idcEmergencyIdtype;
    }

    public void setIdcEmergencyIdtype(Integer idcEmergencyIdtype) {
        this.idcEmergencyIdtype = idcEmergencyIdtype;
    }

    public String getIdcEmergencyId() {
        return idcEmergencyId;
    }

    public void setIdcEmergencyId(String idcEmergencyId) {
        this.idcEmergencyId = idcEmergencyId;
    }

    public String getIdcEmergencyTel() {
        return idcEmergencyTel;
    }

    public void setIdcEmergencyTel(String idcEmergencyTel) {
        this.idcEmergencyTel = idcEmergencyTel;
    }

    public String getIdcEmergencyMobile() {
        return idcEmergencyMobile;
    }

    public void setIdcEmergencyMobile(String idcEmergencyMobile) {
        this.idcEmergencyMobile = idcEmergencyMobile;
    }

    public String getIdcEmergencyEmail() {
        return idcEmergencyEmail;
    }

    public void setIdcEmergencyEmail(String idcEmergencyEmail) {
        this.idcEmergencyEmail = idcEmergencyEmail;
    }

    public Boolean getIdcStatus() {
        return idcStatus;
    }

    public void setIdcStatus(Boolean idcStatus) {
        this.idcStatus = idcStatus;
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
        BasicIdc other = (BasicIdc) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIdcId() == null ? other.getIdcId() == null : this.getIdcId().equals(other.getIdcId()))
            && (this.getIdcName() == null ? other.getIdcName() == null : this.getIdcName().equals(other.getIdcName()))
            && (this.getIdcAddr() == null ? other.getIdcAddr() == null : this.getIdcAddr().equals(other.getIdcAddr()))
            && (this.getIdcZip() == null ? other.getIdcZip() == null : this.getIdcZip().equals(other.getIdcZip()))
            && (this.getIdcCorp() == null ? other.getIdcCorp() == null : this.getIdcCorp().equals(other.getIdcCorp()))
            && (this.getIdcOfficerName() == null ? other.getIdcOfficerName() == null : this.getIdcOfficerName().equals(other.getIdcOfficerName()))
            && (this.getIdcOfficerIdtype() == null ? other.getIdcOfficerIdtype() == null : this.getIdcOfficerIdtype().equals(other.getIdcOfficerIdtype()))
            && (this.getIdcOfficerId() == null ? other.getIdcOfficerId() == null : this.getIdcOfficerId().equals(other.getIdcOfficerId()))
            && (this.getIdcOfficerTel() == null ? other.getIdcOfficerTel() == null : this.getIdcOfficerTel().equals(other.getIdcOfficerTel()))
            && (this.getIdcOfficerMobile() == null ? other.getIdcOfficerMobile() == null : this.getIdcOfficerMobile().equals(other.getIdcOfficerMobile()))
            && (this.getIdcOfficerEmail() == null ? other.getIdcOfficerEmail() == null : this.getIdcOfficerEmail().equals(other.getIdcOfficerEmail()))
            && (this.getIdcEmergencyName() == null ? other.getIdcEmergencyName() == null : this.getIdcEmergencyName().equals(other.getIdcEmergencyName()))
            && (this.getIdcEmergencyIdtype() == null ? other.getIdcEmergencyIdtype() == null : this.getIdcEmergencyIdtype().equals(other.getIdcEmergencyIdtype()))
            && (this.getIdcEmergencyId() == null ? other.getIdcEmergencyId() == null : this.getIdcEmergencyId().equals(other.getIdcEmergencyId()))
            && (this.getIdcEmergencyTel() == null ? other.getIdcEmergencyTel() == null : this.getIdcEmergencyTel().equals(other.getIdcEmergencyTel()))
            && (this.getIdcEmergencyMobile() == null ? other.getIdcEmergencyMobile() == null : this.getIdcEmergencyMobile().equals(other.getIdcEmergencyMobile()))
            && (this.getIdcEmergencyEmail() == null ? other.getIdcEmergencyEmail() == null : this.getIdcEmergencyEmail().equals(other.getIdcEmergencyEmail()))
            && (this.getIdcStatus() == null ? other.getIdcStatus() == null : this.getIdcStatus().equals(other.getIdcStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIdcId() == null) ? 0 : getIdcId().hashCode());
        result = prime * result + ((getIdcName() == null) ? 0 : getIdcName().hashCode());
        result = prime * result + ((getIdcAddr() == null) ? 0 : getIdcAddr().hashCode());
        result = prime * result + ((getIdcZip() == null) ? 0 : getIdcZip().hashCode());
        result = prime * result + ((getIdcCorp() == null) ? 0 : getIdcCorp().hashCode());
        result = prime * result + ((getIdcOfficerName() == null) ? 0 : getIdcOfficerName().hashCode());
        result = prime * result + ((getIdcOfficerIdtype() == null) ? 0 : getIdcOfficerIdtype().hashCode());
        result = prime * result + ((getIdcOfficerId() == null) ? 0 : getIdcOfficerId().hashCode());
        result = prime * result + ((getIdcOfficerTel() == null) ? 0 : getIdcOfficerTel().hashCode());
        result = prime * result + ((getIdcOfficerMobile() == null) ? 0 : getIdcOfficerMobile().hashCode());
        result = prime * result + ((getIdcOfficerEmail() == null) ? 0 : getIdcOfficerEmail().hashCode());
        result = prime * result + ((getIdcEmergencyName() == null) ? 0 : getIdcEmergencyName().hashCode());
        result = prime * result + ((getIdcEmergencyIdtype() == null) ? 0 : getIdcEmergencyIdtype().hashCode());
        result = prime * result + ((getIdcEmergencyId() == null) ? 0 : getIdcEmergencyId().hashCode());
        result = prime * result + ((getIdcEmergencyTel() == null) ? 0 : getIdcEmergencyTel().hashCode());
        result = prime * result + ((getIdcEmergencyMobile() == null) ? 0 : getIdcEmergencyMobile().hashCode());
        result = prime * result + ((getIdcEmergencyEmail() == null) ? 0 : getIdcEmergencyEmail().hashCode());
        result = prime * result + ((getIdcStatus() == null) ? 0 : getIdcStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", idcId=").append(idcId);
        sb.append(", idcName=").append(idcName);
        sb.append(", idcAddr=").append(idcAddr);
        sb.append(", idcZip=").append(idcZip);
        sb.append(", idcCorp=").append(idcCorp);
        sb.append(", idcOfficerName=").append(idcOfficerName);
        sb.append(", idcOfficerIdtype=").append(idcOfficerIdtype);
        sb.append(", idcOfficerId=").append(idcOfficerId);
        sb.append(", idcOfficerTel=").append(idcOfficerTel);
        sb.append(", idcOfficerMobile=").append(idcOfficerMobile);
        sb.append(", idcOfficerEmail=").append(idcOfficerEmail);
        sb.append(", idcEmergencyName=").append(idcEmergencyName);
        sb.append(", idcEmergencyIdtype=").append(idcEmergencyIdtype);
        sb.append(", idcEmergencyId=").append(idcEmergencyId);
        sb.append(", idcEmergencyTel=").append(idcEmergencyTel);
        sb.append(", idcEmergencyMobile=").append(idcEmergencyMobile);
        sb.append(", idcEmergencyEmail=").append(idcEmergencyEmail);
        sb.append(", idcStatus=").append(idcStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}