package com.local;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by harsh on 2/6/17.
 */
/*
http://www.geeksforgeeks.org/find-a-pair-with-the-given-difference/
Examples:
Input: arr[] = {5, 20, 3, 2, 50, 80}, n = 78
Output: Pair Found: (2, 80)



http://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
*/

public class PairWithGivenDifference {
    public static void main(String[] args) {
         //   int arr[] = {1, 8, 30, 40, 100};
//        Integer arr[] = {5, 20, 3, 2, 50, 80}; // 2 3 5 20 50 80
        //int n = 78;
        Integer arr[] = {1, 8, 30, 40, 100};
        int n = 60;
        List<Integer> list = Arrays.asList(arr);
        Collections.sort(list);
 /*
         Wrong solution
        for (int i = 0,j=list.size()-1; (i < list.size() && j>0);) {
            if(list.get(j)-list.get(i) == n){
                System.out.println("Pair " + list.get(i) +  " " + list.get(j));
                break;
            }else if(list.get(j)-list.get(i) <n){
                i++;
            }else{
                j--;
            }
        }*/

        // Initialize positions of two elements
        int i = 0, j = 1;

        // Search for a pair
        while (i < list.size() && j < list.size())
        {
            if (i != j && list.get(j)-list.get(i) == n)
            {
                System.out.print("Pair Found: "+
                        "( "+list.get(i)+", "+ list.get(j)+" )");
                break;
            }
            else if (list.get(j) - list.get(i) < n)
                j++;
            else
                i++;
        }
    }


}
