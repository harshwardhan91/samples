package com.local;

/**
 * Created by harsh on 2/5/17.
 */

/*
The cost of a stock on each day is given in an array,
find the max profit that you can make by buying and selling in those days.
 For example, if the given array is {100, 180, 260, 310, 40, 535, 695},
 the maximum profit can earned by buying on day 0, selling on day 3.
 Again buy on day 4 and sell on day 6.
 If the given array of prices is sorted in decreasing order,
 then profit cannot be earned at all.

 http://code.geeksforgeeks.org/NT9qa8
*/

public class StockBuySellMultipleTimes {
    public static void main(String[] args) {
        //int[] arr = new int[]{100, 180, 260, 310, 40, 535, 695};
        //int[] arr = new int[]{7,1,3,2,9,2,5,4,2,100};
        int[] arr = new int[]{ 200, 210,200,275,275,275};
        int totalProfit = 0;
        int localMinima = 0;
        int localMaxima = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>=arr[i-1]){
                localMaxima =i;
            }else{
                if(localMaxima>localMinima) {
                    totalProfit += arr[localMaxima] - arr[localMinima];
                    System.out.println("Buy on " + localMinima + " Sell on " + localMaxima + " Profit gain " +
                            (arr[localMaxima] - arr[localMinima]));
                }
                localMinima = i;
            }
        }
        System.out.println("Buy on " + localMinima + " Sell on " + localMaxima + " Profit gain " +
                (arr[localMaxima] - arr[localMinima]));
        totalProfit += arr[localMaxima] - arr[localMinima];
        System.out.println("Total profit " + totalProfit);
    }
}
