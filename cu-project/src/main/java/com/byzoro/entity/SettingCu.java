package com.byzoro.entity;

import java.io.Serializable;

/**
 * setting_cu
 * @author 
 */
public class SettingCu implements Serializable {
    private Integer id;

    /**
     * 上报模块IP地址
     */
    private String reportIp;

    /**
     * 上报模块ftp服务端口
     */
    private Integer reportFtpPort;

    /**
     * ES模块IP地址
     */
    private String esIp;

    /**
     * ES数据库端口
     */
    private Integer esPort;

    /**
     * ES模块ftp服务端口
     */
    private Integer esFtpPort;

    private String esDeviceIp;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReportIp() {
        return reportIp;
    }

    public void setReportIp(String reportIp) {
        this.reportIp = reportIp;
    }

    public Integer getReportFtpPort() {
        return reportFtpPort;
    }

    public void setReportFtpPort(Integer reportFtpPort) {
        this.reportFtpPort = reportFtpPort;
    }

    public String getEsIp() {
        return esIp;
    }

    public void setEsIp(String esIp) {
        this.esIp = esIp;
    }

    public Integer getEsPort() {
        return esPort;
    }

    public void setEsPort(Integer esPort) {
        this.esPort = esPort;
    }

    public Integer getEsFtpPort() {
        return esFtpPort;
    }

    public void setEsFtpPort(Integer esFtpPort) {
        this.esFtpPort = esFtpPort;
    }

    public String getEsDeviceIp() {
        return esDeviceIp;
    }

    public void setEsDeviceIp(String esDeviceIp) {
        this.esDeviceIp = esDeviceIp;
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
        SettingCu other = (SettingCu) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getReportIp() == null ? other.getReportIp() == null : this.getReportIp().equals(other.getReportIp()))
            && (this.getReportFtpPort() == null ? other.getReportFtpPort() == null : this.getReportFtpPort().equals(other.getReportFtpPort()))
            && (this.getEsIp() == null ? other.getEsIp() == null : this.getEsIp().equals(other.getEsIp()))
            && (this.getEsPort() == null ? other.getEsPort() == null : this.getEsPort().equals(other.getEsPort()))
            && (this.getEsFtpPort() == null ? other.getEsFtpPort() == null : this.getEsFtpPort().equals(other.getEsFtpPort()))
            && (this.getEsDeviceIp() == null ? other.getEsDeviceIp() == null : this.getEsDeviceIp().equals(other.getEsDeviceIp()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getReportIp() == null) ? 0 : getReportIp().hashCode());
        result = prime * result + ((getReportFtpPort() == null) ? 0 : getReportFtpPort().hashCode());
        result = prime * result + ((getEsIp() == null) ? 0 : getEsIp().hashCode());
        result = prime * result + ((getEsPort() == null) ? 0 : getEsPort().hashCode());
        result = prime * result + ((getEsFtpPort() == null) ? 0 : getEsFtpPort().hashCode());
        result = prime * result + ((getEsDeviceIp() == null) ? 0 : getEsDeviceIp().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", reportIp=").append(reportIp);
        sb.append(", reportFtpPort=").append(reportFtpPort);
        sb.append(", esIp=").append(esIp);
        sb.append(", esPort=").append(esPort);
        sb.append(", esFtpPort=").append(esFtpPort);
        sb.append(", esDeviceIp=").append(esDeviceIp);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}