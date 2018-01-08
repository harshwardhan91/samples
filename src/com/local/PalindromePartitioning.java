package com.local;

/**
 * Created by harsh on 2/7/17.
 */
/*
a w w a a w a w
*/

public class PalindromePartitioning {
    public static void main(String[] args) {
//		char[] string = new char[]{'A','B','A','B','B','B','A','B','B','A','B','A','B','A'};
        char[] string = new char[]{'a','b', 'b', 'a', 'a', 'b', 'a', 'b'};
        boolean[][] dp = new boolean[string.length+1][string.length+1];

        for(int i =0;i<string.length+1;i++){
            dp[i][i] = true;
        }

        int n  = string.length+1;
        for(int L=2;L<n;L++){
            for(int i =1;i<n-L+1;i++){
                int j = i + L -1;
                if(L==2){
                    if(string[i]==string[j]){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = false;
                    }
                }else{
                    if(string[i]==string[j]){
                        dp[i][j] = true;
                        dp[i][j] = dp[i][j]&&dp[i+1][j-1];
                    }else{
                        dp[i][j] = false;
                    }
                }
            }
        }
    }
}
