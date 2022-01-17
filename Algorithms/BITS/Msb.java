package Algorithms.BITS;
/**
 * You are given a positive integer 'N'. Your task is to find the greatest integer less than or equal to 'N' which is a power of 2.
For Example:
If N = 14, then the nearest integer that is less than or equal to 14 and is a power of two is 8(2^3). So, the answer is 8.
 */
public class Msb {
    static int setBitNumber(int n)
    {
        // To find the position of the
        // most significant set bit
        int k = (int)(Math.log(n) / Math.log(2));
        int msb = n & ~(n-1); // this way also we can find the most significant bit 
        // To return the the value of the number
        // with set bit at k-th position
        return 1 << k;
    }
    public static void main(String[] args) {
        
    }
    
}
