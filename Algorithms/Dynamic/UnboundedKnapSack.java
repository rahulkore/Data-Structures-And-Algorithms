package Algorithms.Dynamic;
/**
 * You are given ‘N’ items with certain ‘PROFIT’ and ‘WEIGHT’ and a knapsack with weight capacity 
 * ‘W’. You need to fill the knapsack with the items in such a way that you get the maximum profit.
 *  You are allowed to take one item multiple times.
For Example
Let us say we have 'N' = 3 items and a knapsack of capacity 'W' =  10
'PROFIT' = { 5, 11, 13 }
'WEIGHT' = { 2, 4, 6 }

We can fill the knapsack as:

1 item of weight 6 and 1 item of weight 4.
1 item of weight 6 and 2 items of weight 2.
2 items of weight 4 and 1 item of weight 2.
5 items of weight 2.

The maximum profit will be from case 3 i.e ‘27’. Therefore maximum profit = 27.
Input Format
The first line contains a single integer ‘T’ denoting the number of test cases.

The first line of each test contains two integers ‘N’ - number of elements in the array and 
‘W’ - Capacity of the knapsack.

The second line of each test case contains profiti - profit of the item at the ‘i-th’ index.

The third line of each test case contains weighti - weight of the item at the ‘i-th’ index
Output Format
For each test case, return an integer denoting the maximum profit that can be obtained by 
filling the knapsack.
Note:
You do not need to print anything; it has already been taken care of. Just implement the given
 function.
Constraints
1 <= T <= 50
1 <= N <= 10^3
1 <= W <= 10^3
1 <= PROFIT[ i ] , WEIGHT[ i ] <= 10^8

Time Limit: 1sec
Sample Input 1
2
3 15
7 2 4
5 10 20
2 3
6 12
4 17
Sample Output 1
21
0
Explanation Of Sample Input 1
Test Case 1:  The given knapsack capacity is 15. We can fill the knapsack as [5, 5, 5] and [10, 5]. 
We will get a maximum profit of 21.

Test Case 2: We can clearly see that no item has wait less than knapsack capacity. 
Therefore we can not fill knapsack with any item.
 */
public class UnboundedKnapSack {

    /**recursive approach 
     * Time Complexity: O(N*W)
     * Space Complexity: O(N*W) + O(N)
     */
    static int knapsackUtil(int[] wt,int[] val, int ind, int W,int[][] dp){

        if(ind == 0){
            return ((int)(W/wt[0])) * val[0];
        }
        
        if(dp[ind][W]!=-1)
            return dp[ind][W];
            
        int notTaken = 0 + knapsackUtil(wt,val,ind-1,W,dp);
        
        int taken = Integer.MIN_VALUE;
        if(wt[ind] <= W)
            taken = val[ind] + knapsackUtil(wt,val,ind,W-wt[ind],dp);
            
        return dp[ind][W] = Math.max(notTaken,taken);
    }
    
    
    static int unboundedKnapsack(int n, int W, int[] val,int[] wt) {
        
        int[][] dp=new int[n][W+1];
        for(int row[]: dp)
        Arrays.fill(row,-1);
        return knapsackUtil(wt, val, n-1, W, dp);
    }

    /**Tabulation approach 
     * Time Complexity: O(N*W)
     * Space Complexity: O(N*W)
     */
    static int unboundedKnapsack(int n, int W, int[] val,int[] wt) {
    
        int[][] dp=new int[n][W+1];
        
        //Base Condition
        
        for(int i=wt[0]; i<=W; i++){
            dp[0][i] = ((int) i/wt[0]) * val[0];
        }
        
        for(int ind =1; ind<n; ind++){
            for(int cap=0; cap<=W; cap++){
                
                int notTaken = 0 + dp[ind-1][cap];
                
                int taken = Integer.MIN_VALUE;
                if(wt[ind] <= cap)
                    taken = val[ind] + dp[ind][cap - wt[ind]];
                    
                dp[ind][cap] = Math.max(notTaken, taken);
            }
        }
        
        return dp[n-1][W];
    }
    
    /**Space optimized
     * Time Complexity: O(N*W)
     * Space Complexity: O(W)
     */
    static int unboundedKnapsack(int n, int W, int[] val,int[] wt) {
    
        int cur[]=new int[W+1];
        
        //Base Condition
        
        for(int i=wt[0]; i<=W; i++){
            cur[i] = ((int)i/wt[0]) * val[0];
        }
        
        for(int ind =1; ind<n; ind++){
            for(int cap=0; cap<=W; cap++){
                
                int notTaken = cur[cap];
                
                int taken = Integer.MIN_VALUE;
                if(wt[ind] <= cap)
                    taken = val[ind] + cur[cap - wt[ind]];
                    
                cur[cap] = Math.max(notTaken, taken);
            }
        }
        
        return cur[W];
    
    }
    public static void main(String[] args) {

        nt wt[] = {2,4,6};
        int val[] = {5,11,13};
        int W=10;
        
        int n = wt.length;
                                        
        System.out.println("The Maximum value of items, thief can steal is 
        "+unboundedKnapsack(n,W,val,wt));
        
    }
    
}
