package Algorithms.TopFacebookAskedQuestionsLeetCode;


// A Java program to find a peak element
// using divide and conquer
class PeakElement
{

// A binary search based function
// that returns index of a peak element
public static int findPeakElement(int[] num) {
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

// Driver Code
public static void main(String args[]) {
	int arr[] = { 1, 3, 5, 4, 1, 0,20 };
	int n = arr.length;
	System.out.println("Index of a peak point is " + findPeakElement(arr));
}
}

// This code is contributed by Saurabh Jaiswal

