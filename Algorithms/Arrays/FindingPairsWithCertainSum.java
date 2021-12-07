package Algorithms.Arrays;
import java.util.*;
/**
 * You are given two integer arrays nums1 and nums2. You are tasked to implement a data structure that supports queries of two types:

Add a positive integer to an element of a given index in the array nums2.
Count the number of pairs (i, j) such that nums1[i] + nums2[j] equals a given value (0 <= i < nums1.length and 0 <= j < nums2.length).
Implement the FindSumPairs class:

FindSumPairs(int[] nums1, int[] nums2) Initializes the FindSumPairs object with two integer arrays nums1 and nums2.
void add(int index, int val) Adds val to nums2[index], i.e., apply nums2[index] += val.
int count(int tot) Returns the number of pairs (i, j) such that nums1[i] + nums2[j] == tot.
 

Example 1:

Input
["FindSumPairs", "count", "add", "count", "count", "add", "add", "count"]
[[[1, 1, 2, 2, 2, 3], [1, 4, 5, 2, 5, 4]], [7], [3, 2], [8], [4], [0, 1], [1, 1], [7]]
Output
[null, 8, null, 2, 1, null, null, 11]

 */
class FindSumPairs {

    HashMap<Integer, Integer> n2 = new HashMap<>();
    int []num1;
    int []num2;
    public FindSumPairs(int[] num1, int[] num2) {
        this.num1 = num1;
        this.num2 = num2;
        for(int i=0; i<num2.length; i++) {
            n2.put(num2[i], n2.getOrDefault(num2[i],0) + 1);
        }
    }
    
    public void add(int index, int val) {
        n2.put(num2[index], n2.getOrDefault(num2[index],0) - 1);
        num2[index] += val;
        n2.put(num2[index], n2.getOrDefault(num2[index],0) + 1);
    }
    
    public int count(int tot) {
        int cnt = 0;
        for(int i=0;i<num1.length;i++) {
            cnt += n2.getOrDefault(tot - num1[i], 0);
        }
        return cnt;
    }
}

public class FindingPairsWithCertainSum {

    public static void main(String[] args) {
        
    }
    
}
