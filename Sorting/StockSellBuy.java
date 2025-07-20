// Problem: 121. Best Time to Buy and Sell Stock (LeetCode)

//  My Approach:
//   I first attempted a brute-force solution using two nested loops (O(n^2) time complexity).
//   Although logically correct, it resulted in a Time Limit Exceeded (TLE) error for large inputs.
//   Then I explored the optimized greedy approach using a single pass (O(n) time) by tracking the minimum price so far.
//   This helped me efficiently calculate the max profit for each day with just one iteration.
//   Time Complexity: O(n)
//  Space Complexity: O(1)
import java.util.Scanner;

public class StockSellBuy {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[] prices = new int[n];
        System.out.println("Enter prices for each day:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        int result = maxProfit(prices);
        System.out.println("Maximum profit: " + result);

        
    }
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - minPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }

            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }

        return maxProfit;
    }

}

        

    

