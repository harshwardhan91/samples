package com.local;

public class CoinChangeDP {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(coinChange(arr,4) + " ");
    }

    private static int coinChange(int[] arr, int sum) {
        int len = arr.length;
        int[][] dp = new int[sum+1][len];
  /*      for(int i = 0;i<=sum;i++){
            dp[i][0] = 0;
        }*/
        for(int i = 1;i<=len;i++){
            dp[0][i] = 1;
        }
        for(int i = 1;i<=sum;i++){
            for(int j = 0;j<=len;j++){
                //dp[i][j] = dp[i][j-1] + dp[i][j-arr[j]];
                int x =  i- arr[j] >0?dp[i-arr[j]][j]:0; //including j
                int y = j>=1?dp[i][j-1]:0; //excluding j
                dp[i][j] = x + y;
            }
        }
        return dp[sum][len-1];
    }
}
/*
  1 2 3
0 1 1 1
1
2
3
4
*/
