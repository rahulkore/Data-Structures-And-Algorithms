package Algorithms.TopMicrosoftAskedQuestionsLeetCode;
import java.util.*;
public class MinDelToMakeCharFreqUnique {

    /**Sort the frequency, count from largest and always set a expectation for each frequency in 
     * decreasing order.

// Example:  freq = [50, 50, 49, 6, 5]
// So for the second 50, exp = 49; And for 49, exp = 48;
// And for 6, exp = 47, but 47 > 6 let's re-adjust exp = 6. */

/**TC = O(n) + sorting overhead = 26log26 so almost O(n) */

public int minDeletions(String s) {
    int[] freq = new int[26];
    for (char c : s.toCharArray()) {
        freq[c - 'a']++;
    }
    Arrays.sort(freq);
    int exp = freq[25];
    int res = 0;
    for (int i = 25; i >= 0; i--) {
        // System.out.println(freq[i] + " " + exp);
        if (freq[i] == 0) break;
        if (freq[i] > exp) {
            res += freq[i] - exp;
        } else {
            exp = freq[i];
        }
        if (exp > 0) exp--; // Lowest exp is zero, cannot be negative
        // System.out.println(res);
    }
    return res;
}
    public static void main(String[] args) {
        
    }
    
}
