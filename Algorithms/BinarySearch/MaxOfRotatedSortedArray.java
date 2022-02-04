package Algorithms.BinarySearch;

public class MaxOfRotatedSortedArray {

    private static int findMax(int[] arr) {
		int lo = 0;
		int hi = arr.length - 1;
		while (lo < hi) {
			int mid = (lo + hi + 1) >> 1;
 
			if (arr[mid] > arr[lo]) {
				lo = mid;
			} else {
				hi = mid - 1;
			}
		}
		return lo;
    }
    public static void main(String[] args) {
        
    }
    
}
