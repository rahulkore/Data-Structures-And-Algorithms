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

    /**Recursive Approach
     * Time Complexity: O(N*N)
     * Space Complexity: O(N*N) + O(N)
     */
    static int cutRodUtil(int[] price, int ind, int N,int[][] dp){

        if(ind == 0){
            return N*price[0];
        }
        
        if(dp[ind][N]!=-1)
            return dp[ind][N];
            
        int notTaken = 0 + cutRodUtil(price,ind-1,N,dp);
        
        int taken = Integer.MIN_VALUE;
        int rodLength = ind+1;
        if(rodLength <= N)
            taken = price[ind] + cutRodUtil(price,ind,N-rodLength,dp);
            
        return dp[ind][N] = Math.max(notTaken,taken);
    }
    
    
    static int cutRod(int[] price,int N) {
    
        
        int dp[][]=new int[N][N+1];
        for(int row[]:dp)
        Arrays.fill(row,-1);
        return cutRodUtil(price,N-1,N,dp);
    }

    /**Tabulation Approach 
     * Time Complexity: O(N*N)
     * Space Complexity: O(N*N)
     */
    static int cutRod(int[] price,int N) {


        int dp[][]=new int[N][N+1];
        
        for(int row[]:dp)
        Arrays.fill(row,-1);
        
        for(int i=0; i<=N; i++){
            dp[0][i] = i*price[0];
        }
        
        for(int ind=1; ind<N; ind++){
            for(int length =0; length<=N; length++){
            
                 int notTaken = 0 + dp[ind-1][length];
        
                 int taken = Integer.MIN_VALUE;
                 int rodLength = ind+1;
                 if(rodLength <= length)
                    taken = price[ind] + dp[ind][length-rodLength];
            
                 dp[ind][length] = Math.max(notTaken,taken);   
            }
        }
        
        return dp[N-1][N];
    }

    /**Space Optimized approach
     * Time Complexity: O(N*N)
     * Space Complexity: O(N)
     */
    static int cutRod(int[] price,int N) {

        int cur[]=new int[N+1];
        
        for(int i=0; i<=N; i++){
            cur[i] = i*price[0];
        }
        
        for(int ind=1; ind<N; ind++){
            for(int length =0; length<=N; length++){
            
                 int notTaken = 0 + cur[length];
        
                 int taken = Integer.MIN_VALUE;
                 int rodLength = ind+1;
                 if(rodLength <= length)
                    taken = price[ind] + cur[length-rodLength];
            
                 cur[length] = Math.max(notTaken,taken);   
            }
        }
        
        return cur[N];
    }

    /**Recursive Memoization method [binary way]
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

    /**Tabulation method [binary way]
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

        int price[] = {2,5,7,8,10};
  
        int n = price.length;
                                        
        System.out.println("The Maximum price generated is "+cutRod(price,n));
        
    }
    
}
