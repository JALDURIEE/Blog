package com.ping.blog.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;

public class EncryptStringUtil {

	private static String key = "4E7FF1C1F04F4B36";

	/**
	 * 字符串进行MD5加密
	 * 
	 * @param str 待加密的字符串
	 * @return 加密后的字符串
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static String MD5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String encryptStr = null;
		Encoder encoder = Base64.getEncoder();
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		byte[] bytes = md5.digest(str.getBytes("utf-8"));
		encryptStr = encoder.encodeToString(bytes);
		return encryptStr;
	}

	/**
	 * AES解密
	 * 
	 * @param string
	 *            待解密字符串
	 * @param key
	 *            密钥
	 * @return 解密后的字符串
	 */
	public static String decodeDES(String content, String key) throws Exception {

		Key k = new SecretKeySpec(key.getBytes(), "AES");
		Cipher c = Cipher.getInstance("AES");
		c.init(Cipher.DECRYPT_MODE, k);
		byte[] decordedValue = new BASE64Decoder().decodeBuffer(content);
		byte[] decValue = c.doFinal(decordedValue);
		String decryptedValue = new String(decValue);
		return decryptedValue;
	}

	/**
	 * AES解密
	 * 
	 * @param string
	 *            待解密字符串
	 * @param key
	 *            密钥
	 * @return 解密后的字符串
	 */
	public static String decodeDES(byte[] content, String password) throws Exception {
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		kgen.init(128, new SecureRandom(password.getBytes()));
		SecretKey secretKey = kgen.generateKey();
		byte[] enCodeFormat = secretKey.getEncoded();
		SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
		Cipher cipher = Cipher.getInstance("AES");// 创建密码器
		cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
		byte[] result = cipher.doFinal(content);
		return new String(result); // 加密

	}

	/**
	 * AES加密
	 * @param content 代加密的字符串
	 * @param key 密钥
	 * @return 加密后的字符串
	 * @throws Exception
	 */
	public static String encodeAES(String content, String key) throws Exception {

		Key k = new SecretKeySpec(key.getBytes(), "AES");
		Cipher cipher = Cipher.getInstance("AES");// 创建密码器
		byte[] byteContent = content.getBytes("utf-8");
		cipher.init(Cipher.ENCRYPT_MODE, k);// 初始化
		byte[] result = cipher.doFinal(byteContent);
		Encoder encoder = Base64.getEncoder();
		return new String(encoder.encode(result), "utf-8");

	}

	public static void main(String[] args) {

		try {
			String result = MD5("tiancong");
			// System.out.println(result);
			String content = "123456";
			System.out.println(MD5("123456"));
			System.out.println("加密前---------->" + content);
			String encodeStr = encodeAES(content, key);
			System.out.println("加密后------------>" + encodeStr);
			String decodeStr = decodeDES(encodeStr, key);
			System.out.println("解密后------------>" + decodeStr);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
