package com.local;

/**
 * http://www.geeksforgeeks.org/maximum-contiguous-circular-sum/
 */



public class MaxCircularSubArraySum {
    public static void main(String[] args) {
        int[] arr = new int[]{11, 10, -20, 5, -3, -5, 8, -13, 10};
        Utils.printArray(arr);
        System.out.println();
        int maxSubArraySum = maxSubArraySum(arr);
        System.out.println();
        int wrapSum = 0;
        for (int i = 0; i < arr.length; i++) {
            wrapSum += arr[i];
            arr[i] = -arr[i];
        }
        int maxWrapSum = wrapSum + maxSubArraySum(arr);

        System.out.println(maxWrapSum>maxSubArraySum?maxWrapSum:maxSubArraySum);

    }

    private static int maxSubArraySum(int[] arr){
        if(arr.length==0){
            return 0;
        }
        int maxSubArraySum = Integer.MIN_VALUE;
        int maxLocalSum = arr[0];
        for(int i = 1;i<arr.length;i++){
            maxLocalSum = maxLocalSum + arr[i];
            if(maxLocalSum<0){
                maxLocalSum = 0;
            }
            if(maxLocalSum>maxSubArraySum){
                maxSubArraySum = maxLocalSum;
            }
        }
        return maxSubArraySum;
    }
}
