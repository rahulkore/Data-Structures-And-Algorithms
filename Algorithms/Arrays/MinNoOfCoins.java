package Algorithms.Arrays;

import java.util.Arrays;

/**
 * Find Minimum no of coins to make a value 
 */
public class MinNoOfCoins {

    /** Greedy Approach  */
    /** The time complexity of the above solution is exponential. 
     * If we draw the complete recursion tree, we can observe that many subproblems 
     * are solved again and again. For example, when we start from V = 11, 
     * we can reach 6 by subtracting one 5 times and by subtracting 5 one time. 
     * So the subproblem for 6 is called twice.  */

     /**Tc = exponential */
    // m is size of coins array (number of different coins
    static int minCoins(int coins[], int m, int V)
    {
       // base case
       if (V == 0) return 0;
       // Initialize result
       int res = Integer.MAX_VALUE;
       // Try every coin that has smaller value than V
       for (int i=0; i<m; i++)
       {
         if (coins[i] <= V)
         {
             int sub_res = minCoins(coins, m, V-coins[i]);
             // Check for INT_MAX to avoid overflow and see if
             // result can minimized
             if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res)
                res = sub_res + 1;
         }
       }
       return res;
    }

    /**Memoization approach */
    static int minCoins(int coins[], int m, int V,int[] dp)
    {
       if (V == 0) return 0;
       int res = Integer.MAX_VALUE;
        if(dp[V] != -1){
            return dp[V];
        }
       for (int i=0; i<m; i++)
       {
         if (coins[i] <= V)
         {
             int sub_res = minCoins(coins, m, V-coins[i],dp);
             if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res)
                res = sub_res + 1;
         }
       }
       return dp[V] = res;
    }

    /** Dynamic Solution */
    /** Tc = O(mV) */
    static int minCoinsDp(int coins[], int m, int V)
    {
        // table[i] will be storing
        // the minimum number of coins
        // required for i value. So
        // table[V] will have result
        int table[] = new int[V + 1];
        // Base case (If given value V is 0)
        table[0] = 0;
        // Initialize all table values as Infinite
        Arrays.fill(table,Integer.MAX_VALUE);
        // Compute minimum coins required for all
        // values from 1 to V
        for (int i = 1; i <= V; i++)
        {
            // Go through all coins smaller than i
            for (int j = 0; j < m; j++)
            if (coins[j] <= i)
            {
                int sub_res = table[i - coins[j]];
                if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i])
                       table[i] = sub_res + 1;    
            }    
        }
          if(table[V]==Integer.MAX_VALUE)
            return -1;
       
        return table[V];
         
    }

    public static void main(String[] args) {
        
    }
    
}
