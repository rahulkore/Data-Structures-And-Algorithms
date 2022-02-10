package Algorithms.Dynamic;
import java.util.*;
/**You are given k identical eggs and you have access to a building with n floors labeled 
 * from 1 to n.

You know that there exists a floor f where 0 <= f <= n such that any egg dropped at a floor 
higher than f will break, and any egg dropped at or below floor f will not break.

Each move, you may take an unbroken egg and drop it from any floor x (where 1 <= x <= n). 
If the egg breaks, you can no longer use it. However, if the egg does not break, you may 
reuse it in future moves.

Return the minimum number of moves that you need to determine with certainty what the value 
of f is.

 

Example 1:

Input: k = 1, n = 2
Output: 2
Explanation: 
Drop the egg from floor 1. If it breaks, we know that f = 0.
Otherwise, drop the egg from floor 2. If it breaks, we know that f = 1.
If it does not break, then we know f = 2.
Hence, we need at minimum 2 moves to determine with certainty what the value of f is.
 */
public class EggDropping {

    /**Recursive memoization solution
     * Tc = O(n*2logn)
     * Sc = O(n*2) + O(n)
     */

    public int solve(int e, int f,int[][] dp){
        if(f==1 || f==0 || e==1)
            return f;
        
        if(dp[e][f] != -1)
            return dp[e][f];
        int l=1, r= f;
        int min= Integer.MAX_VALUE;
        while(l<=r)
        {
            int k = (l+r)/2; //here k is the middle floor
                
            // if egg breaks when dropped from the kth floor, 
            //then its sure that the egg will break 
            //if dropped from floors above k then we check for floors below k
            // i.e. we go down
                int down = solve(e-1, k-1,dp); 
            
            // if egg does not break when dropped from the kth floor, 
            //then its sure that the egg will not break 
            //if dropped from floors below k then we check for floors above k
            // i.e. we go up
                int up = solve(e, f-k,dp);
            
            int temp=1+Math.max(down,up);
            //adding one because we have used 1 attempt and max of up and down because
            //we need worst case attempts from both
            
            if(down < up)
                l= k+1;
            else
                r= k-1;
        
             min = Math.min(temp, min); //min because we have to find the min no. of moves   
            }
        return dp[e][f]=min;  
    }

    public int superEggDropMemoization(int egg, int n) {
        
        int[][] dp = new int[egg+1][n+1];
        for(int[] ele : dp)
            Arrays.fill(ele,-1);
        return solve(egg,n,dp);
    }

    /**Tabulation method 
     * Tc = O(n*2logn)
     * Sc = O(n*2)
    */

    public int superEggDropTabulation(int egg, int n) {
        
        int[][] dp = new int[egg+1][n+1];
        for(int e=1;e<dp.length;e++){
            for(int f=0;f<dp[0].length;f++){
                if(f==1 || f==0 || e==1){
                    dp[e][f] = f;
                }else{
                    int l=1;
                    int r=f;
                    int min= Integer.MAX_VALUE;
                    while(l<=r)
                    {
                        int k = (l+r)/2; //here k is the middle floor
                        int down = dp[e-1][k-1]; 
                        int up = dp[e][f-k];
                        int temp=1+Math.max(down,up);
                        if(down < up)
                            l= k+1;
                        else
                            r= k-1;
                         min = Math.min(temp, min); //min because we have to find the min no. of moves   
                    }
                    dp[e][f] = min;
                }
            }
        }
        return dp[egg][n];
    }

    /**Tabulation method 
     * Tc = o(n*3)
     * Sc = O(n*2)
     */
    public int superEggDrop(int k, int n) {
        
        int[][] dp = new int[k+1][n+1];
        
        for(int e=1;e<dp.length;e++){
            for(int f=0;f<dp[0].length;f++){
                if(f==1 || f==0){
                    dp[e][f] = f;
                }else if(e==1){
                    dp[e][f] = f;
                }else{
                    int mini = Integer.MAX_VALUE;
                    for(int z=0;z<f;z++){
                        int maxi = Math.max(dp[e-1][z],dp[e][f-z-1]);
                        mini = Math.min(mini,maxi);
                    }
                    dp[e][f] = mini+1;
                }
            }
        }
        return dp[k][n];
    }

    public static void main(String[] args) {
        
    }
    
}
