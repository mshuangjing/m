package com.byzoro.entity;

import java.io.Serializable;

/**
 * setting_smms
 * @author 
 */
public class SettingSmms implements Serializable {
    private Integer id;

    /**
     * 用户口令
     */
    private String userPasswd;

    /**
     * 消息认证秘钥
     */
    private String authenticationKey;

    /**
     * 2不加密，3加密
     */
    private Boolean isEncrypt;

    /**
     * 加密秘钥
     */
    private String aesKey;

    /**
     * 秘钥偏移量
     */
    private String aesOffset;

    /**
     * 哈希算法，0无哈希，1MD5，2SHA-1
     */
    private Boolean hashMethod;

    /**
     * 0无压缩，1zip压缩格式
     */
    private Boolean isZip;

    /**
     * 接口版本方法
     */
    private String version;

    /**
     * SMMS提供上班的ftp地址
     */
    private String ftpIp;

    /**
     * SMMS的ftp服务端口
     */
    private Integer ftpPort;

    /**
     * SMMS的ftp上报路径
     */
    private String ftpPath;

    /**
     * SMMS的ftp用户名
     */
    private String ftpUser;

    /**
     * SMMS的ftp密码
     */
    private String ftpPasswd;

    /**
     * SMMS的webservice接口地址
     */
    private String webserviceAddr;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserPasswd() {
        return userPasswd;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }

    public String getAuthenticationKey() {
        return authenticationKey;
    }

    public void setAuthenticationKey(String authenticationKey) {
        this.authenticationKey = authenticationKey;
    }

    public Boolean getIsEncrypt() {
        return isEncrypt;
    }

    public void setIsEncrypt(Boolean isEncrypt) {
        this.isEncrypt = isEncrypt;
    }

    public String getAesKey() {
        return aesKey;
    }

    public void setAesKey(String aesKey) {
        this.aesKey = aesKey;
    }

    public String getAesOffset() {
        return aesOffset;
    }

    public void setAesOffset(String aesOffset) {
        this.aesOffset = aesOffset;
    }

    public Boolean getHashMethod() {
        return hashMethod;
    }

    public void setHashMethod(Boolean hashMethod) {
        this.hashMethod = hashMethod;
    }

    public Boolean getIsZip() {
        return isZip;
    }

    public void setIsZip(Boolean isZip) {
        this.isZip = isZip;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFtpIp() {
        return ftpIp;
    }

    public void setFtpIp(String ftpIp) {
        this.ftpIp = ftpIp;
    }

    public Integer getFtpPort() {
        return ftpPort;
    }

    public void setFtpPort(Integer ftpPort) {
        this.ftpPort = ftpPort;
    }

    public String getFtpPath() {
        return ftpPath;
    }

    public void setFtpPath(String ftpPath) {
        this.ftpPath = ftpPath;
    }

    public String getFtpUser() {
        return ftpUser;
    }

    public void setFtpUser(String ftpUser) {
        this.ftpUser = ftpUser;
    }

    public String getFtpPasswd() {
        return ftpPasswd;
    }

    public void setFtpPasswd(String ftpPasswd) {
        this.ftpPasswd = ftpPasswd;
    }

    public String getWebserviceAddr() {
        return webserviceAddr;
    }

    public void setWebserviceAddr(String webserviceAddr) {
        this.webserviceAddr = webserviceAddr;
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
        SettingSmms other = (SettingSmms) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserPasswd() == null ? other.getUserPasswd() == null : this.getUserPasswd().equals(other.getUserPasswd()))
            && (this.getAuthenticationKey() == null ? other.getAuthenticationKey() == null : this.getAuthenticationKey().equals(other.getAuthenticationKey()))
            && (this.getIsEncrypt() == null ? other.getIsEncrypt() == null : this.getIsEncrypt().equals(other.getIsEncrypt()))
            && (this.getAesKey() == null ? other.getAesKey() == null : this.getAesKey().equals(other.getAesKey()))
            && (this.getAesOffset() == null ? other.getAesOffset() == null : this.getAesOffset().equals(other.getAesOffset()))
            && (this.getHashMethod() == null ? other.getHashMethod() == null : this.getHashMethod().equals(other.getHashMethod()))
            && (this.getIsZip() == null ? other.getIsZip() == null : this.getIsZip().equals(other.getIsZip()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getFtpIp() == null ? other.getFtpIp() == null : this.getFtpIp().equals(other.getFtpIp()))
            && (this.getFtpPort() == null ? other.getFtpPort() == null : this.getFtpPort().equals(other.getFtpPort()))
            && (this.getFtpPath() == null ? other.getFtpPath() == null : this.getFtpPath().equals(other.getFtpPath()))
            && (this.getFtpUser() == null ? other.getFtpUser() == null : this.getFtpUser().equals(other.getFtpUser()))
            && (this.getFtpPasswd() == null ? other.getFtpPasswd() == null : this.getFtpPasswd().equals(other.getFtpPasswd()))
            && (this.getWebserviceAddr() == null ? other.getWebserviceAddr() == null : this.getWebserviceAddr().equals(other.getWebserviceAddr()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserPasswd() == null) ? 0 : getUserPasswd().hashCode());
        result = prime * result + ((getAuthenticationKey() == null) ? 0 : getAuthenticationKey().hashCode());
        result = prime * result + ((getIsEncrypt() == null) ? 0 : getIsEncrypt().hashCode());
        result = prime * result + ((getAesKey() == null) ? 0 : getAesKey().hashCode());
        result = prime * result + ((getAesOffset() == null) ? 0 : getAesOffset().hashCode());
        result = prime * result + ((getHashMethod() == null) ? 0 : getHashMethod().hashCode());
        result = prime * result + ((getIsZip() == null) ? 0 : getIsZip().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getFtpIp() == null) ? 0 : getFtpIp().hashCode());
        result = prime * result + ((getFtpPort() == null) ? 0 : getFtpPort().hashCode());
        result = prime * result + ((getFtpPath() == null) ? 0 : getFtpPath().hashCode());
        result = prime * result + ((getFtpUser() == null) ? 0 : getFtpUser().hashCode());
        result = prime * result + ((getFtpPasswd() == null) ? 0 : getFtpPasswd().hashCode());
        result = prime * result + ((getWebserviceAddr() == null) ? 0 : getWebserviceAddr().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userPasswd=").append(userPasswd);
        sb.append(", authenticationKey=").append(authenticationKey);
        sb.append(", isEncrypt=").append(isEncrypt);
        sb.append(", aesKey=").append(aesKey);
        sb.append(", aesOffset=").append(aesOffset);
        sb.append(", hashMethod=").append(hashMethod);
        sb.append(", isZip=").append(isZip);
        sb.append(", version=").append(version);
        sb.append(", ftpIp=").append(ftpIp);
        sb.append(", ftpPort=").append(ftpPort);
        sb.append(", ftpPath=").append(ftpPath);
        sb.append(", ftpUser=").append(ftpUser);
        sb.append(", ftpPasswd=").append(ftpPasswd);
        sb.append(", webserviceAddr=").append(webserviceAddr);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}