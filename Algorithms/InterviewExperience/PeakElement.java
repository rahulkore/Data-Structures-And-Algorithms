package Algorithms.InterviewExperience;


// A Java program to find a peak element
// using divide and conquer
class PeakElement
{

// A binary search based function
// that returns index of a peak element
static int findPeakUtil(int arr[], int low, int high, int n) {
	int l = low;
	int r = high;
	int mid = 0;
	while (l <= r)
	{

	// finding mid by binary right shifting.
	mid = (l + r) >> 1;

	// first case if mid is the answer
	if ((mid == 0 || arr[mid - 1] <= arr[mid] &&
		(mid == n - 1 || arr[mid + 1] <= arr[mid])))
		break;

	// if we have to perform left recursion
	if (mid > 0 && arr[mid - 1] > arr[mid])
		r = mid - 1;

	// else right recursion.
	else
		l = mid + 1;
	}
	return mid;
}

// A wrapper over recursive function findPeakUtil()
static int findPeak(int arr[], int n) {
	return findPeakUtil(arr, 0, n - 1, n);
}

// Driver Code
public static void main(String args[]) {
	int arr[] = { 1, 3, 5, 4, 1, 0,20 };
	int n = arr.length;
	System.out.println("Index of a peak point is " + findPeak(arr, n));
}
}

// This code is contributed by Saurabh Jaiswal

