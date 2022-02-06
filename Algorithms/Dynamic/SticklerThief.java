package Algorithms.Dynamic;
/**
 * Find maximum possible stolen value from houses
 * 
 * 
 * There are n houses build in a line, each of which contains some value in it. 
 * A thief is going to steal the maximal value of these houses, but he can’t steal
 *  in two adjacent houses because the owner of the stolen houses will tell his two neighbors 
 * left and right side. What is the maximum stolen value?
Examples: 
 

Input: hval[] = {6, 7, 1, 3, 8, 2, 4}
Output: 19

Explanation: The thief will steal 6, 1, 8 and 4 from the house.

Input: hval[] = {5, 3, 4, 11, 2}
Output: 16

Explanation: Thief will steal 5 and 11

 */
public class SticklerThief {
    //recursive approach 
    //Complexity Analysis

//Time Complexity:  O(2N). 
//Every element has 2 choices to pick and not pick

//Space Complexity: O(2N). A recursion stack space is required of size 2n, 
//so space complexity is O(2N).
    int maxLoot(int hval[], int n)
    {
        // base case
        if(n < 0){
                return 0 ;
        }
            
        if(n == 0){
                return hval[0] ;
        }
        //if current element is pick then previous cannot be picked
        int pick = hval[n] +  maxLoot(hval, n-2) ;
        //if current element is not picked then previous element is picked
        int notPick = maxLoot(hval, n-1)  ;
        
        // return max of picked and not picked
        return Math.max(pick, notPick) ;
    
    }



    //recursive dp  : Top down approach 
    /**
     * Time Complexity: O(n) . Only one traversal of original array is needed. 
     * So the time complexity is O(n)
Space Complexity:  O(n). Recursive stack space is required of size n, so space complexity is O(n).
     */
    int maxLoot(int hval[], int n, int dp[]){
   
        // base case
        if(n < 0){
                return 0 ;
        }
        if(n == 0){
                return hval[0] ;
        }
        // If the subproblem is already solved
        // then return its value
        if(dp[n] != -1 ){
               return dp[n] ;
        }
        
        //if current element is pick then previous cannot be picked
        int pick = hval[n] +  maxLoot(hval, n-2, dp) ;
        //if current element is not picked then previous element is picked
        int notPick = maxLoot(hval, n-1, dp)  ;
        
        // return max of picked and not picked
        return dp[n] = Math.max(pick, notPick) ;
     }

     /**
      * Method 3: Dynamic Programming : Bottom Up Approach

So the recursive solution can easily be devised. The sub-problems can be stored thus 
reducing the complexity and converting the recursive solution to a Dynamic programming problem.
Time Complexity: O(n)        . 
Only one traversal of original array is needed. So the time complexity is O(n)
Space Complexity: O(n)        . 
An array is required of size n, so space complexity is O(n).
      */

      static int maxLoot2(int hval[], int n)
      {
          if (n == 0)
          return 0;
          if (n == 1)
              return hval[0];
          if (n == 2)
              return Math.max(hval[0], hval[1]);
    
          // dp[i] represent the maximum value stolen
          // so far after reaching house i.
          int[] dp = new int[n];
    
          // Initialize the dp[0] and dp[1]
          dp[0] = hval[0];
          dp[1] = Math.max(hval[0], hval[1]);
    
          // Fill remaining positions
          for (int i = 2; i<n; i++)
              dp[i] = Math.max(hval[i]+dp[i-2], dp[i-1]);
    
          return dp[n-1];
      }


      /**
       * 
       * Further space optimization in dp 
       */

      static int maxLootspaceopt(int hval[], int n)
      {
          if (n == 0)
          return 0;
    
          int prev2 = hval[0];
          if (n == 1)
              return prev2;
    
          int prev = Math.max(hval[0], hval[1]);
          if (n == 2)
              return prev;
     
          // contains maximum stolen value at the end
          int max_val = 0;
    
          // Fill remaining positions
          for (int i=2; i<n; i++)
          {
              max_val = Math.max(hval[i]+prev2, prev);
              prev2 = prev;
              prev = max_val;
          }
    
          return max_val;
      }
    public static void main(String[] args) {
        
    }
    
}
