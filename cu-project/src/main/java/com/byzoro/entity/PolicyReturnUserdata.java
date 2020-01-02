package com.byzoro.entity;

import java.io.Serializable;

/**
 * policy_return_userdata
 * @author 
 */
public class PolicyReturnUserdata implements Serializable {
    /**
     * 自增主健
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 应用服务id
     */
    private Long serviceId;

    /**
     * 应用服务的域名id
     */
    private Long serviceDomainId;

    /**
     * 应用服务占用机房id
     */
    private Long serviceHhId;

    /**
     * 占用机房信息id
     */
    private Long hhId;

    /**
     * 退回数据id
     */
    private Long basicReturnInfoId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getServiceDomainId() {
        return serviceDomainId;
    }

    public void setServiceDomainId(Long serviceDomainId) {
        this.serviceDomainId = serviceDomainId;
    }

    public Long getServiceHhId() {
        return serviceHhId;
    }

    public void setServiceHhId(Long serviceHhId) {
        this.serviceHhId = serviceHhId;
    }

    public Long getHhId() {
        return hhId;
    }

    public void setHhId(Long hhId) {
        this.hhId = hhId;
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
        PolicyReturnUserdata other = (PolicyReturnUserdata) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getServiceId() == null ? other.getServiceId() == null : this.getServiceId().equals(other.getServiceId()))
            && (this.getServiceDomainId() == null ? other.getServiceDomainId() == null : this.getServiceDomainId().equals(other.getServiceDomainId()))
            && (this.getServiceHhId() == null ? other.getServiceHhId() == null : this.getServiceHhId().equals(other.getServiceHhId()))
            && (this.getHhId() == null ? other.getHhId() == null : this.getHhId().equals(other.getHhId()))
            && (this.getBasicReturnInfoId() == null ? other.getBasicReturnInfoId() == null : this.getBasicReturnInfoId().equals(other.getBasicReturnInfoId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getServiceId() == null) ? 0 : getServiceId().hashCode());
        result = prime * result + ((getServiceDomainId() == null) ? 0 : getServiceDomainId().hashCode());
        result = prime * result + ((getServiceHhId() == null) ? 0 : getServiceHhId().hashCode());
        result = prime * result + ((getHhId() == null) ? 0 : getHhId().hashCode());
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
        sb.append(", userId=").append(userId);
        sb.append(", serviceId=").append(serviceId);
        sb.append(", serviceDomainId=").append(serviceDomainId);
        sb.append(", serviceHhId=").append(serviceHhId);
        sb.append(", hhId=").append(hhId);
        sb.append(", basicReturnInfoId=").append(basicReturnInfoId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}