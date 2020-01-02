package com.byzoro.entity;

import java.io.Serializable;

/**
 * basic_iptrans
 * @author 
 */
public class BasicIptrans implements Serializable {
    /**
     * 主健自增
     */
    private Long id;

    /**
     * 域名ID，对应basic_domain表中domain_id
     */
    private Long domainId;

    /**
     * 占用机房信息id
     */
    private Long hhid;

    /**
     * 互联网起始IP地址
     */
    private String internetStartIp;

    /**
     * 互联网终止IP地址
     */
    private String internetEndIp;

    /**
     * 0不变，1新增，2修改，3删除
     */
    private String netStartIp;

    private String netEndIp;

    private Boolean status;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDomainId() {
        return domainId;
    }

    public void setDomainId(Long domainId) {
        this.domainId = domainId;
    }

    public Long getHhid() {
        return hhid;
    }

    public void setHhid(Long hhid) {
        this.hhid = hhid;
    }

    public String getInternetStartIp() {
        return internetStartIp;
    }

    public void setInternetStartIp(String internetStartIp) {
        this.internetStartIp = internetStartIp;
    }

    public String getInternetEndIp() {
        return internetEndIp;
    }

    public void setInternetEndIp(String internetEndIp) {
        this.internetEndIp = internetEndIp;
    }

    public String getNetStartIp() {
        return netStartIp;
    }

    public void setNetStartIp(String netStartIp) {
        this.netStartIp = netStartIp;
    }

    public String getNetEndIp() {
        return netEndIp;
    }

    public void setNetEndIp(String netEndIp) {
        this.netEndIp = netEndIp;
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
        BasicIptrans other = (BasicIptrans) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDomainId() == null ? other.getDomainId() == null : this.getDomainId().equals(other.getDomainId()))
            && (this.getHhid() == null ? other.getHhid() == null : this.getHhid().equals(other.getHhid()))
            && (this.getInternetStartIp() == null ? other.getInternetStartIp() == null : this.getInternetStartIp().equals(other.getInternetStartIp()))
            && (this.getInternetEndIp() == null ? other.getInternetEndIp() == null : this.getInternetEndIp().equals(other.getInternetEndIp()))
            && (this.getNetStartIp() == null ? other.getNetStartIp() == null : this.getNetStartIp().equals(other.getNetStartIp()))
            && (this.getNetEndIp() == null ? other.getNetEndIp() == null : this.getNetEndIp().equals(other.getNetEndIp()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDomainId() == null) ? 0 : getDomainId().hashCode());
        result = prime * result + ((getHhid() == null) ? 0 : getHhid().hashCode());
        result = prime * result + ((getInternetStartIp() == null) ? 0 : getInternetStartIp().hashCode());
        result = prime * result + ((getInternetEndIp() == null) ? 0 : getInternetEndIp().hashCode());
        result = prime * result + ((getNetStartIp() == null) ? 0 : getNetStartIp().hashCode());
        result = prime * result + ((getNetEndIp() == null) ? 0 : getNetEndIp().hashCode());
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
        sb.append(", domainId=").append(domainId);
        sb.append(", hhid=").append(hhid);
        sb.append(", internetStartIp=").append(internetStartIp);
        sb.append(", internetEndIp=").append(internetEndIp);
        sb.append(", netStartIp=").append(netStartIp);
        sb.append(", netEndIp=").append(netEndIp);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}