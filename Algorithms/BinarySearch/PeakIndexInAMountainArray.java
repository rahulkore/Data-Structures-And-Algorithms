package Algorithms.BinarySearch;

public class PeakIndexInAMountainArray {


    /** Same as peak element */
    public int peakIndexInMountainArray(int[] num) {
        
    int low = 0;
	int high = num.length-1;
	
	while(low < high)
	{
		int mid1 = (low+high)/2;
		int mid2 = mid1+1;
		if(num[mid1] < num[mid2])
			low = mid2;
		else
			high = mid1;
	}
	return low;
        
    }
    public static void main(String[] args) {
        
    }
    
}
