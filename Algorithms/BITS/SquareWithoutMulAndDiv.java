package Algorithms.BITS;
/**
 * Both has complexity O(logn)
 */
public class SquareWithoutMulAndDiv {

    /**We can do it in O(Logn) time using bitwise operators. The idea is based on the following fact.

  square(n) = 0 if n == 0
  if n is even 
     square(n) = 4*square(n/2) 
  if n is odd
     square(n) = 4*square(floor(n/2)) + 4*floor(n/2) + 1 

Examples
  square(6) = 4*square(3)
  square(3) = 4*(square(1)) + 4*1 + 1 = 9
  square(7) = 4*square(3) + 4*3 + 1 = 4*9 + 4*3 + 1 = 49
How does this work? 

If n is even, it can be written as
  n = 2*x 
  n2 = (2*x)2 = 4*x2
If n is odd, it can be written as 
  n = 2*x + 1
  n2 = (2*x + 1)2 = 4*x2 + 4*x + 1
 */
    static int square(int n)
    {
        // Base case
        if (n == 0)
            return 0;
        // Handle negative number
        if (n < 0)
            n = -n;
        // Get floor(n/2) using
        // right shift
        int x = n >> 1;
        // If n is odd
        if (n % 2 != 0)
            return ((square(x) << 2) + (x << 2) + 1);
        else // If n is even
            return (square(x) << 2);
    }
    /**For a given number `num` we get square of it by multiplying number as `num * num`. 
Now write one of `num` in square `num * num` in terms of power of `2`. Check below examples.

Eg: num = 10, square(num) = 10 * 10 
                          = 10 * (8 + 2) = (10 * 8) + (10 * 2)
    num = 15, square(num) = 15 * 15 
                          = 15 * (8 + 4 + 2 + 1) = (15 * 8) + (15 * 4) + (15 * 2) + (15 * 1)

Multiplication with power of 2's can be done by left shift bitwise operator.
 */
    public static int squaree(int num)
    {
        // Handle negative input
        if (num < 0)
            num = -num;
        // Initialize result
        int result = 0, times = num;
        while (times > 0)
        {
            int possibleShifts = 0,currTimes = 1;
            while ((currTimes << 1) <= times)
            {
                currTimes = currTimes << 1;
                ++possibleShifts;
            }
            System.out.println(possibleShifts + " " + currTimes);
            result = result + (num << possibleShifts);
            System.out.println(result);
            times = times - currTimes;
        }
        return result;
    }

public static void main(String[] args) {
    System.out.println(squaree(10));
}
    
}
