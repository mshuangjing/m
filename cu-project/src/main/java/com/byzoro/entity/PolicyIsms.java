package com.byzoro.entity;

import java.io.Serializable;

/**
 * policy_isms
 * @author 
 */
public class PolicyIsms implements Serializable {
    /**
     * 自增，用于关联规则表
     */
    private Long id;

    /**
     * 指令id
     */
    private Long commandid;

    /**
     * 1监测 2过滤
     */
    private Boolean type;

    /**
     * 过滤原因，只对过滤策略有效
     */
    private String reason;

    /**
     * 0不记录日志，1记录日志
     */
    private Boolean logFlag;

    /**
     * 0不上传日志，1上次日志
     */
    private Boolean reportFlag;

    /**
     * 生效时间年月日时分秒
     */
    private Integer effectTime;

    /**
     * 失效时间年月日时分秒
     */
    private Integer expiredTime;

    /**
     * IDC/ISP许可证号
     */
    private String idcId;

    /**
     * 生效的机房id，使用半角逗号分隔，全部机房生效时不添加
     */
    private String houseId;

    /**
     * 指令属主，下发策略的用户名
     */
    private String owner;

    /**
     * 0不可读，1刻度
     */
    private Boolean visible;

    /**
     * 0新增，1删除
     */
    private Boolean operationtype;

    /**
     * 指令优先级
     */
    private String level;

    /**
     * 指令生成时间
     */
    private Integer timestamp;

    /**
     * 0 SMMS下发，1 本地配置
     */
    private Boolean source;

    /**
     * 指令状态：1下发中，2下发成功，3下发失败，4接口不通，5取消中，6取消成功，7取消失败，8未回复ACK
     */
    private Boolean status;

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

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Boolean getLogFlag() {
        return logFlag;
    }

    public void setLogFlag(Boolean logFlag) {
        this.logFlag = logFlag;
    }

    public Boolean getReportFlag() {
        return reportFlag;
    }

    public void setReportFlag(Boolean reportFlag) {
        this.reportFlag = reportFlag;
    }

    public Integer getEffectTime() {
        return effectTime;
    }

    public void setEffectTime(Integer effectTime) {
        this.effectTime = effectTime;
    }

    public Integer getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Integer expiredTime) {
        this.expiredTime = expiredTime;
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Boolean getOperationtype() {
        return operationtype;
    }

    public void setOperationtype(Boolean operationtype) {
        this.operationtype = operationtype;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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
        PolicyIsms other = (PolicyIsms) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCommandid() == null ? other.getCommandid() == null : this.getCommandid().equals(other.getCommandid()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()))
            && (this.getLogFlag() == null ? other.getLogFlag() == null : this.getLogFlag().equals(other.getLogFlag()))
            && (this.getReportFlag() == null ? other.getReportFlag() == null : this.getReportFlag().equals(other.getReportFlag()))
            && (this.getEffectTime() == null ? other.getEffectTime() == null : this.getEffectTime().equals(other.getEffectTime()))
            && (this.getExpiredTime() == null ? other.getExpiredTime() == null : this.getExpiredTime().equals(other.getExpiredTime()))
            && (this.getIdcId() == null ? other.getIdcId() == null : this.getIdcId().equals(other.getIdcId()))
            && (this.getHouseId() == null ? other.getHouseId() == null : this.getHouseId().equals(other.getHouseId()))
            && (this.getOwner() == null ? other.getOwner() == null : this.getOwner().equals(other.getOwner()))
            && (this.getVisible() == null ? other.getVisible() == null : this.getVisible().equals(other.getVisible()))
            && (this.getOperationtype() == null ? other.getOperationtype() == null : this.getOperationtype().equals(other.getOperationtype()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getTimestamp() == null ? other.getTimestamp() == null : this.getTimestamp().equals(other.getTimestamp()))
            && (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCommandid() == null) ? 0 : getCommandid().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
        result = prime * result + ((getLogFlag() == null) ? 0 : getLogFlag().hashCode());
        result = prime * result + ((getReportFlag() == null) ? 0 : getReportFlag().hashCode());
        result = prime * result + ((getEffectTime() == null) ? 0 : getEffectTime().hashCode());
        result = prime * result + ((getExpiredTime() == null) ? 0 : getExpiredTime().hashCode());
        result = prime * result + ((getIdcId() == null) ? 0 : getIdcId().hashCode());
        result = prime * result + ((getHouseId() == null) ? 0 : getHouseId().hashCode());
        result = prime * result + ((getOwner() == null) ? 0 : getOwner().hashCode());
        result = prime * result + ((getVisible() == null) ? 0 : getVisible().hashCode());
        result = prime * result + ((getOperationtype() == null) ? 0 : getOperationtype().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getTimestamp() == null) ? 0 : getTimestamp().hashCode());
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
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
        sb.append(", commandid=").append(commandid);
        sb.append(", type=").append(type);
        sb.append(", reason=").append(reason);
        sb.append(", logFlag=").append(logFlag);
        sb.append(", reportFlag=").append(reportFlag);
        sb.append(", effectTime=").append(effectTime);
        sb.append(", expiredTime=").append(expiredTime);
        sb.append(", idcId=").append(idcId);
        sb.append(", houseId=").append(houseId);
        sb.append(", owner=").append(owner);
        sb.append(", visible=").append(visible);
        sb.append(", operationtype=").append(operationtype);
        sb.append(", level=").append(level);
        sb.append(", timestamp=").append(timestamp);
        sb.append(", source=").append(source);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}