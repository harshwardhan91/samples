package com.local;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/minimize-the-maximum-difference-between-the-heights/
 */
public class MinMaxDiffBetweenHeights {
    public static void main(String[] args) {
        int arr[] = {1, 5, 15, 10} ;
        int a = result(arr,3);
    }


    private static int result(int[] a,int k){
        Arrays.sort(a);
        int l = a.length;
        int md = a[l-1] - a[0];
        int sm = a[0] +k;
        int bg = a[l-1]-k;
        if(sm>bg){
            int t = sm;
            sm = bg;
            bg = t;
        }
        for (int i = 1; i < a.length-1; i++) {
            int s = a[i]-k;
            int c = a[i]+k;
            if(s>=sm || c <= bg){
                continue;
            }
            if(bg - s <= c-sm){
                sm = s;
            }else{
                bg = c;
            }
        }
        return Utils.min(md,bg-sm);
    }
    private static int findMinMaxDiff(int[] arr, int k) {
        int h = 0;
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>max){
                max  = arr[i];
                h = i;
            }
        }
        int l = 0;
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]<min){
                min  = arr[i];
                l = i;
            }
        }

        int md = max - min;
        for (int i = 0; i < arr.length; i++) {
            if(i==l){
                int a = arr[i] + k;
                if(a>max){
                    md = a-arr[h];
                    l=h;
                    h = i;
                    arr[i] = a;
                    max = arr[i];
                }else{
                    arr[i] = a;
                    md = max - arr[i];
                    min =arr[i];
                }
            }else if (i ==h){
                int d = arr[i] - k;
                if(d<min){
                    //md =
                }
            }
        }

        return 0;
    }
}
