package com.sport.bet.core.common.general;

import java.util.List;

public abstract class GeneralServiceImpl<T> implements IGeneralService<T>{

	public abstract GeneralMapper<T> getGeneralMapper();

	@Override
	public T findById(int id) {
		return getGeneralMapper().selectById(id);
	}
	
	@Override
	public List<T> findAll() {
		return getGeneralMapper().selectAll();
	}
	
	@Override
	public List<T> save(List<T> list, String tableName) {
		getGeneralMapper().insertByBatch(list, tableName);
		return list;
	}

	@Override
	public T save(T entity, String tableName) {
		getGeneralMapper().insert(entity, tableName);
		return entity;
	}
	
	@Override
	public int truncateTable(String tableName) {
		return getGeneralMapper().truncateTable(tableName);
	}

}
