package Algorithms.BinarySearch;
/**
 * Given a boolean 2D array of n x m dimensions where each row is sorted. Find the 0-based index of the first row that has the maximum number of 1's.

Example 1:

Input: 
N = 4 , M = 4
Arr[][] = {{0, 1, 1, 1},
           {0, 0, 1, 1},
           {1, 1, 1, 1},
           {0, 0, 0, 0}}
Output: 2
Explanation: Row 2 contains 4 1's (0-based
indexing).
 */
public class FinfMaxOnesRow {

    public static int binarySearch(int[][] nums,int r){
        int ans=0;
        int l = 0;
        int h = nums[0].length-1;
        int ind=nums[0].length;
        while(l<=h){
            int m = (l+h) >> 1;
            if(nums[r][m] == 1){
                ind = m;
                h=m-1;
            }else{
                l=m+1;
            }
        }
        ans = nums[0].length  - ind;
        return ans;
    }

    public static int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        int ans = 0; // row number 
        int max1s = 0;
        for(int i = 0;i<arr.length ; i++){
            int count1s = binarySearch(arr, i);
            if(count1s > max1s){
                max1s = count1s;
                ans = i;
            }
        }
        return max1s==0 ? -1 : ans; // if no 1s found then returning -1
    }
    public static void main(String[] args) {
        
    }
    
}
