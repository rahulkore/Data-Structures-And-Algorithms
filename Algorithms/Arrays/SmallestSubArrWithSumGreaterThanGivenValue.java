package Algorithms.Arrays;
/**
 * In this problem we have to give the smallest sub array 
 * with sum greater than the given value 
 */
public class SmallestSubArrWithSumGreaterThanGivenValue {

    /**
     * Tc = O(n2)
     * Sc = O(1)
     * run normal two loops and check if greater sum found then store the length
     * @param nums
     * @param k
     * @return
     */
    public static int naiveApproach(int[] nums, int k){
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int s = 0;
            for(int j=i;j<n;j++){
                s+=nums[j];
                if(s > k){
                    ans = Math.min(ans,j-i+1);
                    break;
                }
            }
        }
        return ans;
    }

    public static int optimal(int[] nums, int k){
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int i=0, j=0;
        int s=0;
        while(i<=j && j<n){
            while(s<=k && j<n){
                s += nums[j++];
            }
            while(s>k && i<j){
                ans = Math.min(ans,j-i);
                s -= nums[i++];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int nums[] = {1,4,45,6,0,19};
        int k = 51;
        int nums1[] = {1,10,5,2,7};
        int k1 =9;
        System.out.println(naiveApproach(nums,k));
        System.out.println(naiveApproach(nums1,k1));
        System.out.println(optimal(nums,k));
        System.out.println(optimal(nums1,k1));
    }
    
}
