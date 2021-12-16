package Algorithms.Dynamic;
/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete at most two transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
 */
public class BuyingAndSellingStockTwoTransac {

    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        int min = prices[0];
        int max = prices[n-1];
        int profit[] = new int[n];
        int dpl[] = new int[n];
        int dpr[] = new int[n];
        
        /** 
        First transaction using the next max value
        */
        for(int i=n-2;i>=0;i--){
            max = Math.max(max,prices[i]);
            profit[i] = Math.max(profit[i+1],max-prices[i]); // single dp profit array
            dpl[i] = Math.max(dpl[i+1],max-prices[i]); // using two dp array
        }
        /** 
        Second transaction using the prev min value
        */
        for(int i=1;i<n;i++){
            min = Math.min(min,prices[i]);
            profit[i] = Math.max(profit[i-1],profit[i]+prices[i]-min); // single dp profit array
            dpr[i] = Math.max(dpr[i-1],prices[i]-min); // using two dp array
        }
        // for two dp array 
        int ans=0;
        for(int i=0;i<n;i++){
            ans = Math.max(ans,dpl[i]+dpr[i]);
        }
        return ans;
        //return profit[n-1]; // using single dp profit array 
    }
    public static void main(String[] args) {
        
    }
    
}
