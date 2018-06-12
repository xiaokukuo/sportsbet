package com.sport.bet.datasource.utils;

import java.util.List;

public class ListUtils {
	
	public static boolean isEmpty(List<Object> list){
		if(list == null || list.size() <= 0){
			return true;
		}
		return false;
	}


}
