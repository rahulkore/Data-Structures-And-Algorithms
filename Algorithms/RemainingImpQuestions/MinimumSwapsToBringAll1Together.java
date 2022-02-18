package Algorithms.RemainingImpQuestions;
/**Given a binary array data, return the minimum number of swaps required to group all 1’s 
 * present in the array together in any place in the array.

 

Example 1:

Input: data = [1,0,1,0,1]
Output: 1
Explanation: There are 3 ways to group all 1's together:
[1,1,1,0,0] using 1 swap.
[0,1,1,1,0] using 2 swaps.
[0,0,1,1,1] using 1 swap.
The minimum is 1. */
public class MinimumSwapsToBringAll1Together {

    public int minSwaps(int[] nums) {
        if(nums.length < 3) return 0;
        int n = 0;
        for(int num: nums){
            if(num == 1) n++; // total number of 1s
        }
        int i=0, j=0, c=0, max=0; //sliding window i to j
        while(j < nums.length) {
            while(j < nums.length && j - i < n){ //until i to j == n or search is done
                if(nums[j++] == 1) c++;
            }
            max = Math.max(c, max); // max all the sliding window of which length equals to n
            if(j == nums.length) break;
            
            if(nums[i++] == 1) { //move i forward
                c--;
            }
        }
        return n - max; //this is the minimun swaps  
    }
    
}
