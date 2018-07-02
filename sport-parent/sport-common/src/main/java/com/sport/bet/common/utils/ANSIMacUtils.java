package com.sport.bet.common.utils;

import java.security.GeneralSecurityException;

public class ANSIMacUtils {
	
	 /** 
     * ANSI X9.9MAC算法  <br/> 
     * (1) ANSI X9.9MAC算法只使用单倍长密钥。  <br/> 
     * (2)  MAC数据先按8字节分组，表示为D0～Dn，如果Dn不足8字节时，尾部以字节00补齐。 <br/> 
     * (3) 用MAC密钥加密D0，加密结果与D1异或作为下一次的输入。 <br/> 
     * (4) 将上一步的加密结果与下一分组异或，然后再用MAC密钥加密。<br/> 
     * (5) 直至所有分组结束，取最后结果的左半部作为MAC。<br/> 
     * 采用x9.9算法计算MAC (Count MAC by ANSI-x9.9). 
     *  
     * @param key  8字节密钥数据 
     * @param data 待计算的缓冲区 
     * @throws GeneralSecurityException  
     */  
    public static byte[] calculateANSIX9_9MAC(byte[] key, byte[] data) throws GeneralSecurityException {  
          
        final int dataLength = data.length;  
        final int lastLength = dataLength % 8;  
        final int lastBlockLength = lastLength == 0 ? 8 : lastLength;  
        final int blockCount = dataLength / 8 + (lastLength > 0 ? 1 : 0);  
          
        // 拆分数据（8字节块/Block）  
        byte[][] dataBlock = new byte[blockCount][8];  
        for (int i = 0; i < blockCount; i++) {  
            int copyLength = i == blockCount - 1 ? lastBlockLength : 8;  
            System.arraycopy(data, i * 8, dataBlock[i], 0, copyLength);  
        }  
          
        byte[] desXor = new byte[8];  
        for (int i = 0; i < blockCount; i++) {  
            byte[] tXor = DESUtils.xOr(desXor, dataBlock[i]);  
            desXor = DESUtils.encryptByDesEcb(tXor, key); // DES加密  
        }  
        return desXor;  
    }  
      
    /** 
     * 采用ANSI x9.19算法计算MAC (Count MAC by ANSI-x9.19).<br/> 
     * 将ANSI X9.9的结果做如下计算<br/> 
     * (6) 用MAC密钥右半部解密(5)的结果。 <br/> 
     * (7) 用MAC密钥左半部加密(6)的结果。<br/> 
     * (8) 取(7)的结果的左半部作为MAC。<br/> 
     * @param key  16字节密钥数据 
     * @param data 待计算的缓冲区 
     * @throws GeneralSecurityException  
     */  
    public static byte[] calculateANSIX9_19MAC(byte[] key, byte[] data) throws GeneralSecurityException {  
        if (key == null || data == null)  
            return null;  
          
        if (key.length != 16) {  
            throw new RuntimeException("秘钥长度错误.");  
        }  
          
        byte[] keyLeft = new byte[8];  
        byte[] keyRight = new byte[8];  
        System.arraycopy(key, 0, keyLeft, 0, 8);  
        System.arraycopy(key, 8, keyRight, 0, 8);  
          
        byte[] result99 = calculateANSIX9_9MAC(keyLeft, data);  
          
        byte[] resultTemp = DESUtils.decryptByDesEcb(result99, keyRight);  
        return DESUtils.encryptByDesEcb(resultTemp, keyLeft);  
    }  
    
    public static byte[] toBytes(String str) {
        if(str == null || str.trim().equals("")) {
            return new byte[0];
        }

        byte[] bytes = new byte[str.length() / 2];
        for(int i = 0; i < str.length() / 2; i++) {
            String subStr = str.substring(i * 2, i * 2 + 2);
            bytes[i] = (byte) Integer.parseInt(subStr, 16);
        }

        return bytes;
    }

    public static String bytesToHexFun3(byte[] bytes) {
        StringBuilder buf = new StringBuilder(bytes.length * 2);
        for(byte b : bytes) { // 浣跨敤String鐨刦ormat鏂规硶杩涜杞崲
            buf.append(String.format("%02x", new Integer(b & 0xff)));
        }

        return buf.toString();
    }
    
    public static String getMac99(String key, String data){
    	  try {
			byte[] result = ANSIMacUtils.calculateANSIX9_19MAC(toBytes(key),toBytes(data));
			return  bytesToHexFun3(result);
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
		return null;
    }

}
