package Algorithms.Dynamic;
import java.util.*;
/**Partition a set into two subsets with minimum absolute sum difference */
public class PartitionSet {

    /**The most efficient solution of subset sum equals k  */
    /**This will give all the possible sums that can be made with the given set 
     * basically all the s1 and using that and totsum-s1 = s2 we can get the minimal 
     * s1-s2 
     */
    static boolean[] subsetSumToKSpaceOpt(int n, int k,int[] arr){
        boolean prev[]= new boolean[k+1];
        
        prev[0] = true;
        
        if(arr[0]<=k)
            prev[arr[0]] = true;
        
        for(int ind = 1; ind<n; ind++){
            boolean cur[]=new boolean[k+1];
            cur[0] = true;
            for(int target= 1; target<=k; target++){
                boolean notTaken = prev[target];
        
                boolean taken = false;
                    if(arr[ind]<=target)
                        taken = prev[target-arr[ind]];
            
                cur[target]= notTaken||taken;
            }
            prev=cur;
        
        }
        
        return prev;
    }


    public static int minSubsetSumDifference(int[] arr, int n) {
		// Write your code here.
        int totsum=0;
        for(int ele : arr)
            totsum += ele;
        boolean prev[] = subsetSumToKSpaceOpt(n,totsum,arr);
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<prev.length;i++){
            if(prev[i]){
                /** we have s1 then |s1-s2| = |s1-(totsum-s1)| 
                 *  = |s1-totsum-s1| = |2*s1 - totsum|
                */
                ans = Math.min(ans,Math.abs(2*i - totsum)); 
            }
        }
        return ans;
	}
    public static void main(String[] args) {
    
        
    }
    
}
