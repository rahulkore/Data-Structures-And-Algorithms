package Algorithms.TopAmazonAskedQuestionsLeetCode;
/**A binary string is monotone increasing if it consists of some number of 0's (possibly none),
 *  followed by some number of 1's (also possibly none).

You are given a binary string s. You can flip s[i] changing it from 0 to 1 or from 1 to 0.

Return the minimum number of flips to make s monotone increasing.

 

Example 1:

Input: s = "00110"
Output: 1
Explanation: We flip the last digit to get 00111.
Example 2:

Input: s = "010110"
Output: 2
Explanation: We flip to get 011111, or alternatively 000111. */
public class FlipStringToMonoToneIncreasing {

    public int minFlipsMonoIncr(String s) {
        int res = 0;
        
        int cntOnes = 0;
        int n = s.length();
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            // if c is 1, then it will not inpact the minFlips
            // if c is 0, then 2 options we can do to make it mono incr
            // 1. keep it as 0, and flip all the preceeding 1 to 0, need to know the count of ones so far
            // 2. flip it to 1, will not need to do anything
            if(c == '1') cntOnes++;
            else{
                int tmp1 = cntOnes;
                int tmp2 = res + 1;
                res = Math.min(tmp1, tmp2);
            }
        }
        
        return res;
    }
    
}
