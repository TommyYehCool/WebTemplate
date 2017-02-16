package com.exfantasy.template.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
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
	 * Given two binary trees, write a function to check if they are equal or not.
	 * 
	 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
	 * </pre>
	 */
	@Test
	@Ignore
	public void test_leetcode_100() {
		/**
		 * public boolean isSameTree(TreeNode p, TreeNode q) {
		 * 		if(p == null && q == null) return true;
         * 		if(p == null || q == null) return false;
         * 		return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
         * }
		 */
	}
	
	/**
	 * <pre>
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
		int expectedOutput3 = 1400;
		int output3 = maxProfit(k3, prices3);
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
	 * <pre>
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
		List<Integer> output = findDuplicatesElegant(nums1);
		assertThat(output).containsAll(expectedOutput1);
	}
	
	@SuppressWarnings("unused")
	private List<Integer> findDuplicates(int[] nums) {
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
	
	private List<Integer> findDuplicatesElegant(int[] nums) {
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
