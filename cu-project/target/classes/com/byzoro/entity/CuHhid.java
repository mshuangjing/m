package com.byzoro.entity;

import java.io.Serializable;

/**
 * cu_hhid
 * @author 
 */
public class CuHhid implements Serializable {
    /**
     * 自增抓紧
     */
    private Long id;

    /**
     * 占用机房信息的ID
     */
    private Long hhid;

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
        CuHhid other = (CuHhid) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getHhid() == null ? other.getHhid() == null : this.getHhid().equals(other.getHhid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getHhid() == null) ? 0 : getHhid().hashCode());
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
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}