package com.local;

import static  com.local.Utils.max;
public class Knapsack01 {

    public static void main(String[] args) {
        int[] val = new int[]{60, 100, 120};
        int[] wt = new int[]{1, 2, 3};
        int  W = 5;
        System.out.println(knapsack(val,wt,W) + "");
    }

    private static int knapsack(int[] val, int[] wt, int W) {
        if(W==0){
            return 0;
        }

        int n = wt.length;
        int[][] K = new int[n+1][W+1];
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if(w == 0 || i ==0){
                    K[i][w] = 0;
                }else if(wt[i-1]<=w){
                    K[i][w] = max(val[i-1] +  K[i-1][w-wt[i-1]],  K[i-1][w]);
                }else{
                    K[i][w] = K[i-1][w];
                }
                System.out.print(K[i][w]+"\t");
            }
            System.out.println();
        }
        return K[n][W];
    }
}
