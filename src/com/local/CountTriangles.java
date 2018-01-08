package com.local;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by harsh on 2/9/17.
 */
public class CountTriangles {
    public static void main(String[] args) {
        int arr[] = {10, 21, 22, 100, 101, 200, 300};
        System.out.println("Total number of triangles is " +
                findNumberOfTriangles(arr));
    }

    private static int findNumberOfTriangles(int[] arr) {
        int count = 0;
        int kk = 0;
      Arrays.sort(arr);
        for (int i = 0; i < arr.length-2; i++) {
           int k = i + 2;
           for(int j = i+1;j<arr.length;j++){
               while (k<arr.length&&arr[k]<arr[i]+arr[j]){
                   if(j!=k)
                    System.out.println(arr[i] + "\t" + arr[j] + "\t" + arr[k]);
                   k++;
                   kk++;
               }
               count += k-j-1;
           }
        }
        System.out.println(" kk " + kk);
        return count;
    }
}
