package com.byzoro.entity;

import java.io.Serializable;

/**
 * basic_user
 * @author 
 */
public class BasicUser implements Serializable {
    /**
     * 自增主健，用户ID，全局唯一
     */
    private Long userId;

    /**
     * IDC/ISP许可证号
     */
    private String idcId;

    /**
     * 用户属性 1.提供互联网服务用户 2.其他用户
     */
    private Boolean nature;

    /**
     * 单位名称
     */
    private String unitname;

    /**
     * 单位属性，见10.2
     */
    private Integer unitnature;

    /**
     * 证件类型，见10.3
     */
    private Integer idType;

    /**
     * 证件号码
     */
    private String idnumber;

    /**
     * 网络信息安全责任人姓名
     */
    private String officerName;

    /**
     * 网络信息安全责任人证件类型见10.3
     */
    private Integer officerIdtype;

    /**
     * 网络信息安全责任人证件号码
     */
    private String officerId;

    /**
     * 网络信息安全责任人固定电话
     */
    private String officerTel;

    /**
     * 网络信息安全责任人移动电话
     */
    private String officerMobile;

    /**
     * 网络信息安全责任人邮箱
     */
    private String officerEmail;

    /**
     * 单位地址
     */
    private String addr;

    /**
     * 邮政编码
     */
    private String zipCode;

    /**
     * 服务开通时间，只有其他用户时需要填写，互联网用户不需要填写
     */
    private Integer serviceRegTime;

    /**
     * 注册时间
     */
    private Integer registerTime;

    /**
     * 0不变，1新增，2修改，3删除
     */
    private Boolean status;

    private Byte isUser;

    private static final long serialVersionUID = 1L;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getIdcId() {
        return idcId;
    }

    public void setIdcId(String idcId) {
        this.idcId = idcId;
    }

    public Boolean getNature() {
        return nature;
    }

    public void setNature(Boolean nature) {
        this.nature = nature;
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    public Integer getUnitnature() {
        return unitnature;
    }

    public void setUnitnature(Integer unitnature) {
        this.unitnature = unitnature;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getOfficerName() {
        return officerName;
    }

    public void setOfficerName(String officerName) {
        this.officerName = officerName;
    }

    public Integer getOfficerIdtype() {
        return officerIdtype;
    }

    public void setOfficerIdtype(Integer officerIdtype) {
        this.officerIdtype = officerIdtype;
    }

    public String getOfficerId() {
        return officerId;
    }

    public void setOfficerId(String officerId) {
        this.officerId = officerId;
    }

    public String getOfficerTel() {
        return officerTel;
    }

    public void setOfficerTel(String officerTel) {
        this.officerTel = officerTel;
    }

    public String getOfficerMobile() {
        return officerMobile;
    }

    public void setOfficerMobile(String officerMobile) {
        this.officerMobile = officerMobile;
    }

    public String getOfficerEmail() {
        return officerEmail;
    }

    public void setOfficerEmail(String officerEmail) {
        this.officerEmail = officerEmail;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getServiceRegTime() {
        return serviceRegTime;
    }

    public void setServiceRegTime(Integer serviceRegTime) {
        this.serviceRegTime = serviceRegTime;
    }

    public Integer getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Integer registerTime) {
        this.registerTime = registerTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Byte getIsUser() {
        return isUser;
    }

    public void setIsUser(Byte isUser) {
        this.isUser = isUser;
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
        BasicUser other = (BasicUser) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getIdcId() == null ? other.getIdcId() == null : this.getIdcId().equals(other.getIdcId()))
            && (this.getNature() == null ? other.getNature() == null : this.getNature().equals(other.getNature()))
            && (this.getUnitname() == null ? other.getUnitname() == null : this.getUnitname().equals(other.getUnitname()))
            && (this.getUnitnature() == null ? other.getUnitnature() == null : this.getUnitnature().equals(other.getUnitnature()))
            && (this.getIdType() == null ? other.getIdType() == null : this.getIdType().equals(other.getIdType()))
            && (this.getIdnumber() == null ? other.getIdnumber() == null : this.getIdnumber().equals(other.getIdnumber()))
            && (this.getOfficerName() == null ? other.getOfficerName() == null : this.getOfficerName().equals(other.getOfficerName()))
            && (this.getOfficerIdtype() == null ? other.getOfficerIdtype() == null : this.getOfficerIdtype().equals(other.getOfficerIdtype()))
            && (this.getOfficerId() == null ? other.getOfficerId() == null : this.getOfficerId().equals(other.getOfficerId()))
            && (this.getOfficerTel() == null ? other.getOfficerTel() == null : this.getOfficerTel().equals(other.getOfficerTel()))
            && (this.getOfficerMobile() == null ? other.getOfficerMobile() == null : this.getOfficerMobile().equals(other.getOfficerMobile()))
            && (this.getOfficerEmail() == null ? other.getOfficerEmail() == null : this.getOfficerEmail().equals(other.getOfficerEmail()))
            && (this.getAddr() == null ? other.getAddr() == null : this.getAddr().equals(other.getAddr()))
            && (this.getZipCode() == null ? other.getZipCode() == null : this.getZipCode().equals(other.getZipCode()))
            && (this.getServiceRegTime() == null ? other.getServiceRegTime() == null : this.getServiceRegTime().equals(other.getServiceRegTime()))
            && (this.getRegisterTime() == null ? other.getRegisterTime() == null : this.getRegisterTime().equals(other.getRegisterTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getIsUser() == null ? other.getIsUser() == null : this.getIsUser().equals(other.getIsUser()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getIdcId() == null) ? 0 : getIdcId().hashCode());
        result = prime * result + ((getNature() == null) ? 0 : getNature().hashCode());
        result = prime * result + ((getUnitname() == null) ? 0 : getUnitname().hashCode());
        result = prime * result + ((getUnitnature() == null) ? 0 : getUnitnature().hashCode());
        result = prime * result + ((getIdType() == null) ? 0 : getIdType().hashCode());
        result = prime * result + ((getIdnumber() == null) ? 0 : getIdnumber().hashCode());
        result = prime * result + ((getOfficerName() == null) ? 0 : getOfficerName().hashCode());
        result = prime * result + ((getOfficerIdtype() == null) ? 0 : getOfficerIdtype().hashCode());
        result = prime * result + ((getOfficerId() == null) ? 0 : getOfficerId().hashCode());
        result = prime * result + ((getOfficerTel() == null) ? 0 : getOfficerTel().hashCode());
        result = prime * result + ((getOfficerMobile() == null) ? 0 : getOfficerMobile().hashCode());
        result = prime * result + ((getOfficerEmail() == null) ? 0 : getOfficerEmail().hashCode());
        result = prime * result + ((getAddr() == null) ? 0 : getAddr().hashCode());
        result = prime * result + ((getZipCode() == null) ? 0 : getZipCode().hashCode());
        result = prime * result + ((getServiceRegTime() == null) ? 0 : getServiceRegTime().hashCode());
        result = prime * result + ((getRegisterTime() == null) ? 0 : getRegisterTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getIsUser() == null) ? 0 : getIsUser().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", idcId=").append(idcId);
        sb.append(", nature=").append(nature);
        sb.append(", unitname=").append(unitname);
        sb.append(", unitnature=").append(unitnature);
        sb.append(", idType=").append(idType);
        sb.append(", idnumber=").append(idnumber);
        sb.append(", officerName=").append(officerName);
        sb.append(", officerIdtype=").append(officerIdtype);
        sb.append(", officerId=").append(officerId);
        sb.append(", officerTel=").append(officerTel);
        sb.append(", officerMobile=").append(officerMobile);
        sb.append(", officerEmail=").append(officerEmail);
        sb.append(", addr=").append(addr);
        sb.append(", zipCode=").append(zipCode);
        sb.append(", serviceRegTime=").append(serviceRegTime);
        sb.append(", registerTime=").append(registerTime);
        sb.append(", status=").append(status);
        sb.append(", isUser=").append(isUser);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}