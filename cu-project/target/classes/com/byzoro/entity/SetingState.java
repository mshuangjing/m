package com.byzoro.entity;

import java.io.Serializable;

/**
 * seting_state
 * @author 
 */
public class SetingState implements Serializable {
    private Long id;

    private Integer smmsState;

    private Integer ftpState;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSmmsState() {
        return smmsState;
    }

    public void setSmmsState(Integer smmsState) {
        this.smmsState = smmsState;
    }

    public Integer getFtpState() {
        return ftpState;
    }

    public void setFtpState(Integer ftpState) {
        this.ftpState = ftpState;
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
        SetingState other = (SetingState) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSmmsState() == null ? other.getSmmsState() == null : this.getSmmsState().equals(other.getSmmsState()))
            && (this.getFtpState() == null ? other.getFtpState() == null : this.getFtpState().equals(other.getFtpState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSmmsState() == null) ? 0 : getSmmsState().hashCode());
        result = prime * result + ((getFtpState() == null) ? 0 : getFtpState().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", smmsState=").append(smmsState);
        sb.append(", ftpState=").append(ftpState);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}