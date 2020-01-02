package com.byzoro.entity;

import java.io.Serializable;

/**
 * basic_frame
 * @author 
 */
public class BasicFrame implements Serializable {
    /**
     * 自增主健，机房信息id，全局唯一
     */
    private Long id;

    /**
     * 机房id
     */
    private String houseId;

    /**
     * 适用类型1.自用，2.出租
     */
    private Boolean usertype;

    /**
     * 分配状态 1.未分配 2.已分配
     */
    private Boolean distribution;

    /**
     * 占用状态 2.未占用 2.已占用
     */
    private Boolean occupancy;

    /**
     * 机房/机位名称
     */
    private String frameName;

    /**
     * 是否为专线 1.否 2.是
     */
    private Boolean isSpecial;

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

    public Boolean getUsertype() {
        return usertype;
    }

    public void setUsertype(Boolean usertype) {
        this.usertype = usertype;
    }

    public Boolean getDistribution() {
        return distribution;
    }

    public void setDistribution(Boolean distribution) {
        this.distribution = distribution;
    }

    public Boolean getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(Boolean occupancy) {
        this.occupancy = occupancy;
    }

    public String getFrameName() {
        return frameName;
    }

    public void setFrameName(String frameName) {
        this.frameName = frameName;
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
        BasicFrame other = (BasicFrame) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getHouseId() == null ? other.getHouseId() == null : this.getHouseId().equals(other.getHouseId()))
            && (this.getUsertype() == null ? other.getUsertype() == null : this.getUsertype().equals(other.getUsertype()))
            && (this.getDistribution() == null ? other.getDistribution() == null : this.getDistribution().equals(other.getDistribution()))
            && (this.getOccupancy() == null ? other.getOccupancy() == null : this.getOccupancy().equals(other.getOccupancy()))
            && (this.getFrameName() == null ? other.getFrameName() == null : this.getFrameName().equals(other.getFrameName()))
            && (this.getIsSpecial() == null ? other.getIsSpecial() == null : this.getIsSpecial().equals(other.getIsSpecial()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getHouseId() == null) ? 0 : getHouseId().hashCode());
        result = prime * result + ((getUsertype() == null) ? 0 : getUsertype().hashCode());
        result = prime * result + ((getDistribution() == null) ? 0 : getDistribution().hashCode());
        result = prime * result + ((getOccupancy() == null) ? 0 : getOccupancy().hashCode());
        result = prime * result + ((getFrameName() == null) ? 0 : getFrameName().hashCode());
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
        sb.append(", id=").append(id);
        sb.append(", houseId=").append(houseId);
        sb.append(", usertype=").append(usertype);
        sb.append(", distribution=").append(distribution);
        sb.append(", occupancy=").append(occupancy);
        sb.append(", frameName=").append(frameName);
        sb.append(", isSpecial=").append(isSpecial);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}