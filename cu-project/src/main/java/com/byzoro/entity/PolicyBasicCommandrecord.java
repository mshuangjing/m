package com.byzoro.entity;

import java.io.Serializable;

/**
 * policy_basic_commandrecord
 * @author 
 */
public class PolicyBasicCommandrecord implements Serializable {
    private Long id;

    private Long commandid;

    private String idcid;

    private Long controlsid;

    private Integer timestamp;

    private Long view;

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

    public String getIdcid() {
        return idcid;
    }

    public void setIdcid(String idcid) {
        this.idcid = idcid;
    }

    public Long getControlsid() {
        return controlsid;
    }

    public void setControlsid(Long controlsid) {
        this.controlsid = controlsid;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public Long getView() {
        return view;
    }

    public void setView(Long view) {
        this.view = view;
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
        PolicyBasicCommandrecord other = (PolicyBasicCommandrecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCommandid() == null ? other.getCommandid() == null : this.getCommandid().equals(other.getCommandid()))
            && (this.getIdcid() == null ? other.getIdcid() == null : this.getIdcid().equals(other.getIdcid()))
            && (this.getControlsid() == null ? other.getControlsid() == null : this.getControlsid().equals(other.getControlsid()))
            && (this.getTimestamp() == null ? other.getTimestamp() == null : this.getTimestamp().equals(other.getTimestamp()))
            && (this.getView() == null ? other.getView() == null : this.getView().equals(other.getView()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCommandid() == null) ? 0 : getCommandid().hashCode());
        result = prime * result + ((getIdcid() == null) ? 0 : getIdcid().hashCode());
        result = prime * result + ((getControlsid() == null) ? 0 : getControlsid().hashCode());
        result = prime * result + ((getTimestamp() == null) ? 0 : getTimestamp().hashCode());
        result = prime * result + ((getView() == null) ? 0 : getView().hashCode());
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
        sb.append(", idcid=").append(idcid);
        sb.append(", controlsid=").append(controlsid);
        sb.append(", timestamp=").append(timestamp);
        sb.append(", view=").append(view);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}