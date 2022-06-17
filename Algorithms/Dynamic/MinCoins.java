package Algorithms.Dynamic;

public class MinCoins {


    /**Recursive solution  
     * Time Complexity: O(N*T)
     * Space Complexity: O(N*T) + O(N)
    */
    static int minimumElementsUtil(int[] arr, int ind, int T, int[][] dp){

        if(ind == 0){
            if(T%arr[0] == 0) return T/arr[0];
            else return (int)Math.pow(10,9);
        }
        
        if(dp[ind][T]!=-1)
            return dp[ind][T];
            
        int notTaken = 0 + minimumElementsUtil(arr,ind-1,T,dp);
        
        int taken = (int)Math.pow(10,9);
        if(arr[ind] <= T)
            taken = 1 + minimumElementsUtil(arr,ind,T-arr[ind],dp);
            
        return dp[ind][T] = Math.min(notTaken,taken);
    }

    static int minimumElements(int[] arr, int T){
    
        int n= arr.length;
        
        int[][] dp=new int[n][T+1];
        
        for(int row[]: dp)
        Arrays.fill(row,-1);
        
        int ans =  minimumElementsUtil(arr, n-1, T, dp);
        if(ans >= (int)Math.pow(10,9)) return -1;
        return ans;
    }

    /**Tabulation method
     * Time Complexity: O(N*T)
     * Space Complexity: O(N*T)
     */

    static int minimumElementsTabulation(int[] arr, int T){
    
        int n= arr.length;
        
        int dp[][]=new int[n][T+1];
        
        for(int i=0; i<=T; i++){
            if(i%arr[0] == 0)  
                dp[0][i] = i/arr[0];
            else dp[0][i] = (int)Math.pow(10,9);
        }
        
        for(int ind = 1; ind<n; ind++){
            for(int target = 0; target<=T; target++){
                
                int notTake = 0 + dp[ind-1][target];
                int take = (int)Math.pow(10,9);
                if(arr[ind]<=target)
                    take = 1 + dp[ind][target - arr[ind]];
                    
                 dp[ind][target] = Math.min(notTake, take);
            }
        }
        
        int ans = dp[n-1][T];
        if(ans >=(int)Math.pow(10,9)) return -1;
        return ans;
    }

    /**Space Optimized approach
     * Time Complexity: O(N*T)
     * Space Complexity: O(T)
     */
    static int minimumElements(int[] arr, int T){
    
        int n= arr.length;
        
        int prev[]=new int[T+1]; 
        int cur[] =new int[T+1];
        
        for(int i=0; i<=T; i++){
            if(i%arr[0] == 0)  
                prev[i] = i/arr[0];
            else prev[i] = (int)Math.pow(10,9);
        }
        
        for(int ind = 1; ind<n; ind++){
            for(int target = 0; target<=T; target++){
                
                int notTake = 0 + prev[target];
                int take = (int)Math.pow(10,9);
                if(arr[ind]<=target)
                    take = 1 + cur[target - arr[ind]];
                    
                 cur[target] = Math.min(notTake, take);
            }
            prev = cur;
        }
        
        int ans = prev[T];
        if(ans >=(int)Math.pow(10,9)) return -1;
        return ans;
    }
    public static void main(String[] args) {

        int arr[] ={1,2,3};
        int T=7;
                                 
        System.out.println("The minimum number of coins required to form the target sum is 
        "+minimumElements(arr,T));
        
    }
    
}

