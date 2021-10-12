package Algorithms.Recursion;
import java.util.*;
/**
 * Given a list arr of N integers, print sums of all subsets in it.

Example 1:

Input:
N = 2
arr[] = {2, 3}
Output:
0 2 3 5
Explanation:
When no elements is taken then Sum = 0.
When only 2 is taken then Sum = 2.
When only 3 is taken then Sum = 3.
When element 2 and 3 are taken then 
Sum = 2+3 = 5.
 */
public class SubsetSum {


    void func(int ind, int sum, ArrayList<Integer> arr, int N, ArrayList<Integer> sumSubset) {
        if(ind == N) {
            sumSubset.add(sum); 
            return; 
        }
        
        // pick the element 
        func(ind + 1, sum + arr.get(ind), arr, N, sumSubset); 
        
        // Do-not pick the element
        func(ind + 1, sum, arr, N, sumSubset);
    }
    
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> sumSubset = new ArrayList<>(); 
        func(0, 0, arr, N, sumSubset); 
        Collections.sort(sumSubset); 
        return sumSubset; 
    }
    public static void main(String[] args) {
        
    }
    
}
