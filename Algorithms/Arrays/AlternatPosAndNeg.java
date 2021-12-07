package Algorithms.Arrays;
import java.util.*;
/**
 * Rearrange the array in alternate positive and negative element in O(1) space
 */
public class AlternatPosAndNeg {
    public static void swap(int nums[],int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    public static void rotate(int nums[],int i,int j){
        int t = nums[j];
        for(int itr=j;itr>i;itr--){
            nums[itr] = nums[itr-1];
        }
        nums[i] = t;
    }
    public static void display(int nums[]){
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
    public static void reArrange(int nums[], int n) {
        int wrongindex = -1;
        for(int i=0;i<n;i++) {
            if(wrongindex != -1){
                if((nums[wrongindex]>=0 && nums[i]<0) || (nums[wrongindex]<0 && nums[i]>=0)) {
                    rotate(nums, wrongindex, i);

                    if(i-wrongindex>=2){
                        wrongindex+=2;
                    }else{
                        wrongindex =-1;
                    }
                }
            }else{
                if((nums[i]<0 && i%2==1) || (nums[i]>=0 && i%2==0)){
                    wrongindex = i;
                }
            }
        }
    }
    public static void main(String[] args) {
        int nums[] = {1,-2,-3,-4,2,3,4};
        reArrange(nums, nums.length);
        display(nums);
    }
    
}
