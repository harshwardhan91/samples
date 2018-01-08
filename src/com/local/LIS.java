package com.local;

public class LIS {

    public static void main(String[] args) {
        int[] arr = {50, 3, 10, 7, 40, 80,3,4,1};//{3, 10, 2, 1, 20};//{ 10, 22, 9, 33, 21, 50, 41, 60,80 };
        System.out.println(getLIS(arr) + "");
    }

    private static int getLIS(int[] arr) {
        int len = arr.length;
        int[] lis = new int[len];
        for (int i = 0; i < len; i++) {
            lis[i] = 1;
        }
        for (int i = 0; i < len; i++) {
            for(int j= 0;j<i;j++){
                if(arr[i]>arr[j] && lis[i]<lis[j]+1){
                    lis[i] = lis[j] + 1;
                }
            }
        }
        int max = lis[0];
        for (int i = 1; i < lis.length; i++) {
            if(max<lis[i]) max = lis[i];
        }
        return max;
    }
}
