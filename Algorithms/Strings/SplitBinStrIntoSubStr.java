package Algorithms.Strings;
/**
 * Split the binary string into substrings with equal number of 0s and 1s
 * 
 * Given a binary string str of length N, 
 * the task is to find the maximum count of consecutive substrings
 *  str can be divided into such that all the substrings are balanced i.e.
 *  they have equal number of 0s and 1s. If it is not possible to split str
 *  satisfying the conditions then print -1.
Example: 
 

Input: str = “0100110101” 
Output: 4 
The required substrings are “01”, “0011”, “01” and “01”.
Input: str = “0111100010” 
Output: 3 
 */
public class SplitBinStrIntoSubStr {

    /**
     * Tc = O(n)
     * Sc = O(1)
     */

    public static int maxSubStr(String str, int n)
    {
 
        // To store the count of 0s and 1s
        int count0 = 0, count1 = 0;
    
        // To store the count of maximum
        // substrings str can be divided into
        int cnt = 0;
        int start = 0;
        for (int i = 0; i < n; i++)
        {
            if (str.charAt(i) == '0')
            {
                count0++;
            }
            else
            {
                count1++;
            }
            if (count0 == count1)
            {
                cnt++;
                System.out.println(str.substring(start,i+1));
                start = i+1;
            }
        }
    
        // It is not possible to
        // split the string
        if (count0 != count1)
        {
            return -1;
        }
        return cnt;
    }
    public static void main(String[] args) {

        String str = "0100110101";
        int n = str.length();
        
        System.out.println(maxSubStr(str, n));
        
    }
    
}
