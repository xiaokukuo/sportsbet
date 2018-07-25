package com.sport.bet.common.test;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

public class ANSIMacBySms4Utils {

	static int inLen = 16;

	/**
	 * ANSI X9.9MAC算法 <br/>
	 * (1) ANSI X9.9MAC算法只使用单倍长密钥。 <br/>
	 * (2) MAC数据先按8字节 ，表示为D0～Dn，如果Dn不足8字节时，尾部以字节00补齐。 <br/>
	 * (3) 用MAC密钥加密D0，加密结果与D1异或作为下一次的输入。 <br/>
	 * (4) 将上一步的加密结果与下一分组异或，然后再用MAC密钥加密。<br/>
	 * (5) 直至所有分组结束，取最后结果的左半部作为MAC。<br/>
	 * 采用x9.9算法计算MAC (Count MAC by ANSI-x9.9).
	 * 
	 * @param key
	 *            8字节密钥数据
	 * @param data
	 *            待计算的缓冲区
	 * @throws GeneralSecurityException
	 */
	public static byte[] calculateANSIX9_9MAC(byte[] key, byte[] data) throws GeneralSecurityException {

		if (key == null || data == null)
			return null;

		if (key.length != 16) {
			throw new RuntimeException("秘钥长度错误.");
		}

		final int dataLength = data.length;
		final int lastLength = dataLength % 16;
		final int lastBlockLength = lastLength == 0 ? 16 : lastLength;
		final int blockCount = dataLength / 16 + (lastLength > 0 ? 1 : 0);

		// 拆分数据（16字节块/Block）
		byte[][] dataBlock = new byte[blockCount][16];
		for (int i = 0; i < blockCount; i++) {
			int copyLength = i == blockCount - 1 ? lastBlockLength : 16;
			System.arraycopy(data, i * 16, dataBlock[i], 0, copyLength);
		}

		byte[] desXor = new byte[16];
		for (int i = 0; i < blockCount; i++) {
			byte[] tXor = Sms4Utils.xOr(desXor, dataBlock[i]);
			Sms4Utils.sms4(tXor, inLen, key, desXor, Sms4Utils.ENCRYPT);
		}
		return desXor;
	}

	public static byte[] toBytes(String str) {
		if (str == null || str.trim().equals("")) {
			return new byte[0];
		}

		byte[] bytes = new byte[str.length() / 2];
		for (int i = 0; i < str.length() / 2; i++) {
			String subStr = str.substring(i * 2, i * 2 + 2);
			bytes[i] = (byte) Integer.parseInt(subStr, 16);
		}

		return bytes;
	}

	public static String bytesToHexFun3(byte[] bytes) {
		StringBuilder buf = new StringBuilder(bytes.length * 2);
		for (byte b : bytes) {
			buf.append(String.format("%02x", new Integer(b & 0xff)));
		}

		return buf.toString();
	}

	public static String getMac99(String key, String data) {

		try {

			System.err.println("data:" + data);
			data = Hex.encode(data);
			
			System.err.println("hex data:" + data);
			byte[] result99 = ANSIMacBySms4Utils.calculateANSIX9_9MAC(Hex.decode(key), Hex.decode(data));
			String response = Hex.encode(result99);

			System.err.println("response:" + response);
			return response;

		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws GeneralSecurityException, UnsupportedEncodingException {

		String key = "11111111111111111111111111111111";
		String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n"+
 "<Message><Head><PlatDate>20180705</PlatDate><PlatTrace>94</PlatTrace><RetCode>0000</RetCode><RetMsg>交易成功</RetMsg></Head><Body><bal>89993012.16</bal></Body></Message>";
		ANSIMacBySms4Utils.getMac99(key, str);

	}

}
