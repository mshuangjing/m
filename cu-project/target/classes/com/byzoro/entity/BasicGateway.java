package com.byzoro.entity;

import java.io.Serializable;

/**
 * basic_gateway
 * @author 
 */
public class BasicGateway implements Serializable {
    /**
     * 自增主健，机房互联网入口ID，全局唯一
     */
    private Long id;

    /**
     * 机房id
     */
    private String houseId;

    /**
     * 链路带宽
     */
    private Long bandwidth;

    /**
     * 链路类型 1.电信，2.联通，3.移动，3铁通，9.其他
     */
    private Boolean linktype;

    /**
     * 链路接入单位信息
     */
    private String accessunit;

    /**
     * 网管IP地址
     */
    private String gatewayip;

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

    public Long getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(Long bandwidth) {
        this.bandwidth = bandwidth;
    }

    public Boolean getLinktype() {
        return linktype;
    }

    public void setLinktype(Boolean linktype) {
        this.linktype = linktype;
    }

    public String getAccessunit() {
        return accessunit;
    }

    public void setAccessunit(String accessunit) {
        this.accessunit = accessunit;
    }

    public String getGatewayip() {
        return gatewayip;
    }

    public void setGatewayip(String gatewayip) {
        this.gatewayip = gatewayip;
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
        BasicGateway other = (BasicGateway) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getHouseId() == null ? other.getHouseId() == null : this.getHouseId().equals(other.getHouseId()))
            && (this.getBandwidth() == null ? other.getBandwidth() == null : this.getBandwidth().equals(other.getBandwidth()))
            && (this.getLinktype() == null ? other.getLinktype() == null : this.getLinktype().equals(other.getLinktype()))
            && (this.getAccessunit() == null ? other.getAccessunit() == null : this.getAccessunit().equals(other.getAccessunit()))
            && (this.getGatewayip() == null ? other.getGatewayip() == null : this.getGatewayip().equals(other.getGatewayip()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getHouseId() == null) ? 0 : getHouseId().hashCode());
        result = prime * result + ((getBandwidth() == null) ? 0 : getBandwidth().hashCode());
        result = prime * result + ((getLinktype() == null) ? 0 : getLinktype().hashCode());
        result = prime * result + ((getAccessunit() == null) ? 0 : getAccessunit().hashCode());
        result = prime * result + ((getGatewayip() == null) ? 0 : getGatewayip().hashCode());
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
        sb.append(", bandwidth=").append(bandwidth);
        sb.append(", linktype=").append(linktype);
        sb.append(", accessunit=").append(accessunit);
        sb.append(", gatewayip=").append(gatewayip);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}