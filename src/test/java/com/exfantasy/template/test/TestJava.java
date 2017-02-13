package com.exfantasy.template.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

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
	
	@Test
	public void testStringFormat() {
		String date = "2017-2-12";
		String url = "http://tw.global.nba.com/stats2/scores/daily.json?countryCode=TW&locale=zh_TW&gameDate={0}";
		String formattedUrl = MessageFormat.format(url, date);
		System.out.println(formattedUrl);
	}
}
