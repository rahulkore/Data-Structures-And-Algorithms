package Algorithms.Dynamic;
import java.util.*;
/**A Ninja has an ‘N’ Day training schedule. He has to perform one of these three activities 
 * (Running, Fighting Practice, or Learning New Moves) each day. There are merit points associated
 *  with performing an activity each day. The same activity can’t be performed on two consecutive
 *  days. We need to find the maximum merit points the ninja can attain in N Days.

We are given a 2D Array POINTS of size ‘N*3’ which tells us the merit point of specific activity 
on that particular day. Our task is to calculate the maximum number of merit points that the 
ninja can earn. */
public class NinjasTraining {

    /**Memoization of recursion solution => top down approach 
     * Tc = O(n*4*3)
     * n*4 => dimensions of dp 
     * There are N*4 states and for every state, we are running a for loop iterating three times.
     * 
     * Sc = O(n) + O(n*4)
    */
    static int f(int day, int last, int[][] points, int[][] dp) {

        if (dp[day][last] != -1) return dp[day][last];

        if (day == 0) {
            int maxi = 0;
            for (int i = 0; i <= 2; i++) {
                if (i != last)
                    maxi = Math.max(maxi, points[0][i]);
            }
            return dp[day][last] = maxi;
        }

        int maxi = 0;
        for (int i = 0; i <= 2; i++) {
            if (i != last) {
                int activity = points[day][i] + f(day - 1, i, points, dp);
                maxi = Math.max(maxi, activity);
            }

        }

        return dp[day][last] = maxi;
    }

    static int ninjaTraining(int n, int[][] points) {

        int dp[][] = new int[n][4];
        for (int[] row: dp)
            Arrays.fill(row, -1);

        return f(n - 1, 3, points, dp);
    }

    /**Tabulation 
     * Tc = o(n*4*3)
     * Sc = O(n*4)
    */
    static int ninjaTrainingTabulation(int n, int[][] points) {


        int[][] dp = new int[n][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        int activity = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }

        }

        return dp[n - 1][3];
    }

    /**Space Optimized solution 
     * Tc = O(n*4*3)
     * Sc = O(4)
    */
    static int ninjaTrainingSPaceOptimized(int n, int[][] points) {


        int prev[] = new int[4];

        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {

            int temp[] = new int[4];
            for (int last = 0; last < 4; last++) {
                temp[last] = 0;
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        temp[last] = Math.max(temp[last], points[day][task] + prev[task]);
                    }
                }
            }

            prev = temp;

        }

        return prev[3];
    }

    /**Tc = O(3n) 
     * Sc = O(3)
    */
    public static void calc(int[] prev,int[] temp){
        prev[0] = Math.max(temp[1],temp[2]);
        prev[1] = Math.max(temp[0],temp[2]);
        prev[2] = Math.max(temp[0],temp[1]);
    }
    public static int ninjaTrainingBestOptimized(int n, int points[][]) {
        int prev[] = new int[3];
        int temp[] = new int[3];
        temp[0] = points[0][0];
        temp[1] = points[0][1];
        temp[2] = points[0][2];
        calc(prev,temp);
        for (int day = 1; day < n; day++) {
            for(int task=0;task<=2;task++){
                temp[task] = prev[task] + points[day][task];
            }
			calc(prev,temp);
        }
        int ans=Integer.MIN_VALUE;
        for(int task=0;task<=2;task++){
            ans = Math.max(ans,prev[task]);
        }
        return ans;
    }

    public static void main(String[] args) {

        int[][] points = {{10,40,70},
                          {20,50,80},
                          {30,60,90}};
           

        int n = points.length;
        System.out.println(ninjaTraining(n, points));
        
    }
    
}
