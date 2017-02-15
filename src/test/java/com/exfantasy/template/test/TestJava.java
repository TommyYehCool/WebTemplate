package com.exfantasy.template.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestJava {
	
	@Test
	public void testFizzBuzz() {	
		List<String> fizzBuzz = fizzBuzz(15);
		System.out.println(fizzBuzz);
	}
	
	private List<String> fizzBuzz(int n) {
	    List<String> numbers = new ArrayList<>();
	    for (int i = 1; i <= n; i++) {
	    	if (i % 15 == 0) {
	            numbers.add("FizzBuzz");
	        }
	    	else if (i % 3 == 0) {
	            numbers.add("Fizz");
	        }
	        else if (i % 5 == 0) {
	            numbers.add("Buzz");
	        }
	        else {
	            numbers.add(String.valueOf(i));
	        }
	    }
	    return numbers;
	}

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
	
	private int binarySearch(int[] a, int key) {
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

	@Test
	public void testShift() {
		int[] a = new int[] {2, 3, 5, 7, 41, 57, 91, 93};
		
		int low = 0;
        int high = a.length - 1;

        int mid = (low + high) >> 1;
        
        System.out.println("low: " + low + ", high: " + high + ", mid: " + mid);
	}
	
	@Test
	public void testArray() {
		int[] nums1 = new int[] {1, 3};
		int[] nums2 = new int[] {2};
		double median = findMedianSortedArrays(nums1, nums2);
		System.out.println(median);
	}
	
	private double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, nums, 0, nums1.length);
        System.arraycopy(nums2, 0, nums, nums1.length, nums2.length);
        Arrays.sort(nums);
        double result = (double) (nums[0] + nums[nums.length - 1]) / 2;
		return result;
    }
}
