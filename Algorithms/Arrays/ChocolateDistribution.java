package Algorithms.Arrays;

import java.util.Arrays;

/**
 * Given an array of n integers where each value represents the number of chocolates in a packet. 
 * Each packet can have a variable number of chocolates. There are m students, 
 * the task is to distribute chocolate packets such that: 

Each student gets one packet.
The difference between the number of chocolates in the packet with maximum chocolates and packet 
with minimum chocolates given to the students is minimum.
 */
public class ChocolateDistribution {

    /**
     * Tc = O(nlogn)
     * Sc = O(1)
     * We basically sort the array ans then use the sliding window of size m to calc the max-min 
     * chocolate distributed and get the minimal max-min value
     * @param packets
     * @param m
     * @return
     */
    public static Integer findDistributionAns(int[] packets, int m){
        int n = packets.length;
        int ans = Integer.MAX_VALUE;
        if(n==0 || m==0 || m>n)
        return -1;
        Arrays.sort(packets);
        for(int i=0 ; i+m-1 < n ; i++){
            ans = Math.min(ans,packets[i+m-1]-packets[i]);
        }
        return ans;
    }
    public static void main(String[] args) {

        int[] packets = {1,3,4,7,9,9,56,12};
        int ans = findDistributionAns(packets,5);
        System.out.println(ans);
    }
    
}
