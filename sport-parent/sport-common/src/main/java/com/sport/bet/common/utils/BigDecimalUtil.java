package com.sport.bet.common.utils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * BigDecimal工具类
 * @author zsf
 * @创建时间 2016年3月19日 上午10:09:14
 */
public class BigDecimalUtil {

	/**
	 * 两个BigDecimal数据相加,若n1或n2为null,则返回null
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static BigDecimal add(BigDecimal n1,BigDecimal n2){
		return add(n1, n2, null);
	}
	/**
	 * 两个BigDecimal数据相加,若n1或n2为null,则返回null
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static BigDecimal add(BigDecimal n1,BigDecimal n2,MathContext mc){
		if(n1 != null){
			if(n2 == null){
				return n1;
			}
			if(mc != null){
				return n1.add(n2,mc);
			}
			return n1.add(n2);
		}
		return null;
	}

	/**
	 * 返回一个 BigDecimal，其值为 (n1 + n2 + ...)
	 */
	public static BigDecimal add(MathContext mc,BigDecimal...n){
		BigDecimal result = BigDecimal.ZERO;
		if(n != null && n.length > 0){
			for(int i = 0,len = n.length; i < len; i++){
				result = add(result, n[i], mc);
			}
		}
		return result;
	}
	
	/**
	 * 返回一个 BigDecimal，其值为 (n1 - n2),若n1或n2为null，则返回null
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static BigDecimal subtract(BigDecimal n1,BigDecimal n2){
		return subtract(n1, n2, null);
	}
	/**
	 * 返回一个 BigDecimal，其值为 (n1 - n2),若n1或n2为null，则返回null
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static BigDecimal subtract(BigDecimal n1,BigDecimal n2,MathContext mc){
		if(n1 != null){
			if(n2 == null){
				return n1;
			}
			if(mc != null){
				return n1.subtract(n2,mc);
			}
			return n1.subtract(n2);
		}
		return null;
	}
	/**
	 * 返回一个BigDecimal，其值为 (n1 / n2),若n1或n2为null,则返回null
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static BigDecimal divide(BigDecimal n1,BigDecimal n2){
		return divide(n1, n2, (MathContext)null);
	}
	/**
	 * 返回一个BigDecimal，其值为 (n1 / n2),若n1或n2为null,则返回null
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static BigDecimal divide(BigDecimal n1,BigDecimal n2,MathContext mc){
		if(n1 != null){
			if(n2 == null){
				return n1;
			}
			if(mc != null){
				return n1.divide(n2,mc);
			}
			return n1.divide(n2);
		}
		return null;
	}
	
	/**
	 * 返回一个BigDecimal，其值为 (n1 / n2),若n1或n2为null,则返回null
	 * @param n1
	 * @param n2
	 * @param roundingMode 要应用的舍入模式
	 * @return
	 */
	public static BigDecimal divide(BigDecimal n1,BigDecimal n2,int scale,RoundingMode roundingMode){
		if(n1 != null && n2 !=null){
			return n1.divide(n2, scale, roundingMode);
		}
		return null;
	}
	/**
	 * 返回一个BigDecimal，其值为 (n1 / n2),若n1或n2为null,则返回null
	 * @param n1
	 * @param n2
	 * @param roundingMode 要应用的舍入模式
	 * @return
	 */
	public static BigDecimal divide(BigDecimal n1,BigDecimal n2,RoundingMode roundingMode){
		if(n1 != null && n2 !=null){
			return n1.divide(n2,roundingMode);
		}
		return null;
	}
	
	/**
	 * 返回一个 BigDecimal，其值为 (n1 × n2)，
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static BigDecimal multiply(BigDecimal n1,BigDecimal n2){
		if(n1 != null && n2 !=null){
			return n1.multiply(n2);
		}
		return null;
	}
	/**
	 * 返回一个 BigDecimal，其值为 (n1 × n2 x ...)，
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static BigDecimal multiply(MathContext mc,BigDecimal...n){
		BigDecimal result = new BigDecimal(1,mc);
		if(n != null && n.length >1){
			for(int i = 0,len = n.length; i < len; i++){
				result = result.multiply(n[i],mc);
			}
		}
		return result;
	}
	
	/**
	 * 返回一个 BigDecimal，其值为 (n1 × n2)，
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static BigDecimal multiply(BigDecimal n1,BigDecimal n2,MathContext mc){
		if(n1 != null && n2 !=null){
			return n1.multiply(n2,mc);
		}
		return null;
	}
	
	public static BigDecimal multiply(BigDecimal n1,BigDecimal n2,int scale,RoundingMode roundingMode){
		if(n1 != null && n2 !=null){
			return n1.multiply(n2).setScale(scale, roundingMode);
		}
		return null;
	}
	
	/**
	 * 返回一个 BigDecimal，其标度为指定值，其值在数值上等于此 BigDecimal 的值。
	 * @param n1
	 * @param scale
	 * @return
	 */
	public static BigDecimal setScale(BigDecimal n1,int scale){
		return n1.setScale(scale);
	}
	
	public static BigDecimal setScale(BigDecimal n1,int scale,RoundingMode roundingMode){
		return n1.setScale(scale, roundingMode);
	}
	
	public static BigDecimal setScale(BigDecimal n1,MathContext mathContext){
		return n1.setScale(mathContext.getPrecision(), mathContext.getRoundingMode());
	}
	
	public static double doubleValue(BigDecimal n){
		return n.doubleValue();
	}
	
	/**
	 * 返回其值为 (thisn) 的 BigDecimal，准确计算该幂，使其具有无限精度
	 * @param value
	 * @param n
	 * @return
	 */
	public static BigDecimal pow(BigDecimal value,int n){
		return value.pow(n);
	}
	/**
	 * 返回其值为 (thisn) 的 BigDecimal，准确计算该幂，使其具有无限精度
	 * @param value
	 * @param n
	 * @return
	 */
	public static BigDecimal pow(BigDecimal value,int n,MathContext mc){
		return value.pow(n,mc);
	}
	
	public static int intValue(BigDecimal n){
		return n.intValue();
	}
}
