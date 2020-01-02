package com.byzoro.entity;

import java.io.Serializable;

/**
 * basic_service
 * @author 
 */
public class BasicService implements Serializable {
    /**
     * 自增主健，服务编号，全局唯一
     */
    private Long serviceId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 服务内容代码，见10.6
     */
    private String serviceContent;

    /**
     * 备案类型，见10.9
     */
    private Integer regtype;

    /**
     * 备案号/许可证号
     */
    private String regid;

    /**
     * 接入方式见10.1
     */
    private Integer setMode;

    /**
     * 业务类型 1.IDC业务，2.ISP业务
     */
    private Boolean business;

    /**
     * 0不变，1新增，2修改，3删除
     */
    private Boolean status;

    private static final long serialVersionUID = 1L;

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getServiceContent() {
        return serviceContent;
    }

    public void setServiceContent(String serviceContent) {
        this.serviceContent = serviceContent;
    }

    public Integer getRegtype() {
        return regtype;
    }

    public void setRegtype(Integer regtype) {
        this.regtype = regtype;
    }

    public String getRegid() {
        return regid;
    }

    public void setRegid(String regid) {
        this.regid = regid;
    }

    public Integer getSetMode() {
        return setMode;
    }

    public void setSetMode(Integer setMode) {
        this.setMode = setMode;
    }

    public Boolean getBusiness() {
        return business;
    }

    public void setBusiness(Boolean business) {
        this.business = business;
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
        BasicService other = (BasicService) that;
        return (this.getServiceId() == null ? other.getServiceId() == null : this.getServiceId().equals(other.getServiceId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getServiceContent() == null ? other.getServiceContent() == null : this.getServiceContent().equals(other.getServiceContent()))
            && (this.getRegtype() == null ? other.getRegtype() == null : this.getRegtype().equals(other.getRegtype()))
            && (this.getRegid() == null ? other.getRegid() == null : this.getRegid().equals(other.getRegid()))
            && (this.getSetMode() == null ? other.getSetMode() == null : this.getSetMode().equals(other.getSetMode()))
            && (this.getBusiness() == null ? other.getBusiness() == null : this.getBusiness().equals(other.getBusiness()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getServiceId() == null) ? 0 : getServiceId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getServiceContent() == null) ? 0 : getServiceContent().hashCode());
        result = prime * result + ((getRegtype() == null) ? 0 : getRegtype().hashCode());
        result = prime * result + ((getRegid() == null) ? 0 : getRegid().hashCode());
        result = prime * result + ((getSetMode() == null) ? 0 : getSetMode().hashCode());
        result = prime * result + ((getBusiness() == null) ? 0 : getBusiness().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serviceId=").append(serviceId);
        sb.append(", userId=").append(userId);
        sb.append(", serviceContent=").append(serviceContent);
        sb.append(", regtype=").append(regtype);
        sb.append(", regid=").append(regid);
        sb.append(", setMode=").append(setMode);
        sb.append(", business=").append(business);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}