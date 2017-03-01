package com.exfantasy.template.test;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.assertj.core.api.Assertions.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCommonAlgorithm {

	@Test
	public void testBinarySearch() {
		int[] array = new int[] {1, 3, 5, 8, 12, 34, 56, 78};
		
		int indexToSearch = 5;
		int key = array[indexToSearch];
		
		int output = binarySearch(array, key);
		
		assertThat(output).isEqualTo(indexToSearch);
	}
	
	private int binarySearch(int[] array, int key) {
		int lo = 0;
		int hi = array.length - 1;
		while (lo <= hi) {
			int mid = (lo + hi) >>> 1;
			if (key < array[mid]) {
				hi = mid - 1;
			} else if (key > array[mid]) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	@Test
	public void testBubbleSort() {
		int[] array = new int[] {4, 7, 1, 6, 3, 8, 2, 5, 9};

		bubbleSort(array);
		
		int[] expectedOutput = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		assertThat(array).isEqualTo(expectedOutput);
	}

	private void bubbleSort(int[] array) {
		for (int i = array.length - 1; i > 0; --i)
			for (int j = 0; j < i; ++j)
				if (array[j] > array[j + 1])
					swap(array, j, j + 1);
	}

	private void swap(int[] array, int indexA, int indexB) {
		int tmp = array[indexA];
		array[indexA] = array[indexB];
		array[indexB] = tmp;
	}
}
