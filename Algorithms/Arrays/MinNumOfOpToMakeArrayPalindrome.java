package Algorithms.Arrays;

public class MinNumOfOpToMakeArrayPalindrome {

    public static int minOpeartaions(int nums[]){
        int ans= 0 ;
        int i=0;
        int j = nums.length-1;
        while(i<=j){
            if(nums[i]==nums[j]){
                i++;
                j--;
            }else if(nums[i] < nums[j]){
                nums[i+1] += nums[i]; // merge i+1 and i
                i++;
                ans++;
            }else{
                nums[j-1] += nums[j]; // merge j-1 and j
                j--;
                ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int nums[] = {1,2,3,5,10,1};
        System.out.println(minOpeartaions(nums));
    }
    
}
