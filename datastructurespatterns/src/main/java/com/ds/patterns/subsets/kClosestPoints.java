package com.ds.patterns.subsets;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getDistanceFromOrigin() {
		return (x * x) + (y * y);
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
}

public class kClosestPoints {

	private static List<Point> find(Point[] point, int k) {

		PriorityQueue<Point> maxHeap = new PriorityQueue<Point>(
				(a, b) -> b.getDistanceFromOrigin() - a.getDistanceFromOrigin());

		for (int i = 0; i < k; i++) {
			maxHeap.add(point[i]);
		}

		for (int i = k; i < point.length; i++) {

			if (point[i].getDistanceFromOrigin() < maxHeap.peek().getDistanceFromOrigin()) {
				maxHeap.poll();
				maxHeap.add(point[i]);
			}
		}

		return new ArrayList<Point>(maxHeap);
	}

	public static void main(String[] args) {

		Point[] point = new Point[] { new Point(1, 2), new Point(1, 3) };
		System.out.println(find(point, 1).toString());

		point = new Point[] { new Point(1, 3), new Point(3, 4), new Point(2, -1) };
		System.out.println(find(point, 2).toString());

	}

}
