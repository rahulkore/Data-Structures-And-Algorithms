package Algorithms.Dynamic;
import java.util.*;
/**This is a follow-up question to “Frog Jump” discussed in the previous article.
 *  In the previous question, the frog was allowed to jump either one or two steps at a time. 
 * In this question, the frog is allowed to jump up to ‘K’ steps at a time. If K=4, the frog 
 * can jump 1,2,3, or 4 steps at every index. */
public class FrogJumpKDist {

     /**Recursive memoization solution => Top Down approach => From answer to base case
     * Tc = O(n*k)
     * Sc = O(n)
    */
    static int solveUtil(int ind, int[] height, int[] dp, int k){
        if(ind==0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        
        int mmSteps = Integer.MAX_VALUE;
            
        for(int j=1;j<=k;j++){
            if(ind-j>=0){
           int jump = solveUtil(ind-j, height, dp, k)+ Math.abs(height[ind]- 
           height[ind-j]);
                mmSteps= Math.min(jump, mmSteps);
            }
        }
        return dp[ind]= mmSteps;
        
    }

    static int solve(int n, int[] height , int k){
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return solveUtil(n-1, height, dp, k);
    }

    /**Tabulation solution => Iterative => Bottom Up Approach
     * Tc = O(nk)
     * Sc = O(n)
    */
    static int solveUtilTable(int n, int[] height, int[] dp, int k){
        dp[0]=0;
        for(int i=1;i<n;i++){
            int mmSteps = Integer.MAX_VALUE;
            
            for(int j=1;j<=k;j++){
                if(i-j>=0){
                    int jump = dp[i-j]+ Math.abs(height[i]- height[i-j]);
                    mmSteps= Math.min(jump, mmSteps);
                }
            }
            dp[i]= mmSteps;
        }
        return dp[n-1];
        
    }
    
    static int solveTable(int n, int[] height , int k){
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return solveUtilTable(n, height, dp, k);
    }


    
    public static void main(String[] args) {

        int height[]={30,10,60 , 10 , 60 , 50};
        int n=height.length;
        int k=2;
        System.out.println(solve(n,height,k));
                
    }
    
}
