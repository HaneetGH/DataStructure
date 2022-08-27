package com.technorapper.datastructure.ds;

public class MaxProfitStock {

    public static int maxProfit(int[] pricesArray) {

        int max = 0;
        int min = Integer.MAX_VALUE;


        for (int price : pricesArray) {
            if (price < min) {
                min = price;
            } else {
                max = Math.max(max, price - min);
            }
        }
        return max;
    }


    static int maxProfit(int price[], int n, int k) {

        int profit[][] = new int[k + 1][n + 1];
        for (int i = 0; i <= k; i++)
            profit[i][0] = 0;
        for (int j = 0; j <= n; j++)
            profit[0][j] = 0;
        for (int i = 1; i <= k; i++) {
            int prevDiff = Integer.MIN_VALUE;
            for (int j = 1; j < n; j++) {
                prevDiff = Math.max(prevDiff,
                        profit[i - 1][j - 1] -
                                price[j - 1]);
                profit[i][j] = Math.max(profit[i][j - 1],
                        price[j] + prevDiff);
            }
        }
        return profit[k][n];
    }

    static int maxProfit(int prices[], int size)
    {

        // maxProfit adds up the difference between
        // adjacent elements if they are in increasing order
        int maxProfit = 0;

        // The loop starts from 1
        // as its comparing with the previous
        for (int i = 1; i < size; i++)
            if (prices[i] > prices[i - 1])
                maxProfit += prices[i] - prices[i - 1];
        return maxProfit;
    }
    public static void main(String[] args) {
        int price[] = { 6,5,3,7,1,4 };
        int n = price.length;
        System.out.println(maxProfit(price, n ));
    }
}
