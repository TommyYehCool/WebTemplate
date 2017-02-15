package com.exfantasy.template.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestLeetcode {

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
	public void test_leetcode_4() {
		int[] nums1 = new int[] {4, 5, 6, 8, 9, 11};
		int[] nums2 = new int[] {};
		double median = findMedianSortedArrays(nums1, nums2);
		System.out.println(median);
	}
	
	private double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, nums, 0, nums1.length);
        System.arraycopy(nums2, 0, nums, nums1.length, nums2.length);
        Arrays.sort(nums);
        if (nums.length % 2 == 0) {
        	int firstMedianIndex = (nums.length / 2) - 1;
        	int secondMedianIndex = (nums.length / 2);
        	return (double) (nums[firstMedianIndex] + nums[secondMedianIndex]) / 2;
        }
        else {
        	int medianIndex = (nums.length / 2);
        	return nums[medianIndex];
        }
    }
}
