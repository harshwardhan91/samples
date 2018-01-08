package com.local;

/**
 * http://www.geeksforgeeks.org/find-minimum-cost-buy-books/
 */
public class MinCostToBuyBooks {
    public static void main(String[] args) {
        int[] ratings = { 1, 6, 8, 3, 4, 1, 5, 7 };
        System.out.println(findMinCost(ratings));
    }

    private static int findMinCost(int[] ratings) {
        int[] lToRCost = new int[ratings.length];
        int[] rTolCost = new int[ratings.length];
        lToRCost[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if(ratings[i]>ratings[i-1]){
                lToRCost[i] = lToRCost[i-1]+1;
            }else{
                lToRCost[i] = 1;
            }
        }
        rTolCost[ratings.length-1] =1;
        for (int i = ratings.length-2; i >=0; i--) {
            if(ratings[i]>ratings[i+1]){
                rTolCost[i] = rTolCost[i+1]+1;
            }else{
                rTolCost[i] = 1;
            }
        }
        int sum = 0;
        for(int i =0;i <ratings.length;i++){
            sum += Utils.max(lToRCost[i],rTolCost[i]);
        }
        return sum;
    }
}
