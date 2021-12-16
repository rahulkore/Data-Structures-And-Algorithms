package Algorithms.Arrays;
/**
 * Minimum swaps required to bring elements less than or equal to k together .
 */
public class MinimumSwapsToBringGoodElementsTogether {

    /**
     * we will use the sliding window technique
     * 
     */
    public static int minSwpas(int nums[], int k){
        int good = 0;
        int bad = 0;
        int ans = Integer.MAX_VALUE;
        for (int i : nums) {
            if(i <= k)
                good+=1;
        }
        for(int i=0;i<good;i++){
            if(nums[i]>k)
                bad+=1;
        }
        int i=0,j=good;
        ans = Math.min(ans, bad);
        while(j<nums.length){
            if(nums[i]>k) // if start of the window only was bad then decrease bad va;ie because in next 
            // window the start value will be removed
                bad--;
            if(nums[j]>k) // if the next element to enter in the window is a bad value then 
            //increase the bad value count because that element will be entering in the window
            // in the next iteration
                bad++;   
            ans = Math.min(ans, bad);         
            i++;
            j++;
        }
        return ans;
    }
    public static void main(String[] args) {
        int nums[] = {1,2,5,3,7,6};
        System.out.println(minSwpas(nums, 3 ));
    }
    
}
