package Algorithms.Arrays;

import java.util.Arrays;

/**
 * Given a set of N jobs where each jobi has a deadline and profit associated with it. Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit if and only if the job is completed by its deadline. The task is to find the number of jobs done and the maximum profit.

Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job.


Example 1:

Input:
N = 4
Jobs = {(1,4,20),(2,1,10),(3,1,40),(4,1,30)}
Output:
2 60
Explanation:
Job1 and Job3 can be done with
maximum profit of 60 (20+40).
Example 2:

Input:
N = 5
Jobs = {(1,2,100),(2,1,19),(3,2,27),
        (4,1,25),(5,1,15)}
Output:
2 127
Explanation:
2 jobs can be done with
maximum profit of 127 (100+27).

 */
class Job{
    int id;
    int profit;
    int deadline;
}
public class JobSequencingProblem {

    // return an array of size 2 having the 0th element equal to the count
    // and 1st element equal to the maximum profit
    int[] JobScheduling(Job arr[], int n){
        Arrays.sort(arr, (a, b) -> (b.profit - a.profit)); 
        
        int maxi = 0; 
        for(int i = 0;i<n;i++) {
            if(arr[i].deadline > maxi) {
                maxi = arr[i].deadline; 
            }
        }
        
        int result[] = new int[maxi + 1]; 
        
        for(int i = 1;i<=maxi;i++) {
            result[i] = -1; 
        }
         
        int countJobs = 0, jobProfit = 0; 
        
        for (int i = 0; i < n; i++)  
        { 
        
            for (int j = arr[i].deadline; j > 0; j--) { 
  
                // Free slot found 
                if (result[j] == -1)  
                { 
                    result[j] = i; 
                    countJobs++;
                    jobProfit += arr[i].profit; 
                    break; 
                } 
            } 
        } 
  
        int ans[] = new int[2]; 
        ans[0] = countJobs; 
        ans[1] = jobProfit; 
        return ans;
        
    }
    public static void main(String[] args) {
        
    }
    
}
