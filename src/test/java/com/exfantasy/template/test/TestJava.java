package com.exfantasy.template.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestJava {

	@Test
	@Ignore
	public void testDate() {
		Long timeInMillis = 1486783800000L;
		Date date = new Date(timeInMillis);
		
		String timeStr = "2017-02-11 11:30:00";
		
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		assertThat(dateTimeFormat.format(date)).isEqualTo(timeStr);
	}
	
	@Test
	@Ignore
	public void testStringFormat() {
		String date = "2017-2-12";
		String url = "http://tw.global.nba.com/stats2/scores/daily.json?countryCode=TW&locale=zh_TW&gameDate={0}";
		String formattedUrl = MessageFormat.format(url, date);
		System.out.println(formattedUrl);
	}
	
	@Test
	public void testBinarySearch() {
		int[] a = new int[] {2, 3, 5, 7, 41, 55, 57, 73, 91, 93};

		int index = 2;
		int searchTarget = a[index];

		int foundIndex = binarySearch(a, searchTarget);
		assertThat(index).isEqualTo(foundIndex);
	}
	
	@Test
	public void testShift() {
		int[] a = new int[] {2, 3, 5, 7, 41, 57, 91, 93};
		
		int low = 0;
        int high = a.length - 1;

        int mid = (low + high) >> 1;
        
        System.out.println("low: " + low + ", high: " + high + ", mid: " + mid);
	}
	
	/**
	 * http://program-lover.blogspot.tw/2008/08/binary-search.html
	 * 
	 * @param a
	 * @param key
	 * @return
	 */
	public static int binarySearch(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            if (key < a[mid]) {
            	hi = mid - 1;
            }
            else if (key > a[mid]) {
            	lo = mid + 1;
            }
            else {
            	return mid;
            }
        }
        return -1;
    }
}
