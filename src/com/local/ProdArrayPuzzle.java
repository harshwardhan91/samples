package com.local;

/**
 * Created by harsh on 2/6/17.
 */
/*
http://www.geeksforgeeks.org/a-product-array-puzzle/
*/

public class ProdArrayPuzzle {

    static void printArray(int[] arr){
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
    public static void main(String[] args) {
        int a[] = {10, 3, 5, 6, 2};
        int prod = 1;
        int prodArr[] = new int[a.length];

        int i,j;
        for(i=0,j=a.length-1;(i<a.length && j>-1);i++,j--) {
            if(i<j){
                prodArr[i]=prod*a[j];
                prodArr[j]=prod*a[i];
                prod = a[i]*a[j]*prod;
            }else if(i>j){
                prodArr[i]=prod*prodArr[i];
                prodArr[j]=prod*prodArr[j];
                prod = a[i]*a[j]*prod;
            }else{
                prodArr[i]=prod;
                prod = a[i];
            }
            printArray(prodArr);
            System.out.println( " Prod " + prod);
        }
        System.out.println();
        for (int i1 : prodArr) {
            System.out.print(i1 + "\t");
        }
    }
}
