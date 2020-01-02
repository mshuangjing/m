package com.byzoro.utils;

import java.security.SecureRandom;

/**
 * 生成salt
 */
public class DigestUtils {
	private static SecureRandom secureRandom=new SecureRandom();

	private static final String BASECODE = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	/**
	 * 生成盐
	 * @param saltSize
	 * @return
	 */
	public static String generateSalt(int saltSize){
		int baseCodeIndex;
		StringBuffer sb=new StringBuffer();
		for (int i = 0; i < saltSize; i++) {
			baseCodeIndex = secureRandom.nextInt(BASECODE.length());
			sb.append(BASECODE.charAt(baseCodeIndex));
		}
		return sb.toString();
	}

	/**
	 * 生成盐
	 * @param num 生成盐的位数
	 * @return
	 */
	public static byte[] generateByteSalt(int num) {
		byte[] bytes = new byte[num];
		secureRandom.nextBytes(bytes);
		return  bytes;
}
	public static void main(String[] args) {

		System.out.println(generateSalt(8));
	}
}
