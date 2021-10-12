package Algorithms.Recursion;
import java.util.*;
/**
 * The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

 

Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"
 */
public class KthPermutation {

    private String kthPermutation(int n ,int k, List<Integer> nums){
        k-=1;
        int fact=1;
        for(int i=1;i<=n-1;i++){
            fact *= i; 
        }
        String ans ="";
        while(true){
            ans += nums.get(k/fact).toString();
            nums.remove(k/fact);
            if(nums.size() == 0) break;
            k = k % fact;
            fact = fact / nums.size() ;
        }
        return ans;
    }
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for(int i=0;i<n;i++){
            nums.add(i+1);
        }
        return kthPermutation(n,k,nums);
        
    }
    public static void main(String[] args) {
        
    }
    
}
