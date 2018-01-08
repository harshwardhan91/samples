package com.local;
/*
    http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
 */
public class MinJumpToReachEnd {

    public static void main(String[] args) {
        int arr[] ={1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};// {1, 3, 6, 1, 0, 9};//{1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
        System.out.println(countMinJumps(arr) + "");
    }

    private static int countMinJumps(int[] arr) {
        int[] tmp = new int[arr.length];

        tmp[0] = 0;
        for (int i = 1; i < tmp.length; i++) {
            tmp[i] = Integer.MAX_VALUE;
        }

        for(int i =1;i<arr.length;i++){
            for(int j=0;j<i;j++) {
                if(j+arr[j] >= i && tmp[i]>(tmp[j]+1)) {
                    tmp[i] = tmp[j] + 1;
                }
            }
        }

        return tmp[arr.length-1];
    }
}
