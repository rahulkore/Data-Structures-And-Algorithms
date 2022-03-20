package Algorithms.TopFacebookAskedQuestionsLeetCode;

public class ArrangingCoins {

    /**As we know the number of coins in each staircase are forming an AP

Eg :- 1+2+3+...+a = n
Sum of all terms of AP :- (1+a)a/2 = n
n is given to us in question, we have to find a

===> a ^ 2 + a = 2 n
===> x ^ 2 + a + 1/4 = 2 n +1/4
===> (a + 1/2 ) ^ 2 = 2n + 1/4
===> (a + 0.5) = sqrt( 2n + 1/4 )
===> a = -0.5 + sqrt( 2n + 1/4 )
We have calculated the value of a = -0.5 + sqrt( 2*n + 1/4 ) */


    public int arrangeCoins(int n) {
        return (int)(Math.sqrt(2 * (long)n + 0.25) - 0.5);
    }

    int arrangeCoinsinN(int n) {
        int i = 1, ans = 0;
        
        while (n>=0) {
            n -= i++;
            if(n >= 0) ++ans;
            else break;
        }
        
        return ans;
    }
    public static void main(String[] args) {
        
    }
    
}
