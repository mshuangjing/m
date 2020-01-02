package com.byzoro.entity;

import java.io.Serializable;

/**
 * policy_basic_codelist
 * @author 
 */
public class PolicyBasicCodelist implements Serializable {
    private Long id;

    private Long commandid;

    private String jrfs;

    private String dwsx;

    private String zjlx;

    private String jfxz;

    private String dllx;

    private String fwnr;

    private String gzlx;

    private String wfwgqk;

    private Integer timestamp;

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

    public String getJrfs() {
        return jrfs;
    }

    public void setJrfs(String jrfs) {
        this.jrfs = jrfs;
    }

    public String getDwsx() {
        return dwsx;
    }

    public void setDwsx(String dwsx) {
        this.dwsx = dwsx;
    }

    public String getZjlx() {
        return zjlx;
    }

    public void setZjlx(String zjlx) {
        this.zjlx = zjlx;
    }

    public String getJfxz() {
        return jfxz;
    }

    public void setJfxz(String jfxz) {
        this.jfxz = jfxz;
    }

    public String getDllx() {
        return dllx;
    }

    public void setDllx(String dllx) {
        this.dllx = dllx;
    }

    public String getFwnr() {
        return fwnr;
    }

    public void setFwnr(String fwnr) {
        this.fwnr = fwnr;
    }

    public String getGzlx() {
        return gzlx;
    }

    public void setGzlx(String gzlx) {
        this.gzlx = gzlx;
    }

    public String getWfwgqk() {
        return wfwgqk;
    }

    public void setWfwgqk(String wfwgqk) {
        this.wfwgqk = wfwgqk;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
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
        PolicyBasicCodelist other = (PolicyBasicCodelist) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCommandid() == null ? other.getCommandid() == null : this.getCommandid().equals(other.getCommandid()))
            && (this.getJrfs() == null ? other.getJrfs() == null : this.getJrfs().equals(other.getJrfs()))
            && (this.getDwsx() == null ? other.getDwsx() == null : this.getDwsx().equals(other.getDwsx()))
            && (this.getZjlx() == null ? other.getZjlx() == null : this.getZjlx().equals(other.getZjlx()))
            && (this.getJfxz() == null ? other.getJfxz() == null : this.getJfxz().equals(other.getJfxz()))
            && (this.getDllx() == null ? other.getDllx() == null : this.getDllx().equals(other.getDllx()))
            && (this.getFwnr() == null ? other.getFwnr() == null : this.getFwnr().equals(other.getFwnr()))
            && (this.getGzlx() == null ? other.getGzlx() == null : this.getGzlx().equals(other.getGzlx()))
            && (this.getWfwgqk() == null ? other.getWfwgqk() == null : this.getWfwgqk().equals(other.getWfwgqk()))
            && (this.getTimestamp() == null ? other.getTimestamp() == null : this.getTimestamp().equals(other.getTimestamp()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCommandid() == null) ? 0 : getCommandid().hashCode());
        result = prime * result + ((getJrfs() == null) ? 0 : getJrfs().hashCode());
        result = prime * result + ((getDwsx() == null) ? 0 : getDwsx().hashCode());
        result = prime * result + ((getZjlx() == null) ? 0 : getZjlx().hashCode());
        result = prime * result + ((getJfxz() == null) ? 0 : getJfxz().hashCode());
        result = prime * result + ((getDllx() == null) ? 0 : getDllx().hashCode());
        result = prime * result + ((getFwnr() == null) ? 0 : getFwnr().hashCode());
        result = prime * result + ((getGzlx() == null) ? 0 : getGzlx().hashCode());
        result = prime * result + ((getWfwgqk() == null) ? 0 : getWfwgqk().hashCode());
        result = prime * result + ((getTimestamp() == null) ? 0 : getTimestamp().hashCode());
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
        sb.append(", jrfs=").append(jrfs);
        sb.append(", dwsx=").append(dwsx);
        sb.append(", zjlx=").append(zjlx);
        sb.append(", jfxz=").append(jfxz);
        sb.append(", dllx=").append(dllx);
        sb.append(", fwnr=").append(fwnr);
        sb.append(", gzlx=").append(gzlx);
        sb.append(", wfwgqk=").append(wfwgqk);
        sb.append(", timestamp=").append(timestamp);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}