package com.local;

/**
 * Created by harsh on 2/7/17.
 */
/*
http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/
*/

public class SubsetSum {
    public static void main(String[] args) {
        int set[] ={10, 34, 4, 12, 5, 2};
        int sum = 10;
        int n = set.length;
       // if (isSubsetSum(set, n-1, sum) == true)
        if (isSubsetSum(set,  sum) == true)
            System.out.println("Found a subset with given sum");
        else
            System.out.println("No subset with given sum");
    }

    private static boolean isSubsetSum(int[] a, int i, int k) {
        if(k==0)
            return true;
        if(i==0 && a[i]==k)
            return true;
        if(i==0 && a[i] < k)
            return false;
        if(i==0 && a[i] > k)
            return false;
        if(k<a[i])
            return isSubsetSum(a,i-1,k);
        return isSubsetSum(a,i-1,k)|| isSubsetSum(a, i-1, k-a[i]);
    }

    private static boolean isSubsetSum(int a[],int k){
        boolean[][] dp = new boolean[k+1][a.length+1];
        for (int i = 0; i < a.length+1; i++) {
            dp[0][i] = true;
        }
        for(int i =1;i< k + 1 ;i++){
            dp[i][0] = false;
        }
        for (int i = 1; i < k+1; i++) {
            for(int j = 1;j<a.length+1;j++){
                if(i<a[j-1]){
                    dp[i][j]=dp[i][j-1];
                }else{
                    dp[i][j]=dp[i][j-1]||dp[i-a[j-1]][j-1];
                }
            }
        }
        printArray(dp);
        return dp[k][a.length];
    }
    public static void printArray(boolean matrix[][]) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }
}
