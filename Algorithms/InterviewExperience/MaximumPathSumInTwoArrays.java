package Algorithms.InterviewExperience;

/**Create some variables, result, sum1, sum2. Initialize result as 0. Also initialize 
 * two variables sum1 and sum2 as 0. Here sum1 and sum2 are used to store sum of element
 *  in ar1[] and ar2[] respectively. These sums are between two common points.
Now run a loop to traverse elements of both arrays. While traversing compare current
 elements of array 1 and array 2 in the following order.
If current element of array 1 is smaller than current element of array 2, then update 
sum1, else if current element of array 2 is smaller, then update sum2.
If the current element of array 1 and array 2are same, then take the maximum of sum1 
and sum2 and add it to the result. Also add the common element to the result.
This step can be compared to the merging of two sorted arrays, If the smallest element
 of the two current array indices is processed then it is guaranteed that if there is 
 any common element it will be processed together. So the sum of elements between two
  common elements can be processed. */
class MaximumPathSumInTwoArrays
{
	// Utility function to find maximum of two integers
	int max(int x, int y) { return (x > y) ? x : y; }

	// This function returns the sum of elements on maximum
	// path from beginning to end
	public static int maxPathSum(int ar1[], int ar2[], int m, int n)
	{
		// initialize indexes for ar1[] and ar2[]
		int i = 0, j = 0;

		// Initialize result and current sum through ar1[]
		// and ar2[].
		int result = 0, sum1 = 0, sum2 = 0;

		// Below 3 loops are similar to merge in merge sort
		while (i < m && j < n)
		{
			// Add elements of ar1[] to sum1
			if (ar1[i] < ar2[j])
				sum1 += ar1[i++];

			// Add elements of ar2[] to sum2
			else if (ar1[i] > ar2[j])
				sum2 += ar2[j++];

			// we reached a common point
			else
			{
				// Take the maximum of two sums and add to
				// result
				//Also add the common element of array, once
				result += Math.max(sum1, sum2) + ar1[i];

				// Update sum1 and sum2 for elements after this
				// intersection point
				sum1 = 0;
				sum2 = 0;

				//update i and j to move to next element of each array
				i++;
				j++;
			}
		}

		// Add remaining elements of ar1[]
		while (i < m)
			sum1 += ar1[i++];

		// Add remaining elements of ar2[]
		while (j < n)
			sum2 += ar2[j++];

		// Add maximum of two sums of remaining elements
		result += Math.max(sum1, sum2);

		return result;
	}

	// Driver code
	public static void main(String[] args)
	{
		
		int ar1[] = { 2, 3, 7, 10, 12, 15, 30, 34 };
		int ar2[] = { 1, 5, 7, 8, 10, 15, 16, 19 };
		int m = ar1.length;
		int n = ar2.length;
	
		// Function call
		System.out.println(
			"Maximum sum path is :"
			+ maxPathSum(ar1, ar2, m, n));
	}
}

// This code has been contributed by Mayank Jaiswal

