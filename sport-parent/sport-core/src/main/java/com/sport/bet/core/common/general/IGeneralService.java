package com.sport.bet.core.common.general;

import java.util.List;

public interface IGeneralService<T> {

	void save(List<T> list, String tableName);
	
}
