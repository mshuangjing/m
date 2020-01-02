package com.byzoro.entity;

import java.io.Serializable;

/**
 * basic_ipseg
 * @author 
 */
public class BasicIpseg implements Serializable {
    /**
     * 自增主健，IP地址段资源编号，全局唯一
     */
    private Long id;

    /**
     * 机房id
     */
    private String houseId;

    /**
     * 起始IP地址
     */
    private String startip;

    /**
     * 终止IP地址
     */
    private String endip;

    /**
     * IP地址使用类型 0静止，1动态，2保留
     */
    private Boolean type;

    /**
     * 使用人或者单位
     */
    private String user;

    /**
     * 使用人证件类型 见10.3
     */
    private Integer idType;

    /**
     * 证件号码
     */
    private String idnumber;

    /**
     * 来源单位
     */
    private String sourceunit;

    /**
     * 分配单位
     */
    private String allocationunit;

    /**
     * 分配使用时间
     */
    private Integer usertime;

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

    public String getStartip() {
        return startip;
    }

    public void setStartip(String startip) {
        this.startip = startip;
    }

    public String getEndip() {
        return endip;
    }

    public void setEndip(String endip) {
        this.endip = endip;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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

    public String getSourceunit() {
        return sourceunit;
    }

    public void setSourceunit(String sourceunit) {
        this.sourceunit = sourceunit;
    }

    public String getAllocationunit() {
        return allocationunit;
    }

    public void setAllocationunit(String allocationunit) {
        this.allocationunit = allocationunit;
    }

    public Integer getUsertime() {
        return usertime;
    }

    public void setUsertime(Integer usertime) {
        this.usertime = usertime;
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
        BasicIpseg other = (BasicIpseg) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getHouseId() == null ? other.getHouseId() == null : this.getHouseId().equals(other.getHouseId()))
            && (this.getStartip() == null ? other.getStartip() == null : this.getStartip().equals(other.getStartip()))
            && (this.getEndip() == null ? other.getEndip() == null : this.getEndip().equals(other.getEndip()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getUser() == null ? other.getUser() == null : this.getUser().equals(other.getUser()))
            && (this.getIdType() == null ? other.getIdType() == null : this.getIdType().equals(other.getIdType()))
            && (this.getIdnumber() == null ? other.getIdnumber() == null : this.getIdnumber().equals(other.getIdnumber()))
            && (this.getSourceunit() == null ? other.getSourceunit() == null : this.getSourceunit().equals(other.getSourceunit()))
            && (this.getAllocationunit() == null ? other.getAllocationunit() == null : this.getAllocationunit().equals(other.getAllocationunit()))
            && (this.getUsertime() == null ? other.getUsertime() == null : this.getUsertime().equals(other.getUsertime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getHouseId() == null) ? 0 : getHouseId().hashCode());
        result = prime * result + ((getStartip() == null) ? 0 : getStartip().hashCode());
        result = prime * result + ((getEndip() == null) ? 0 : getEndip().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getUser() == null) ? 0 : getUser().hashCode());
        result = prime * result + ((getIdType() == null) ? 0 : getIdType().hashCode());
        result = prime * result + ((getIdnumber() == null) ? 0 : getIdnumber().hashCode());
        result = prime * result + ((getSourceunit() == null) ? 0 : getSourceunit().hashCode());
        result = prime * result + ((getAllocationunit() == null) ? 0 : getAllocationunit().hashCode());
        result = prime * result + ((getUsertime() == null) ? 0 : getUsertime().hashCode());
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
        sb.append(", startip=").append(startip);
        sb.append(", endip=").append(endip);
        sb.append(", type=").append(type);
        sb.append(", user=").append(user);
        sb.append(", idType=").append(idType);
        sb.append(", idnumber=").append(idnumber);
        sb.append(", sourceunit=").append(sourceunit);
        sb.append(", allocationunit=").append(allocationunit);
        sb.append(", usertime=").append(usertime);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}