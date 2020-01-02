package com.byzoro.entity;

import java.io.Serializable;

/**
 * policy_access_query
 * @author 
 */
public class PolicyAccessQueryWithBLOBs extends PolicyAccessQuery implements Serializable {
    /**
     * URL
     */
    private String url;

    /**
     * 包含服务器绝对路径，文件名等信息
     */
    private String ftpPath;

    private static final long serialVersionUID = 1L;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFtpPath() {
        return ftpPath;
    }

    public void setFtpPath(String ftpPath) {
        this.ftpPath = ftpPath;
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
        PolicyAccessQueryWithBLOBs other = (PolicyAccessQueryWithBLOBs) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCommandid() == null ? other.getCommandid() == null : this.getCommandid().equals(other.getCommandid()))
            && (this.getIdcId() == null ? other.getIdcId() == null : this.getIdcId().equals(other.getIdcId()))
            && (this.getHouseId() == null ? other.getHouseId() == null : this.getHouseId().equals(other.getHouseId()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getSrcStartIp() == null ? other.getSrcStartIp() == null : this.getSrcStartIp().equals(other.getSrcStartIp()))
            && (this.getSrcEndIp() == null ? other.getSrcEndIp() == null : this.getSrcEndIp().equals(other.getSrcEndIp()))
            && (this.getDstStartIp() == null ? other.getDstStartIp() == null : this.getDstStartIp().equals(other.getDstStartIp()))
            && (this.getDstEndIp() == null ? other.getDstEndIp() == null : this.getDstEndIp().equals(other.getDstEndIp()))
            && (this.getSrcPort() == null ? other.getSrcPort() == null : this.getSrcPort().equals(other.getSrcPort()))
            && (this.getDstPort() == null ? other.getDstPort() == null : this.getDstPort().equals(other.getDstPort()))
            && (this.getProtocol() == null ? other.getProtocol() == null : this.getProtocol().equals(other.getProtocol()))
            && (this.getTimestamp() == null ? other.getTimestamp() == null : this.getTimestamp().equals(other.getTimestamp()))
            && (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getResult() == null ? other.getResult() == null : this.getResult().equals(other.getResult()))
            && (this.getRecordNum() == null ? other.getRecordNum() == null : this.getRecordNum().equals(other.getRecordNum()))
            && (this.getFileNumber() == null ? other.getFileNumber() == null : this.getFileNumber().equals(other.getFileNumber()))
            && (this.getUploadStatus() == null ? other.getUploadStatus() == null : this.getUploadStatus().equals(other.getUploadStatus()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getFtpPath() == null ? other.getFtpPath() == null : this.getFtpPath().equals(other.getFtpPath()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCommandid() == null) ? 0 : getCommandid().hashCode());
        result = prime * result + ((getIdcId() == null) ? 0 : getIdcId().hashCode());
        result = prime * result + ((getHouseId() == null) ? 0 : getHouseId().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getSrcStartIp() == null) ? 0 : getSrcStartIp().hashCode());
        result = prime * result + ((getSrcEndIp() == null) ? 0 : getSrcEndIp().hashCode());
        result = prime * result + ((getDstStartIp() == null) ? 0 : getDstStartIp().hashCode());
        result = prime * result + ((getDstEndIp() == null) ? 0 : getDstEndIp().hashCode());
        result = prime * result + ((getSrcPort() == null) ? 0 : getSrcPort().hashCode());
        result = prime * result + ((getDstPort() == null) ? 0 : getDstPort().hashCode());
        result = prime * result + ((getProtocol() == null) ? 0 : getProtocol().hashCode());
        result = prime * result + ((getTimestamp() == null) ? 0 : getTimestamp().hashCode());
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getResult() == null) ? 0 : getResult().hashCode());
        result = prime * result + ((getRecordNum() == null) ? 0 : getRecordNum().hashCode());
        result = prime * result + ((getFileNumber() == null) ? 0 : getFileNumber().hashCode());
        result = prime * result + ((getUploadStatus() == null) ? 0 : getUploadStatus().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getFtpPath() == null) ? 0 : getFtpPath().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", url=").append(url);
        sb.append(", ftpPath=").append(ftpPath);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}