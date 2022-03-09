package Algorithms.TopAmazonAskedQuestionsLeetCode;
/**You have an inventory of different colored balls, and there is a customer that wants 
 * orders balls of any color.

The customer weirdly values the colored balls. Each colored ball's value is the number of 
balls of that color you currently have in your inventory. For example, if you own 6 yellow balls, 
the customer would pay 6 for the first yellow ball. After the transaction, there are only 5 yellow 
balls left, so the next yellow ball is then valued at 5 (i.e., the value of the balls decreases as
 you sell more to the customer).

You are given an integer array, inventory, where inventory[i] represents the number of balls of 
the ith color that you initially own. You are also given an integer orders, which represents the 
total number of balls that the customer wants. You can sell the balls in any order.

Return the maximum total value that you can attain after selling orders colored balls. 
As the answer may be too large, return it modulo 109 + 7.

 

Example 1:


Input: inventory = [2,5], orders = 4
Output: 14
Explanation: Sell the 1st color 1 time (2) and the 2nd color 3 times (5 + 4 + 3).
The maximum total value is 2 + 5 + 4 + 3 = 14.
Example 2:

Input: inventory = [3,5], orders = 6
Output: 19
Explanation: Sell the 1st color 2 times (3 + 2) and the 2nd color 4 times (5 + 4 + 3 + 2).
The maximum total value is 3 + 2 + 5 + 4 + 3 + 2 = 19. */
import java.util.*;
public class SellDeminishingValuedColorBalls {

    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);
        long ans = 0;
        int n = inventory.length-1;
        long count = 1;
        while(orders > 0){
            if(n > 0 && inventory[n] - inventory[n-1] > 0 && orders >= count * (inventory[n] - inventory[n-1])){
                ans += count * sumFromNtoX(inventory[n], inventory[n-1]);
                orders -= count * (inventory[n] - inventory[n-1]);
                System.out.println(count + " " + orders);
            }else if(n == 0 || inventory[n] - inventory[n-1] > 0){
                long a = orders / count;
                ans += count * sumFromNtoX(inventory[n], inventory[n]-a);
                long b = orders % count;
                ans += b * (inventory[n]-a);
                System.out.println(count + " " + orders + " " + a + " " + b);
                orders = 0;
                
            }
            
            ans %= 1000000007;
            n --;
            count ++;
        }
        return (int)ans;
    }
    
    private long sumFromNtoX(long n, long x){
        return (n * (n+1))/2 - (x * (x+1))/2;
    }
    
}
