package com.exfantasy.template.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Stream;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestLeetcode {

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
			int mid = (lo + hi) >>> 1;
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
	
	/**
	 * <pre>
	 * 1. Two Sum
	 * 
	 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
	 * 
	 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
	 * 
	 * Example:
	 * Given nums = [2, 7, 11, 15], target = 9,
	 * 
	 * Because nums[0] + nums[1] = 2 + 7 = 9,
	 * return [0, 1].
	 * </pre>
	 */
	@Test
	public void test_leetcode_1() {
		int[] nums1 = new int[] {2, 7, 11, 15};
		int target1 = 9;
		int[] output1 = twoSum1(nums1, target1);
		int[] expectedOutput1 = new int[] {0, 1};
		assertThat(output1).isEqualTo(expectedOutput1);
	}
	
	private int[] twoSum1(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				return new int[] { map.get(nums[i]) + 1, i + 1 };
			} else {
				map.put(target - nums[i], i);
			}
		}
		return new int[] { 0, 0 };
	}
	
	/**
	 * <pre>
	 * 4. Median of Two Sorted Arrays
	 * 
	 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
	 * 
	 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
	 * 
	 * Example 1:
	 * nums1 = [1, 3]
	 * nums2 = [2]
	 * 
	 * The median is 2.0
	 * 
	 * Example 2:
	 * nums1 = [1, 2]
	 * nums2 = [3, 4]
	 * 
	 * The median is (2 + 3)/2 = 2.5
	 * </pre>
	 */
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
	 * 10. Regular Expression Matching
	 * 
	 * Implement regular expression matching with support for '.' and '*'.
	 * 
	 * '.' Matches any single character.
	 * '*' Matches zero or more of the preceding element.
	 * 
	 * The matching should cover the entire input string (not partial).
	 * 
	 * The function prototype should be:
	 * bool isMatch(const char *s, const char *p)
	 * 
	 * Some examples:
	 * isMatch("aa","a") → false
	 * isMatch("aa","aa") → true
	 * isMatch("aaa","aa") → false
	 * isMatch("aa", "a*") → true
	 * isMatch("aa", ".*") → true
	 * isMatch("ab", ".*") → true
	 * isMatch("aab", "c*a*b") → true
	 * </pre>
	 */
	@Test
	public void test_leetcode_10() {
		String s1 = "aa";
		String p1 = "a";
		boolean expectedOutput1 = false;
		boolean output1 = isMatch10(s1, p1);
		assertThat(expectedOutput1).isEqualTo(output1);
		
		String s2 = "aa";
		String p2 = ".*";
		boolean expectedOutput2 = true;
		boolean output2 = isMatch10(s2, p2);
		assertThat(expectedOutput2).isEqualTo(output2);
	}
	
	private boolean isMatch10(String s, String p) {
		if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }
        for (int i = 0 ; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
	
	/**
	 * <pre>
	 * 15. 3Sum
	 * 
	 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
	 * 
	 * Note: The solution set must not contain duplicate triplets.
	 * 
	 * For example, given array S = [-1, 0, 1, 2, -1, -4],
	 * 
	 * A solution set is:
	 * [
  	 * 		[-1, 0, 1],
  	 * 		[-1, -1, 2]
	 * ]
	 * </pre>
	 */
	@Test
	public void test_leetcode_15() {
		int[] nums1 = new int[] {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> output1 = threeSum(nums1);
		List<List<Integer>> expectedOutput1 = new ArrayList<>();
		expectedOutput1.add(Arrays.asList(-1, 0, 1));
		expectedOutput1.add(Arrays.asList(-1, -1, 2));
		assertThat(output1).containsAll(expectedOutput1);
	}
	
	private List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new LinkedList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
				while (lo < hi) {
					if (nums[lo] + nums[hi] == sum) {
						res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
						while (lo < hi && nums[lo] == nums[lo + 1])
							lo++;
						while (lo < hi && nums[hi] == nums[hi - 1])
							hi--;
						lo++;
						hi--;
					} else if (nums[lo] + nums[hi] < sum)
						lo++;
					else
						hi--;
				}
			}
		}
		return res;
	}
	
	/**
	 * <pre>
	 * 16. 3Sum Closest
	 * 
	 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
	 * 
     * For example, given array S = {-1 2 1 -4}, and target = 1.
	 * 
     * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
	 * </pre>
	 */
	@Test
	public void test_leetcode_16() {
		int[] nums1 = new int[] {-1, 2, 1, -4};
		int target1 = 1;
		int output1 = threeSumClosest(nums1, target1);
		int expectedOutput1 = 2;
		assertThat(output1).isEqualTo(expectedOutput1);
	}
	
	private int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);

		int len = nums.length;
		int res = 0;

		if (len <= 3) {
			for (int num : nums)
				res += num;
			return res;
		}

		res = nums[0] + nums[1] + nums[2];

		for (int i = 0; i <= len - 3; i++) {
			int j = i + 1;
			int k = len - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (Math.abs(target - res) >= Math.abs(target - sum)) {
					res = sum;
					if (res == target)
						return res;
				}
				if (sum > target)
					k--;
				else if (sum < target)
					j++;
			}
		}
		return res;
	}
	
	/**
	 * <pre>
	 * 17. Letter Combinations of a Phone Number
	 * 
	 * Given a digit string, return all possible letter combinations that the number could represent.
	 * 
	 * A mapping of digit to letters (just like on the telephone buttons) is given below.
	 * 
	 * <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/?tab=Description">letter-combinations-of-a-phone-number</a>
	 * 
	 * Input:Digit string "23"
	 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
	 * </pre>
	 */
	@Test
	public void test_leetcode_17() {
		String digits1 = "23";
		List<String> output1 = letterCombinations(digits1);
		List<String> expectedOutput1 = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
		assertThat(output1).containsExactlyElementsOf(expectedOutput1);
		
		String digits2 = "58";
		List<String> output2 = letterCombinations(digits2);
		List<String> expectedOutput2 = Arrays.asList("jt", "ju", "jv", "kt", "ku", "kv", "lt", "lu", "lv");
		assertThat(output2).containsExactlyElementsOf(expectedOutput2);
	}
	
	private List<String> letterCombinations(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		if (digits.length() == 0) {
			return ans;
		}
		String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		ans.add("");
		for (int i = 0; i < digits.length(); i++) {
			int x = Character.getNumericValue(digits.charAt(i));
			while (ans.peek().length() == i) {
				String t = ans.remove();
				for (char s : mapping[x].toCharArray())
					ans.add(t + s);
			}
		}
		return ans;
	}
	
	/**
	 * <pre>
	 * 26. Remove Duplicates from Sorted Array
	 * 
	 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
	 * 
	 * Do not allocate extra space for another array, you must do this in place with constant memory.
	 * 
	 * For example,
	 * Given input array nums = [1,1,2],
	 * 
	 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
	 * </pre>
	 */
	@Test
	public void test_leetcode_26() {
		int[] nums1 = new int[] {1,1,2,3};
		int expectedOutput1 = 3;
		int output1 = removeDuplicates(nums1);
		assertThat(output1).isEqualTo(expectedOutput1);
		
		int[] nums2 = new int[] {1,1,2,2,3,4,4,4,5};
		int expectedOutput2 = 5;
		int output2 = removeDuplicates(nums2);
		assertThat(output2).isEqualTo(expectedOutput2);
		
		int[] nums3 = new int[] {8};
		int expectedOutput3 = 1;
		int output3 = removeDuplicates(nums3);
		assertThat(output3).isEqualTo(expectedOutput3);
		
		int[] nums4 = new int[] {1,1};
		int expectedOutput4 = 1;
		int output4 = removeDuplicates(nums4);
		assertThat(output4).isEqualTo(expectedOutput4);
	}
	
	private int removeDuplicates(int[] nums) {
		int i = nums.length > 0 ? 1 : 0;
		for (int n : nums)
			if (n > nums[i - 1])
				nums[i++] = n;
		return i;
	}
	
	/**
	 * <pre>
	 * 27. Remove Element
	 * 
	 * Given an array and a value, remove all instances of that value in place and return the new length.
	 * 
	 * Do not allocate extra space for another array, you must do this in place with constant memory.
	 * 
	 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
	 * 
	 * Example:
	 * Given input array nums = [3,2,2,3], val = 3
	 * 
	 * Your function should return length = 2, with the first two elements of nums being 2.
	 * </pre>
	 */
	@Test
	public void test_leetcode_27() {
		int[] nums1 = new int[] {3,2,2,3};
		int val1 = 3;
		int expectedOutput1 = 2;
		int output1 = removeElement(nums1, val1);
		assertThat(output1).isEqualTo(expectedOutput1);
	}
	
    private int removeElement(int[] nums, int val) {
		int m = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[m] = nums[i];
				m++;
			}
		}
		return m;
    }
    
    /**
     * <pre>
     * 32. Longest Valid Parentheses
     * 
     * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
     * 
     * For "(()", the longest valid parentheses substring is "()", which has length = 2.
     * 
     * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
     * </pre>
     */
    @Test
    public void test_leetcode_32() {
    	String s1 = "(()";
    	int output1 = longestValidParentheses(s1);
    	int expectedOutput1 = 2;
    	assertThat(output1).isEqualTo(expectedOutput1);
    	
    	String s2 = ")()())";
    	int output2 = longestValidParentheses(s2);
    	int expectedOutput2 = 4;
    	assertThat(output2).isEqualTo(expectedOutput2);
    	
    	String s3 = "()(()";
    	int output3 = longestValidParentheses(s3);
    	int expectedOutput3 = 2;
    	assertThat(output3).isEqualTo(expectedOutput3);
    	
    	String s4 = "()(())";
    	int output4 = longestValidParentheses(s4);
    	int expectedOutput4 = 6;
    	assertThat(output4).isEqualTo(expectedOutput4);
    }
    
	private int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		int left = -1;
		for (int i = 0; i < s.length(); i++) {
			// got '('
			if (s.charAt(i) == '(') {
				stack.push(i);
			}
			// got ')'
			else {
				if (stack.isEmpty()) {
					left = i;
				}
				else {
					stack.pop();
					if (stack.isEmpty()) {
						max = Math.max(max, i - left);
					}
					else {
						max = Math.max(max, i - stack.peek());
					}
				}
			}
		}
		return max;
	}
    
    private int myWrongSolution_longestValidParentheses(String s) {
    	char[] sc = s.toCharArray();
    	
    	Stack<Character> stack = new Stack<>();
    	
    	int currentLength = 0;
    	boolean lastCharIsLeft = false;
    	for (char c : sc) {
    		switch (c) {
    			case '(':
    				if (lastCharIsLeft) {
    					currentLength = 0;
    				}
    				lastCharIsLeft = true;
    				stack.push(c);
    				break;
    				
    			case ')':
    				lastCharIsLeft = false;
    				Character pop = !stack.isEmpty() ? stack.pop() : ' ';
    				if (pop == '(') {
    					currentLength += 2;
    				}
    				break;
    		}
    	}
    	return currentLength;
    }
    
    /**
     * <pre>
     * 34. Search for a Range
     * 
     * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
     * 
     * Your algorithm's runtime complexity must be in the order of O(log n).
     * 
     * If the target is not found in the array, return [-1, -1].
     * 
     * For example,
     * Given [5, 7, 7, 8, 8, 10] and target value 8,
     * return [3, 4].
     * </pre>
     */
    @Test
    public void test_leetcode_34() {
    	int[] nums1 = new int[] {1};
    	int target1 = 1;
    	int[] output1 = searchRange(nums1, target1);
    	int[] expectedOutput1 = new int[] {0,0};
    	assertThat(output1).isEqualTo(expectedOutput1);
    	
    	int[] nums2 = new int[] {5, 7, 7, 8, 8, 10};
    	int target2 = 8;
    	int[] output2 = searchRange(nums2, target2);
    	int[] expectedOutput2 = new int[] {3,4};
    	assertThat(output2).isEqualTo(expectedOutput2);
    }
    
	private int[] searchRange(int[] nums, int target) {
		int start = firstGreaterEqual(nums, target);
		if (start == nums.length || nums[start] != target) {
			return new int[] { -1, -1 };
		}
		return new int[] { start, firstGreaterEqual(nums, target + 1) - 1 };
	}

	// find the first number that is greater than or equal to target.
	// could return A.length if target is greater than A[A.length-1].
	// actually this is the same as lower_bound in C++ STL.
	private int firstGreaterEqual(int[] A, int target) {
		int low = 0, high = A.length;
		while (low < high) {
			int mid = low + ((high - low) >> 1);
			if (A[mid] < target) {
				low = mid + 1;
			} else {
				//should not be mid-1 when A[mid]==target.
				//could be mid even if A[mid]>target because mid<high.
				high = mid;
			}
		}
		return low;
	}
    
    /**
     * <pre>
     * 35. Search Insert Position
     * 
     * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
     * 
     * You may assume no duplicates in the array.
     * 
     * Here are few examples.
     * [1,3,5,6], 5 → 2
     * [1,3,5,6], 2 → 1
     * [1,3,5,6], 7 → 4
     * [1,3,5,6], 0 → 0
     * </pre>
     */
    @Test
    public void test_leetcode_35() {
    	int[] nums = new int[] {1,3,5,6};
    	int target1 = 5;
    	int expectedOutput1 = 2;
    	int output1 = searchInsert(nums, target1);
    	assertThat(output1).isEqualTo(expectedOutput1);
    	
    	int target2 = 2;
    	int expectedOutput2 = 1;
    	int output2 = searchInsert(nums, target2);
    	assertThat(output2).isEqualTo(expectedOutput2);
    	
    	int target3 = 7;
    	int expectedOutput3 = 4;
    	int output3 = searchInsert(nums, target3);
    	assertThat(output3).isEqualTo(expectedOutput3);
    	
    	int target4 = 0;
    	int expectedOutput4 = 0;
    	int output4 = searchInsert(nums, target4);
    	assertThat(output4).isEqualTo(expectedOutput4);
    }
    
    private int searchInsert(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] > target)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return low;
    }

	/**
	 * <pre>
	 * 44. Wildcard Matching
	 * 
	 * Implement wildcard pattern matching with support for '?' and '*'.
	 * 
	 * '?' Matches any single character.
	 * '*' Matches any sequence of characters (including the empty sequence).
	 * 
	 * The matching should cover the entire input string (not partial).
	 * 
	 * The function prototype should be:
	 * bool isMatch(const char *s, const char *p)
	 * 
	 * Some examples:
	 * isMatch("aa","a") → false
	 * isMatch("aa","aa") → true
	 * isMatch("aaa","aa") → false
	 * isMatch("aa", "*") → true
	 * isMatch("aa", "a*") → true
	 * isMatch("ab", "?*") → true
	 * isMatch("aab", "c*a*b") → false
	 * </pre>
	 */
	@Test
	public void test_leetcode_44() {
		String s1 = "aa";
		String p1 = "a";
		boolean expectedResult1 = false;
		boolean output1 = isMatch44(s1, p1);
		assertThat(expectedResult1).isEqualTo(output1);
		
		String s2 = "aa";
		String p2 = "a*";
		boolean expectedResult2 = true;
		boolean output2 = isMatch44(s2, p2);
		assertThat(expectedResult2).isEqualTo(output2);
	}
	
	private boolean isMatch44(String s, String p) {
		int sL = s.length(), pL = p.length();

		boolean[][] dp = new boolean[pL + 1][sL + 1];
		dp[0][0] = true;

		for (int i = 1; i <= pL; i++) {
			boolean flag = false; // The flag is moved here;

			for (int j = 0; j <= sL; j++) {
				flag = flag || dp[i - 1][j];
				char c = p.charAt(i - 1);

				if (c != '*') {
					dp[i][j] = j > 0 && dp[i - 1][j - 1] && (c == '?' || c == s.charAt(j - 1));
				} else {
					// For k>=0 and k<=j, if any dp[i-1][k] is true,
					// then '*' will match the rest sequence in s after index k;
					dp[i][j] = i == 1 || flag;
				}
			}
		}
		return dp[pL][sL];
	}
	
	/**
	 * <pre>
	 * 56. Merge Intervals
	 * 
	 * Given a collection of intervals, merge all overlapping intervals.
	 * 
	 * For example,
	 * Given [1,3],[2,6],[8,10],[15,18],
	 * return [1,6],[8,10],[15,18].
	 * </pre>
	 */
	@Test
	public void test_leetcode_56() {
		List<Interval> intervals1 = Arrays.asList(
			new Interval(2, 6),
			new Interval(1, 3),
			new Interval(8, 10),
			new Interval(15, 18)
		);
		
		List<Interval> output1 = merge(intervals1);
		
		List<Interval> expectedOutput1 = Arrays.asList(
			new Interval(1, 6),
			new Interval(8, 10),
			new Interval(15, 18)
		);
		
		assertThat(output1).isEqualTo(expectedOutput1);
	}
	
	private List<Interval> merge(List<Interval> intervals) {
		intervals.sort((i1, i2) -> (Integer.compare(i1.start, i2.start)));
        List<Interval> result = new ArrayList<>();
        for (Interval interval : intervals) {
            if (!result.isEmpty() && result.get(result.size() - 1).end >= interval.start) {
                Interval prev = result.get(result.size() - 1);
                prev.start = Math.min(prev.start, interval.start);
                prev.end = Math.max(prev.end, interval.end);
            } else {
                result.add(interval);
            }
        }
        return result;
	}
	
	private class Interval {
		int start;
		int end;

		Interval(int s, int e) {
			start = s;
			end = e;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + end;
			result = prime * result + start;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Interval other = (Interval) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (end != other.end)
				return false;
			if (start != other.start)
				return false;
			return true;
		}

		private TestLeetcode getOuterType() {
			return TestLeetcode.this;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Interval [start=").append(start).append(", end=").append(end).append("]");
			return builder.toString();
		}
	}
	
	/**
	 * <pre>
	 * 58. Length of Last Word
	 * 
	 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
	 * 
	 * If the last word does not exist, return 0.
	 * 
	 * Note: A word is defined as a character sequence consists of non-space characters only.
	 * 
	 * For example, 
	 * Given s = "Hello World",
	 * return 5.
	 * </pre>
	 */
	@Test
	public void test_leetcode_58() {
		String s1 = "Hello World";
		int output1 = lengthOfLastWord(s1);
		int expectedOutput1 = 5;
		assertThat(output1).isEqualTo(expectedOutput1);
	}
	
	private int lengthOfLastWord(String s) {
		return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
	}
	
	/**
	 * <pre>
	 * 61. Rotate List
	 * 
	 * Given a list, rotate the list to the right by k places, where k is non-negative.
	 * 
	 * For example:
	 * Given 1->2->3->4->5->NULL and k = 2,
	 * return 4->5->1->2->3->NULL.
	 * </pre>
	 */
	@Test
	public void test_leetcode_61() {
		ListNode head1 = new ListNode(1);
		head1.addLast(2);
		head1.addLast(3);
		head1.addLast(4);
		head1.addLast(5);
		int k1 = 2;
		ListNode output1 = rotateRight(head1, k1);
		String expectedOutput1 = "4 -> 5 -> 1 -> 2 -> 3";
		assertThat(output1.toString()).isEqualTo(expectedOutput1);
	}
	
	private ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null)
			return head;

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode fast = dummy, slow = dummy;

		int i;
		for (i = 0; fast.next != null; i++) // Get the total length
			fast = fast.next;

		for (int j = i - k % i; j > 0; j--) // Get the i-n%i th node
			slow = slow.next;

		fast.next = dummy.next; // Do the rotation
		dummy.next = slow.next;
		slow.next = null;

		return dummy.next;
	}
	
	/**
	 * <pre>
	 * 64. Minimum Path Sum
	 * 
	 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
	 * 
	 * Note: You can only move either down or right at any point in time.
	 * </pre>
	 */
	@Test
	public void test_leetcode_64() {
		int[][] grid1 = new int[][] {
			new int[] {1,2,3}, 
			new int[] {4,5,6}, 
			new int[] {7,8,9}
		};
		int output1 = minPathSum(grid1);
		int expectedOutput1 = 21;
		assertThat(output1).isEqualTo(expectedOutput1);
		
		int[][] grid2 = new int[][] {
			new int[] {1,7,4}, 
			new int[] {3,8,2}, 
			new int[] {9,5,6}
		};
		int output2 = minPathSum(grid2);
		int expectedOutput2 = 20;
		assertThat(output2).isEqualTo(expectedOutput2);
	}
	
    private int minPathSum(int[][] grid) {
    	int m = grid.length;// row
    	int n = grid[0].length; // column
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
    			if (i == 0 && j != 0) {
    				grid[i][j] = grid[i][j] + grid[i][j - 1];
    			} else if (i != 0 && j == 0) {
    				grid[i][j] = grid[i][j] + grid[i - 1][j];
    			} else if (i == 0 && j == 0) {
    				grid[i][j] = grid[i][j];
    			} else {
    				grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
    			}
    		}
    	}
    	return grid[m - 1][n - 1];
    }
	
	/**
	 * <pre>
	 * 68. Text Justification
	 * 
	 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
	 * 
	 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
	 * 
	 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
	 * 
	 * For the last line of text, it should be left justified and no extra space is inserted between words.
	 * 
	 * For example,
	 * words: ["This", "is", "an", "example", "of", "text", "justification."]
	 * L: 16.
	 * 
	 * Return the formatted lines as:
	 * [
   	 *   "This    is    an",
   	 *   "example  of text",
   	 *   "justification.  "
	 * ]
	 * </pre>
	 */
	@Test
	public void test_leetcode_68() {
		String[] words = new String[] {"This", "is", "an", "example", "of", "text", "justification."};
		int maxWidth = 16;
		List<String> output1 = fullJustify(words, maxWidth);
		List<String> expectedOutput1 = Arrays.asList("This    is    an", 
													 "example  of text", 
													 "justification.  ");
		assertThat(output1).isEqualTo(expectedOutput1);
	}
	
	private List<String> fullJustify(String[] words, int maxWidth) {
		List<String> lines = new ArrayList<String>();
        
        int index = 0;
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (words[last].length() + count + 1 > maxWidth) break;
                count += words[last].length() + 1;
                last++;
            }
            
            StringBuilder builder = new StringBuilder();
            int diff = last - index - 1;
            // if last line or number of words in the line is 1, left-justified
            if (last == words.length || diff == 0) {
                for (int i = index; i < last; i++) {
                    builder.append(words[i] + " ");
                }
                builder.deleteCharAt(builder.length() - 1);
                for (int i = builder.length(); i < maxWidth; i++) {
                    builder.append(" ");
                }
            } else {
                // middle justified
                int spaces = (maxWidth - count) / diff;
                int r = (maxWidth - count) % diff;
                for (int i = index; i < last; i++) {
                    builder.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j <= (spaces + ((i - index) < r ? 1 : 0)); j++) {
                            builder.append(" ");
                        }
                    }
                }
            }
            lines.add(builder.toString());
            index = last;
        }
        return lines;
    }
	
	/**
	 * <pre>
	 * 78. Subsets
	 * 
	 * Given a set of distinct integers, nums, return all possible subsets.
	 * 
	 * Note: The solution set must not contain duplicate subsets.
	 * 
	 * For example,
	 * If nums = [1,2,3], a solution is:
	 * 
	 * [
  	 *  [3],
  	 *  [1],
  	 *  [2],
  	 *  [1,2,3],
  	 *  [1,3],
  	 *  [2,3],
  	 *  [1,2],
  	 *  []
	 * ]
	 * </pre>
	 */
	@Test
	public void test_leetcode_78() {
		int[] nums1 = new int[] {1,2,3};
		List<List<Integer>> expectedOutput1 = new ArrayList<>();
		expectedOutput1.add(Arrays.asList(1));
		expectedOutput1.add(Arrays.asList(2));
		expectedOutput1.add(Arrays.asList(3));
		expectedOutput1.add(Arrays.asList(1,3));
		expectedOutput1.add(Arrays.asList(1,2));
		expectedOutput1.add(Arrays.asList(2,3));
		expectedOutput1.add(Arrays.asList(1,2,3));
		expectedOutput1.add(Arrays.asList());
		List<List<Integer>> output1 = subsets(nums1);
		assertThat(output1).containsAll(expectedOutput1);
	}
	
    private List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		
		// add empty result
		res.add(new ArrayList<Integer>());

		Arrays.sort(nums);

		for (int num : nums) {
			List<List<Integer>> newResult = new ArrayList<>();

			for (List<Integer> sub : res) {
				// 取得目前已經有的結果
				List<Integer> currentSubset = new ArrayList<>(sub);
				
				// 把目前的數字加入
				currentSubset.add(num);
				
				// 加入新的結果
				newResult.add(currentSubset);
			}
			// 加入最終結果
			res.addAll(newResult);
		}
		return res;
    }
    
    /**
     * <pre>
     * 79. Word Search
     * 
     * Given a 2D board and a word, find if the word exists in the grid.
     * 
     * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
     * 
     * For example,
     * Given board =
     * 
     * [
     * 		['A','B','C','E'],
     *		['S','F','C','S'],
     * 		['A','D','E','E']
     * ]
     * word = "ABCCED", -> returns true,
     * word = "SEE", -> returns true,
     * word = "ABCB", -> returns false.
     * </pre>
     */
    @Test
    public void test_leetcode_79() {
    	char[][] board = new char[][] {
    		{'A','B','C','E'},
    		{'S','F','C','S'},
    		{'A','D','E','E'}
    	};

    	String word1 = "ABCCED";
    	boolean output1 = exist(board, word1);
    	boolean expectedOutput1 = true;
    	assertThat(output1).isEqualTo(expectedOutput1);
    	
    	String word2 = "SEE";
    	boolean output2 = exist(board, word2);
    	boolean expectedOutput2 = true;
    	assertThat(output2).isEqualTo(expectedOutput2);
    	
    	String word3 = "ABCB";
    	boolean output3 = exist(board, word3);
    	boolean expectedOutput3 = false;
    	assertThat(output3).isEqualTo(expectedOutput3);
	}
    
	private boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++) {
				if (exist(board, i, j, word, 0))
					return true;
			}
		return false;
	}

	private boolean exist(char[][] board, int i, int j, String word, int ind) {
		if (ind == word.length())
			return true;

		if (i > board.length - 1 || i < 0 || j < 0 || j > board[0].length - 1 || board[i][j] != word.charAt(ind))
			return false;

		board[i][j] = '*';

		boolean result = 
				exist(board, i - 1, j, word, ind + 1) || 
				exist(board, i, j - 1, word, ind + 1) || 
				exist(board, i, j + 1, word, ind + 1) || 
				exist(board, i + 1, j, word, ind + 1);

		board[i][j] = word.charAt(ind);

		return result;
	}
	
	/**
	 * <pre>
	 * 80. Remove Duplicates from Sorted Array II
	 * 
	 * Follow up for "Remove Duplicates":
	 * What if duplicates are allowed at most twice?
	 * 
	 * For example,
	 * Given sorted array nums = [1,1,1,2,2,3],
	 * 
	 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
	 * </pre>
	 */
	@Test
	public void test_leetcode_80() {
		int[] nums1 = new int[] {1,1,1,2,2,3};
		int output1 = removeDuplicatesAtMostTwice(nums1);
		int expectedOutput1 = 5;
		assertThat(output1).isEqualTo(expectedOutput1);
		
		int[] nums2 = new int[] {1,1,1,2};
		int output2 = removeDuplicatesAtMostTwice(nums2);
		int expectedOutput2 = 3;
		assertThat(output2).isEqualTo(expectedOutput2);
	}
	
	private int removeDuplicatesAtMostTwice(int[] nums) {
		int i = 0;
		for (int n : nums)
			if (i < 2 || n > nums[i - 2])
				nums[i++] = n;
		return i;
	}
	
	/**
	 * <pre>
	 * 83. Remove Duplicates from Sorted List
	 * 
	 * Given a sorted linked list, delete all duplicates such that each element appear only once.
	 * 
	 * For example,
	 * Given 1->1->2, return 1->2.
	 * Given 1->1->2->3->3, return 1->2->3.
	 * </pre>
	 */
	@Test
	public void test_leetcode_83() {
		ListNode head1 = new ListNode(1);
		head1.addLast(1);
		head1.addLast(2);
		ListNode output1 = deleteDuplicates(head1);
		String expectedOutput1 = "1 -> 2";
		assertThat(output1.toString()).isEqualTo(expectedOutput1);
	}
	
    private ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		head.next = deleteDuplicates(head.next);
		return head.val == head.next.val ? head.next : head;
    }
	
	/**
	 * <pre>
	 * 84. Largest Rectangle in Histogram
	 * 
	 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
	 * find the area of largest rectangle in the histogram.
	 * 
	 * For example,
	 * Given heights = [2,1,5,6,2,3],
	 * return 10.
	 * </pre>
	 */
	@Test
	public void test_leetcode_84() {
		int[] heights1 = new int[] {2,1,5,6,2,3};
		int expectedOutput1 = 10;
		int output1 = largestRectangleArea(heights1);
		assertThat(output1).isEqualTo(expectedOutput1);
	}
	
	private int largestRectangleArea(int[] heights) {
		int len = heights.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : heights[i]);
            if(s.isEmpty() || h >= heights[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                maxArea = Math.max(maxArea, heights[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
	}
	
	/**
	 * <pre>
	 * 89. Gray Code
	 * 
	 * The gray code is a binary numeral system where two successive values differ in only one bit.
	 * 
	 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
	 * 
	 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
	 * 
	 * 00 - 0
	 * 01 - 1
	 * 11 - 3
	 * 10 - 2
	 * </pre>
	 */
	@Test
	public void test_leetcode_89() {
		int input = 2;
		
		List<Integer> expectedOutput = new ArrayList<>();
		expectedOutput.add(0);
		expectedOutput.add(1);
		expectedOutput.add(3);
		expectedOutput.add(2);
		
		List<Integer> output = grayCode(input);
		
		assertThat(output).containsAll(expectedOutput);
	}
	
	private List<Integer> grayCode(int n) {
		List<Integer> result = new LinkedList<>();
	    for (int i = 0; i < 1 << n; i++) result.add(i ^ i >> 1);
	    return result;
    }
	
	/**
	 * <pre>
	 * 100. Same Tree
	 * 
	 * Given two binary trees, write a function to check if they are equal or not.
	 * 
	 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
	 * </pre>
	 */
	@Test
	public void test_leetcode_100() {
		int[] tree1Vals = new int[] {10, 30, 70, 80, 90};
		int[] tree2Vals = tree1Vals;
		TreeNode tree1Root = sortedArrayToBST(tree1Vals);
//		System.out.println(binaryTreePaths(tree1Root));
		TreeNode tree2Root = sortedArrayToBST(tree2Vals);
//		System.out.println(binaryTreePaths(tree2Root));
		boolean output1 = isSameTree(tree1Root, tree2Root);
		assertThat(output1).isEqualTo(true);
		
		int[] tree3Vals = new int[] {10, 30, 70, 80, 90};
		int[] tree4Vals = new int[] {10, 50, 60, 90, 100};
		TreeNode tree3Root = sortedArrayToBST(tree3Vals);
//		System.out.println(binaryTreePaths(tree3Root));
		TreeNode tree4Root = sortedArrayToBST(tree4Vals);
//		System.out.println(binaryTreePaths(tree4Root));
		boolean output2 = isSameTree(tree3Root, tree4Root);
		assertThat(output2).isEqualTo(false);
	}
	
	private boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
	
	/**
	 * <pre>
	 * 102. Binary Tree Level Order Traversal
	 * 
	 * [Reference 107]
	 * 
	 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
	 * 
	 * For example:
	 * Given binary tree [3,7,9,15,20],
     * 		9
   	 * 	   / \
  	 *    3  15
     *     \   \
   	 *      7  20
	 * return its level order traversal as:
	 * [
  	 * 	[9],
  	 * 	[3,15],
  	 * 	[7,20]
	 * ]
	 * </pre>
	 */
	@Test
	public void test_leetcode_102() {
		System.out.println(">>>> test leetcode 102 starting...");
		int[] nums = new int[] {3,7,9,15,20};
		TreeNode root = sortedArrayToBST(nums);
		List<String> treePaths = binaryTreePaths(root);
		System.out.println("All tree paths: " + treePaths);
		List<List<Integer>> output = levelOrder(root);
		for (List<Integer> out : output) {
			System.out.println(out);
		}
		System.out.println("<<<< test leetcode 102 done");
	}
	
	private List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

		if (root == null)
			return wrapList;

		queue.offer(root);
		while (!queue.isEmpty()) {
			int levelNum = queue.size();
			List<Integer> subList = new LinkedList<Integer>();
			for (int i = 0; i < levelNum; i++) {
				if (queue.peek().left != null)
					queue.offer(queue.peek().left);
				if (queue.peek().right != null)
					queue.offer(queue.peek().right);
				subList.add(queue.poll().val);
			}
			wrapList.add(subList);
		}
		return wrapList;
	}

	/**
	 * <pre>
	 * 104. Maximum Depth of Binary Tree
	 * 
	 * Given a binary tree, find its maximum depth.
	 * 
	 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
	 * </pre>
	 */
	@Test
	public void test_leetcode_104() {
		int[] tree1Vals = new int[] {10, 20, 30, 70, 80, 90, 120, 140, 160, 200, 210, 220, 230, 240, 250, 260};
		TreeNode tree1Root = sortedArrayToBST(tree1Vals);
//		System.out.println(binaryTreePaths(tree1Root));
		int output1 = maxDepth(tree1Root);
		int expectedOutput1 = 5;
		assertThat(output1).isEqualTo(expectedOutput1);
	}
	
	private int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}
	
	/**
	 * <pre>
	 * 107. Binary Tree Level Order Traversal II
	 * 
	 * [Reference 102]
	 * 
	 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
	 * 
	 * For example:
	 * Given binary tree [3,9,20,null,null,15,7],
     * 		3
   	 * 	   / \
  	 *    9  20
     *       / \
   	 *      15  7
	 * return its bottom-up level order traversal as:
	 * [
  	 * 	[15,7],
  	 * 	[9,20],
  	 * 	[3]
	 * ]
	 * </pre>
	 */
	@Test
	public void test_leetcode_107() {
		System.out.println(">>>> test leetcode 107 starting...");
		int[] nums = new int[] {3,7,9,15,20};
		TreeNode root = sortedArrayToBST(nums);
		List<String> treePaths = binaryTreePaths(root);
		System.out.println("All tree paths: " + treePaths);
		List<List<Integer>> output = levelOrderBottom(root);
		for (List<Integer> out : output) {
			System.out.println(out);
		}
		System.out.println("<<<< test leetcode 107 done");
	}

	private List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        
        if(root == null) return wrapList;
        
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(0, subList);
        }
        return wrapList;
    }
	
	/**
	 * <pre>
	 * 108. Convert Sorted Array to Binary Search Tree
	 * 
	 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
	 * 
	 * reference: 257
	 * </pre>
	 */
	@Test
	public void test_leetcode_108() {
		int[] nums = new int[] { 1, 3, 4, 6, 7, 8, 9 };
		TreeNode root = sortedArrayToBST(nums);
		List<String> output = binaryTreePaths(root);
		List<String> expectedOutput = Arrays.asList("6->3->1", "6->3->4", "6->8->7", "6->8->9");
		assertThat(expectedOutput).containsAll(output);
	}

	private TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0) {
			return null;
		}
		TreeNode head = createTreeNode(nums, 0, nums.length - 1);
		return head;
	}

	private TreeNode createTreeNode(int[] num, int low, int high) {
		if (low > high) { // Done
			return null;
		}
		int mid = (low + high) >>> 1;
		TreeNode node = new TreeNode(num[mid]);
		node.left = createTreeNode(num, low, mid - 1);
		node.right = createTreeNode(num, mid + 1, high);
		return node;
	}
	
	/**
	 * <pre>
	 * 112. Path Sum
	 * 
	 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
	 * 
	 * For example:
	 * Given the below binary tree and sum = 22,
	 *               5
	 *              / \
	 *             4   8
	 *            /   / \
	 *           11  13  4
	 *          /  \      \
	 *         7    2      1
	 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
	 * </pre>
	 */
	@Test
	public void test_leetcode_112() {
		System.out.println(">>>> test leecode 112 starting...");
		int nums[] = new int[] {1,2,3,4,5,7,8,11,13};
		TreeNode root = sortedArrayToBST(nums);
		List<String> treePaths = binaryTreePaths(root);
		System.out.println(treePaths);
	    boolean output1 = hasPathSum(root, 37);
	    assertThat(output1).isTrue();
	    boolean output2 = hasPathSum(root, 14);
	    assertThat(output2).isTrue();
	    boolean output3 = hasPathSum(root, 13);
	    assertThat(output3).isFalse();
		System.out.println("<<<< test leecode 112 done");
	}
	
	private boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;

		if (root.left == null && root.right == null && sum - root.val == 0)
			return true;

		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
	
	/**
	 * <pre>
	 * 120. Triangle
	 * 
	 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
	 * 
	 * For example, given the following triangle
	 * [
     * 		[2],
     * 	   [3,4],
   	 * 	  [6,5,7],
  	 *   [4,1,8,3]
	 * ]
	 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
	 * </pre>
	 */
	@Test
	public void test_leetcode_120() {
		List<List<Integer>> triangle1 = new ArrayList<>();
		triangle1.add(Arrays.asList(2));
		triangle1.add(Arrays.asList(3,4));
		triangle1.add(Arrays.asList(6,5,7));
		triangle1.add(Arrays.asList(4,1,8,3));
		int expectedOutput1 = 11;
		int output1 = minimumTotal(triangle1);
		assertThat(output1).isEqualTo(expectedOutput1);
	}
	
    private int minimumTotal(List<List<Integer>> triangle) {
		int[] A = new int[triangle.size() + 1];
		for (int i = triangle.size() - 1; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				A[j] = Math.min(A[j], A[j + 1]) + triangle.get(i).get(j);
			}
		}
		return A[0];
    }
    
    /**
     * <pre>
     * 121. Best Time to Buy and Sell Stock
     * 
     * [IMPORTANT]
     * 
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * 
     * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
     * 
     * Example 1:
     * Input: [7, 1, 5, 3, 6, 4]
     * Output: 5
     * 
     * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
     * 
     * Example 2:
     * Input: [7, 6, 4, 3, 1]
     * Output: 0
     * 
     * In this case, no transaction is done, i.e. max profit = 0.
     * </pre>
     */
    @Test
    public void test_leetcode_121() {
    	int[] prices1 = new int[] { 7, 1, 5, 3, 6, 4 };
    	int output1 = maxProfit121(prices1);
    	int expectedOutput1 = 5;
    	assertThat(output1).isEqualTo(expectedOutput1);
    	
    	int[] prices2 = new int[] { 7, 6, 4, 3, 1 };
    	int output2 = maxProfit121(prices2);
    	int expectedOutput2 = 0;
    	assertThat(output2).isEqualTo(expectedOutput2);
    }
    
    private int maxProfit121(int[] prices) {
    	int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
	
	/**
	 * <pre>
	 * 122. Best Time to Buy and Sell Stock II
	 * 
	 * [IMPORTANT]
	 * 
	 * Say you have an array for which the ith element is the price of a given stock on day i.
	 * 
	 * Design an algorithm to find the maximum profit. 
	 * 
	 * You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). 
	 * 
	 * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
	 * </pre>
	 */
	@Test
	public void test_leetcode_122() {
		int[] prices1 = new int[] {10,20,80};
		int expectedOutput1 = 70;
		int output1 = maxProfit(prices1);
		assertThat(output1).isEqualTo(expectedOutput1);
		
		int[] prices2 = new int[] {30,20,90,120,100,200};
		int expectedOutput2 = 200;
		int output2 = maxProfit(prices2);
		assertThat(output2).isEqualTo(expectedOutput2);
	}
	
	private int maxProfit(int[] prices) {
		int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++) {
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) {
            	profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
	}
	
	/**
	 * <pre>
	 * Given a binary tree, find the maximum path sum.
	 * 
	 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
	 * 
	 * For example:
	 * Given the below binary tree,
	 * 
	 *    1
     * 	 / \
     *  2   3
     *  
	 * Return 6.
	 * </pre>
	 */
	@Test
	public void test_leetcode_124() {
		TreeNode root1 = new TreeNode(1);
		root1.addLeft(2);
		root1.addRight(3);
		int output1 = maxPathSum(root1);
		int expectedOutput1 = 6;
		assertThat(output1).isEqualTo(expectedOutput1);
		
		int[] nums = new int[] { 1, 3, 4, 6, 7, 8, 9 };
		TreeNode root2 = sortedArrayToBST(nums);
//		List<String> treePaths = binaryTreePaths(root2);
//		System.out.println(treePaths);
		int output2 = maxPathSum(root2);
		int expectedOutput2 = 30;
		assertThat(output2).isEqualTo(expectedOutput2);
	}
	
	private int maxPathSum(TreeNode root) {
		int[] max = new int[1];
		max[0] = Integer.MIN_VALUE;
		maxPathSum(max, root);
		return max[0];
	}

	private int maxPathSum(int[] max, TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftMax = Math.max(0, maxPathSum(max, root.left));
		int rightMax = Math.max(0, maxPathSum(max, root.right));
		max[0] = Math.max(max[0], root.val + leftMax + rightMax);
		return root.val + Math.max(leftMax, rightMax);
	}
	
	/**
	 * <pre>
	 * 142. Linked List Cycle II
	 * 
	 * [IMPORTANT]
	 * 
	 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
	 * 
	 * Note: Do not modify the linked list.
	 * 
	 */
	@Test
	@Ignore
	public void test_leetcode_142() {
//		ListNode cycleBeginNode = detectCycle(head);
	}
	
//	private ListNode detectCycle(ListNode head) {
//		ListNode slow = head;
//		ListNode fast = head;
//
//		while (fast != null && fast.next != null) {
//			fast = fast.next.next;
//			slow = slow.next;
//
//			if (fast == slow) {
//				ListNode slow2 = head;
//				while (slow2 != slow) {
//					slow = slow.next;
//					slow2 = slow2.next;
//				}
//				return slow;
//			}
//		}
//		return null;
//	}
	
	/**
	 * <pre>
	 * 160. Intersection of Two Linked Lists
	 * 
	 * Write a program to find the node at which the intersection of two singly linked lists begins.
	 * 
	 * 
	 * For example, the following two linked lists:
	 * 
	 * A:      a1 → a2
     *			                   ↘
     * 				    c1 → c2 → c3
     * 				       ↗            
	 * B: b1 → b2 → b3
	 * begin to intersect at node c1.
	 * 
	 * 
	 * Notes:
	 * 
	 * If the two linked lists have no intersection at all, return null.
	 * The linked lists must retain their original structure after the function returns.
	 * You may assume there are no cycles anywhere in the entire linked structure.
	 * Your code should preferably run in O(n) time and use only O(1) memory.
	 * </pre>
	 */
	@Test
	public void test_leetcode_160() {
		// TODO testing case
	}
	
	private ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;
        
        ListNode a = headA;
        ListNode b = headB;
        
        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
        	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;    
        }
        
        return a;
    }
	
	/**
	 * <pre>
	 * 167. Two Sum II - Input array is sorted
	 * 
	 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
	 * 
	 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
	 * 
	 * You may assume that each input would have exactly one solution and you may not use the same element twice.
	 * 
	 * Input: numbers={2, 7, 11, 15}, target=9
	 * Output: index1=1, index2=2
	 * </pre>
	 */
	@Test
	public void test_leetcode_167() {
		int[] numbers1 = new int[] {2, 7, 11, 15};
		int target1 = 9;
		int[] output1 = twoSum167(numbers1, target1);
		int[] expectedOutput1 = new int[] {1, 2};
		assertThat(output1).isEqualTo(expectedOutput1);
		
		int[] numbers2 = new int[] {2, 7, 9, 11, 15, 23};
		int target2 = 24;
		int[] output2 = twoSum167(numbers2, target2);
		int[] expectedOutput2 = new int[] {3, 5};
		assertThat(output2).isEqualTo(expectedOutput2);
	}
	
	private int[] twoSum167(int[] numbers, int target) {
		int[] indice = new int[2];
		if (numbers == null || numbers.length < 2)
			return indice;

		int left = 0, right = numbers.length - 1;
		while (left < right) {
			int v = numbers[left] + numbers[right];
			if (v == target) {
				indice[0] = left + 1;
				indice[1] = right + 1;
				break;
			} else if (v > target) {
				right--;
			} else {
				left++;
			}
		}
		return indice;
    }
	
	/**
	 * <pre>
	 * 172. Factorial Trailing Zeroes
	 * 
	 * Given an integer n, return the number of trailing zeroes in n!.
	 *
	 * Note: Your solution should be in logarithmic time complexity.
	 * 
	 * 詳解: https://skyyen999.gitbooks.io/-leetcode-with-javascript/content/questions/172md.html 
	 * </pre>
	 */
	@Test
	public void test_leetcode_172() {
		int input = 20;
		int expectedOutput = 4;

		int output = trailingZeroes(input);
		
		assertThat(output).isEqualTo(expectedOutput);
	}
	
	private int trailingZeroes(int n) {
		return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
	
	/**
	 * <pre>
	 * 173. Binary Search Tree Iterator
	 * 
	 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
	 * 
	 * Calling next() will return the next smallest number in the BST.
	 * 
	 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
	 * </pre>
	 */
	@Test
	@Ignore
	public void test_leetcode_173() {
//	public class BSTIterator {
//
//	    Stack<TreeNode> stack =  null ;            
//	    TreeNode current = null ;
//	    	
//	    public BSTIterator(TreeNode root) {
//	        current = root;	     
//	        stack = new Stack<> ();
//	    }
//	    
//	    /** @return whether we have a next smallest number */
//	    public boolean hasNext() {		  
//	        return !stack.isEmpty() || current != null;  
//	    }
//
//	    /** @return the next smallest number */
//	    public int next() {
//	        while (current != null) {
//	            stack.push(current);
//	            current = current.left ;
//	        }		
//	        TreeNode t = stack.pop() ;		
//	        current = t.right ;		
//	        return t.val ;
//	    }
//	}
	}
	
	/**
	 * <pre>
	 * 176. Second Highest Salary
	 * 
	 * Write a SQL query to get the second highest salary from the Employee table.
	 * 
	 * +----+--------+
	 * | Id | Salary |
	 * +----+--------+
	 * | 1  | 100    |
	 * | 2  | 200    |
	 * | 3  | 300    |
	 * +----+--------+
	 * For example, given the above Employee table, the second highest salary is 200. If there is no second highest salary, then the query should return null.
	 * </pre>
	 */
	@Test
	public void test_leetcode_176() {
		/**
		 * SELECT max(Salary) AS SecondHighestSalary
		 * FROM Employee
		 * WHERE Salary < (SELECT max(Salary) FROM Employee)
		 */
	}
	
	/**
	 * <pre>
	 * 179. Largest Number
	 * 
	 * Given a list of non negative integers, arrange them such that they form the largest number.
	 * 
	 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
	 * 
	 * Note: The result may be very large, so you need to return a string instead of an integer.
	 * </pre>
	 */
	@Test
	public void test_leetcode_179() {
		int[] num1 = new int[] {3, 30, 34, 5, 9};
		String output1 = largestNumber(num1);
		String expectedOutput1 = "9534330";
		assertThat(output1).isEqualTo(expectedOutput1);
	}
	
    private String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0)
			return "";

		// Convert int array to String array, so we can sort later on
		String[] s_num = new String[nums.length];
		for (int i = 0; i < nums.length; i++)
			s_num[i] = String.valueOf(nums[i]);

		// Comparator to decide which string should come first in concatenation
		Comparator<String> comp = new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				String s1 = str1 + str2;
				String s2 = str2 + str1;
				return s2.compareTo(s1); // reverse order here, so we can do append() later
			}
		};

		Arrays.sort(s_num, comp);

		// An extreme edge case by lc, say you have only a bunch of 0 in your int array
		if (s_num[0].charAt(0) == '0')
			return "0";

		StringBuilder sb = new StringBuilder();
		for (String s : s_num)
			sb.append(s);

		return sb.toString();
    }
	
	/**
	 * <pre>
	 * Write a SQL query to find all numbers that appear at least three times consecutively.
	 * 
	 * +----+-----+
	 * | Id | Num |
	 * +----+-----+
	 * | 1  |  1  |
	 * | 2  |  1  |
	 * | 3  |  1  |
	 * | 4  |  2  |
	 * | 5  |  1  |
	 * | 6  |  2  |
	 * | 7  |  2  |
	 * +----+-----+
	 * For example, given the above Logs table, 1 is the only number that appears consecutively for at least three times.
	 * </pre>
	 */
	@Test
	@Ignore
	public void test_leetcode_180() {
		@SuppressWarnings("unused")
		String result = 
			"Select DISTINCT l1.Num ConsecutiveNums from Logs l1, Logs l2, Logs l3" +  
			"where l1.Id=l2.Id-1 and l2.Id=l3.Id-1" +
			"and l1.Num=l2.Num and l2.Num=l3.Num";
	}
	
	/**
	 * <pre>
	 * 188. Best Time to Buy and Sell Stock IV
	 * 
	 * [IMPORTANT]
	 * 
	 * Say you have an array for which the ith element is the price of a given stock on day i.
	 * 
	 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
	 * 
	 * Note:
	 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
	 * 
	 * Note:
	 * buy and sell belong to one transaction.
	 * 
	 * Note:
	 * 給予所有股票價格, 算出 k 次交易可得最大獲利, 一次交易 = 買了後賣, 不可同時擁有多張 
	 * 
	 * </pre>
	 */
	@Test
	public void test_leetcode_188() {
		int k = 2;
		int[] prices = new int[] {10,20,80};
		int expectedOutput = 70;
		int output = maxProfit(k, prices);
		assertThat(output).isEqualTo(expectedOutput);

		int k2 = 3;
		int[] prices2 = new int[] {150,150,300,550,200,600,800};
		int expectedOutput2 = 1000;
		int output2 = maxProfit(k2, prices2);
		assertThat(output2).isEqualTo(expectedOutput2);
		
		int k3 = 3;
		int[] prices3 = new int[] {150,150,300,550,200,600,800,1200};
		int output3 = maxProfit(k3, prices3);
		int expectedOutput3 = 1400;
		assertThat(output3).isEqualTo(expectedOutput3);
		
		int k4 = 3;
		int[] prices4 = new int[] {150,150,300,550,200,600,800,1200};
		int expectedOutput4 = 1400;
		int output4 = maxProfitUnderstood(k4, prices4);
		assertThat(output4).isEqualTo(expectedOutput4);
		
		int k5 = 2;
		int[] prices5 = new int[] {10,30,120,100,90,190};
		int expectedOutput5 = 210;
		int output5 = maxProfitUnderstood(k5, prices5);
		assertThat(output5).isEqualTo(expectedOutput5);
	}
	
	private int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) {
        	return quickSolve(prices);
        }
        
        int[][] t = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int tmpMax = -prices[0];
            for (int j = 1; j < len; j++) {
                t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
                tmpMax =  Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
            }
        }
        return t[k][len - 1];
    }
    
	private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++) {
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) {
            	profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
	
	private int maxProfitUnderstood(int k, int[] prices) {
		// means you can't do any transactions
		if (k < 1) {
			return 0;
		}

		// if there is only one price data point you can't make any transaction 
		if (prices == null || prices.length <= 1) {
			return 0;
		}

		// if k >= prices.length / 2, then you can make maximum number of transactions
		if (k >= prices.length / 2) {
			int profit = 0;
			for (int i = 1; i < prices.length; i++) {
				if (prices[i] > prices[i - 1]) {
					profit += prices[i] - prices[i - 1];
				}
			}
			return profit;
		}

		// DP for at most k trades
		int[] buy = new int[k + 1];
		int[] sell = new int[k + 1];

		for (int i = 0; i <= k; i++) {
			buy[i] = Integer.MIN_VALUE;
			sell[i] = 0;
		}

		for (int i = 0; i < prices.length; i++) {
			for (int j = k; j > 0; j--) {
				sell[j] = Math.max(sell[j], prices[i] + buy[j]);
				buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
			}
		}

		return sell[k];
	}
	
	/**
	 * <pre>
	 * Write a SQL query to delete all duplicate email entries in a table named Person, keeping only unique emails based on its smallest Id.
	 * 
	 * +----+------------------+
	 * | Id | Email            |
	 * +----+------------------+
	 * | 1  | john@example.com |
	 * | 2  | bob@example.com  |
	 * | 3  | john@example.com |
	 * +----+------------------+
	 * Id is the primary key column for this table.
	 * For example, after running your query, the above Person table should have the following rows:
	 * 
	 * +----+------------------+
	 * | Id | Email            |
	 * +----+------------------+
	 * | 1  | john@example.com |
	 * | 2  | bob@example.com  |
	 * +----+------------------+
	 * </pre>
	 */
	@Test
	@Ignore
	public void test_leetcode_196() {
		@SuppressWarnings("unused")
		String result = "DELETE p1 FROM Person p1, Person p2 WHERE p1.Email = p2.Email AND p1.Id > p2.Id";
	}
	
	/**
	 * <pre>
	 * 205. Isomorphic Strings
	 * 
	 * Given two strings s and t, determine if they are isomorphic.
	 * 
	 * Two strings are isomorphic if the characters in s can be replaced to get t.
	 * 
	 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
	 * 
	 * For example,
	 * Given "egg", "add", return true.
	 * 
	 * Given "foo", "bar", return false.
	 * 
	 * Given "paper", "title", return true.
	 * </pre>
	 */
	@Test
	public void test_leetcode_205() {
		String s1 = "egg", t1 = "add";
		boolean output1 = isIsomorphic(s1, t1);
		boolean expectedOutput1 = true;
		assertThat(output1).isEqualTo(expectedOutput1);
	}
	
	private boolean isIsomorphic(String s, String t) {
		Map<Character, Character> s2t = new HashMap<>(), t2s = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (s2t.getOrDefault(s.charAt(i), t.charAt(i)) != t.charAt(i) || 
				t2s.getOrDefault(t.charAt(i), s.charAt(i)) != s.charAt(i)) {
				return false;
			}
			s2t.put(s.charAt(i), t.charAt(i));
			t2s.put(t.charAt(i), s.charAt(i));
		}
		return true;
	}
	
	/**
	 * <pre>
	 * 214. Shortest Palindrome
	 * 
	 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.
	 * 
	 * For example:
	 * 
	 * Given "aacecaaa", return "aaacecaaa".
	 * 
	 * Given "abcd", return "dcbabcd".
	 * </pre>
	 */
	@Test
	public void test_leetcode_214() {
		String input1 = "aacecaaa";
		String expectedOutput1 = "aaacecaaa";
		String output1 = shortestPalindrome(input1);
		assertThat(output1).isEqualTo(expectedOutput1);
		
		String input2 = "abcd";
		String expectedOutput2 = "dcbabcd";
		String output2 = shortestPalindrome(input2);
		assertThat(output2).isEqualTo(expectedOutput2);
	}
	
	private String shortestPalindrome(String s) {
		int j = 0;
	    for (int i = s.length() - 1; i >= 0; i--) {
	        if (s.charAt(i) == s.charAt(j)) {
	        	j += 1;
	        }
	    }
	    if (j == s.length()) {
	    	return s;
	    }
	    String suffix = s.substring(j);
	    return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
    }

	/**
	 * <pre>
	 * 215. Kth Largest Element in an Array
	 * 
	 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
	 * 
	 * For example,
	 * Given [3,2,1,5,6,4] and k = 2, return 5.
	 * </pre>
	 */
	@Test
	public void test_leetcode_215() {
		int[] nums1 = new int[] {3,2,1,5,6,4};
		int kth1 = 2;
		int expectedOutput1 = 5;
		
		int output1 = findKthLargest(nums1, kth1);
		
		assertThat(output1).isEqualTo(expectedOutput1);
	}
	
	private int findKthLargest(int[] nums, int k) {
		int allNumbersLength = nums.length;
        Arrays.sort(nums);
        return nums[allNumbersLength - k];
	}
	
	/**
	 * <pre>
	 * 217. Contains Duplicate
	 * 
	 * Given an array of integers, find if the array contains any duplicates. 
	 * 
	 * Your function should return true if any value appears at least twice in the array, 
	 * 
	 * and it should return false if every element is distinct.
	 * </pre>
	 */
	@Test
	public void test_leetcode_217() {
		int[] nums1 = new int[] {1,2,3,4,5,5,5};
		boolean expectedOutput1 = true;
		boolean output1 = containsDuplicate(nums1);
		assertThat(output1).isEqualTo(expectedOutput1);
	}
	
	private boolean containsDuplicate(int[] nums) {
		Set<Integer> distinctNums = new HashSet<>();
		for (int num : nums) {
			if (distinctNums.contains(num)) {
				return true;
			}
			distinctNums.add(num);
		}
		return false;
	}
	
	/**
	 * <pre>
	 * 228. Summary Ranges
	 * 
	 * Given a sorted integer array without duplicates, return the summary of its ranges.
	 * 
	 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
	 * </pre>
	 */
	@Test
	public void test_leetcode_228() {
		int[] nums1 = new int[] {0,1,2,4,5,7};
		List<String> output1 = summaryRanges(nums1);
		List<String> expectedOutput1 = Arrays.asList("0->2", "4->5", "7");
		assertThat(output1).containsExactlyElementsOf(expectedOutput1);
		
		int[] nums2 = new int[] {0,2,4,5,6,8,9,10};
		List<String> output2 = summaryRanges(nums2);
		List<String> expectedOutput2 = Arrays.asList("0", "2", "4->6", "8->10");
		assertThat(output2).containsExactlyElementsOf(expectedOutput2);
	}
	
	private List<String> summaryRanges(int[] nums) {
		List<String> list = new ArrayList<>();
		if (nums.length == 1) {
			list.add(nums[0] + "");
			return list;
		}
		for (int i = 0; i < nums.length; i++) {
			int a = nums[i];
			while (i + 1 < nums.length && (nums[i + 1] - nums[i]) == 1) {
				i++;
			}
			if (a != nums[i]) {
				list.add(a + "->" + nums[i]);
			} else {
				list.add(a + "");
			}
		}
		return list;
	}
	
	/**
	 * <pre>
	 * 230. Kth Smallest Element in a BST
	 * 
	 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
	 * 
	 * Note: 
	 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
	 * </pre>
	 */
	@Test
	public void test_leetcode_230() {
		int[] nums1 = new int[] {1,4,7,9,12,20};
		TreeNode root1 = sortedArrayToBST(nums1);
		int k1 = 3;
		int output1 = kthSmallest(root1, k1);
		int expectedOutput1 = 7;
		assertThat(output1).isEqualTo(expectedOutput1);
		
		int k2 = 5;
		int output2 = kthSmallest(root1, k2);
		int expectedOutput2 = 12;
		assertThat(output2).isEqualTo(expectedOutput2);
	}
	
	private int kthSmallest(TreeNode root, int k) {
		int count = countNodes(root.left);
		if (k <= count) {
			return kthSmallest(root.left, k);
		} else if (k > count + 1) {
			return kthSmallest(root.right, k - 1 - count); // 1 is counted as current node
		}
		return root.val;
	}

	private int countNodes(TreeNode n) {
		if (n == null)
			return 0;

		return 1 + countNodes(n.left) + countNodes(n.right);
	}
	
	/**
	 * <pre>
	 * 232. Implement Queue using Stacks
	 * 
	 * Implement the following operations of a queue using stacks.
	 * 
	 * push(x) -- Push element x to the back of queue.
	 * pop() -- Removes the element from in front of queue.
	 * peek() -- Get the front element.
	 * empty() -- Return whether the queue is empty.
	 * Notes:
	 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
	 * </pre>
	 */
	@Test
	public void test_leetcode_232() {
		MyQueue obj = new MyQueue();
		obj.push(1);
//		System.out.println(">>> test_leetcode_232 --> Push 1 done");
		obj.push(2);
//		System.out.println(">>> test_leetcode_232 --> Push 2 done");
		int param_2 = obj.pop();
		assertThat(param_2).isEqualTo(1);
//		System.out.println(">>> test_leetcode_232 --> Pop done, get " + param_2);
		int param_3 = obj.peek();
		assertThat(param_3).isEqualTo(2);
//		System.out.println(">>> test_leetcode_232 --> Peek result: " + param_3);
		int param_4 = obj.pop();
		assertThat(param_4).isEqualTo(2);
//		System.out.println(">>> test_leetcode_232 --> Pop done, get " + param_4);
		boolean param_5 = obj.empty();
		assertThat(param_5).isTrue();
	}
	
	private class MyQueue {

	    Stack<Integer> input = new Stack<Integer>();
	    Stack<Integer> output = new Stack<Integer>();
	    
	    public void push(int x) {
	        input.push(x);
	    }

	    public Integer pop() {
	        peek();
	        return output.pop();
	    }

	    public int peek() {
	        if (output.empty())
	            while (!input.empty())
	                output.push(input.pop());
	        return output.peek();
	    }

	    public boolean empty() {
	        return input.empty() && output.empty();
	    }
	}
	
	/**
	 * <pre>
	 * 234. Palindrome Linked List
	 * 
	 * Given a singly linked list, determine if it is a palindrome.
	 * </pre>
	 */
	@Test
	public void test_leetcode_234() {
		System.out.println(">>>> test_leetcode_234 starting...");
		ListNode head = new ListNode(1);
		head.addLast(2);
		head.addLast(3);
		head.addLast(2);
		head.addLast(1);
		boolean output1 = isPalindrome(head);
		boolean expectedOutput1 = true;
		assertThat(output1).isEqualTo(expectedOutput1);
		System.out.println("<<<< test_leetcode_234 starting done");
	}
	
	/**
	 * <a href="https://discuss.leetcode.com/topic/33376/java-easy-to-understand">java easy to understand</a> 
	 */
    private boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        
        System.out.println("Set Fast as head: " + fast);
        System.out.println("Set Slow as head: " + slow);
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            System.out.println("Set Fast as next next: " + fast);
            slow = slow.next;
            System.out.println("Set Slow as next: " + slow);
        }
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
            System.out.println("Set Slow as next: " + slow);
        }
        slow = reverse(slow);
        System.out.println("Reverse Slow: " + slow);
        
        fast = head;
        System.out.println("Set Fast as head: " + fast);
        
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            System.out.println("Set Fast as next: " + slow);
            
            slow = slow.next;
            System.out.println("Set Slow as next: " + slow);
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
	
	/**
	 * <pre>
	 * 237. Delete Node in a Linked List
	 * 
	 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
	 * 
	 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, 
	 * 
	 * the linked list should become 1 -> 2 -> 4 after calling your function.
	 * 
	 * <a href="http://codereview.stackexchange.com/questions/82698/singly-linked-list-in-java">singly-linked-list-in-java</a>
	 * </pre>
	 */
	@Test
	public void test_leetcode_237() {
		// The answer is
		/**
		 * private void deleteNode(ListNode node) {
		 *     	node.val = node.next.val;
         * 		node.next = node.next.next;
    	 * }
		 */
	}
	
	@Test
	@Ignore
	public void test_my_linkedlist() {
		ListNode root = new ListNode(1);
		System.out.println(root);
		root.addLast(2);
		System.out.println(root);
		root.addLast(3);
		System.out.println(root);
		root.addLast(1);
		System.out.println(root);
		root.addLast(2);
		System.out.println(root);
		root.addLast(3);
		System.out.println(root);
		root.removeLast();
		System.out.println(root);
		root.removeLast();
		System.out.println(root);
		root.removeLast();
		System.out.println(root);
		root.removeLast();
		System.out.println(root);
		root.removeLast();
		System.out.println(root);
	}
	
	private class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
		
		public void addLast(int x) {
			ListNode current = this;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new ListNode(x);
		}
		
		public void removeLast() {
			ListNode previous = null;
			ListNode current = this;
			while (current.next != null) {
				previous = current;
				current = current.next;
			}
			previous.next = null;
		}
		
		@Override
		public String toString() {
			ListNode current = this;
			
			String result = String.valueOf(current.val);
            while (current.next != null) {
                current = current.next;
                result += " -> " + current.val;
            }
            return result;
		}
	}
	
	/**
	 * <pre>
	 * 257. Binary Tree Paths
	 * 
	 * Given a binary tree, return all root-to-leaf paths.
	 * 
	 * For example, given the following binary tree:
	 * 
   	 *    1
 	 *  /   \
	 * 2     3
 	 *  \
  	 *   5
	 * All root-to-leaf paths are:
	 * 
	 * ["1->2->5", "1->3"]
	 * </pre>
	 */
	@Test
	public void test_leetcode_257() {
		TreeNode root = new TreeNode(1);
		root.addLeft(2);
		root.addRight(3);
		
		root.getLeftNode().addLeft(4);
		root.getLeftNode().addRight(5);
		
		List<String> output = binaryTreePaths(root);
		
		List<String> expectedOutput = Arrays.asList("1->2->4", "1->2->5", "1->3");
		
		assertThat(expectedOutput).containsExactlyElementsOf(output);
	}
		
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int x) {
			val = x;
		}
		
		public void addLeft(int val) {
			left = new TreeNode(val);
		}
		
		public void addRight(int val) {
			right = new TreeNode(val);
		}
		
		public TreeNode getLeftNode() {
			return left;
		}
		
		public TreeNode getRightNode() {
			return right;
		}
	}
	
	private List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<String>();
        if (root != null) searchBT(root, "", answer);
        return answer;
    }
	
    private void searchBT(TreeNode node, String path, List<String> answer) {
        if (node.left == null && node.right == null) answer.add(path + node.val);
        if (node.left != null) searchBT(node.left, path + node.val + "->", answer);
        if (node.right != null) searchBT(node.right, path + node.val + "->", answer);
    }
    
    /**
     * <pre>
     * 258. Add Digits
     * 
     * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
     * 
     * For example:
     * 
     * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.</pre>
     * 
     * <a href="https://discuss.leetcode.com/topic/21588/1-line-java-solution/8">Java Solution</a>
     */
    @Test
    public void test_leecode_258() {
    	int num1 = 38;
    	int output1 = addDigits(num1);
    	int expectedOutput1 = 2;
    	assertThat(output1).isEqualTo(expectedOutput1);
    }
    
    private int addDigits(int num) {
		return num == 0 ? 0 : (num % 9 == 0 ? 9 : (num % 9));
    }
    
    /**
     * <pre>
     * 268. Missing Number
     * 
     * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
     * 
     * For example,
     * Given nums = [0, 1, 3] return 2.
     * </pre>
     */
    @Test
    public void test_leetcode_268() {
    	int[] nums1 = new int[] {1, 0};
    	int output1 = myMissingNumber(nums1);
    	int expectedOutput1 = 2;
    	assertThat(output1).isEqualTo(expectedOutput1);
    	
    	int[] nums2 = new int[] {1, 0};
    	int output2 = betterMissingNumber(nums2);
    	int expectedOutput2 = 2;
    	assertThat(output2).isEqualTo(expectedOutput2);
    }
    
    private int myMissingNumber(int[] nums) {
    	Arrays.sort(nums);
    	
        if (nums[0] != 0) {
            return 0;
        }
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i] - 1) {
                return nums[i] - 1;
            }
        }
        return nums[nums.length - 1] + 1;
    }
    
    /**
     * Pretty simple since we are told that we are missing only one number in [1,n], 
     * 
     * we just need to look at the difference between the sum([1,n]) = n * (n+1) / 2 and the sum of nums in our array.
     */
	private int betterMissingNumber(int[] nums) {
		int sum = 0;
		for (int num : nums)
			sum += num;

		return (nums.length * (nums.length + 1)) / 2 - sum;
	}
    
    /**
     * <pre>
     * 273. Integer to English Words
     * 
     * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
     * 
     * For example,
     * 123 -> "One Hundred Twenty Three"
     * 12345 -> "Twelve Thousand Three Hundred Forty Five"
     * 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
     * </pre>
     */
    @Test
    public void test_leetcode_273() {
    	int num1 = 123;
    	String output1 = numberToWords(num1);
    	String expectedOutput1 = "One Hundred Twenty Three";
    	assertThat(output1).isEqualTo(expectedOutput1);
    	
    	int num2 = 12345;
    	String output2 = numberToWords(num2);
    	String expectedOutput2 = "Twelve Thousand Three Hundred Forty Five";
    	assertThat(output2).isEqualTo(expectedOutput2);
    	
    	int num3 = 1234567;
    	String output3 = numberToWords(num3);
    	String expectedOutput3 = "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven";
    	assertThat(output3).isEqualTo(expectedOutput3);
    }
    
	private String numberToWords(int num) {
		if (num == 0)
			return "Zero";

		String[] lessThan20Words 
			= { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
		String[] tyWords 
			= { "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
		String[] dexWords 
			= { "Billion", "Million", "Thousand", "Hundred" };
		int[] radix = { 1000000000, 1000000, 1000, 100 };

		StringBuffer sb = new StringBuffer();

		int count = 0;
		for (int i = 0; i < radix.length; ++i) {
			count = num / radix[i];
			if (count == 0)
				continue;
			sb.append(numberToWords(count) + " ");
			sb.append(dexWords[i] + " ");
			num %= radix[i];
		}

		if (num < 20) {
			sb.append(lessThan20Words[num]);
		} else {
			sb.append(tyWords[num / 10 - 2] + " ");
			sb.append(lessThan20Words[num % 10]);
		}
		return sb.toString().trim();
	}
	
	/**
	 * <pre>
	 * 295. Find Median from Data Stream
	 * 
	 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
	 * 
	 * Examples: 
	 * [2,3,4] , the median is 3
	 * 
	 * [2,3], the median is (2 + 3) / 2 = 2.5
	 * 
	 * Design a data structure that supports the following two operations:
	 * 
	 * void addNum(int num) - Add a integer number from the data stream to the data structure.
	 * double findMedian() - Return the median of all elements so far.
	 * For example:
	 * 
	 * addNum(1)
	 * addNum(2)
	 * findMedian() -> 1.5
	 * addNum(3) 
	 * findMedian() -> 2
	 * </pre>
	 */
	@Test
	public void test_leetcode_295() {
		MedianFinder obj = new MedianFinder();

		obj.addNum(1);
		obj.addNum(2);

		double output1 = obj.findMedian();
		double expectedOutuput1 = 1.5;
		assertThat(output1).isEqualTo(expectedOutuput1);
		
		obj.addNum(3);
		
		double output2 = obj.findMedian();
		double expectedOutuput2 = 2;
		assertThat(output2).isEqualTo(expectedOutuput2);
	}
	
	private class MedianFinder {
	    // max queue is always larger or equal to min queue
	    PriorityQueue<Integer> min = new PriorityQueue<Integer>();
	    PriorityQueue<Integer> max = new PriorityQueue<Integer>(1000, Collections.reverseOrder());

	    // Adds a number into the data structure.
	    public void addNum(int num) {
	        max.offer(num);
	        min.offer(max.poll());
	        if (max.size() < min.size()){
	            max.offer(min.poll());
	        }
	    }

	    // Returns the median of current data stream
	    public double findMedian() {
	        if (max.size() == min.size()) {
	        	return (max.peek() + min.peek()) /  2.0;
	        }
	        else {
	        	return max.peek();
	        }
	    }
	}
	
	/**
	 * <pre>
	 * 299. Bulls and Cows
	 * 
	 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.
	 * 
	 * For example:
	 * 
	 * Secret number:  "1807"
	 * Friend's guess: "7810"
	 * Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
	 * 
	 * Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. In the above example, your function should return "1A3B".
	 * 
	 * Please note that both secret number and friend's guess may contain duplicate digits, for example:
	 * 
	 * Secret number:  "1123"
	 * Friend's guess: "0111"
	 * In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
	 * 
	 * You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
	 * </pre>
	 */
	@Test
	public void test_leetcode_299() {
		String secret1 = "1807";
		String guess1 = "7810";
		String output1 = getHint(secret1, guess1);
		String expectedOutput1 = "1A3B";
		assertThat(output1).isEqualTo(expectedOutput1);
		
		String secret2 = "1123";
		String guess2 = "0111";
		String output2 = getHint(secret2, guess2);
		String expectedOutput2 = "1A1B";
		assertThat(output2).isEqualTo(expectedOutput2);
	}
	
	private String getHint(String secret, String guess) {
		int bulls = 0;
	    int cows = 0;
	    int[] numbers = new int[10];
	    for (int i = 0; i<secret.length(); i++) {
	        int s = Character.getNumericValue(secret.charAt(i));
	        int g = Character.getNumericValue(guess.charAt(i));
	        if (s == g) {
	        	bulls++;
	        }
	        else {
	            if (numbers[s] < 0) {
	            	cows++;
	            }
	            if (numbers[g] > 0) {
	            	cows++;
	            }
	            numbers[s]++;
	            numbers[g]--;
	        }
	    }
	    return bulls + "A" + cows + "B";
    }
	
	/**
	 * <pre>
	 * 300. Longest Increasing Subsequence
	 * 
	 * Given an unsorted array of integers, find the length of longest increasing subsequence.
	 * 
	 * For example,
	 * Given [10, 9, 2, 5, 3, 7, 101, 18],
	 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.
	 * 
	 * Your algorithm should run in O(n2) complexity.
	 * </pre>
	 */
	@Test
	public void test_leetcode_300() {
		int[] nums1 = new int[] {10, 9, 2, 5, 3, 7, 101, 18};
		int output1 = lengthOfLIS(nums1);
		int expectedOutput1 = 4;
		assertThat(output1).isEqualTo(expectedOutput1);
		
		int[] nums2 = new int[] {10, 9, 2, 5, 6, 3, 7, 101, 18};
		int output2 = lengthOfLIS(nums2);
		int expectedOutput2 = 5;
		assertThat(output2).isEqualTo(expectedOutput2);
	}
	
	private int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		int len = 0;

		for (int num : nums) {
			int index = Arrays.binarySearch(dp, 0, len, num);
			if (index < 0) {
				index = -(index + 1);
			}
			
			dp[index] = num;
			
			if (index == len) {
				len++;
			}
		}
		return len;
	}
	
	/**
	 * <pre>
	 * 303. Range Sum Query - Immutable
	 * 
	 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
	 * 
	 * Example:
	 * Given nums = [-2, 0, 3, -5, 2, -1]
	 * 
	 * sumRange(0, 2) -> 1
	 * sumRange(2, 5) -> -1
	 * sumRange(0, 5) -> -3
	 * </pre>
	 */
	@Test
	public void test_leetcode_303() {
		int[] nums = new int[] {-2, 0, 3, -5, 2, -1};

		MyNumArray obj = new MyNumArray(nums);

		int param_1 = obj.sumRange(0, 2);
		assertThat(param_1).isEqualTo(1);
		
		int param_2 = obj.sumRange(2, 5);
		assertThat(param_2).isEqualTo(-1);
		
		int param_3 = obj.sumRange(0, 5);
		assertThat(param_3).isEqualTo(-3);
		
		BetterNumArray better = new BetterNumArray(nums);
		
		int param_4 = better.sumRange(0, 2);
		assertThat(param_4).isEqualTo(1);
		
		int param_5 = better.sumRange(2, 5);
		assertThat(param_5).isEqualTo(-1);
		
		int param_6 = better.sumRange(0, 5);
		assertThat(param_6).isEqualTo(-3);
	}
	
	private class MyNumArray {
		
		private int[] nums;

		public MyNumArray(int[] nums) {
			this.nums = nums;
		}

		public int sumRange(int i, int j) {
			int sum = 0;
			for (int index = i; index <= j; index++) {
				sum += nums[index];
			}
			return sum;
		}
	}
	
	private class BetterNumArray {
		int[] nums;

		public BetterNumArray(int[] nums) {
		    for (int i = 1; i < nums.length; i++)
		        nums[i] += nums[i - 1];
		    
		    this.nums = nums;
		}

		public int sumRange(int i, int j) {
			if (i == 0)
		        return nums[j];
		    
		    return nums[j] - nums[i - 1];
		}
	}
	
	/**
	 * <pre>
	 * 328. Odd Even Linked List
	 * 
	 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
	 * 
	 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
	 * 
	 * Example:
	 * Given 1->2->3->4->5->NULL,
	 * return 1->3->5->2->4->NULL.
	 * 
	 * </pre>
	 */
	@Test
	public void test_leetcode_328() {
		ListNode head1 = new ListNode(1);
		head1.addLast(2);
		head1.addLast(3);
		head1.addLast(4);
		head1.addLast(5);
		ListNode output1 = oddEvenList(head1);
		assertThat("1 -> 3 -> 5 -> 2 -> 4").isEqualTo(output1.toString());
		
		ListNode head2 = new ListNode(9);
		head2.addLast(10);
		head2.addLast(11);
		head2.addLast(12);
		head2.addLast(13);
		head2.addLast(14);
		ListNode output2 = oddEvenList(head2);
		assertThat("9 -> 11 -> 13 -> 10 -> 12 -> 14").isEqualTo(output2.toString());
	}
	
	private ListNode oddEvenList(ListNode head) {
        if (head != null) {
            ListNode odd = head, even = head.next, evenHead = even; 
    
            while (even != null && even.next != null) {
                odd.next = odd.next.next; 
                even.next = even.next.next; 
                odd = odd.next;
                even = even.next;
            }
            odd.next = evenHead; 
        }
        return head;
    }
	
	/**
	 * <pre>
	 * 344. Reverse String
	 * 
	 * Write a function that takes a string as input and returns the string reversed.
	 * 
	 * Example:
	 * Given s = "hello", return "olleh".
	 * </pre>
	 */
	@Test
	public void test_leetcode_344() {
		String s1 = "hello";
		String output1 = reverseString(s1);
		String expectedOutput1 = "olleh";
		assertThat(output1).isEqualTo(expectedOutput1);
		
		String output2 = betterReverseString(s1);
		assertThat(output2).isEqualTo(expectedOutput1);
	}
	
    private String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }
    
    private String betterReverseString(String s) {
        byte[] bytes = s.getBytes();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            byte temp = bytes[i];
            bytes[i] = bytes[j];
            bytes[j] = temp;
            i++;
            j--;
        }
        return new String(bytes);
    }
    
    /**
	 * <pre>
	 * 355. Design Twitter
	 * 
	 * Design a simplified version of Twitter where users can post tweets, 
	 * 
	 * follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. 
	 * 
	 * Your design should support the following methods:
	 * 
	 * postTweet(userId, tweetId): Compose a new tweet.
	 * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
	 * follow(followerId, followeeId): Follower follows a followee.
	 * unfollow(followerId, followeeId): Follower unfollows a followee.
	 * 
	 * Example:
	 * 
	 * Twitter twitter = new Twitter();
	 * 
	 * // User 1 posts a new tweet (id = 5).
	 * twitter.postTweet(1, 5);
	 * 
	 * // User 1's news feed should return a list with 1 tweet id -> [5].
	 * twitter.getNewsFeed(1);
	 * 
	 * // User 1 follows user 2.
	 * twitter.follow(1, 2);
	 * 
	 * // User 2 posts a new tweet (id = 6).
	 * twitter.postTweet(2, 6);
	 * 
	 * // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
	 * // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
	 * twitter.getNewsFeed(1);
	 * 
	 * // User 1 unfollows user 2.
	 * twitter.unfollow(1, 2);
	 * 
	 * // User 1's news feed should return a list with 1 tweet id -> [5],
	 * // since user 1 is no longer following user 2.
	 * twitter.getNewsFeed(1);
	 * </pre>
	 */
	@Test
	public void test_leetcode_355() {
		Twitter twitter = new Twitter(); // null
		twitter.postTweet(1, 5); // null
		List<Integer> news1 = twitter.getNewsFeed(1); // 5
		List<Integer> expectedNews1 = Arrays.asList(5);
		twitter.follow(1, 2); // null
		twitter.postTweet(2, 6); // null
		List<Integer> news2 = twitter.getNewsFeed(1); // 6,5
		List<Integer> expectedNews2 = Arrays.asList(6,5);
		twitter.unfollow(1, 2); // null
		twitter.getNewsFeed(1); // 5
		
		assertThat(news1).isEqualTo(expectedNews1);
		assertThat(news2).isEqualTo(expectedNews2);
	}
	
	private class Twitter {

		private int timeStamp = 0;
	    
	    // easy to find if user exist
	    private Map<Integer, User> userMap;
	    
	    // Tweet link to next Tweet so that we can save a lot of time
	    // when we execute getNewsFeed(userId)
	    private class Tweet {
	        public int id;
	        public int time;
	        public Tweet next;
	        
	        public Tweet(int id) {
	            this.id = id;
	            time = timeStamp++;
	            next = null;
	        }
	    }
	    
	    // OO design so User can follow, unfollow and post itself
	    public class User {
	        @SuppressWarnings("unused")
			public int id;
	        public Set<Integer> followed;
	        public Tweet tweet_head;
	        
	        public User(int id){
				this.id = id;
	            followed = new HashSet<>();
	            follow(id); // first follow itself
	            tweet_head = null;
	        }
	        
	        public void follow(int id) {
	            followed.add(id);
	        }
	        
	        public void unfollow(int id) {
	            followed.remove(id);
	        }
	        
	        // everytime user post a new tweet, add it to the head of tweet list.
	        public void post(int id) {
				Tweet t = new Tweet(id);
				t.next = tweet_head;
				tweet_head = t;
	        }
	    }
	    
	    /** Initialize your data structure here. */
	    public Twitter() {
	        userMap = new HashMap<Integer, User>();
	    }
	    
	    /** Compose a new tweet. */
	    public void postTweet(int userId, int tweetId) {
			if (!userMap.containsKey(userId)) {
				User u = new User(userId);
				userMap.put(userId, u);
			}
			userMap.get(userId).post(tweetId);
		}
	    
	    /*
	     * Best part of this.
	     * first get all tweets lists from one user including itself and all people it followed.
	     * Second add all heads into a max heap. Every time we poll a tweet with 
	     * largest time stamp from the heap, then we add its next tweet into the heap.
	     * So after adding all heads we only need to add 9 tweets at most into this 
	     * heap before we get the 10 most recent tweet.
	     */
	    public List<Integer> getNewsFeed(int userId) {
			List<Integer> res = new LinkedList<>();

			if (!userMap.containsKey(userId))
				return res;

			Set<Integer> users = userMap.get(userId).followed;
			PriorityQueue<Tweet> q = new PriorityQueue<Tweet>(users.size(), (a, b) -> (b.time - a.time));
			for (int user : users) {
				Tweet t = userMap.get(user).tweet_head;
				// very imporant! If we add null to the head we are screwed.
				if (t != null) {
					q.add(t);
				}
			}
			int n = 0;
			while (!q.isEmpty() && n < 10) {
				Tweet t = q.poll();
				res.add(t.id);
				n++;
				if (t.next != null)
					q.add(t.next);
			}
			return res;
	    }
	    
	    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
		public void follow(int followerId, int followeeId) {
			if (!userMap.containsKey(followerId)) {
				User u = new User(followerId);
				userMap.put(followerId, u);
			}
			if (!userMap.containsKey(followeeId)) {
				User u = new User(followeeId);
				userMap.put(followeeId, u);
			}
			userMap.get(followerId).follow(followeeId);
		}
	    
	    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
		public void unfollow(int followerId, int followeeId) {
			if (!userMap.containsKey(followerId) || followerId == followeeId)
				return;
			userMap.get(followerId).unfollow(followeeId);
		}
	}
	
	/**
	 * <pre>
	 * 371. Sum of Two Integers
	 * 
	 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
	 * 
	 * Example:
	 * Given a = 1 and b = 2, return 3.
	 * </pre>
	 */
	@Test
	public void test_leetcode_371() {
		int a1 = 1;
		int b1 = 2;
		int expectedOutput1 = 3;
		int output1 = getSum(a1, b1);
		assertThat(output1).isEqualTo(expectedOutput1);
		
		int a2 = 3;
		int b2 = 5;
		int expectedOutput2 = 8;
		int output2 = getSum(a2, b2);
		assertThat(output2).isEqualTo(expectedOutput2);
	}
	
	/**
	 * For this, problem, for example, we have a = 1, b = 3,
	 * 
	 * In bit representation, a = 0001, b = 0011,
	 * 
	 * First, we can use "and" ("&") operation between a and b to find a carry.
	 * 
	 * carry = a & b, then carry = 0001
	 * 
	 * Second, we can use "xor" ("^") operation between a and b to find the different bit, and assign it to a,
	 * 
	 * Then, we shift carry one position left and assign it to b, b = 0010.
	 * 
	 * Iterate until there is no carry (or b == 0)
	 */
	private int getSum(int a, int b) {
		if (a == 0) return b;
		if (b == 0) return a;

		while (b != 0) {
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}
		
		return a;
    }
	
	/**
	 * <pre>
	 * 373. Find K Pairs with Smallest Sums
	 * 
	 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
	 * 
	 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
	 * 
	 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
	 * 
	 * Example 1:
	 * Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3
	 * 
	 * Return: [1,2],[1,4],[1,6]
	 * 
	 * The first 3 pairs are returned from the sequence:
	 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
	 * 
	 * Example 2:
	 * Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2
	 * 
	 * Return: [1,1],[1,1]
	 * 
	 * The first 2 pairs are returned from the sequence:
	 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
	 * 
	 * Example 3:
	 * Given nums1 = [1,2], nums2 = [3],  k = 3 
	 * 
	 * Return: [1,3],[2,3]
	 * 
	 * All possible pairs are returned from the sequence:
	 * [1,3],[2,3]
	 * </pre>
	 */
	@Test
	public void test_leetcode_373() {
		int[] firstNums1 = new int[] {1,7,11};
		int[] firstNums2 = new int[] {2,4,6};
		int firstK = 3;
		List<int[]> firstExpectedOuptut = Arrays.asList(new int[] {1,2}, new int[] {1,4}, new int[] {1,6});
		List<int[]> firstOutput = kSmallestPairs(firstNums1, firstNums2, firstK);
		assertThat(firstExpectedOuptut).containsExactlyElementsOf(firstOutput);
	}
	
	private List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
		List<int[]> res = new ArrayList<>();

		if (nums1.length == 0 || nums2.length == 0 || k == 0)
			return res;

		for (int i = 0; i < nums1.length && i < k; i++)
			queue.offer(new int[] { nums1[i], nums2[0], 0 });

		while (k-- > 0 && !queue.isEmpty()) {
			int[] cur = queue.poll();
			res.add(new int[] { cur[0], cur[1] });
			if (cur[2] == nums2.length - 1)
				continue;
			queue.offer(new int[] { cur[0], nums2[cur[2] + 1], cur[2] + 1 });
		}
		return res;
	}
	
	/**
	 * <pre>
	 * 374. Guess Number Higher or Lower
	 * 
	 * We are playing the Guess Game. The game is as follows:
	 * 
	 * I pick a number from 1 to n. You have to guess which number I picked.
	 * 
	 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
	 * 
	 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
	 * 
	 * -1 : My number is lower
 	 * 1 : My number is higher
 	 * 0 : Congrats! You got it!
	 * 
	 * Example:
	 * n = 10, I pick 6.
	 * 
	 * Return 6.
	 * </pre> 
	 */
	@Test
	@Ignore
	public void test_leetcode_374() {
//		public int guessNumber(int n) {
//	        return bsearch(1,n);
//	    }
//
//	    private int bsearch(int start,int end){
//	        if(start>end) return -1;//R u kidding me?
//	        if(guess(start)==0) return start;
//	        if(guess(end)==0) return end;
//	        int mid = start+(end-start)/2;
//	        if(guess(mid)==0) return mid;
//	        else if(guess(mid)==-1) return bsearch(start+1,mid-1);
//	        else return bsearch(mid+1,end-1);
//	    }
	}
	
	/**
	 * <pre>
	 * 378. Kth Smallest Element in a Sorted Matrix
	 * 
	 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
	 * 
	 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
	 * 
	 * Example:
	 * 
	 * matrix = [
   	 * 	  [ 1,  5,  9],
   	 * 	  [10, 11, 13],
   	 *    [12, 13, 15]
	 * ],
	 * k = 8,
	 * 
	 * return 13.
	 * </pre>
	 */
	@Test
	public void test_leetcode_378() {
		int[][] matrix1 = new int[][] {
			new int[] {1, 5, 9},
			new int[] {10, 11, 13},
			new int[] {12, 13, 15}
		};
		int k1 = 8;
		int output1 = kthSmallest(matrix1, k1);
		int expectedOutput1 = 13;
		assertThat(output1).isEqualTo(expectedOutput1);
	}
	
	private int kthSmallest(int[][] matrix, int k) {
		int lo = matrix[0][0];
		int hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			int count = 0, j = matrix[0].length - 1;
			for (int i = 0; i < matrix.length; i++) {
				while (j >= 0 && matrix[i][j] > mid)
					j--;
				count += (j + 1);
			}
			if (count < k)
				lo = mid + 1;
			else
				hi = mid;
		}
		return lo;
	}
	
	/**
	 * <pre>
	 * 389. Find the Difference
	 * 
	 * Given two strings s and t which consist of only lowercase letters.
	 * 
	 * String t is generated by random shuffling string s and then add one more letter at a random position.
	 * 
	 * Find the letter that was added in t.
	 * 
	 * Example:
	 * 
	 * Input:
	 * s = "abcd"
	 * t = "abcde"
	 * 
	 * Output:
	 * e
	 * 
	 * Explanation:
	 * 'e' is the letter that was added.
	 * </pre>
	 */
	@Test
	public void test_leetcode_389() {
		String s1 = "abcd";
		String t1 = "abcde";
		char output1 = findTheDifference(s1, t1);
		char expectedOutput1 = 'e';
		assertThat(output1).isEqualTo(expectedOutput1);
		
		String s2 = "abcde";
		String t2 = "abcdez";
		char output2 = betterFindTheDifference(s2, t2);
		char expectedOutput2 = 'z';
		assertThat(output2).isEqualTo(expectedOutput2);
	}
	
    private char findTheDifference(String s, String t) {
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        
        for (char sc : sa) {
        	for (int i = 0; i < ta.length; i++) {
        		if (sc == ta[i]) {
        			ta[i] = '-';
        			break;
        		}
        	}
        }
        
        char res = ' ';
        for (char tc : ta) { 
        	if (tc != '-') {
        		res = tc;
        	}
        }
        return res;
    }
    
    private char betterFindTheDifference(String s, String t) {
        // Initialize variables to store sum of ASCII codes for each string
        int charCodeS = 0, charCodeT = 0;

        // Iterate through both strings and char codes
        for (int i = 0; i < s.length(); i++) charCodeS += (int) s.charAt(i);
        for (int i = 0; i < t.length(); i++) charCodeT += (int) t.charAt(i);

        // Return the difference between 2 strings as char
        return (char)(charCodeT - charCodeS);
    }
	
	/**
	 * <pre>
	 * 394. Decode String
	 * 
	 * Given an encoded string, return it's decoded string.
	 * 
	 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
	 * 
	 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
	 * 
	 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
	 * 
	 * Examples:
	 * 
	 * s = "3[a]2[bc]", return "aaabcbc".
	 * s = "3[a2[c]]", return "accaccacc".
	 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
	 * </pre> 
	 */
	@Test
	public void test_leetcode_394() {
		String s1 = "3[a]2[bc]";
		String expectedOutput1 = "aaabcbc";
		String output1 = decodeString(s1);
		assertThat(output1).isEqualTo(expectedOutput1);
		
		String s2 = "3[a2[c]]";
		String expectedOutput2 = "accaccacc";
		String output2 = decodeString(s2);
		assertThat(output2).isEqualTo(expectedOutput2);
	}

	private String decodeString(String s) {
		String res = "";
	
	    Stack<Integer> countStack = new Stack<>();
	    Stack<String> resStack = new Stack<>();
	    int idx = 0;
	    while (idx < s.length()) {
	        if (Character.isDigit(s.charAt(idx))) {
	            int count = 0;
	            while (Character.isDigit(s.charAt(idx))) {
	                count = 10 * count + (s.charAt(idx) - '0');
	                idx++;
	            }
	            countStack.push(count);
	        }
	        else if (s.charAt(idx) == '[') {
	            resStack.push(res);
	            res = "";
	            idx++;
	        }
	        else if (s.charAt(idx) == ']') {
	            StringBuilder temp = new StringBuilder (resStack.pop());
	            int repeatTimes = countStack.pop();
	            for (int i = 0; i < repeatTimes; i++) {
	                temp.append(res);
	            }
	            res = temp.toString();
	            idx++;
	        }
	        else {
	            res += s.charAt(idx);
	            idx++;
	        }
	    }
	    return res;
	}
	
	/**
	 * <pre>
	 * 402. Remove K Digits
	 * 
	 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
	 * 
	 * Note:
	 * The length of num is less than 10002 and will be ≥ k.
	 * The given num does not contain any leading zero.
	 * 
	 * Example 1:
	 * 
	 * Input: num = "1432219", k = 3
	 * Output: "1219"
	 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
	 * 
	 * Example 2:
	 * 
	 * Input: num = "10200", k = 1
	 * Output: "200"
	 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
	 * 
	 * Example 3:
	 * 
	 * Input: num = "10", k = 2
	 * Output: "0"
	 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
	 * </pre>
	 */
	@Test
	public void test_leetcode_402() {
		String num1 = "1432219";
		int k1 = 3;
		String output1 = removeKdigits(num1, k1);
		String expectedOutput1 = "1219";
		assertThat(output1).isEqualTo(expectedOutput1);
		
		String num2 = "10200";
		int k2 = 1;
		String output2 = removeKdigits(num2, k2);
		String expectedOutput2 = "200";
		assertThat(output2).isEqualTo(expectedOutput2);
		
		String num3 = "10";
		int k3 = 2;
		String output3 = removeKdigits(num3, k3);
		String expectedOutput3 = "0";
		assertThat(output3).isEqualTo(expectedOutput3);
	}
	
    private String removeKdigits(String num, int k) {
		int len = num.length();

		// corner case
		if (k == len)
			return "0";

		Stack<Character> stack = new Stack<>();
		int i = 0;
		while (i < len) {
			// whenever meet a digit which is less than the previous digit, discard the previous one
			while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
				stack.pop();
				k--;
			}
			stack.push(num.charAt(i));
			i++;
		}

		// corner case like "1111"
		while (k > 0) {
			stack.pop();
			k--;
		}

		// construct the number from the stack
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty())
			sb.append(stack.pop());

		sb.reverse();

		// remove all the 0 at the head
		while (sb.length() > 1 && sb.charAt(0) == '0')
			sb.deleteCharAt(0);

		return sb.toString();
    }

	/**
	 * <pre>
	 * 405. Convert a Number to Hexadecimal
	 * 
	 * Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.
	 * 
	 * Note:
	 * 
	 * All letters in hexadecimal (a-f) must be in lowercase.
	 * The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
	 * The given number is guaranteed to fit within the range of a 32-bit signed integer.
	 * You must not use any method provided by the library which converts/formats the number to hex directly.
	 * 
	 * Example 1:
	 * 
	 * Input:
	 * 26
	 * Output:
	 * "1a"
	 * 
	 * Example 2:
	 * 
	 * Input:
	 * -1
	 * Output:
	 * "ffffffff"
	 * 
	 * </pre>
	 */
	@Test
	public void test_leetcode_405() {
		int num1 = 26;
		String expectedOutput1 = "1a";
		String outpu1 = toHex(num1);
		assertThat(outpu1).isEqualTo(expectedOutput1);
		
		int num2 = -1;
		String expectedOutput2 = "ffffffff";
		String outpu2 = toHex(num2);
		assertThat(outpu2).isEqualTo(expectedOutput2);
	}
	
	private String toHex(int num) {
		char[] map = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

		if (num == 0)
			return "0";

		String result = "";
		while (num != 0) {
			result = map[(num & 15)] + result;
			num = (num >>> 4);
		}

		return result;
	}

	/**
	 * <pre>
	 * 412. Fizz Buzz
	 * 
	 * Write a program that outputs the string representation of numbers from 1 to n.
	 * 
	 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
	 * 
	 * Example:
	 * 
	 * n = 15,
	 * 
	 * Return:
	 * [
	 * "1",
	 * "2",
	 * "Fizz",
	 * "4",
	 * "Buzz",
	 * "Fizz",
	 * "7",
	 * "8",
	 * "Fizz",
	 * "Buzz",
	 * "11",
	 * "Fizz",
	 * "13",
	 * "14",
	 * "FizzBuzz"
	 * ]
	 * </pre> 
	 */
	@Test
	public void test_leetcode_412() {
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
	
	/**
	 * Java 4ms solution , Not using "%" operation
	 */
	private List<String> betterFizzBuzz(int n) {
		List<String> ret = new ArrayList<String>(n);
		for (int i = 1, fizz = 0, buzz = 0; i <= n; i++) {
			fizz++;
			buzz++;
			if (fizz == 3 && buzz == 5) {
				ret.add("FizzBuzz");
				fizz = 0;
				buzz = 0;
			} else if (fizz == 3) {
				ret.add("Fizz");
				fizz = 0;
			} else if (buzz == 5) {
				ret.add("Buzz");
				buzz = 0;
			} else {
				ret.add(String.valueOf(i));
			}
		}
		return ret;
	}
	
	/**
	 * <pre>
	 * 414. Third Maximum Number
	 * 
	 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
	 * 
	 * Example 1:
	 * Input: [3, 2, 1]
	 * 
	 * Output: 1
	 * Explanation: The third maximum is 1.
	 * 
	 * Example 2:
	 * Input: [1, 2]
	 * 
	 * Output: 2
	 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
	 * 
	 * Example 3:
	 * Input: [2, 2, 3, 1]
	 * 
	 * Output: 1
	 * Explanation: Note that the third maximum here means the third maximum distinct number.
	 * 
	 * Both numbers with value 2 are both considered as second maximum.
	 * </pre>
	 */
	@Test
	public void test_leetcode_414() {
		int[] nums1 = new int[] {3,2,1};
		int expectedOutput1 = 1;
		int output1 = thirdMax(nums1);
		assertThat(output1).isEqualTo(expectedOutput1);
	
		int[] nums2 = new int[] {10,10,20,8,9,6};
		int expectedOutput2 = 9;
		int output2 = thirdMax(nums2);
		assertThat(output2).isEqualTo(expectedOutput2);
	}
	
	private int thirdMax(int[] nums) {
		Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
	}
	
	/**
	 * <pre>
	 * 420. Strong Password Checker
	 * 
	 * A password is considered strong if below conditions are all met:
	 * 
	 * It has at least 6 characters and at most 20 characters.
	 * It must contain at least one lowercase letter, at least one uppercase letter, and at least one digit.
	 * It must NOT contain three repeating characters in a row ("...aaa..." is weak, but "...aa...a..." is strong, assuming other conditions are met).
	 * 
	 * Write a function strongPasswordChecker(s), that takes a string s as input, and return the MINIMUM change required to make s a strong password. If s is already strong, return 0.
	 * 
	 * Insertion, deletion or replace of any one character are all considered as one change.
	 * </pre>
	 */
	@Test
	public void test_leetcode_420() {
		String s1 = "7Kaf41n5";
		int output1 = strongPasswordChecker(s1);
		int expectedOutput1 = 0;
		assertThat(output1).isEqualTo(expectedOutput1);
		
		String s2 = "7kfn5";
		int output2 = strongPasswordChecker(s2);
		int expectedOutput2 = 1;
		assertThat(output2).isEqualTo(expectedOutput2);
	}
	
	private int strongPasswordChecker(String s) {
		if (s.length() < 2)
			return 6 - s.length();

		/**
		 * Initialize the states, including current ending character(end),
		 * existence of lowercase letter(lower), uppercase letter(upper),
		 * digit(digit) and number of replicates for ending character(end_rep)
		 */
		char end = s.charAt(0);
		boolean upper = end >= 'A' && end <= 'Z', lower = end >= 'a' && end <= 'z', digit = end >= '0' && end <= '9';

		/**
		 * Also initialize the number of modification for repeated characters,
		 * total number needed for eliminate all consequnce 3 same character by
		 * replacement(change), and potential maximun operation of deleting
		 * characters(delete). Note delete[0] means maximum number of reduce 1
		 * replacement operation by 1 deletion operation, delete[1] means
		 * maximun number of reduce 1 replacement by 2 deletion operation,
		 * delete[2] is no use here.
		 */
		int end_rep = 1, change = 0;
		int[] delete = new int[3];

		for (int i = 1; i < s.length(); ++i) {
			if (s.charAt(i) == end)
				++end_rep;
			else {
				change += end_rep / 3;
				if (end_rep / 3 > 0)
					++delete[end_rep % 3];
				// updating the states
				end = s.charAt(i);
				upper = upper || end >= 'A' && end <= 'Z';
				lower = lower || end >= 'a' && end <= 'z';
				digit = digit || end >= '0' && end <= '9';
				end_rep = 1;
			}
		}
		change += end_rep / 3;
		if (end_rep / 3 > 0)
			++delete[end_rep % 3];

		// The number of replcement needed for missing of specific character(lower/upper/digit)
		int check_req = (upper ? 0 : 1) + (lower ? 0 : 1) + (digit ? 0 : 1);

		if (s.length() > 20) {
			int del = s.length() - 20;

			// Reduce the number of replacement operation by deletion
			if (del <= delete[0])
				change -= del;
			else if (del - delete[0] <= 2 * delete[1])
				change -= delete[0] + (del - delete[0]) / 2;
			else
				change -= delete[0] + delete[1] + (del - delete[0] - 2 * delete[1]) / 3;

			return del + Math.max(check_req, change);
		} else
			return Math.max(6 - s.length(), Math.max(check_req, change));
	}
	
	/**
	 * <pre>
	 * 423. Reconstruct Original Digits from English
	 * 
	 * Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.
	 * 
	 * Note:
	 * Input contains only lowercase English letters.
	 * Input is guaranteed to be valid and can be transformed to its original digits. That means invalid inputs such as "abc" or "zerone" are not permitted.
	 * Input length is less than 50,000.
	 * 
	 * Example 1:
	 * Input: "owoztneoer"
	 * Output: "012"
	 * 
	 * Example 2:
	 * Input: "fviefuro"
	 * Output: "45"
	 * </pre>
	 */
	@Test
	public void test_leetcode_423() {
		String input1 = "owoztneoer";
		String expectedOutput1 = "012";
		String output1 = originalDigits(input1);
		assertThat(output1).isEqualTo(expectedOutput1);
		
		String input2 = "fviefuro";
		String expectedOutput2 = "45";
		String output2 = originalDigits(input2);
		assertThat(output2).isEqualTo(expectedOutput2);
	}
	
	/**
	 * The idea is:
	 * 
	 * for zero, it's the only word has letter 'z',
	 * for two, it's the only word has letter 'w',
	 * ......
	 * so we only need to count the unique letter of each word, Coz the input is always valid.
	 */
	private String originalDigits(String s) {
		int[] count = new int[10];
	    for (int i = 0; i < s.length(); i++){
	        char c = s.charAt(i);
	        if (c == 'z') count[0]++;
	        if (c == 'o') count[1]++; //1-0-2-4
	        if (c == 'w') count[2]++;
	        if (c == 'h') count[3]++; //3-8
	        if (c == 'u') count[4]++; 
	        if (c == 'f') count[5]++; //5-4
	        if (c == 'x') count[6]++;
	        if (c == 's') count[7]++; //7-6
	        if (c == 'g') count[8]++;
	        if (c == 'i') count[9]++; //9-8-5-6
	    }
	    count[1] = count[1] - count[0] - count[2] - count[4];
	    count[3] -= count[8];
	    count[5] -= count[4];
	    count[7] -= count[6];
	    count[9] = count[9] - count[8] - count[5] - count[6];
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i <= 9; i++){
	        for (int j = 0; j < count[i]; j++){
	            sb.append(i);
	        }
	    }
	    return sb.toString();
    }

	/**
	 * <pre>
	 * 434. Number of Segments in a String
	 * 
	 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
	 * 
	 * Please note that the string does not contain any non-printable characters.
	 * 
	 * Example:
	 * 
	 * Input: "Hello, my name is John"
	 * Output: 5
	 * </pre>
	 */
	@Test
	public void test_leetcode_434() {
		String input1 = ", , , ,        a, eaefa";
		int expectedOutput1 = 6;
		
		int output1 = countSegments(input1);
		
		assertThat(output1).isEqualTo(expectedOutput1);
		
		String input2 = "                ";
		int expectedOutput2 = 0;
		
		int output2 = countSegments(input2);
		
		assertThat(output2).isEqualTo(expectedOutput2);
	}
	
	private int countSegments(String s) {
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
				res++;
			}
		}
		return res;
    }
	
	/**
	 * <pre>
	 * 441. Arranging Coins
	 * 
	 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
	 * 
	 * Given n, find the total number of full staircase rows that can be formed.
	 * 
	 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
	 * 
	 * Example 1:
	 * 
	 * n = 5
	 * 
	 * The coins can form the following rows:
	 * ¤
	 * ¤ ¤
	 * ¤ ¤
	 * 
	 * Because the 3rd row is incomplete, we return 2.
	 * 
	 * Example 2:
	 * 
	 * n = 8
	 * 
	 * The coins can form the following rows:
	 * ¤
	 * ¤ ¤
	 * ¤ ¤ ¤
	 * ¤ ¤
	 * 
	 * Because the 4th row is incomplete, we return 3.
	 * </pre>
	 */
	@Test
	public void test_leetcode_441() {
		int n1 = 5;
		int output1 = arrangeCoins(n1);
		int expectedOutput1 = 2;
		assertThat(output1).isEqualTo(expectedOutput1);
		
		int n2 = 8;
		int output2 = arrangeCoins(n2);
		int expectedOutput2 = 3;
		assertThat(output2).isEqualTo(expectedOutput2);
	}
	
	private int arrangeCoins(int n) {
		int start = 0;
		int end = n;
		int mid = 0;
		while (start <= end) {
			mid = (start + end) >>> 1;
			if ((0.5 * mid * mid + 0.5 * mid) <= n) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return start - 1;
	}
	
	/**
	 * <pre>
	 * 442. Find All Duplicates in an Array
	 * 
	 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
	 * 
	 * Find all the elements that appear twice in this array.
	 * 
	 * Could you do it without extra space and in O(n) runtime?
	 * 
	 * Example:
	 * Input:
	 * [4,3,2,7,8,2,3,1]
	 * 
	 * Output:
	 * [2,3]
	 * </pre>
	 */
	@Test
	public void test_leetcode_442() {
		int[] nums1 = new int[] {4,3,2,7,8,2,3,1};
		List<Integer> expectedOutput1 = new ArrayList<>();
		expectedOutput1.add(2);
		expectedOutput1.add(3);
		List<Integer> output = betterFindDuplicates(nums1);
		assertThat(expectedOutput1).containsExactlyElementsOf(output);
	}
	
	private List<Integer> myFindDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> digitCounts = new HashMap<>();
        for (int num : nums) {
        	if (!digitCounts.containsKey(num)) {
        		digitCounts.put(num, 1);
        	}
        	else {
        		Integer counts = digitCounts.get(num);
        		counts++;
        		digitCounts.put(num, counts);
        	}
        }
        
        Iterator<Integer> itKey = digitCounts.keySet().iterator();
        while (itKey.hasNext()) {
        	Integer key = itKey.next();
        	Integer counts = digitCounts.get(key);
        	if (counts == 2) {
        		res.add(key);
        	}
        }
        return res;
	}
	
	private List<Integer> betterFindDuplicates(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		if (nums == null)
			return result;
		for (int i = 0; i < nums.length; i++) {
			int location = Math.abs(nums[i]) - 1;
			if (nums[location] < 0) {
				result.add(Math.abs(nums[i]));
			} else {
				nums[location] = -nums[location];
			}
		}
		for (int i = 0; i < nums.length; i++)
			nums[i] = Math.abs(nums[i]);

		return result;
	}

	/**
	 * <pre>
	 * 448. Find All Numbers Disappeared in an Array
	 * 
	 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
	 * 
	 * Find all the elements of [1, n] inclusive that do not appear in this array.
	 * 
	 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
	 * 
	 * Example:
	 * 
	 * Input:
	 * [4,3,2,7,8,2,3,1]
	 * 
	 * Output:
	 * [5,6]
	 * </pre>
	 */
	@Test
	public void test_leetcode_448() {
		int[] nums1 = new int[] {4,3,2,7,8,2,3,1};
		List<Integer> expectedOutput1 = new ArrayList<>();
		expectedOutput1.add(5);
		expectedOutput1.add(6);
		List<Integer> output1 = findDisappearedNumbers(nums1);
		assertThat(output1).containsAll(expectedOutput1);
		
		// make sure the values of source array aren't changed
//		System.out.println(Arrays.toString(nums1));
	}
	
	private List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();

		for (int i = 0; i < nums.length; i++) {
			int val = Math.abs(nums[i]) - 1;
			
			// if nums[val] > 0 means the number never occurred
			if (nums[val] > 0) {
				// set it to negative represent occurred
				nums[val] = -nums[val];
			}
		}

		for (int i = 0; i < nums.length; i++) {
			// if nums[val] > 0 means the number never occurred
			if (nums[i] > 0) {
				// add to result list
				res.add(i + 1);
			}
			else {
				// reset the source array value
				nums[i] = Math.abs(nums[i]);
			}
		}
		return res;
	}

	/**
	 * <pre>
	 * 455. Assign Cookies
	 * 
	 * Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie. Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be content with; and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.
	 * 
	 * Note:
	 * You may assume the greed factor is always positive. 
	 * You cannot assign more than one cookie to one child.
	 * 
	 * Example 1:
	 * Input: [1,2,3], [1,1]
	 * 
	 * Output: 1
	 * 
	 * Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3. 
	 * And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
	 * You need to output 1.
	 * 
	 * Example 2:
	 * Input: [1,2], [1,2,3]
	 * 
	 * Output: 2
	 * 
	 * Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2. 
	 * You have 3 cookies and their sizes are big enough to gratify all of the children, 
	 * You need to output 2.
	 * </pre>
	 */
	@Test
	public void test_leetcode_455() {
		int[] g1 = new int[] {1,2,3};
		int[] s1 = new int[] {1,1};
		int expectedOutput1 = 1;
		int output1 = findContentChildren(g1, s1);
		assertThat(output1).isEqualTo(expectedOutput1);
		
		int[] g2 = new int[] {1,2};
		int[] s2 = new int[] {1,2,3};
		int expectedOutput2 = 2;
		int output2 = findContentChildren(g2, s2);
		assertThat(output2).isEqualTo(expectedOutput2);
	}
	
	private int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int i = 0;
		for (int j = 0; i < g.length && j < s.length; j++) {
			if (g[i] <= s[j])
				i++;
		}
		return i;
	}
	
	/**
	 * <pre>
	 * 459. Repeated Substring Pattern
	 * 
	 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
	 * 
	 * Example 1:
	 * Input: "abab"
	 * Output: True
	 * 
	 * Explanation: It's the substring "ab" twice.
	 * 
	 * Example 2:
	 * Input: "aba"
	 * Output: False
	 * 
	 * Example 3:
	 * Input: "abcabcabcabc"
	 * Output: True
	 * 
	 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
	 * </pre>
	 */
	@Test
	public void test_leetcode_459() {
		String input1 = "abab";
		boolean expectedOutput1 = true;
		boolean output1 = repeatedSubstringPattern(input1);
		assertThat(output1).isEqualTo(expectedOutput1);
		
		String input2 = "aba";
		boolean expectedOutput2 = false;
		boolean output2 = repeatedSubstringPattern(input2);
		assertThat(output2).isEqualTo(expectedOutput2);
		
		String input3 = "abcabcabcabc";
		boolean expectedOutput3 = true;
		boolean output3 = repeatedSubstringPattern(input3);
		assertThat(output3).isEqualTo(expectedOutput3);
	}
	
	private boolean repeatedSubstringPattern(String str) {
		int len = str.length();
		for (int i = len / 2; i >= 1; i--) {
			if (len % i == 0) {
				int m = len / i;
				String subS = str.substring(0, i);
				int j;
				for (j = 1; j < m; j++) {
					if (!subS.equals(str.substring(j * i, i + j * i)))
						break;
				}
				if (j == m)
					return true;
			}
		}
		return false;
    }
	
	/**
	 * <pre>
	 * 494. Target Sum
	 * 
	 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
	 * 
	 * Find out how many ways to assign symbols to make sum of integers equal to target S.
	 * 
	 * Example 1:
	 * Input: nums is [1, 1, 1, 1, 1], S is 3. 
	 * Output: 5
	 * Explanation: 
	 * 
	 * -1+1+1+1+1 = 3
	 * +1-1+1+1+1 = 3
	 * +1+1-1+1+1 = 3
	 * +1+1+1-1+1 = 3
	 * +1+1+1+1-1 = 3
	 * 
	 * There are 5 ways to assign symbols to make the sum of nums be target 3.
	 * </pre> 
	 */
	@Test
	public void test_leetcode_494() {
		int[] nums1 = new int[] {1,1,1,1,1};
		int S1 = 3;
		int expectedOutput1 = 5;
		int output1 = findTargetSumWays(nums1, S1);
		assertThat(output1).isEqualTo(expectedOutput1);
	}
	
	private int findTargetSumWays(int[] nums, int S) {
		int sum = 0;
        for (int n : nums)
            sum += n;
        return (sum < S || (S + sum) % 2 > 0) ? 0 : subsetSum(nums, (S + sum) >> 1); 
	}
	
	private int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1]; 
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n]; 
        return dp[s];
    } 

	/**
	 * <pre>
	 * 500. Keyboard Row
	 * 
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
	 * 503. Next Greater Element II
	 * 
	 * Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.
	 * 
	 * Example 1:
	 * Input: [1,2,1]
	 * Output: [2,-1,2]
	 * 
	 * Explanation: 
	 * The first 1's next greater number is 2; 
	 * The number 2 can't find next greater number; 
	 * The second 1's next greater number needs to search circularly, which is also 2.
	 * 
	 * Note: The length of given array won't exceed 10000.
	 * </pre>
	 */
	@Test
	public void test_leetcode_503() {
		int[] num1 = new int[] {1,2,1};
		int[] output1 = nextGreaterElements(num1);
		int[] expectedOutput1 = new int[] {2,-1,2};
		assertThat(output1).isEqualTo(expectedOutput1);
		
		int[] num2 = new int[] {1,2,5,3,7,3};
		int[] output2 = nextGreaterElements(num2);
		int[] expectedOutput2 = new int[] {2,5,7,7,-1,5};
		assertThat(output2).isEqualTo(expectedOutput2);
	}
	
    private int[] nextGreaterElements(int[] nums) {
    	int n = nums.length, next[] = new int[n];
        Arrays.fill(next, -1);
        Stack<Integer> stack = new Stack<>(); // index stack
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n]; 
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                next[stack.pop()] = num;
            }
            if (i < n) {
            	stack.push(i);
            }
        }   
        return next;
    }
    
    /**
     * <pre>
     * 513. Find Bottom Left Tree Value
     * 
     * Given a binary tree, find the leftmost value in the last row of the tree.
     * 
     * Example 1:
     * Input:
     * 
     * 		2
     * 	   / \
     *    1   3
	 *
     * Output:
     * 1
     * 
     * Example 2: 
     * Input:
     * 
     * 		1
     * 	   / \
     * 	  2   3
     *   /   / \
     *  4   5   6
     *     /
     *    7
     * 
     * Output:
     * 7
     * Note: You may assume the tree (i.e., the given root node) is not NULL.
     * </pre>
     */
    @Test
    public void test_leetcode_513() {
    	TreeNode root1 = sortedArrayToBST(new int[] {1,2,3});
    	int output1 = findBottomLeftValue(root1);
    	int expectedOutput1 = 1;
    	assertThat(output1).isEqualTo(expectedOutput1);
    	
    	TreeNode root2 = sortedArrayToBST(new int[] {1,2,3,4,5,6,7,8,9});
    	int output2 = findBottomLeftValue(root2);
    	int expectedOutput2 = 4;
    	assertThat(output2).isEqualTo(expectedOutput2);
    }
    
    private int findBottomLeftValue(TreeNode root) {
    	if (root == null) return 0;
        
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) result = node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        
        return result;
    }
	
	/**
	 * <pre>
	 * 515. Find Largest Value in Each Tree Row
	 * 
	 * You need to find the largest value in each row of a binary tree.
	 * 
	 * Example:
	 * Input: 
	 * 
     * 		1
     * 	   / \
     *    3   2
     *   / \   \  
     *  5   3   9 
	 * 
	 * Output: [1, 3, 9]
	 * </pre>
	 */
	@Test
	public void test_leetcode_515() {
		int[] tree1Vals = new int[] {1, 2, 3, 3, 5, 9};
		TreeNode tree1Root = sortedArrayToBST(tree1Vals);
//		System.out.println(binaryTreePaths(tree1Root));
		List<Integer> output1 = largestValues(tree1Root);
		List<Integer> expectedOutput1 = Arrays.asList(3, 5, 9);
		assertThat(expectedOutput1).isEqualTo(output1);
	}
	
    private List<Integer> largestValues(TreeNode root) {
    	List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(max);
        }
        
        Integer[] result = new Integer[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        
        return Arrays.asList(result);
    }

	/**
	 * <pre>
	 * 516. Longest Palindromic Subsequence
	 * 
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
