package Algorithms.BITS;
/**
 * Given an integer n, return true if it is a power of two. Otherwise, return false.

An integer n is a power of two, if there exists an integer x such that n == 2x.

 

Example 1:

Input: n = 1
Output: true
Explanation: 2^0 = 1
Input: n = 3
Output: false
 */
public class PowerOfTwo {
    /**
     * Brian Kernighan’s Algorithm:  
     * Subtracting 1 from a decimal number flips all the bits after the rightmost set bit(which is 1) including the rightmost set bit. 
for example : 
10 in binary is 00001010 
9 in binary is  00001001 
8 in binary is 00001000 
7 in binary is 00000111 
So if we subtract a number by 1 and do it bitwise & with itself (n & (n-1)), we unset the rightmost set bit. If we do n & (n-1) in a loop and count the number of times the loop executes, we get the set bit count. 
The beauty of this solution is the number of times it loops is equal to the number of set bits in a given integer.
     */
    public static boolean main(String[] args) {
        int n=4;
        if(n<=0)
            return false;
        n= n&(n-1);
        return n==0;
    }
    
}
