package app;

import java.util.*;

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new PointComparator());
        for (int[] point : points) {
            insertPoint(maxHeap, point, K);
        }

        int[][] closestPoints = new int[K][];
        for (int index = 0; index < K; index++) {
            closestPoints[index] = maxHeap.poll();
        }

        return closestPoints;
    }

    public void insertPoint(PriorityQueue<int[]> maxHeap, int[] point, int k) {
        if (maxHeap.size() < k) {
            maxHeap.add(point);
        } else {
            int[] kthPoint = maxHeap.peek();

            if (Double.compare(getDistanceFromOrigin(point), getDistanceFromOrigin(kthPoint)) < 0) {
                maxHeap.poll();
                maxHeap.add(point);
            }
        }
    }

    public double getDistanceFromOrigin(int[] array) {
        return Math.pow((array[0]), 2) + Math.pow((array[1]), 2);
    }
}

class PointComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] pointA, int[] pointB) {
        return Double.compare(Math.pow((pointB[0]), 2) + Math.pow((pointB[1]), 2),
                Math.pow((pointA[0]), 2) + Math.pow((pointA[1]), 2));
    }
}