package com.exfantasy.template.test;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.assertj.core.api.Assertions.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestJava {

	@Test
	public void testDate() {
		Long timeInMillis = 1486783800000L;
		Date date = new Date(timeInMillis);
		
		String timeStr = "2017-02-11 11:30:00";
		
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		assertThat(dateTimeFormat.format(date)).isEqualTo(timeStr);
	}
}
