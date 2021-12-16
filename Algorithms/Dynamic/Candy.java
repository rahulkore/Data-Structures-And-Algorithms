package Algorithms.Dynamic;
/**
 * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.

 

Example 1:

Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.
 */
public class Candy {

    /**
     * Tc = O(n)
     * Sc = O(2n)
     * In the below method we use the left array to store the candy value based on left candidate
     * And right array to store the candy values based on the right candidate 
     * And then calc the answer based upon whichever is the maximum .
     * @param ratings
     * @return
     */

    public int candyLeftRifht(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        left[0] = 1;
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i - 1]){
                left[i] = left[i-1] + 1;
            }
            else{
                left[i] = 1;
            }
        }
        right[right.length - 1] = 1;
        for(int i = ratings.length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1]){
                right[i] = right[i+1] + 1;
            }else{
                right[i]=1;
            }
        }
        int ans = 0;
        for(int i = 0; i < ratings.length; i++)
            ans += Math.max(right[i],left[i]);
        return ans;
    }

    /**
     * Tc = O(n)
     * Sc = O(n)
     * In the below method we use the dp array to accomplish the same results of left and right array
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int[] dp = new int[ratings.length];
        dp[0]=1;
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i - 1]){
                dp[i] = dp[i - 1] + 1;
            }
            else{
                dp[i] = 1;
            }
        }
        for(int i = ratings.length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1]){
                dp[i] = Math.max(dp[i + 1] + 1,dp[i]);
            }
        }
        int ans = 0;
        for(int i = 0; i < ratings.length; i++)
            ans += dp[i];
        return ans;
    }
    public static void main(String[] args) {
        
    }
    
}
