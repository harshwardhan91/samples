package com.local;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
 */
public class CuttingRod {
    public static void main(String[] args) {
        int[] arr = {3 ,  5,   8 ,  9,  10 , 17 , 17 , 20};//{1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(""+getMaxPriceCuttingRod(arr));
    }

    private static int getMaxPriceCuttingRod(int[] arr) {
        if(arr == null || arr.length ==0){
            return 0;
        }
        int[] tmp = new int[arr.length+1];
        int l = arr.length + 1;
        tmp[0] = 0;
        for (int i = 1; i < l; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                max = Utils.max(max,arr[j] + tmp[i-j-1]);
            }
            tmp[i] = max;
        }
        return tmp[l-1];
    }
}
