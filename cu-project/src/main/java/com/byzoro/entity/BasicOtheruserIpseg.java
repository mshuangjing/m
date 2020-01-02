package com.byzoro.entity;

import java.io.Serializable;

/**
 * basic_otheruser_ipseg
 * @author 
 */
public class BasicOtheruserIpseg implements Serializable {
    /**
     * 自增主健。IP段编号，全局唯一
     */
    private Long ipId;

    /**
     * 占用机房id
     */
    private Long hhid;

    /**
     * 起始IP地址
     */
    private String startIp;

    /**
     * 终止IP地址
     */
    private String endIp;

    private Boolean isSpecial;

    /**
     * 0不变，1新增，2修改，3删除
     */
    private Boolean status;

    private static final long serialVersionUID = 1L;

    public Long getIpId() {
        return ipId;
    }

    public void setIpId(Long ipId) {
        this.ipId = ipId;
    }

    public Long getHhid() {
        return hhid;
    }

    public void setHhid(Long hhid) {
        this.hhid = hhid;
    }

    public String getStartIp() {
        return startIp;
    }

    public void setStartIp(String startIp) {
        this.startIp = startIp;
    }

    public String getEndIp() {
        return endIp;
    }

    public void setEndIp(String endIp) {
        this.endIp = endIp;
    }

    public Boolean getIsSpecial() {
        return isSpecial;
    }

    public void setIsSpecial(Boolean isSpecial) {
        this.isSpecial = isSpecial;
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
        BasicOtheruserIpseg other = (BasicOtheruserIpseg) that;
        return (this.getIpId() == null ? other.getIpId() == null : this.getIpId().equals(other.getIpId()))
            && (this.getHhid() == null ? other.getHhid() == null : this.getHhid().equals(other.getHhid()))
            && (this.getStartIp() == null ? other.getStartIp() == null : this.getStartIp().equals(other.getStartIp()))
            && (this.getEndIp() == null ? other.getEndIp() == null : this.getEndIp().equals(other.getEndIp()))
            && (this.getIsSpecial() == null ? other.getIsSpecial() == null : this.getIsSpecial().equals(other.getIsSpecial()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIpId() == null) ? 0 : getIpId().hashCode());
        result = prime * result + ((getHhid() == null) ? 0 : getHhid().hashCode());
        result = prime * result + ((getStartIp() == null) ? 0 : getStartIp().hashCode());
        result = prime * result + ((getEndIp() == null) ? 0 : getEndIp().hashCode());
        result = prime * result + ((getIsSpecial() == null) ? 0 : getIsSpecial().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ipId=").append(ipId);
        sb.append(", hhid=").append(hhid);
        sb.append(", startIp=").append(startIp);
        sb.append(", endIp=").append(endIp);
        sb.append(", isSpecial=").append(isSpecial);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}