package com.byzoro.entity;

import java.io.Serializable;

/**
 * seting_config
 * @author 
 */
public class SetingConfig implements Serializable {
    private Boolean configFlag;

    private static final long serialVersionUID = 1L;

    public Boolean getConfigFlag() {
        return configFlag;
    }

    public void setConfigFlag(Boolean configFlag) {
        this.configFlag = configFlag;
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
        SetingConfig other = (SetingConfig) that;
        return (this.getConfigFlag() == null ? other.getConfigFlag() == null : this.getConfigFlag().equals(other.getConfigFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getConfigFlag() == null) ? 0 : getConfigFlag().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", configFlag=").append(configFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}