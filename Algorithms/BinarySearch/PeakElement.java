package Algorithms.BinarySearch;


// A Java program to find a peak element
// using divide and conquer
class PeakElement
{


/**Most people have figured out the binary search solution but are not able to understand how
 *  its working. I will try to explain it simply. What we are essentially doing is going in the 
 * direction of the rising slope(by choosing the element which is greater than current). 
 * How does that guarantee the result? Think about it, there are 2 possibilities.a) rising
 *  slope has to keep rising till end of the array b) rising slope will encounter a lesser
 *  element and go down.
In both scenarios we will have an answer. In a) the answer is the end element because we take 
the boundary as -INFINITY b) the answer is the largest element before the slope falls. Hope this 
makes things clearer. */
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

