// https://leetcode.com/problems/minimum-cost-for-tickets/description/ 

// TC : O(n^2), SC : (n)

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length+1];
        // Arrays.fill(dp, -1);
        return tabulation(days, costs, dp);
    }

    private int helper(int[] days, int[] costs, int ind) {
        // base case

        if(ind >= days.length) return 0;

        // recurrence relation 
        // 1 day pass 
        int take_one_day_pass = costs[0] + helper(days, costs, ind+1);
        // 7 days pass
        int i;
        for(i=ind;i<days.length && days[i]<days[ind]+7; i++);
        int take_seven_day_pass = costs[1] + helper(days, costs, i);
        // 30 days pass 
        for(i=ind;i<days.length && days[i]<days[ind]+30; i++);
        int take_thirty_day_pass = costs[2] + helper(days, costs, i);

        // return statement
        return Math.min(take_one_day_pass, Math.min(take_seven_day_pass, take_thirty_day_pass));
    }

    private int helper_memoize(int[] days, int[] costs, int ind, int[] dp) {
        // base case
        if(ind >= days.length) return 0;
        if(dp[ind] != -1) return dp[ind];
        // recurrence relation 
        // 1 day pass 
        int take_one_day_pass = costs[0] + helper_memoize(days, costs, ind+1, dp);
        // 7 days pass
        int i;
        for(i=ind;i<days.length && days[i]<days[ind]+7; i++);
        int take_seven_day_pass = costs[1] + helper_memoize(days, costs, i, dp);
        // 30 days pass 
        for(i=ind;i<days.length && days[i]<days[ind]+30; i++);
        int take_thirty_day_pass = costs[2] + helper_memoize(days, costs, i, dp);
        // return statement
        return dp[ind] = Math.min(take_one_day_pass, Math.min(take_seven_day_pass, take_thirty_day_pass));
    }

    private int tabulation(int[] days, int[] costs, int[] dp) {
        dp[days.length] = 0;
        for(int ind=days.length-1; ind>=0; ind--) {
            int take_one_day_pass = costs[0] + dp[ind+1];
            // 7 days pass
            int i;
            for(i=ind;i<days.length && days[i]<days[ind]+7; i++);
            int take_seven_day_pass = costs[1] + dp[i];
            // 30 days pass 
            for(i=ind;i<days.length && days[i]<days[ind]+30; i++);
            int take_thirty_day_pass = costs[2] + dp[i];
            dp[ind] = Math.min(take_one_day_pass, Math.min(take_seven_day_pass, take_thirty_day_pass));
        }
        return dp[0];
    }
}
