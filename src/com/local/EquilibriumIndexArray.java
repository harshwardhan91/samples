package com.local;

/**
 * Created by harsh on 2/5/17.
 */
/*
http://www.geeksforgeeks.org/equilibrium-index-of-an-array/
Equilibrium index of an array is an index such that the sum of elements at lower indexes
is equal to the sum of elements at higher indexes. For example, in an arrya A:

 {-7, 1, 5, 2, -4, 3, 0};

A[0] = -7, A[1] = 1, A[2] = 5, A[3] = 2, A[4] = -4, A[5] = 3, A[6]=0

3 is an equilibrium index, because:
A[0] + A[1] + A[2] = A[4] + A[5] + A[6]

6 is also an equilibrium index, because sum of zero elements is zero, i.e., A[0] + A[1] + A[2] + A[3] + A[4] + A[5]=0

7 is not an equilibrium index, because it is not a valid index of array A.

Write a function int equilibrium(int[] arr, int n); that given a sequence arr[] of size n,
 returns an equilibrium index (if any) or -1 if no equilibrium indexes exist.
*/

public class EquilibriumIndexArray {
    public static void main(String[] args) {
        //int[] inp = {-7, 1, 5, 2, -4, 3, 0};
        int[] inp = {-7, 0, 0, 0, 4, 3, 0};
//        int[] inp = {7,-6,-1,7};
        int totalSum  = 0;
        for (int i = 0; i < inp.length; i++) {
            totalSum+=inp[i];
        }
        /*
        if(totalSum%2!=0) {
            System.out.println("No index " + -1);
        }
        int localSum = 0;
        for (int i = 0; i < inp.length; i++) {
            localSum+=inp[i];
            if(localSum==totalSum/2 || localSum > totalSum/2){
                System.out.println("Eq index " + i);
                break;
            }
        }*/

        int leftSum = 0;
        for (int i = 0; i < inp.length; i++) {
            totalSum -= inp[i];
            if(leftSum==totalSum) {
                System.out.println("Eq index " + i);
                break;
            }
            leftSum += inp[i];
        }


    }
}
