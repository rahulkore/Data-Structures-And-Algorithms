//https://leetcode.com/problems/perfect-squares
/**
Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words,
it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

 

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 

Constraints:

1 <= n <= 104
*/


class Solution {
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        // return helper(n, dp);
        // return helper_bfs(n);
        return helper_math(n);
    }

    /**
        Recursive Memoized solution - Dynamic Programming
        TC : O(n*sqrt(n)), SC : O(n) recursive depth and memoized space.
     */
    private int helper(int n, int[] dp) {
        if(n <= 0) return 0;
        if(dp[n] != -1) return dp[n];
        int j = 1;
        int minimum = Integer.MAX_VALUE;
        while(j*j <= n){
            int mini = 1 + helper(n-j*j, dp);
            minimum = Math.min(minimum, mini);
            j++;
        }
        return dp[n] = minimum;
    }

    /**
        BFS Solution 
        TC : O(n*sqrt(n)), SC : O(n)
     */
    private int helper_bfs(int n){
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(0);
        int depth = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            depth += 1;
            for(int i=1; i<=size; i++){
                int element = queue.poll();
                for(int j=1; j*j<=n; j++) {
                    int k = element + j*j;
                    if(k==n) {
                        return depth;
                    }

                    if(k>n){
                        break;
                    }

                    if(!visited.contains(k)) {
                        queue.offer(k);
                        visited.add(k);
                    }
                }
            }
        }

        return depth;
    }

    /**
        Math based solution : Legendre's three-square theorem
        TC : O(sqrt(n)), SC: O(1)
     */
    private int helper_math(int n){
        if(isSquare(n)) return 1;

        // The result is 4 if and only if n can be written in the 
        // form of 4^k*(8*m + 7). Please refer to 
        // Legendre's three-square theorem.

        while((n & 3) == 0) { // n%4==0
            n >>= 2; // n/=4
        }
        if((n & 7) == 7) { // n%8 ==7
            return 4;
        }

        // check whether n can be represented using two squares. 
        for(int i=1 ; i*i<=n ; i++){
            if(isSquare(n-i*i)) {
                return 2;
            }
        }

        return 3;
    }

    private boolean isSquare(int n) {
        int sqrt = (int)Math.sqrt(n);
        return n == sqrt*sqrt;
    }
}
