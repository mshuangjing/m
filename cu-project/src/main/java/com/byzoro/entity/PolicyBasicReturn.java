package com.byzoro.entity;

import java.io.Serializable;

/**
 * policy_basic_return
 * @author 
 */
public class PolicyBasicReturn implements Serializable {
    /**
     * 自增主健
     */
    private Long id;

    /**
     * 经营者id
     */
    private String idcId;

    /**
     * 退回原因
     */
    private String returnCode;

    /**
     * 退回原因说明
     */
    private String returnMsg;

    /**
     * 退回时间
     */
    private Integer returnStamp;

    /**
     * 处理时间
     */
    private Integer operationTime;

    /**
     * 处理人
     */
    private String operationUser;

    /**
     * 处理状态 0未处理，1已处理
     */
    private Boolean operationType;

    /**
     * 0无，1有
     */
    private Boolean isReturn;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdcId() {
        return idcId;
    }

    public void setIdcId(String idcId) {
        this.idcId = idcId;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public Integer getReturnStamp() {
        return returnStamp;
    }

    public void setReturnStamp(Integer returnStamp) {
        this.returnStamp = returnStamp;
    }

    public Integer getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Integer operationTime) {
        this.operationTime = operationTime;
    }

    public String getOperationUser() {
        return operationUser;
    }

    public void setOperationUser(String operationUser) {
        this.operationUser = operationUser;
    }

    public Boolean getOperationType() {
        return operationType;
    }

    public void setOperationType(Boolean operationType) {
        this.operationType = operationType;
    }

    public Boolean getIsReturn() {
        return isReturn;
    }

    public void setIsReturn(Boolean isReturn) {
        this.isReturn = isReturn;
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
        PolicyBasicReturn other = (PolicyBasicReturn) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIdcId() == null ? other.getIdcId() == null : this.getIdcId().equals(other.getIdcId()))
            && (this.getReturnCode() == null ? other.getReturnCode() == null : this.getReturnCode().equals(other.getReturnCode()))
            && (this.getReturnMsg() == null ? other.getReturnMsg() == null : this.getReturnMsg().equals(other.getReturnMsg()))
            && (this.getReturnStamp() == null ? other.getReturnStamp() == null : this.getReturnStamp().equals(other.getReturnStamp()))
            && (this.getOperationTime() == null ? other.getOperationTime() == null : this.getOperationTime().equals(other.getOperationTime()))
            && (this.getOperationUser() == null ? other.getOperationUser() == null : this.getOperationUser().equals(other.getOperationUser()))
            && (this.getOperationType() == null ? other.getOperationType() == null : this.getOperationType().equals(other.getOperationType()))
            && (this.getIsReturn() == null ? other.getIsReturn() == null : this.getIsReturn().equals(other.getIsReturn()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIdcId() == null) ? 0 : getIdcId().hashCode());
        result = prime * result + ((getReturnCode() == null) ? 0 : getReturnCode().hashCode());
        result = prime * result + ((getReturnMsg() == null) ? 0 : getReturnMsg().hashCode());
        result = prime * result + ((getReturnStamp() == null) ? 0 : getReturnStamp().hashCode());
        result = prime * result + ((getOperationTime() == null) ? 0 : getOperationTime().hashCode());
        result = prime * result + ((getOperationUser() == null) ? 0 : getOperationUser().hashCode());
        result = prime * result + ((getOperationType() == null) ? 0 : getOperationType().hashCode());
        result = prime * result + ((getIsReturn() == null) ? 0 : getIsReturn().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", idcId=").append(idcId);
        sb.append(", returnCode=").append(returnCode);
        sb.append(", returnMsg=").append(returnMsg);
        sb.append(", returnStamp=").append(returnStamp);
        sb.append(", operationTime=").append(operationTime);
        sb.append(", operationUser=").append(operationUser);
        sb.append(", operationType=").append(operationType);
        sb.append(", isReturn=").append(isReturn);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}