package Algorithms.BinarySearch;
/**
 * Optimized using the fact that the difference between all adjacent elements is at most k. 
 * The idea is to start comparing from the leftmost element and find the difference between 
 * the current array element and x. Let this difference be ‘diff’. From the given property of 
 * the array, we always know that x must be at least ‘diff/k’ away, so instead of searching 
 * one by one, we jump ‘diff/k’. 
Below is the implementation of the above idea.
 */
public class SearchWhereAdjDiffByAtmostK {

    // x is the element to be searched
    // in arr[0..n-1] such that all
    // elements differ by at-most k.
    static int search(int arr[], int n, int x, int k)
    {
         
        // Traverse the given array starting
        // from leftmost element
        int i = 0;
         
        while (i < n) {
             
            // If x is found at index i
            if (arr[i] == x)
                return i;
 
            // Jump the difference between
            // current array element and x
            // divided by k We use max here
            // to make sure that i moves
            // at-least one step ahead.
            i = i + Math.max(1, Math.abs(arr[i]- x) / k);
        }
 
        System.out.println("number is " + "not present!");
        return -1;
    }
    public static void main(String[] args) {
        
    }
    
}
