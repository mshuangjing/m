package com.byzoro.entity;

import java.io.Serializable;

/**
 * setting_eu
 * @author 
 */
public class SettingEu implements Serializable {
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
     * 0不加密，1加密
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
     * 哈希算法 0无哈希，1MD5，2SHA-1
     */
    private Boolean hashMethod;

    /**
     * 0无压缩，1.zip压缩格式
     */
    private Boolean isZip;

    /**
     * 接口版本方法
     */
    private String version;

    /**
     * 省份编号
     */
    private String provId;

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

    public String getProvId() {
        return provId;
    }

    public void setProvId(String provId) {
        this.provId = provId;
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
        SettingEu other = (SettingEu) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserPasswd() == null ? other.getUserPasswd() == null : this.getUserPasswd().equals(other.getUserPasswd()))
            && (this.getAuthenticationKey() == null ? other.getAuthenticationKey() == null : this.getAuthenticationKey().equals(other.getAuthenticationKey()))
            && (this.getIsEncrypt() == null ? other.getIsEncrypt() == null : this.getIsEncrypt().equals(other.getIsEncrypt()))
            && (this.getAesKey() == null ? other.getAesKey() == null : this.getAesKey().equals(other.getAesKey()))
            && (this.getAesOffset() == null ? other.getAesOffset() == null : this.getAesOffset().equals(other.getAesOffset()))
            && (this.getHashMethod() == null ? other.getHashMethod() == null : this.getHashMethod().equals(other.getHashMethod()))
            && (this.getIsZip() == null ? other.getIsZip() == null : this.getIsZip().equals(other.getIsZip()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getProvId() == null ? other.getProvId() == null : this.getProvId().equals(other.getProvId()));
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
        result = prime * result + ((getProvId() == null) ? 0 : getProvId().hashCode());
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
        sb.append(", provId=").append(provId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}