package Algorithms.Dynamic;
import java.util.*;
/**Minimum multiplication cost to multiply series of matrices 
 * 
 */
public class MatrixChainMultiplication {

    /**Recursive Memoization solution 
     * Tc = O(n*n*n)
     * Sc = O(n*n) O(n)
     */
    public static int helper(int i, int j, int[] arr,int[][] dp){
        if(i == j)
            return 0;
        int mini = Integer.MAX_VALUE;
        if(dp[i][j] != -1)
            return dp[i][j];
        for(int k=i;k<j;k++){
            int count = helper(i,k,arr,dp)+helper(k+1,j,arr,dp)+arr[i-1]*arr[k]*arr[j];
            mini = Math.min(mini,count);
        }
        return dp[i][j] = mini;
    }

    /**Tabulation Method
     * Tc = O(n*n*n)
     * Sc = O(n*n)
     * Gap method
     */
    public static int matrixMultiplication(int[] arr , int N) {
		// Write your code here
        
        int[][] dp = new int[N][N];
        for(int[] ele : dp)
            Arrays.fill(ele,Integer.MAX_VALUE);

        N = N-1;
  		for(int g=0;g<N;g++){
            for(int i=0,j=g;j<N;i++,j++){
                if(g == 0){
                    dp[i][j] = 0;
                }else if(g == 1){
                    dp[i][j] = arr[i]*arr[j]*arr[j+1];
                }else{
                    for(int k=i;k<j;k++){
                        int count = dp[i][k]+dp[k+1][j]+arr[i]*arr[k+1]*arr[j+1];
                        dp[i][j] = Math.min(dp[i][j],count);
                    }
                }
            }
        }
        return dp[0][N-1];
	}

    public static int main(String[] args) {

        int N = 4;
        int[] arr = {1,2,3,4};
        int[][] dp = new int[N][N];
        for(int[] ele : dp)
            Arrays.fill(ele,-1);
        return helper(1,N-1,arr,dp);
        
    }
    
}
