/*
 * 28 August, 2025
 * PLACEMENT ARRAY 5
 * BestTimeToBuyAndSellStock.java
 * LeetCode 121: Best Time to Buy and Sell Stock
 * Problem link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * Optimized Approach (Explanation)

Keep track of the minimum price seen so far.

At each day, calculate profit if sold today: price - minPrice.

Keep the maximum profit encountered.

Works in O(n) time and O(1) space.
 */

import java.util.Scanner;

public class BestTimeToBuyAndSellStock_5 {

    // Brute Force Approach
    public static int maxProfitBruteForce(int[] prices) {
        int maxProfit = 0;
        int n = prices.length;

        for (int i = 0; i < n; i++) { // choose buy day
            for (int j = i + 1; j < n; j++) { // choose sell day
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }

    // Optimized Approach
    public static int maxProfitOptimized(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // update buying price
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice; // update max profit
            }
        }

        return maxProfit;
    }

    // Main method for user input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of days: ");
        int n = sc.nextInt();
        int[] prices = new int[n];

        System.out.println("Enter stock prices: ");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        System.out.println("Brute Force Max Profit: " + maxProfitBruteForce(prices));
        System.out.println("Optimized Max Profit: " + maxProfitOptimized(prices));
    }
}
