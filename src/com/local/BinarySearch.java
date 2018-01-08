package com.local;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        //int[] ar = { 1, 6, 8, 3, 4,  5, 7 };
        int[] ar = { 2,3,4,10,40};
        System.out.println(search(ar,2));
    }

    private static int search(int[] ar,int k) {
        Arrays.sort(ar);

        return binarySearch(ar,0,ar.length-1,k);
    }

    private static int binarySearch(int[] ar, int l, int h,int k) {
        if(h>=l){
            int m = (l+h)/2;
            if(ar[m]==k){
                return m;
            }else if(ar[m]>=k){
                return binarySearch(ar,l,m-1,k);
            }else{
                return binarySearch(ar,m+1,h,k);
            }
        }
        return -1;
    }
}
