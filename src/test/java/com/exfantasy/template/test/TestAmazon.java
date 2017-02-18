package com.exfantasy.template.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestAmazon {

	@Test
	public void testBasic() {
		RandomizedSet<Character> set = new RandomizedSet<>();
		for (char val = 'A'; val <= 'Z'; val++) {
			set.add(val);
		}
		for (char val = 'A'; val <= 'Z'; val++) {
			System.out.print(set.deleteRandom());
		}
		System.out.println();
		assertThat(0).isEqualTo(set.size());
		
		for (char val = 'A'; val <= 'Z'; val++) {
			set.add(val);
		}
		for (char val = 'A'; val <= 'Z'; val++) {
			System.out.print(set.delete(val));
		}
		System.out.println();
		assertThat(0).isEqualTo(set.size());
	}

	private class RandomizedSet<T> {

		private Map<T, Integer> valueIndexes;
		private List<T> values;
		private Random rand;

		public RandomizedSet() {
			valueIndexes = new HashMap<>();
			values = new ArrayList<>();
			rand = new Random(System.currentTimeMillis());
		}

		public void add(T value) {
			if (!contains(value)) {
				int lastIndex = values.size();
				valueIndexes.put(value, lastIndex);
				values.add(value);
			}
		}

		public boolean contains(T value) {
			if (value == null) {
				throw new NullPointerException();
			}
			return valueIndexes.containsKey(value);
		}

		@SuppressWarnings("unused")
		public T getRandom() {
			if (valueIndexes.isEmpty()) {
				throw new NoSuchElementException();
			}
			int randomIndex = rand.nextInt(values.size());
			return values.get(randomIndex);
		}

		public T deleteRandom() {
			if (valueIndexes.isEmpty()) {
				throw new NoSuchElementException();
			}
			int randomIndex = rand.nextInt(values.size());
			return deleteValue(randomIndex);
		}

		public T delete(T value) {
			if (!contains(value)) {
				throw new NoSuchElementException();
			}
			int index = valueIndexes.get(value);
			return deleteValue(index);
		}

		private T deleteValue(int currentIndex) {
			// remove the current element in the array, swap with the last,
			// and update the new index value in the map.
			T currentValue = values.get(currentIndex);
			int lastIndex = values.size() - 1;
			T lastVal = values.get(lastIndex);
			Collections.swap(values, currentIndex, lastIndex);
			// removing the last element is constant
			values.remove(lastIndex);
			valueIndexes.put(lastVal, currentIndex);
			valueIndexes.remove(currentValue);
			return currentValue;
		}

		public int size() {
			if (values.size() != valueIndexes.size()) {
				// should never happen.
				throw new IllegalStateException();
			}
			return values.size();
		}
	}
}