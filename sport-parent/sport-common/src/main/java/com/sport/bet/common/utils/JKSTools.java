/*package com.sport.bet.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JKSTools {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	*//**
	 * 加签私钥
	 *//*
	private PrivateKey privateKey;

	*//**
	 * 验签公钥
	 *//*
	private PublicKey publicKey;

	@Value("${jks.jksdirpath:null}")
	private String jksdirpath;

	@Value("${jks.jks0:null}")
	private String jks0;

	*//**
	 * 证书密码
	 *//*
	@Value("${jks.passwordjks0:null}")
	private String passwordjks0;

	@Value("${jks.callbackIsHttps:null}")
	private String isCallbackHttps;

	@PostConstruct
	public void initProvider() {
		try {
			KeyStore ks = KeyStore.getInstance("JKS");
			FileInputStream fis = new FileInputStream(jksdirpath + File.separator + jks0);
			// If the keystore password is empty(""), then we have to set
			// to null, otherwise it won't work!!!
			char[] nPassword = null;
			if ((passwordjks0 == null) || passwordjks0.trim().equals("")) {
				nPassword = null;
			} else {
				nPassword = passwordjks0.toCharArray();
			}
			ks.load(fis, nPassword);
			fis.close();
			Enumeration<?> enumas = ks.aliases();
			String keyAlias = null;
			if (enumas.hasMoreElements())// we are readin just one certificate.
			{
				keyAlias = (String) enumas.nextElement();
			}
			privateKey = (PrivateKey) ks.getKey(keyAlias, nPassword);
			Certificate cert = ks.getCertificate(keyAlias);
			publicKey = cert.getPublicKey();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 转换成十六进制字符串
	public static String Byte2String(byte[] b) {
		String hs = "";
		String stmp = "";

		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
			// if (n<b.length-1) hs=hs+":";
		}
		return hs.toUpperCase();
	}

	public static byte[] StringToByte(int number) {
		int temp = number;
		byte[] b = new byte[4];
		for (int i = b.length - 1; i > -1; i--) {
			b[i] = new Integer(temp & 0xff).byteValue();// 将最高位保存在最低位
			temp = temp >> 8; // 向右移8位
		}
		return b;
	}

	*//**
	 * 
	 * @param strPfx
	 * @param strPassword
	 * @return List 0:prrivateKey 1:publicKey
	 *//*
	@SuppressWarnings("rawtypes")
	private List<Key> getKeys(String strPfx, String strPassword) {

		List<Key> list = new ArrayList<Key>();
		try {
			KeyStore ks = KeyStore.getInstance("JKS");
			FileInputStream fis = new FileInputStream(strPfx);
			// If the keystore password is empty(""), then we have to set
			// to null, otherwise it won't work!!!
			char[] nPassword = null;
			if ((strPassword == null) || strPassword.trim().equals("")) {
				nPassword = null;
			} else {
				nPassword = strPassword.toCharArray();
			}
			ks.load(fis, nPassword);
			fis.close();
			Enumeration enumas = ks.aliases();
			String keyAlias = null;
			if (enumas.hasMoreElements())// we are readin just one certificate.
			{
				keyAlias = (String) enumas.nextElement();
			}
			privateKey = (PrivateKey) ks.getKey(keyAlias, nPassword);
			Certificate cert = ks.getCertificate(keyAlias);
			publicKey = cert.getPublicKey();
			list.add(privateKey);
			list.add(publicKey);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		JKSTools jsk = new JKSTools();
		List<Key> listKey = jsk.getKeys("d:\\ssl\\tomcat.jks", "tanglei");
		System.out.println(listKey.toArray());
	}

	public String sign(byte[] data) {
		try {
			logger.debug("=======加签：=======");
			logger.debug("私钥[{}]", Base64.encodeBase64String(privateKey.getEncoded()));
			Signature signature = Signature.getInstance("MD5withRSA");
			signature.initSign(privateKey);
			signature.update(data);
			return Base64.encodeBase64String(signature.sign());
		} catch (Exception e) {
			// throw new ProcessException(BankRespCode.E_1003.getCode(),
			// BankRespCode.E_1003.getMessage());
		}
		return jks0;

	}

	public boolean verify(byte[] data, String sign) {
		try {
			Signature signature = Signature.getInstance("MD5withRSA");
			logger.debug("公钥[{}]", Base64.encodeBase64String(publicKey.getEncoded()));

			signature.initVerify(publicKey);

			signature.update(data);

			return signature.verify(Base64.decodeBase64(sign));
		} catch (NoSuchAlgorithmException e) {
			// throw new ProcessException(BankRespCode.E_1002.getCode(),
			// BankRespCode.E_1002.getMessage());
		} catch (InvalidKeyException e) {
			// throw new ProcessException(BankRespCode.E_1002.getCode(),
			// BankRespCode.E_1002.getMessage());
		} catch (SignatureException e) {
			// throw new ProcessException(BankRespCode.E_1002.getCode(),
			// BankRespCode.E_1002.getMessage());
		}
		return false;

	}

	public String getJksdirpath() {
		return jksdirpath;
	}

	public void setJksdirpath(String jksdirpath) {
		this.jksdirpath = jksdirpath;
	}

	public String getJks0() {
		return jks0;
	}

	public void setJks0(String jks0) {
		this.jks0 = jks0;
	}

	public String getPasswordjks0() {
		return passwordjks0;
	}

	public void setPasswordjks0(String passwordjks0) {
		this.passwordjks0 = passwordjks0;
	}

	public String getIsCallbackHttps() {
		return isCallbackHttps;
	}

	public void setIsCallbackHttps(String isCallbackHttps) {
		this.isCallbackHttps = isCallbackHttps;
	}
	
}*/