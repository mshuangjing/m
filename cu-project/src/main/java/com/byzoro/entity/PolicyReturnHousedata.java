package com.byzoro.entity;

import java.io.Serializable;

/**
 * policy_return_housedata
 * @author 
 */
public class PolicyReturnHousedata implements Serializable {
    /**
     * 自增主健
     */
    private Long id;

    /**
     * 机房id
     */
    private String houseId;

    /**
     * 链路id
     */
    private Long gatewayId;

    /**
     * IP段id
     */
    private Long ipSegId;

    /**
     * 机架信息
     */
    private Long frameInfoId;

    /**
     * 退回数据id。对应policy_basic_return中的id
     */
    private Long basicReturnInfoId;

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

    public Long getGatewayId() {
        return gatewayId;
    }

    public void setGatewayId(Long gatewayId) {
        this.gatewayId = gatewayId;
    }

    public Long getIpSegId() {
        return ipSegId;
    }

    public void setIpSegId(Long ipSegId) {
        this.ipSegId = ipSegId;
    }

    public Long getFrameInfoId() {
        return frameInfoId;
    }

    public void setFrameInfoId(Long frameInfoId) {
        this.frameInfoId = frameInfoId;
    }

    public Long getBasicReturnInfoId() {
        return basicReturnInfoId;
    }

    public void setBasicReturnInfoId(Long basicReturnInfoId) {
        this.basicReturnInfoId = basicReturnInfoId;
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
        PolicyReturnHousedata other = (PolicyReturnHousedata) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getHouseId() == null ? other.getHouseId() == null : this.getHouseId().equals(other.getHouseId()))
            && (this.getGatewayId() == null ? other.getGatewayId() == null : this.getGatewayId().equals(other.getGatewayId()))
            && (this.getIpSegId() == null ? other.getIpSegId() == null : this.getIpSegId().equals(other.getIpSegId()))
            && (this.getFrameInfoId() == null ? other.getFrameInfoId() == null : this.getFrameInfoId().equals(other.getFrameInfoId()))
            && (this.getBasicReturnInfoId() == null ? other.getBasicReturnInfoId() == null : this.getBasicReturnInfoId().equals(other.getBasicReturnInfoId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getHouseId() == null) ? 0 : getHouseId().hashCode());
        result = prime * result + ((getGatewayId() == null) ? 0 : getGatewayId().hashCode());
        result = prime * result + ((getIpSegId() == null) ? 0 : getIpSegId().hashCode());
        result = prime * result + ((getFrameInfoId() == null) ? 0 : getFrameInfoId().hashCode());
        result = prime * result + ((getBasicReturnInfoId() == null) ? 0 : getBasicReturnInfoId().hashCode());
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
        sb.append(", gatewayId=").append(gatewayId);
        sb.append(", ipSegId=").append(ipSegId);
        sb.append(", frameInfoId=").append(frameInfoId);
        sb.append(", basicReturnInfoId=").append(basicReturnInfoId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}