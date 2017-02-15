package com.exfantasy.template.test;

import java.util.Stack;

import org.junit.Test;

public class TestStack {
	
	@Test
	public void test() {
		Stack<Integer> stack = new Stack<>();
		
		Integer push1 = stack.push(1);
		System.out.println("Push : " + push1);
		
		Integer pop1 = stack.pop();
		System.out.println("Pop: " + pop1);
		
		Integer push2 = stack.push(2);
		System.out.println("Push : " + push2);
		
		Integer push3 = stack.push(3);
		System.out.println("Push : " + push3);
		
		System.out.println("Looks at the object at the top of this stack: " + stack.peek());
	}
}
