package com.byzoro.utils;


import org.apache.commons.codec.binary.Hex;
import org.apache.shiro.crypto.hash.Sha1Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * 生成密码工具
 */
public class PasswordUtil {
    /**
     * 加密密码
     * @param plainPassword 原始密码
     * @return salt+ecryptedPwd
     */
    public static String encryptPassword(String plainPassword){
        String salt = Hex.encodeHexString(DigestUtils.generateByteSalt(8));
        ByteSource saltBytes = ByteSource.Util.bytes(salt);
        SimpleHash simpleHash = new SimpleHash(Sha1Hash.ALGORITHM_NAME, plainPassword, saltBytes, 1024);
        String encryptedPwd = salt.concat(simpleHash.toString());
        return encryptedPwd;
    }

    /**
     * 根据salt生成密码
     * @param plainPassword 原始密码
     * @param salt salt
     * @return
     */
    public static String encryptPassword(String plainPassword,String salt){
        ByteSource saltBytes = ByteSource.Util.bytes(salt);
        SimpleHash simpleHash = new SimpleHash(Sha1Hash.ALGORITHM_NAME, plainPassword, saltBytes, 1024);
        String encryptedPwd = salt.concat(simpleHash.toString());
        return encryptedPwd;
    }

    public static void main(String[] args) {
        System.out.println(encryptPasswordnew("1qaz2wsx"));
    }

    /**
     * 加密密码
     *
     * @param plainPassword 原始密码
     * @return salt+ecryptedPwd
     */
    public static String encryptPasswordnew(String plainPassword) {
        String salt = Hex.encodeHexString(DigestUtils.generateByteSalt(8));
        ByteSource saltBytes = ByteSource.Util.bytes(salt);
        SimpleHash simpleHash = new SimpleHash(Sha1Hash.ALGORITHM_NAME, plainPassword, saltBytes, 1024);
        String encryptedPwd = salt.concat(simpleHash.toString());
        return encryptedPwd;
    }
}
