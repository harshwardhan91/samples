package com.local;

/**
 * http://www.geeksforgeeks.org/nearly-sorted-algorithm/
 */
public class SortNearKSortedArray {
    public static void main(String[] args) {
        int[] a = new int[]{20, 2, 6, 9, 15, 29, 24};
        int k = 4;
        MinHeap h = new MinHeap(k);
        for(int i =0;i<k;i++){
            h.insert(a[i]);
        }
        for (int i = 0;i<a.length-k;i++){
            int currentMin = h.getMin();
            a[i] = currentMin;
            h.insert(a[i+k]);
        }
        for(int i = a.length-k;i<a.length;i++){
            a[i] = h.getMin();
        }
        Utils.printArray(a);
    }
}
