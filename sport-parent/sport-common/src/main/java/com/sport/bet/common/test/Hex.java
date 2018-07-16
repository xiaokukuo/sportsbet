package com.sport.bet.common.test;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 16进制字符串编解码接口
 * @author 		zmfeng
 * @since 		2017年4月1日 下午9:25:38
 */
public final class Hex {
	private Hex() {
		throw new AssertionError("static class.");
	}
	
	/**
	 * 将字符串转换为16进制字符串
	 * @param 		data
	 * 				字符串
	 * @return		16进制字符串；若{@code data}为{@code null}，返回空字符串{@code ""}。
	 */
	public static String encode(final String data) {
			try {
				return data == null ? "" : encode(data.getBytes("GBK"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		
	}
	
	/**
	 * 将字节数组转换为16进制字符串
	 * @param 		data
	 * 					字节数组
	 * @return		16进制字符串；若{@code data}为{@code null}，返回空字符串{@code ""}。
	 */
	public static String encode(final byte[] data) {
		if (data == null || data.length == 0) {
			return "";
		}
		
		byte[] hex = new byte[data.length * 2];
		final byte[] HEX = {0x30, 0x31, 0x32, 0x33, 0x34, 0x35, 0x36, 0x37, 0x38, 0x39, 0x41, 0x42, 0x43, 0x44, 0x45, 0x46}; 
	    for (int i = 0; i < data.length; i++) {
	    	hex[2 * i] = HEX[(data[i] & 0xFF) >> 4];
	    	hex[2 * i + 1] = HEX[data[i] & 0x0F];
	    }
	    return (new String(hex));
	}
	
	/**
	 * 将16进制字符串解码为字节数组
	 * @param 		str
	 * 					16进制字符串
	 * @return		字节数组；若{@code str}为{@code null}或{@code ""}，返回{@code byte[0]}。
	 */
	public static byte[] decode(final String str) {
		if (str == null || str.length() == 0) {
			return new byte[0];
		}
		//Checker.checkArgument(isBase16String(str), "illegal Hex string[%s].", str);
		
		try {
			byte[] hex = str.getBytes("GBK");
			byte[] bin = new byte[hex.length / 2];
			for (int i = 0; i < bin.length; i++) {
				bin[i] = (byte) (((hex[2 * i] >> 6) * 9+ (hex[2 * i] & 0x0F)) *16 + (hex[2 * i + 1] >> 6) * 9 + (hex[2 * i + 1] & 0x0F));
			}
			return bin;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private static boolean isBase16String(String str) {
		if (str.length() % 2 != 0) {
			return false;
		}
		String regex = "^[A-Fa-f0-9]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.find();
	}
	
}
