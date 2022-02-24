package Algorithms.BinarySearch;
/**
 * Given two sorted arrays arr1 and arr2 of size N and M respectively and an element K. The task is to find the element that would be at the k’th position of the final sorted array.
 

Example 1:

Input:
arr1[] = {2, 3, 6, 7, 9}
arr2[] = {1, 4, 8, 10}
k = 5
Output:
6
Explanation:
The final sorted array would be -
1, 2, 3, 4, 6, 7, 8, 9, 10
The 5th element of this array is 6.
 */
public class KthElementOfTwoSortedArrays {

    public static long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        if(n > m) {
            return kthElement(arr2, arr1, m, n, k); 
        }
        
        int low = Math.max(0,k-m), high = Math.min(k,n);
        
        while(low <= high) {
            int cut1 = (low + high) >> 1; 
            int cut2 = k - cut1; 
            int l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1]; 
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];
            int r1 = cut1 == n ? Integer.MAX_VALUE : arr1[cut1]; 
            int r2 = cut2 == m ? Integer.MAX_VALUE : arr2[cut2]; 
            
            if(l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }
            else if (l1 > r2) {
                high = cut1 - 1;
            }
            else {
                low = cut1 + 1; 
            }
        }
        return 1; 
    }
    public static void main(String[] args) {
        int arr1[] = {2, 3, 6,7};
        int arr2[] = {1, 4, 8, 10};
        long ans = kthElement(arr1,arr2,arr1.length,arr2.length,5);
        System.out.println(ans);
    }
    
}
