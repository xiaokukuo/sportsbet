package com.sport.bet.core.common.general;

import java.util.List;

public interface IGeneralService<T> {
	
	T findById(int id, String tableName);
	
	List<T> findAll(String tableName);

	List<T> save(List<T> list, String tableName);
	
	T save(T entity, String tableName);
	
	int truncateTable(String tableName);
}
