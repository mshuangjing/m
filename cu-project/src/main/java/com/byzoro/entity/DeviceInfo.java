package com.byzoro.entity;

import java.io.Serializable;

/**
 * device_info
 * @author 
 */
public class DeviceInfo implements Serializable {
    private Long id;

    /**
     * 机房名称
     */
    private String houseId;

    /**
     * 社保名称
     */
    private String deviceName;

    /**
     * webservice接口地址
     */
    private String webserviceAddr;

    /**
     * 0离线，1在线
     */
    private Boolean online;

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

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getWebserviceAddr() {
        return webserviceAddr;
    }

    public void setWebserviceAddr(String webserviceAddr) {
        this.webserviceAddr = webserviceAddr;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
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
        DeviceInfo other = (DeviceInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getHouseId() == null ? other.getHouseId() == null : this.getHouseId().equals(other.getHouseId()))
            && (this.getDeviceName() == null ? other.getDeviceName() == null : this.getDeviceName().equals(other.getDeviceName()))
            && (this.getWebserviceAddr() == null ? other.getWebserviceAddr() == null : this.getWebserviceAddr().equals(other.getWebserviceAddr()))
            && (this.getOnline() == null ? other.getOnline() == null : this.getOnline().equals(other.getOnline()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getHouseId() == null) ? 0 : getHouseId().hashCode());
        result = prime * result + ((getDeviceName() == null) ? 0 : getDeviceName().hashCode());
        result = prime * result + ((getWebserviceAddr() == null) ? 0 : getWebserviceAddr().hashCode());
        result = prime * result + ((getOnline() == null) ? 0 : getOnline().hashCode());
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
        sb.append(", deviceName=").append(deviceName);
        sb.append(", webserviceAddr=").append(webserviceAddr);
        sb.append(", online=").append(online);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}