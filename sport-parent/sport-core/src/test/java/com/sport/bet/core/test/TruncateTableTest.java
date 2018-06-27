package com.sport.bet.core.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sport.bet.core.service.impl.TruncateServiceImpl;
import com.sport.bet.core.test.base.BaseTest;

public class TruncateTableTest extends BaseTest {


	@Autowired
	private TruncateServiceImpl truncateServiceImpl;
	
	@Test
	//@Rollback(value = true)
	public void truncateTest (){
		truncateServiceImpl.truncateByName("pin111");
	}
	
}
