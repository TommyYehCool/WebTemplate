package com.exfantasy.template.test;

import org.junit.Ignore;
import org.junit.Test;

import com.exfantasy.template.mybatis.custom.CustomNBAGameSqlProvider;

public class TestCustomSQLProvider {
	private CustomNBAGameSqlProvider sqlProvider = new CustomNBAGameSqlProvider();

	@Test
	@Ignore
	public void testSelectNBAGameResps() {
		System.out.println(sqlProvider.selectNBAGameResps());
	}
	
	@Test
	public void test() {
		System.out.println(sqlProvider.selectNBAGameRespByGameId());
	}
}
