package misc.Easy;
/**
 * Given an integer n, return the number of trailing zeroes in n!.

Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.

 

Example 1:

Input: n = 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: n = 5
Output: 1
Explanation: 5! = 120, one trailing zero.
Example 3:

Input: n = 0
Output: 0
 */
public class FactorialTrailingZeros {

    public int trailingZeroes(int n) {
        int trailingzeros= 0;
        for (int i= 5;i<=n;i*=5){
            trailingzeros = trailingzeros+ (n/i);
        }
        return trailingzeros; 
    }

    public static void main(String[] args) {
            
    }
    
}
