package com.byzoro.entity;

import java.io.Serializable;

/**
 * policy_access_query
 * @author 
 */
public class PolicyAccessQuery implements Serializable {
    /**
     * 自增主健
     */
    private Long id;

    /**
     * 指令id
     */
    private Long commandid;

    /**
     * 经营单位id
     */
    private String idcId;

    /**
     * 机房id
     */
    private String houseId;

    /**
     * 查询起始时间
     */
    private Integer startTime;

    /**
     * 查询结束时间
     */
    private Integer endTime;

    /**
     * 源IP起始IP
     */
    private String srcStartIp;

    /**
     * 源IP结束IP
     */
    private String srcEndIp;

    /**
     * 目的IP起始IP
     */
    private String dstStartIp;

    /**
     * 目的IP结束IP
     */
    private String dstEndIp;

    /**
     * 源端口
     */
    private Integer srcPort;

    /**
     * 目的端口
     */
    private Integer dstPort;

    /**
     * 1 TCP, 2 UDP
     */
    private Boolean protocol;

    /**
     * 指令生成时间
     */
    private Integer timestamp;

    /**
     * 0 SMMS 1本地策略
     */
    private Boolean source;

    /**
     * 指令状态：1下发中，2下发成功，3查询条件错误，4DU解析错误，5DU系统繁忙，6其他错误，7下发失败
     */
    private Boolean status;

    /**
     * 日志上报结果，默认空 1等待DU返回结果，2DU返回查询结果，3DU未查询到结果，4DU上传失败，5.DU返回其他错误
     */
    private Boolean result;

    /**
     * 上报日志总条数目数
     */
    private Integer recordNum;

    /**
     * 返回文件个数
     */
    private Integer fileNumber;

    /**
     * 0未上报， 1已上报
     */
    private Boolean uploadStatus;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommandid() {
        return commandid;
    }

    public void setCommandid(Long commandid) {
        this.commandid = commandid;
    }

    public String getIdcId() {
        return idcId;
    }

    public void setIdcId(String idcId) {
        this.idcId = idcId;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public String getSrcStartIp() {
        return srcStartIp;
    }

    public void setSrcStartIp(String srcStartIp) {
        this.srcStartIp = srcStartIp;
    }

    public String getSrcEndIp() {
        return srcEndIp;
    }

    public void setSrcEndIp(String srcEndIp) {
        this.srcEndIp = srcEndIp;
    }

    public String getDstStartIp() {
        return dstStartIp;
    }

    public void setDstStartIp(String dstStartIp) {
        this.dstStartIp = dstStartIp;
    }

    public String getDstEndIp() {
        return dstEndIp;
    }

    public void setDstEndIp(String dstEndIp) {
        this.dstEndIp = dstEndIp;
    }

    public Integer getSrcPort() {
        return srcPort;
    }

    public void setSrcPort(Integer srcPort) {
        this.srcPort = srcPort;
    }

    public Integer getDstPort() {
        return dstPort;
    }

    public void setDstPort(Integer dstPort) {
        this.dstPort = dstPort;
    }

    public Boolean getProtocol() {
        return protocol;
    }

    public void setProtocol(Boolean protocol) {
        this.protocol = protocol;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public Boolean getSource() {
        return source;
    }

    public void setSource(Boolean source) {
        this.source = source;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public Integer getRecordNum() {
        return recordNum;
    }

    public void setRecordNum(Integer recordNum) {
        this.recordNum = recordNum;
    }

    public Integer getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(Integer fileNumber) {
        this.fileNumber = fileNumber;
    }

    public Boolean getUploadStatus() {
        return uploadStatus;
    }

    public void setUploadStatus(Boolean uploadStatus) {
        this.uploadStatus = uploadStatus;
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
        PolicyAccessQuery other = (PolicyAccessQuery) that;
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
            && (this.getUploadStatus() == null ? other.getUploadStatus() == null : this.getUploadStatus().equals(other.getUploadStatus()));
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
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", commandid=").append(commandid);
        sb.append(", idcId=").append(idcId);
        sb.append(", houseId=").append(houseId);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", srcStartIp=").append(srcStartIp);
        sb.append(", srcEndIp=").append(srcEndIp);
        sb.append(", dstStartIp=").append(dstStartIp);
        sb.append(", dstEndIp=").append(dstEndIp);
        sb.append(", srcPort=").append(srcPort);
        sb.append(", dstPort=").append(dstPort);
        sb.append(", protocol=").append(protocol);
        sb.append(", timestamp=").append(timestamp);
        sb.append(", source=").append(source);
        sb.append(", status=").append(status);
        sb.append(", result=").append(result);
        sb.append(", recordNum=").append(recordNum);
        sb.append(", fileNumber=").append(fileNumber);
        sb.append(", uploadStatus=").append(uploadStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}