package com.byzoro.entity;

import java.io.Serializable;

/**
 * basic_virtualhost
 * @author 
 */
public class BasicVirtualhost implements Serializable {
    /**
     * 自增主健
     */
    private Long id;

    /**
     * 占用机房信息id
     */
    private Long hhid;

    /**
     * 虚拟主机名称
     */
    private String virtualHostName;

    /**
     * 虚拟主机状态
     */
    private Integer virtualHostState;

    /**
     * 虚拟主机类型 1.共享式，2.专用式，3.云虚拟
     */
    private Boolean virtualHostType;

    /**
     * 虚拟主机网络地址
     */
    private String virtualHostAddr;

    /**
     * 虚拟主机管理地址
     */
    private String virtualHostManagementAddr;

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

    public String getVirtualHostName() {
        return virtualHostName;
    }

    public void setVirtualHostName(String virtualHostName) {
        this.virtualHostName = virtualHostName;
    }

    public Integer getVirtualHostState() {
        return virtualHostState;
    }

    public void setVirtualHostState(Integer virtualHostState) {
        this.virtualHostState = virtualHostState;
    }

    public Boolean getVirtualHostType() {
        return virtualHostType;
    }

    public void setVirtualHostType(Boolean virtualHostType) {
        this.virtualHostType = virtualHostType;
    }

    public String getVirtualHostAddr() {
        return virtualHostAddr;
    }

    public void setVirtualHostAddr(String virtualHostAddr) {
        this.virtualHostAddr = virtualHostAddr;
    }

    public String getVirtualHostManagementAddr() {
        return virtualHostManagementAddr;
    }

    public void setVirtualHostManagementAddr(String virtualHostManagementAddr) {
        this.virtualHostManagementAddr = virtualHostManagementAddr;
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
        BasicVirtualhost other = (BasicVirtualhost) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getHhid() == null ? other.getHhid() == null : this.getHhid().equals(other.getHhid()))
            && (this.getVirtualHostName() == null ? other.getVirtualHostName() == null : this.getVirtualHostName().equals(other.getVirtualHostName()))
            && (this.getVirtualHostState() == null ? other.getVirtualHostState() == null : this.getVirtualHostState().equals(other.getVirtualHostState()))
            && (this.getVirtualHostType() == null ? other.getVirtualHostType() == null : this.getVirtualHostType().equals(other.getVirtualHostType()))
            && (this.getVirtualHostAddr() == null ? other.getVirtualHostAddr() == null : this.getVirtualHostAddr().equals(other.getVirtualHostAddr()))
            && (this.getVirtualHostManagementAddr() == null ? other.getVirtualHostManagementAddr() == null : this.getVirtualHostManagementAddr().equals(other.getVirtualHostManagementAddr()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getHhid() == null) ? 0 : getHhid().hashCode());
        result = prime * result + ((getVirtualHostName() == null) ? 0 : getVirtualHostName().hashCode());
        result = prime * result + ((getVirtualHostState() == null) ? 0 : getVirtualHostState().hashCode());
        result = prime * result + ((getVirtualHostType() == null) ? 0 : getVirtualHostType().hashCode());
        result = prime * result + ((getVirtualHostAddr() == null) ? 0 : getVirtualHostAddr().hashCode());
        result = prime * result + ((getVirtualHostManagementAddr() == null) ? 0 : getVirtualHostManagementAddr().hashCode());
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
        sb.append(", virtualHostName=").append(virtualHostName);
        sb.append(", virtualHostState=").append(virtualHostState);
        sb.append(", virtualHostType=").append(virtualHostType);
        sb.append(", virtualHostAddr=").append(virtualHostAddr);
        sb.append(", virtualHostManagementAddr=").append(virtualHostManagementAddr);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}