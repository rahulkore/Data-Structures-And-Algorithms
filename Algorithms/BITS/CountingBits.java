package Algorithms.BITS;
/**
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

 

Example 1:

Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10
Example 2:

Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
 */
public class CountingBits {

    /**
     * We can use brian kernighans algorithm over here and this will give us O(nlogn) solution 
     */
        public static int[] main(String[] args) {
        int n= 5;
        int ans[] = new int[n+1];
        for(int i=0;i<=n;i++){
            ans[i]=Integer.bitCount(i);
        }
        return ans;
    }
    
}

