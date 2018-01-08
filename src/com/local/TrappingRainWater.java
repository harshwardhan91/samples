package com.local;

/**
 * http://www.geeksforgeeks.org/trapping-rain-water/
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int a[] = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] lMaxArr = new int[a.length];
        int[] rMaxArr = new int[a.length];
        int localMax = a[0];
        lMaxArr[0] = localMax;
        for (int i = 1; i < a.length; i++) {
            if(a[i]>localMax){
                localMax = a[i];
            }
            lMaxArr[i] = localMax;
        }
        Utils.printArray(lMaxArr);
        int size = a.length;
        localMax = a[size-1];
        rMaxArr[size-1] = localMax;
        for (int i = size-1; i >= 0; i--) {
            if(a[i]>localMax){
                localMax = a[i];
            }
            rMaxArr[i] = localMax;
        }
        Utils.printArray(rMaxArr);

        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            sum += lMaxArr[i]>rMaxArr[i]?rMaxArr[i]-a[i]:lMaxArr[i]-a[i];
        }
        System.out.println();
        System.out.println(sum);

    }
}
