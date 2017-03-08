package com.exfantasy.template.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import lombok.AllArgsConstructor;
import lombok.Data;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestJava {
	
	@Test
	public void testBinarySearch() {
		System.out.println(">>>> Starting to testBinarySearch");

		int[] nums = new int[] {6, 2, 3, 8, 23, 22, 10, 18, 12, 17};
		
		int index = 7;
		int target = nums[index];

		// 因為陣列沒排序過就用 binary search 會找不到
		int foundIndex = Arrays.binarySearch(nums, target);
		assertThat(index).isNotEqualTo(foundIndex);
		
		// 陣列經過排序後, 用 binary search 就可以找到
		Arrays.sort(nums);
		foundIndex = Arrays.binarySearch(nums, target);
		assertThat(index).isEqualTo(foundIndex);
		
		System.out.println("<<<< testBinarySearch done");
	}
	
	@Test
	public void testStrReverse() {
		System.out.println(">>>> Starting to testStrReverse");
		
		char[] c1 = "123456".toCharArray();
		reverse(c1, 0, c1.length - 1);
		String expectedOutput = "654321";
		assertThat(new String(c1)).isEqualTo(expectedOutput);
		
		System.out.println("<<<< testStrReverse done");
	}
	
	private void reverse(char[] s, int start, int end) {
	    while (start < end) {
	        char temp = s[start];
	        s[start] = s[end];
	        s[end] = temp;
	        start++;
	        end--;
	    }
	}
	
	@Test
	public void testAscii() {
		char a = 'a';
		char z = 'z';
		System.out.println((int) a);
		System.out.println((int) z);
		
		System.out.println((int) z - (int) a);
	}
	
	@Test
	@Ignore
	public void testDate() {
		Long timeInMillis = 1486783800000L;
		Date date = new Date(timeInMillis);
		
		String timeStr = "2017-02-11 11:30:00";
		
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		assertThat(dateTimeFormat.format(date)).isEqualTo(timeStr);
		
		// 測試 JUnit 的 Assert
		assertEquals(dateTimeFormat.format(date), timeStr);
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
	public void testShift() {
		System.out.println(">>>> Starting to testShift");
		
		int[] a = new int[] {2, 3, 5, 7, 41, 57, 91, 93};
		
		int low = 0;
        int high = a.length - 1;

        int mid = (low + high) >> 1;
        
        System.out.println("low: " + low + ", high: " + high + ", mid: " + mid);
        
        System.out.println("<<<< testShift done");
	}
	
	/**
	 * <pre>
	 * <a href="http://rx1226.pixnet.net/blog/post/323727963-%5Bjava%5D-5-3-%E4%BD%8D%E7%A7%BB%E9%81%8B%E7%AE%97%E5%AD%90-shift-operators">Java shift operators</a>
	 * </pre>
	 */
	@Test
	public void testShift2() {
		System.out.println(">>>> Starting to testShift2");
		
		// 結果 0x0000 0010 相當於乘 2 
		System.out.printf("0x%x\n", 1 << 1);
		
		// 結果 0x0000 0000 相當於計算機的除 2
		System.out.printf("0x%x\n", 1 >> 1);
		
		// 左邊補上原來最左邊的位元值, 相當於除 2
		System.out.printf("0x%x\n", -1 >> 1);
		
		// 左邊補上 0, 其他向右位移
		System.out.printf("0x%x\n", -1 >>> 1);
		
		System.out.println("<<<< testShift2 done");
	}
	
	@Test
	public void testStack() {
		System.out.println(">>>> Starting to testStack");
		
		Stack<Integer> stack = new Stack<>();
		
		Integer push1 = stack.push(1);
		System.out.println("Push: " + push1);
		
		Integer pop1 = stack.pop();
		System.out.println("Pop: " + pop1);
		
		Integer push2 = stack.push(2);
		System.out.println("Push: " + push2);
		
		Integer push3 = stack.push(3);
		System.out.println("Push: " + push3);
		
		System.out.println("Looks at the object at the top of this stack: " + stack.peek());
		
		System.out.println("<<<< testStack done");
	}
	
	@Test
	public void testMathAbs() {
		System.out.println(">>>> Starting to testMathAbs");

		int a = -88;
		int aAbs = Math.abs(a);
		System.out.println("a: " + a + ", Match.abs(a): " + aAbs);
		
		assertEquals(aAbs, 88);
		
		System.out.println("<<<< testMathAbs done");
	}
	
	@Test
	public void testStringBuilderReverse() {
		System.out.println(">>>> Starting to testStringBuilderReverse");
		
		String testStr = "TommyYeh";
		StringBuilder builder = new StringBuilder(testStr);
		StringBuilder reverseBuilder = builder.reverse();
		String reverseStr = reverseBuilder.toString();
		assertEquals(reverseStr, "heYymmoT");
		
		System.out.println("Original String: " + testStr + " -> Reverse String: " + reverseStr);
		
		System.out.println("<<<< testStringBuilderReverse done");
	}

	@Data
	@AllArgsConstructor
	private class MyObj {
		private String key;
		private int value;
	}
	
	/**
	 * Ref: <a href="http://javarevisited.blogspot.tw/2016/04/10-examples-of-converting-list-to-map.html">10-examples-of-converting-list-to-map</a>
	 */
	@Test
	public void testStreamListToMap() {
		System.out.println(">>>> Starting to testStreamListToMap");
		
		List<MyObj> objs = new ArrayList<>();
		objs.add(new MyObj("tommy", 37));
		objs.add(new MyObj("alice", 31));
		Map<String, MyObj> map 
			= objs.stream().collect(Collectors.toMap(MyObj::getKey, Function.identity()));
		System.out.println(map);
		
		objs.clear();
		
		objs.add(new MyObj("benson", 37));
		objs.add(new MyObj("ben", 31));
		map 
			= objs.stream().collect(Collectors.toMap(MyObj::getKey, Function.identity()));
		System.out.println(map);
		
		assertEquals(map.size(), 2);
		assertThat(map.values()).containsAll(objs);
		
		System.out.println("<<<< testStreamListToMap done");
	}
	
	@Test
	public void testMap() {
		Map<String, String> map = new HashMap<>();
		String orDefault = map.getOrDefault("Hello", "World");
		System.out.println(orDefault);
	}
	
	@Test
	public void testAddToBuild() {
		System.out.println("haha");
	}
}
