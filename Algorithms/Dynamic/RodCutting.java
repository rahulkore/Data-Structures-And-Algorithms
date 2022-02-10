package Algorithms.Dynamic;
import java.util.*;
/**Given a rod of length ‘N’ units. The rod can be cut into different sizes and each 
 * size has a cost associated with it. Determine the maximum cost obtained by cutting
 *  the rod and selling its pieces.
Note:
1. The sizes will range from 1 to ‘N’ and will be integers.

2. The sum of the pieces cut should be equal to ‘N’.

3. Consider 1-based indexing. */
public class RodCutting {

    /**Recursive Memoization method
     * Tc = O(n*n)
     * Sc = O(n) + O(n)
     */
    public static int helper(int ind, int[] np,int[] dp){
        if(ind == 0){
            return 0;
        }
        if(ind == 1){
            return np[1];
        }
        if(dp[ind] != -1){
            return dp[ind];
        }
        int l = 1;
        int r = ind-1;
        int cost = np[ind];
        while(l<=r){
            cost = Math.max(cost,helper(l,np,dp)+helper(r,np,dp));
            l++;
            r--;
        }
        return dp[ind] = cost;
    }

    public static int cutRod(int price[], int n) {
		// Write your code here.
        int[] np = new int[n+1];
        for(int i=0;i<n;i++){
            np[i+1] = price[i];
        }
        int dp[] = new int[np.length];
        Arrays.fill(dp,-1);
        return helper(np.length-1,np,dp);
    }

    /**Tabulation method 
     * Tc = O(n*n)
     * Sc = O(n)
     */
    public static int cutRodTabulation(int price[], int n) {
		// Write your code here.
        int[] np = new int[n+1];
        for(int i=0;i<n;i++){
            np[i+1] = price[i];
        }
        int dp[] = new int[np.length];
        dp[0] = 0;
        dp[1] = np[1];
        for(int i=2;i<np.length;i++){
            dp[i] = np[i];
            int l = 1;
            int r = i-1;
            while(l<=r){
                dp[i] = Math.max(dp[i],dp[l]+dp[r]);
                l++;
                r--;
            }
        }
        return dp[np.length-1];
	}

    public static void main(String[] args) {
        
    }
    
}
