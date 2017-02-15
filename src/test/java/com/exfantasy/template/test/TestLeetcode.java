package com.exfantasy.template.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestLeetcode {

	@Test
	public void testFizzBuzz() {
		List<String> fizzBuzz = fizzBuzz(15);
		
		List<String> expectedResult = new ArrayList<String>();
		expectedResult.add("1");
		expectedResult.add("2");
		expectedResult.add("Fizz");
		expectedResult.add("4");
		expectedResult.add("Buzz");
		expectedResult.add("Fizz");
		expectedResult.add("7");
		expectedResult.add("8");
		expectedResult.add("Fizz");
		expectedResult.add("Buzz");
		expectedResult.add("11");
		expectedResult.add("Fizz");
		expectedResult.add("13");
		expectedResult.add("14");
		expectedResult.add("FizzBuzz");
		
		assertThat(fizzBuzz).isEqualTo(expectedResult);
	}

	private List<String> fizzBuzz(int n) {
		List<String> numbers = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (i % 15 == 0) {
				numbers.add("FizzBuzz");
			} else if (i % 3 == 0) {
				numbers.add("Fizz");
			} else if (i % 5 == 0) {
				numbers.add("Buzz");
			} else {
				numbers.add(String.valueOf(i));
			}
		}
		return numbers;
	}

	@Test
	public void testBinarySearch() {
		int[] a = new int[] { 2, 3, 5, 7, 41, 55, 57, 73, 91, 93 };

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
			} else if (key > a[mid]) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	@Test
	public void test_leetcode_4() {
		int[] nums1 = new int[] { 4, 5, 6, 8, 9, 11 };
		int[] nums2 = new int[] {};

		double expectedOutput = (double) (6 + 8) / 2;

		double median = findMedianSortedArrays(nums1, nums2);

		assertThat(median).isEqualTo(expectedOutput);
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
		} else {
			int medianIndex = (nums.length / 2);
			return nums[medianIndex];
		}
	}
	
	/**
	 * <pre>
	 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
	 * 
	 * Example 1:
	 *		Input: ["Hello", "Alaska", "Dad", "Peace"]
	 *		Output: ["Alaska", "Dad"]
	 * </pre>
	 */
	@Test
	public void test_leetcode_500() {
		String[] input = new String[] {"Hello", "Alaska", "Dad", "Peace"};
		String[] expectedOutput = new String[] {"Alaska", "Dad"};
		
		String[] output = findWords(input);
		
		assertThat(output).isEqualTo(expectedOutput);
	}
	
	private String[] findWords(String[] words) {
		return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
    }

	/**
	 * <pre>
	 * Given a string s, find the longest palindromic subsequence's length in s.
	 * You may assume that the maximum length of s is 1000.
	 *
	 * Example 1: 
	 * 		Input: "bbbab" 
	 * 		Output: 4 
	 * 		One possible longest palindromic subsequence is "bbbb".
	 *
	 * Example 2: 
	 * 		Input: "cbbd" 
	 * 		Output: 2 
	 * 		One possible longest palindromic subsequence is "bb".
	 * </pre>
	 */
	@Test
	public void test_leetcode_516() {
		String input = "bbbab";
		int expectedOutput = 4;

		int output = longestPalindromeSubseq(input);

		assertThat(output).isEqualTo(expectedOutput);
	}

	private int longestPalindromeSubseq(String s) {
		int[][] dp = new int[s.length()][s.length()];

		for (int i = s.length() - 1; i >= 0; i--) {
			dp[i][i] = 1;
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i + 1][j - 1] + 2;
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[0][s.length() - 1];
	}
}
