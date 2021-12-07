package Algorithms.Arrays;
/**
 * You are given an m x n integer matrix points (0-indexed). Starting with 0 points, you want to maximize the number of points you can get from the matrix.

To gain points, you must pick one cell in each row. Picking the cell at coordinates (r, c) will add points[r][c] to your score.

However, you will lose points if you pick a cell too far from the cell that you picked in the previous row. For every two adjacent rows r and r + 1 (where 0 <= r < m - 1), picking cells at coordinates (r, c1) and (r + 1, c2) will subtract abs(c1 - c2) from your score.

Return the maximum number of points you can achieve.

abs(x) is defined as:

x for x >= 0.
-x for x < 0.
 

Example 1:


Input: points = [[1,2,3],[1,5,1],[3,1,1]]
Output: 9
Explanation:
The blue cells denote the optimal cells to pick, which have coordinates (0, 2), (1, 1), and (2, 0).
You add 3 + 5 + 3 = 11 to your score.
However, you must subtract abs(2 - 1) + abs(1 - 0) = 2 from your score.
Your final score is 11 - 2 = 9.
 */
public class MaximumNoOfPointsWithCost {
    
    /** Brute Fore O(n3) */
    public long maxPointsBrute(int[][] points) {
        
        int rows = points.length;
        int cols = points[0].length;
        long[] prev = new long[cols];
        for (int i = 0; i < cols; i++) {
            prev[i] = points[0][i];
        }
        // for(long ele: prev)
        // System.out.print(ele + " ");
        for (int i = 1; i < rows; i++) {
            long[] curr = new long[cols];
            for (int j = 0; j < cols; j++) {                
                
                int num = points[i][j];
                long ans = 0;
                for (int k = 0; k < cols; k++) {
                    ans = Math.max(ans, num + prev[k] - Math.abs(k - j));
                    //System.out.println(num + " " + prev[k] + " " + k +" "+j);
                }
                curr[j] = ans;
            }
            prev = curr;
        }
        long maxPoints = 0;
        for (int j = 0; j < cols; j++) {
            maxPoints = Math.max(maxPoints, prev[j]);
        }
        return maxPoints;
    }

    /** Dp : TC => O(n2) SC => O(4n) */
    public long maxPointsDp(int[][] points) {
        int rows = points.length;
        int cols = points[0].length;
        long[] prev = new long[cols];
        for (int i = 0; i < cols; i++) {
            prev[i] = points[0][i];
        }
        for (int i = 0; i < rows - 1; i++) {
            long[] left = new long[cols];
            long[] right = new long[cols];
            long curr[] = new long[cols];
            left[0] = prev[0];
            right[cols - 1] = prev[cols - 1];
            for (int j = 1; j < cols; j++) {
                left[j] = Math.max(left[j-1] - 1, prev[j]);
            }
            for (int j = cols - 2; j >= 0; j--) {
                right[j] = Math.max(right[j+1] - 1, prev[j]);
            }
            for (int j = 0; j < cols; j++) {
                curr[j] = points[i + 1][j] + Math.max(left[j], right[j]);
            }
            prev = curr;
        }
        long maxPoints = 0;
        for (int j = 0; j < cols; j++) {
            maxPoints = Math.max(maxPoints, prev[j]);
        }
        return maxPoints;
    }
    /**Dp TC=> O(n2) SC=>O(n) */
    public long maxPoints(int[][] points) {
        int rows = points.length;
        int cols = points[0].length;
        long[] dp = new long[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dp[j] += points[i][j];
            }
			//left to right pass
            for (int j = 1; j < cols; j++) {
                dp[j] = Math.max(dp[j], dp[j - 1] - 1);
            }
			//right to left pass
            for (int j = cols - 2; j >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j + 1] - 1);
            }
        }
        long maxPoints = 0;
        for (int j = 0; j < cols; j++) {
            maxPoints = Math.max(maxPoints, dp[j]);
        }
        return maxPoints;
    }
    public static void main(String[] args) {
        
    }
}
