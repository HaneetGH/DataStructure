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

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
