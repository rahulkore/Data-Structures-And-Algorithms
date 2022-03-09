package Algorithms.TopAmazonAskedQuestionsLeetCode;
import java.util.*;
/**The width of a sequence is the difference between the maximum and minimum elements in the
 *  sequence.

Given an array of integers nums, return the sum of the widths of all the non-empty subsequences
 of nums. Since the answer may be very large, return it modulo 109 + 7.

A subsequence is a sequence that can be derived from an array by deleting some or no elements 
without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence 
of the array [0,3,1,6,2,2,7].

 

Example 1:

Input: nums = [2,1,3]
Output: 6
Explanation: The subsequences are [1], [2], [3], [2,1], [2,3], [1,3], [2,1,3].
The corresponding widths are 0, 0, 0, 1, 1, 2, 2.
The sum of these widths is 6.
 */
public class SumOfSubSequenceWidths {

    /**The order in initial arrays doesn't matter,
my first intuition is to sort the array.

For each number A[i]:

There are i smaller numbers,
so there are 2 ^ i sequences in which A[i] is maximum.
we should do res += A[i] * 2^i

There are n - i - 1 bigger numbers,
so there are 2 ^ (n - i - 1) sequences in which A[i] is minimum.
we should do res -= A[i] * 2^(n - i - 1)

Done.


Time Complexity:
Time O(NlogN)
Space O(1) */
public int sumSubseqWidths(int[] A) {
    Arrays.sort(A);
    long c = 1, res = 0, mod = (long)1e9 + 7;
    for (int i = 0, n = A.length; i < n; ++i, c = c * 2 % mod)
        res = (res + A[i] * c - A[n - i - 1] * c) % mod;
    return (int)((res + mod) % mod);
}
    
}
