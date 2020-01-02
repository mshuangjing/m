package com.byzoro.entity;

import java.io.Serializable;

/**
 * log_active_state
 * @author 
 */
public class LogActiveState implements Serializable {
    private Long id;

    /**
     * idc/isp许可证号
     */
    private String idcId;

    /**
     * 机房总数
     */
    private Integer houseAmount;

    /**
     * 异常机房总数
     */
    private Integer errhouseAmount;

    /**
     * 上报时间
     */
    private Integer timestamp;

    /**
     * 异常机房id，多个以逗号分隔
     */
    private String errhouseId;

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

    public Integer getHouseAmount() {
        return houseAmount;
    }

    public void setHouseAmount(Integer houseAmount) {
        this.houseAmount = houseAmount;
    }

    public Integer getErrhouseAmount() {
        return errhouseAmount;
    }

    public void setErrhouseAmount(Integer errhouseAmount) {
        this.errhouseAmount = errhouseAmount;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public String getErrhouseId() {
        return errhouseId;
    }

    public void setErrhouseId(String errhouseId) {
        this.errhouseId = errhouseId;
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
        LogActiveState other = (LogActiveState) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIdcId() == null ? other.getIdcId() == null : this.getIdcId().equals(other.getIdcId()))
            && (this.getHouseAmount() == null ? other.getHouseAmount() == null : this.getHouseAmount().equals(other.getHouseAmount()))
            && (this.getErrhouseAmount() == null ? other.getErrhouseAmount() == null : this.getErrhouseAmount().equals(other.getErrhouseAmount()))
            && (this.getTimestamp() == null ? other.getTimestamp() == null : this.getTimestamp().equals(other.getTimestamp()))
            && (this.getErrhouseId() == null ? other.getErrhouseId() == null : this.getErrhouseId().equals(other.getErrhouseId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIdcId() == null) ? 0 : getIdcId().hashCode());
        result = prime * result + ((getHouseAmount() == null) ? 0 : getHouseAmount().hashCode());
        result = prime * result + ((getErrhouseAmount() == null) ? 0 : getErrhouseAmount().hashCode());
        result = prime * result + ((getTimestamp() == null) ? 0 : getTimestamp().hashCode());
        result = prime * result + ((getErrhouseId() == null) ? 0 : getErrhouseId().hashCode());
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
        sb.append(", houseAmount=").append(houseAmount);
        sb.append(", errhouseAmount=").append(errhouseAmount);
        sb.append(", timestamp=").append(timestamp);
        sb.append(", errhouseId=").append(errhouseId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}