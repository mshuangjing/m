package com.byzoro.entity;

import java.io.Serializable;

/**
 * policy_no_filter
 * @author 
 */
public class PolicyNoFilter implements Serializable {
    /**
     * 自增主健
     */
    private Long id;

    /**
     * 指令id
     */
    private Long commandid;

    /**
     * IDC/ISP许可证号
     */
    private String idcId;

    /**
     * 0新增，1删除
     */
    private Boolean operationtype;

    /**
     * 1域名，2IP
     */
    private Boolean type;

    /**
     * 具体的域名或IP地址
     */
    private String contents;

    /**
     * 指令优先级
     */
    private String level;

    /**
     * 指令生成时间
     */
    private Integer timestamp;

    /**
     * 0SMMS下发，1本地配置
     */
    private Boolean source;

    /**
     * 添加人账号，如果来自SMMS，则添加SMMS即可，本地添加填写当前登录用户
     */
    private String owner;

    /**
     * 指令状态：1下发中，2下发成功，3下发失败，4借口不同，5取消中，6取消成功，7取消失败，8未回复ack
     */
    private Boolean status;

    /**
     * 机房id
     */
    private String houseId;

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

    public Boolean getOperationtype() {
        return operationtype;
    }

    public void setOperationtype(Boolean operationtype) {
        this.operationtype = operationtype;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
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
        PolicyNoFilter other = (PolicyNoFilter) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCommandid() == null ? other.getCommandid() == null : this.getCommandid().equals(other.getCommandid()))
            && (this.getIdcId() == null ? other.getIdcId() == null : this.getIdcId().equals(other.getIdcId()))
            && (this.getOperationtype() == null ? other.getOperationtype() == null : this.getOperationtype().equals(other.getOperationtype()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getContents() == null ? other.getContents() == null : this.getContents().equals(other.getContents()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getTimestamp() == null ? other.getTimestamp() == null : this.getTimestamp().equals(other.getTimestamp()))
            && (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()))
            && (this.getOwner() == null ? other.getOwner() == null : this.getOwner().equals(other.getOwner()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getHouseId() == null ? other.getHouseId() == null : this.getHouseId().equals(other.getHouseId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCommandid() == null) ? 0 : getCommandid().hashCode());
        result = prime * result + ((getIdcId() == null) ? 0 : getIdcId().hashCode());
        result = prime * result + ((getOperationtype() == null) ? 0 : getOperationtype().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getContents() == null) ? 0 : getContents().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getTimestamp() == null) ? 0 : getTimestamp().hashCode());
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
        result = prime * result + ((getOwner() == null) ? 0 : getOwner().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getHouseId() == null) ? 0 : getHouseId().hashCode());
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
        sb.append(", operationtype=").append(operationtype);
        sb.append(", type=").append(type);
        sb.append(", contents=").append(contents);
        sb.append(", level=").append(level);
        sb.append(", timestamp=").append(timestamp);
        sb.append(", source=").append(source);
        sb.append(", owner=").append(owner);
        sb.append(", status=").append(status);
        sb.append(", houseId=").append(houseId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}