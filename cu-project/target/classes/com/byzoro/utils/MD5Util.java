package com.byzoro.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	
	public static void main(String[] args) {
		System.out.println(getMd5("111111"));
		System.out.println(getMd5("123456"));
		System.out.println(getMd5("admin"));
		System.out.println(getMd5("1qaz2wsx"));
		//96e79218965eb72c92a549dd5a330112
		//e10adc3949ba59abbe56e057f20f883e
		//21232f297a57a5a743894a0e4a801fc3
		}

	//静态方法，便于作为工具类
    public static String getMd5(String plainText) {
     try {
         MessageDigest md = MessageDigest.getInstance("MD5");
             md.update(plainText.getBytes());
         byte[] b = md.digest();

           int i;

            StringBuffer buf = new StringBuffer("");
          for (int offset = 0; offset < b.length; offset++) {
                     i = b[offset];
                     if (i < 0) {
                         i += 256;
                     }
                     if (i < 16) {
                         buf.append("0");
                     }
                   buf.append(Integer.toHexString(i));
                 }
         //32位加密
          return buf.toString();
             // 16位的加密
         } catch (NoSuchAlgorithmException e) {
             e.printStackTrace();
          return null;
         }

    }

}
