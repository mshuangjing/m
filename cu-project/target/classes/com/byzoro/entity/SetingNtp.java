package com.byzoro.entity;

import java.io.Serializable;

/**
 * seting_ntp
 * @author 
 */
public class SetingNtp implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * ntp服务器IP
     */
    private String ntpServerIp;

    /**
     * 端口：默认123
     */
    private Integer port;

    /**
     * 同步频率，单位：分钟
     */
    private Integer synFreq;

    /**
     * 状态 0：正常 ；1：异常
     */
    private Boolean state;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNtpServerIp() {
        return ntpServerIp;
    }

    public void setNtpServerIp(String ntpServerIp) {
        this.ntpServerIp = ntpServerIp;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getSynFreq() {
        return synFreq;
    }

    public void setSynFreq(Integer synFreq) {
        this.synFreq = synFreq;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
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
        SetingNtp other = (SetingNtp) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getNtpServerIp() == null ? other.getNtpServerIp() == null : this.getNtpServerIp().equals(other.getNtpServerIp()))
            && (this.getPort() == null ? other.getPort() == null : this.getPort().equals(other.getPort()))
            && (this.getSynFreq() == null ? other.getSynFreq() == null : this.getSynFreq().equals(other.getSynFreq()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getNtpServerIp() == null) ? 0 : getNtpServerIp().hashCode());
        result = prime * result + ((getPort() == null) ? 0 : getPort().hashCode());
        result = prime * result + ((getSynFreq() == null) ? 0 : getSynFreq().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", ntpServerIp=").append(ntpServerIp);
        sb.append(", port=").append(port);
        sb.append(", synFreq=").append(synFreq);
        sb.append(", state=").append(state);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}