package Algorithms.BinarySearch;
/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
Example 3:

Input: nums1 = [0,0], nums2 = [0,0]
Output: 0.00000
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length < nums1.length) return findMedianSortedArrays(nums2,nums1);
        int n1 = nums1.length;
        int n2 = nums2.length;
        int low  = 0;
        int high = n1;
        while(low <= high){
            int cut1  = (low + high)/2;
            int cut2  = (n1+n2+1)/2 - cut1;
            
            int left1 = cut1==0 ? Integer.MIN_VALUE : nums1[cut1-1];
            int left2 = cut2==0 ? Integer.MIN_VALUE  : nums2[cut2-1];
            
            int right1 = cut1==n1 ? Integer.MAX_VALUE  : nums1[cut1];
            int right2 = cut2==n2 ? Integer.MAX_VALUE  : nums2[cut2];
            
            if(left1 <= right2 && left2 <= right1){
                if((n1+n2) % 2 == 0){
                    return (Math.max(left1,left2) + Math.min(right1,right2))/2.0 ;
                }else{
                    return (Math.max(left1,left2));
                }
            }
            if(left1 > right2){
                high = cut1-1;
            }else{
                low = cut1+1;
            }
        }
        return 0.0;
    }
    public static void main(String[] args) {
        
    }
    
}
