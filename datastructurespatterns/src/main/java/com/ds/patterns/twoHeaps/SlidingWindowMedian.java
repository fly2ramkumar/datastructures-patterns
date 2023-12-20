package com.ds.patterns.twoHeaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindowMedian {

	private static List<Double> findMedian(List<Integer> inputList, int windowSize) {

		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> a - b);

		List<Double> medianList = new ArrayList<>();

		int windowStart = 0;

		for (int windowEnd = 0; windowEnd < inputList.size(); windowEnd++) {

			int currentElement = inputList.get(windowEnd);

			if (maxHeap.isEmpty() || maxHeap.peek() >= currentElement) {
				maxHeap.add(inputList.get(windowEnd));
			} else {
				minHeap.add(inputList.get(windowEnd));
			}

			rebalanceHeaps(maxHeap, minHeap);

			if (windowEnd >= windowSize - 1) {

				if (maxHeap.size() == minHeap.size()) {
					medianList.add(maxHeap.peek() / 2.0 + minHeap.peek() / 2.0);

				} else {
					medianList.add(Double.parseDouble(maxHeap.peek().toString()));
				}

				if (inputList.get(windowStart) <= maxHeap.peek()) {

				}

				int elementToBeRemoved = inputList.get(windowStart);

				if (elementToBeRemoved <= maxHeap.peek()) {
					maxHeap.remove(elementToBeRemoved);
				} else {
					minHeap.remove(elementToBeRemoved);
				}

				rebalanceHeaps(maxHeap, minHeap);

				windowStart++;
			}
		}

		return medianList;
	}

	private static void rebalanceHeaps(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
		if (maxHeap.size() > minHeap.size() + 1) {
			minHeap.add(maxHeap.poll());

		} else if (maxHeap.size() < minHeap.size()) {
			maxHeap.add(minHeap.poll());
		}
	}

	// Modified for educative
	public static double[] medianSlidingWindow(int[] nums, int k) {

		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> a - b);

		double[] result = new double[nums.length - k + 1];
		int resultCount = 0;

		int windowStart = 0;

		for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {

			int currentElement = nums[windowEnd];

			if (maxHeap.isEmpty() || maxHeap.peek() >= currentElement) {
				maxHeap.add(currentElement);
			} else {
				minHeap.add(currentElement);
			}

			rebalanceHeaps(maxHeap, minHeap);

			if (windowEnd >= k - 1) {

				if (maxHeap.size() == minHeap.size()) {
					result[resultCount++] = maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;

				} else {
					result[resultCount++] = Double.parseDouble(maxHeap.peek().toString());
				}
				
				int elementToBeRemoved = nums[windowStart];

				if (elementToBeRemoved <= maxHeap.peek()) {
					maxHeap.remove(elementToBeRemoved);
				} else {
					minHeap.remove(elementToBeRemoved);
				}

				rebalanceHeaps(maxHeap, minHeap);

				windowStart++;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		List<Integer> inputList = Arrays.asList(1, 2, -1, 3, 5);
		System.out.println(findMedian(inputList, 2).toString());
	}

}
