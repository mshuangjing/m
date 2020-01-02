package com.byzoro.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * backups
 * @author 
 */
public class Backups implements Serializable {
    private Long id;

    /**
     * 备份范围
     */
    private String tables;

    private String pathName;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 备份时间
     */
    private LocalDateTime addTime;

    /**
     * 备份方式
     */
    private String isTelnet;

    /**
     * 远程IP
     */
    private String telnetIp;

    /**
     * 远程用户
     */
    private String telnetUser;

    /**
     * 远程密码
     */
    private String telnetPwd;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTables() {
        return tables;
    }

    public void setTables(String tables) {
        this.tables = tables;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public LocalDateTime getAddTime() {
        return addTime;
    }

    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    public String getIsTelnet() {
        return isTelnet;
    }

    public void setIsTelnet(String isTelnet) {
        this.isTelnet = isTelnet;
    }

    public String getTelnetIp() {
        return telnetIp;
    }

    public void setTelnetIp(String telnetIp) {
        this.telnetIp = telnetIp;
    }

    public String getTelnetUser() {
        return telnetUser;
    }

    public void setTelnetUser(String telnetUser) {
        this.telnetUser = telnetUser;
    }

    public String getTelnetPwd() {
        return telnetPwd;
    }

    public void setTelnetPwd(String telnetPwd) {
        this.telnetPwd = telnetPwd;
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
        Backups other = (Backups) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTables() == null ? other.getTables() == null : this.getTables().equals(other.getTables()))
            && (this.getPathName() == null ? other.getPathName() == null : this.getPathName().equals(other.getPathName()))
            && (this.getFileName() == null ? other.getFileName() == null : this.getFileName().equals(other.getFileName()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getIsTelnet() == null ? other.getIsTelnet() == null : this.getIsTelnet().equals(other.getIsTelnet()))
            && (this.getTelnetIp() == null ? other.getTelnetIp() == null : this.getTelnetIp().equals(other.getTelnetIp()))
            && (this.getTelnetUser() == null ? other.getTelnetUser() == null : this.getTelnetUser().equals(other.getTelnetUser()))
            && (this.getTelnetPwd() == null ? other.getTelnetPwd() == null : this.getTelnetPwd().equals(other.getTelnetPwd()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTables() == null) ? 0 : getTables().hashCode());
        result = prime * result + ((getPathName() == null) ? 0 : getPathName().hashCode());
        result = prime * result + ((getFileName() == null) ? 0 : getFileName().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getIsTelnet() == null) ? 0 : getIsTelnet().hashCode());
        result = prime * result + ((getTelnetIp() == null) ? 0 : getTelnetIp().hashCode());
        result = prime * result + ((getTelnetUser() == null) ? 0 : getTelnetUser().hashCode());
        result = prime * result + ((getTelnetPwd() == null) ? 0 : getTelnetPwd().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tables=").append(tables);
        sb.append(", pathName=").append(pathName);
        sb.append(", fileName=").append(fileName);
        sb.append(", addTime=").append(addTime);
        sb.append(", isTelnet=").append(isTelnet);
        sb.append(", telnetIp=").append(telnetIp);
        sb.append(", telnetUser=").append(telnetUser);
        sb.append(", telnetPwd=").append(telnetPwd);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}