package com.sport.bet.core.common.general;

import java.util.List;

public abstract class GeneralServiceImpl<T> implements IGeneralService<T>{

	public abstract GeneralMapper<T> getGeneralMapper();

	@Override
	public void save(List<T> list, String tableName) {
		getGeneralMapper().insertByBatch(list, tableName);
	}

}
