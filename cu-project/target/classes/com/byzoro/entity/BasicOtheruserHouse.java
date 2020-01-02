package com.byzoro.entity;

import java.io.Serializable;

/**
 * basic_otheruser_house
 * @author 
 */
public class BasicOtheruserHouse implements Serializable {
    /**
     * 自增主健
     */
    private Long id;

    /**
     * 占用机房信息ID
     */
    private Long hhid;

    /**
     * 其他用户id
     */
    private Long userId;

    /**
     * IDC/ISP机房ID
     */
    private String houseId;

    /**
     * 资源分配时间
     */
    private Integer distributeTime;

    /**
     * 网络宽带
     */
    private Integer bandWidth;

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

    public Long getHhid() {
        return hhid;
    }

    public void setHhid(Long hhid) {
        this.hhid = hhid;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public Integer getDistributeTime() {
        return distributeTime;
    }

    public void setDistributeTime(Integer distributeTime) {
        this.distributeTime = distributeTime;
    }

    public Integer getBandWidth() {
        return bandWidth;
    }

    public void setBandWidth(Integer bandWidth) {
        this.bandWidth = bandWidth;
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
        BasicOtheruserHouse other = (BasicOtheruserHouse) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getHhid() == null ? other.getHhid() == null : this.getHhid().equals(other.getHhid()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getHouseId() == null ? other.getHouseId() == null : this.getHouseId().equals(other.getHouseId()))
            && (this.getDistributeTime() == null ? other.getDistributeTime() == null : this.getDistributeTime().equals(other.getDistributeTime()))
            && (this.getBandWidth() == null ? other.getBandWidth() == null : this.getBandWidth().equals(other.getBandWidth()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getHhid() == null) ? 0 : getHhid().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getHouseId() == null) ? 0 : getHouseId().hashCode());
        result = prime * result + ((getDistributeTime() == null) ? 0 : getDistributeTime().hashCode());
        result = prime * result + ((getBandWidth() == null) ? 0 : getBandWidth().hashCode());
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
        sb.append(", hhid=").append(hhid);
        sb.append(", userId=").append(userId);
        sb.append(", houseId=").append(houseId);
        sb.append(", distributeTime=").append(distributeTime);
        sb.append(", bandWidth=").append(bandWidth);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}