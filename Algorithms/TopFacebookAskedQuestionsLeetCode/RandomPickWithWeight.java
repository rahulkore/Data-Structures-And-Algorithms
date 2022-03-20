package Algorithms.TopFacebookAskedQuestionsLeetCode;
import java.util.*;

/**You are given a 0-indexed array of positive integers w where w[i] describes the weight of the 
 * ith index.

You need to implement the function pickIndex(), which randomly picks an index in the range 
[0, w.length - 1] (inclusive) and returns it. The probability of picking an index i is w[i] / sum(w).

For example, if w = [1, 3], the probability of picking index 0 is 1 / (1 + 3) = 0.25 (i.e., 25%), 
and the probability of picking index 1 is 3 / (1 + 3) = 0.75 (i.e., 75%).
 

Example 1:

Input
["Solution","pickIndex"]
[[[1]],[]]
Output
[null,0]

Explanation
Solution solution = new Solution([1]);
solution.pickIndex(); // return 0. The only option is to return 0 since there is only one element 
in w.
Example 2:

Input
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output
[null,1,1,1,1,0]

Explanation
Solution solution = new Solution([1, 3]);
solution.pickIndex(); // return 1. It is returning the second element (index = 1) that has a 
probability of 3/4.
solution.pickIndex(); // return 1
solution.pickIndex(); // return 1
solution.pickIndex(); // return 1
solution.pickIndex(); // return 0. It is returning the first element (index = 0) that has a 
probability of 1/4.

Since this is a randomization problem, multiple answers are allowed.
All of the following outputs can be considered correct:
[null,1,1,1,1,0]
[null,1,1,1,1,1]
[null,1,1,1,0,0]
[null,1,1,1,0,1]
[null,1,0,1,0,0]
......
and so on. */
public class RandomPickWithWeight {

    static Random random;
    static int[] wSums;
    
    /**Use accumulated freq array to get idx.
w[] = {2,5,3,4} => wsum[] = {2,7,10,14}
then get random val random.nextInt(14)+1, idx is in range [1,14] */

/**For those who might still be confused, here is my understanding of how it works, 
 * in the solution we are actually using the width of each range as the weight of the indexes 
 * (accumulated sum increases more with a higher weight), for example, for index 1 the range 
 * is [3, 7] which is longer than other ranges (since it has higher weight, 5), and therefore 
 * the random pick falls into that range with higher probability. */
    public static void Solution(int[] w) {
        random = new Random();
        for(int i=1; i<w.length; ++i)
            w[i] += w[i-1];
        wSums = w;
    }
    
    public int pickIndex() {
        int len = wSums.length;
        int idx = random.nextInt(wSums[len-1]) + 1;
        int left = 0, right = len - 1;
        // search position 
        while(left < right){
            int mid = left + (right-left)/2;
            if(wSums[mid] == idx)
                return mid;
            else if(wSums[mid] < idx)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        
    }
    
}
