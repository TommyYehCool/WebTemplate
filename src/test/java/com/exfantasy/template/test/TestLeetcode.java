package com.exfantasy.template.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Stream;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
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
