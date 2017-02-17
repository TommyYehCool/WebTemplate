package com.exfantasy.template.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
	public void testShift() {
		System.out.println(">>>> Starting to testShift");
		
		int[] a = new int[] {2, 3, 5, 7, 41, 57, 91, 93};
		
		int low = 0;
        int high = a.length - 1;

        int mid = (low + high) >> 1;
        
        System.out.println("low: " + low + ", high: " + high + ", mid: " + mid);
        
        System.out.println("<<<< testShift done");
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
		
		System.out.println("<<<< testMathAbs done");
	}
	
	@Test
	public void testStringBuilderReverse() {
		System.out.println(">>>> Starting to testStringBuilderReverse");
		
		StringBuilder builder = new StringBuilder("TommyYeh");
		System.out.println(builder.reverse());
		
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
		List<MyObj> objs = new ArrayList<>();
		objs.add(new MyObj("tommy", 37));
		objs.add(new MyObj("alice", 31));
		Map<String, MyObj> map 
			= objs.stream().collect(Collectors.toMap(MyObj::getKey, Function.identity()));
		System.out.println(map);
	}
}
