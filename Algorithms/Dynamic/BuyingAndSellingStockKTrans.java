package Algorithms.Dynamic;

public class BuyingAndSellingStockKTrans {

    /** 
    The below is the O(n3) solution.
    */
    public static int maxProfit(int k, int[] prices) {
        /**
         * rows will denote the no of transactions 
         * cols will denote the days and their corresponding stock prices .  
         */
        int n = prices.length;
        if(n==0 || n==1) return 0;
        int[][] dp = new int[k+1][n];// create a dp matrix. initialized at k+1 because 
        for(int t=1;t<=k;t++){ // t means transactions 
            for(int d=1;d<n;d++){  // d means days 
                int max = dp[t][d-1];// at d-1 day all t transaction happened so that is considered 
                for(int pd=0;pd<d;pd++){
                // loop will check if at t-1 transaction and cuurent day and that day transaction which will be the tth transaction 
                    // prices[d]-prices[pd] means tth transaction 
                    // dp[t-1][pd] means (t-1)th transaction 
                    // both addition will give the actual t transactions value .
                    max = Math.max(prices[d]-prices[pd]+dp[t-1][pd],max);
                }
                dp[t][d] = max;
            }
        }
        
        return dp[k][n-1];
    }


    /** 
    The below is the O(n2 ) solution.
    */
    public static int maxProfitnsquare(int k, int[] prices) {
        /**
         * rows will denote the no of transactions 
         * cols will denote the days and their corresponding stock prices .  
         */
        int n = prices.length;
        if(n==0 || n==1) return 0;
        int[][] dp = new int[k+1][n];// create a dp matrix. initialized at k+1 because 
        for(int t=1;t<=k;t++){ // t means transactions 
            int max = Integer.MIN_VALUE;
            for(int d=1;d<n;d++){  // d means days 
                max = Math.max(max,dp[t-1][d-1]-prices[d-1]); // maintain the max while going ahead in 
                // column and use that to check with prev day tth transaction.
                dp[t][d] = Math.max(dp[t][d-1],max+prices[d]);
            }
        }
        
        return dp[k][n-1];
    }
    public static void main(String[] args) {
         
    }
    
}
