package com.exfantasy.template.test;

import static org.junit.Assert.assertEquals;

import java.util.PriorityQueue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPriorityQueue {
	
	@Test
	public void test() {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		
		queue.add(4);
		queue.add(5);
		queue.add(1);
		queue.add(3);
		queue.add(2);
		
		int times = 1;
		while (!queue.isEmpty()) {
			Integer peek = queue.peek();
			System.out.println("Peek: " + peek);

			Integer poll = queue.poll();
			System.out.println("Pool: " + poll);
			
			switch (times) {
				case 1:
					assertEquals(peek, new Integer(1));
					assertEquals(poll, new Integer(1));
					break;
				case 2:
					assertEquals(peek, new Integer(2));
					assertEquals(poll, new Integer(2));
					break;
				case 3:
					assertEquals(peek, new Integer(3));
					assertEquals(poll, new Integer(3));
					break;
				case 4:
					assertEquals(peek, new Integer(4));
					assertEquals(poll, new Integer(4));
					break;
				case 5:
					assertEquals(peek, new Integer(5));
					assertEquals(poll, new Integer(5));
					break;
			}
			times++;
		}
	}

}
