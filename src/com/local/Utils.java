package com.local;

/**
 * Created by harsh on 2/6/17.
 */
public class Utils {
    public static void printArray(int[] arr){
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    public static int max(int a,int b){
        if(a>=b){
            return a;
        }
        return b;
    }
    public static int min(int a,int b){
        if(a>=b){
            return b;
        }
        return a;
    }
    public static int binarySearch(int[] ar, int l, int h,int k) {
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
