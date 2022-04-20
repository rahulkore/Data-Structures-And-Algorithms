package Algorithms.InterviewExperience;
import java.util.*;

import javax.swing.text.AbstractDocument.Content;
/**Given an array arr[] of N integers, the task is to find the length of the longest 
 * sub-sequence such that adjacent elements of the sub-sequence have at least one digit 
 * in common.
Examples: 
 

Input: arr[] = {1, 12, 44, 29, 33, 96, 89} 
Output: 5 
The longest sub-sequence is {1 12 29 96 89}
Input: arr[] = {12, 23, 45, 43, 36, 97} 
Output: 4 
The longest sub-sequence is {12 23 43 36}  */
public class LongestSubSeqAdjEleOneComDigit {


    /**Tc = O(n*2) 
     * Sc = O(n)
    */
    static int findSubsequence(int arr[], int n)
{
 
    // To store length of maximum length subsequence
    int len = 1;
 
    // To store current element arr[i]
    int tmp;
 
    int i, j, d;
 
    // To store length of subsequence
    // having common digit d
    int dp[] = new int[10];
 
 
    // To store digits present in current element
    int cnt[] = new int[10];
 
    // To store local maximum for current element
    int locMax;
 
    // For first element maximum length is 1 for
    // each digit
    tmp = arr[0];
    while (tmp > 0)
    {
        dp[tmp % 10] = 1;
        tmp /= 10;
    }
 
    // Find digits of each element, then find length
    // of subsequence for each digit and then find
    // local maximum
    for (i = 1; i < n; i++)
    {
        tmp = arr[i];
        locMax = 1;
        Arrays.fill(cnt, 0);
 
        // Find digits in current element
        while (tmp > 0)
        {
            cnt[tmp % 10] = 1;
            tmp /= 10;
        }
 
        // For each digit present find length of
        // subsequence and find local maximum
        for (d = 0; d <= 9; d++)
        {
            if (cnt[d] == 1)
            {
                dp[d]++;
                locMax = Math.max(locMax, dp[d]);
            }
        }
 
        // Update value of dp[d] for each digit
        // present in current element to local maximum
        // found
        for (d = 0; d <= 9; d++)
        {
            if (cnt[d] == 1)
            {
                dp[d] = locMax;
            }
        }
 
        // Update maximum length with local maximum
        len = Math.max(len, locMax);
    }
 
    return len;
}
    

    public static void main(String[] args) {
    
    }
    
}
