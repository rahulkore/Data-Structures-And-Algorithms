package Algorithms.Arrays;
import java.util.*;
/**
 * Kth smallest element in O(n) time 
 */
public class kthSmallestElement {

    /**
     * In this post method 5 is discussed which is mainly an extension of method 4 (QuickSelect) 
     * discussed in the previous post. The idea is to randomly pick a pivot element. 
     * To implement randomized partition, we use a random function, rand() to generate index 
     * between l and r, swap the element at randomly generated index with the last element,
     *  and finally call the standard partition process which uses last element as pivot.
     */

    // Java program to find k'th smallest element in expected
    // linear time

	// This function returns k'th smallest element in arr[l..r]
	// using QuickSort based method. ASSUMPTION: ALL ELEMENTS
	// IN ARR[] ARE DISTINCT
	static int kthSmallest(int arr[], int l, int r, int k)
	{
		// If k is smaller than number of elements in array
		if (k > 0 && k <= r - l + 1)
		{
			// Partition the array around a random element and
			// get position of pivot element in sorted array
			int pos = randomPartition(arr, l, r);

			// If position is same as k
			if (pos-l == k-1)
				return arr[pos];

			// If position is more, recur for left subarray
			if (pos-l > k-1)
				return kthSmallest(arr, l, pos-1, k);

			// Else recur for right subarray
			return kthSmallest(arr, pos+1, r, k-pos+l-1);
		}

		// If k is more than number of elements in array
		return Integer.MAX_VALUE;
	}

	// Utility method to swap arr[i] and arr[j]
	static void swap(int arr[], int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// Standard partition process of QuickSort(). It considers
	// the last element as pivot and moves all smaller element
	// to left of it and greater elements to right. This function
	// is used by randomPartition()
	static int partition(int arr[], int l, int r)
	{
		int x = arr[r], i = l;
		for (int j = l; j <= r - 1; j++)
		{
			if (arr[j] <= x)
			{
				swap(arr, i, j);
				i++;
			}
		}
		swap(arr, i, r);
		return i;
	}

	// Picks a random pivot element between l and r and
	// partitions arr[l..r] arount the randomly picked
	// element using partition()
	static int randomPartition(int arr[], int l, int r)
	{
		int n = r-l+1;
		int pivot = (int)(Math.random()) * (n-1);
		swap(arr, l + pivot, r);
		return partition(arr, l, r);
	}

    /**
     * The worst case time complexity of the above solution is still O(n2). 
     * In the worst case, the randomized function may always pick a corner element. T
     * he expected time complexity of above randomized QuickSelect is O(n),
     */
	// Driver method to test above
	public static void main(String args[])
	{
		int arr[] = {12, 3, 5, 7, 4, 19, 26};
		int n = arr.length,k = 3;
		System.out.println("K'th smallest element is "+
						kthSmallest(arr, 0, n-1, k));
	}


    /**
     * In previous post, we discussed an expected linear time algorithm. In this post, a worst-case linear time method is discussed. The idea in this new method is similar to quickSelect(), we get worst-case linear time by selecting a pivot that divides array in a balanced way (there are not very few elements on one side and many on another side). After the array is divided in a balanced way, we apply the same steps as used in quickSelect() to decide whether to go left or right of the pivot.
        Following is complete algorithm.

        kthSmallest(arr[0..n-1], k) 
1) Divide arr[] into ⌈n/5⌉ groups where size of each group is 5 except possibly the last group which may have less than 5 elements. 
2) Sort the above created ⌈n/5⌉ groups and find median of all groups. Create an auxiliary array ‘median[]’ and store medians of all ⌈n/5⌉ groups in this median array.
// Recursively call this method to find median of median[0..⌈n/5⌉-1] 
3) medOfMed = kthSmallest(median[0..⌈n/5⌉-1], ⌈n/10⌉)
4) Partition arr[] around medOfMed and obtain its position. 
pos = partition(arr, n, medOfMed)
5) If pos == k return medOfMed 
6) If pos > k return kthSmallest(arr[l..pos-1], k) 
7) If pos < k return kthSmallest(arr[pos+1..r], k-pos+l-1)  
     */



     // int partition(int arr[], int l, int r, int k);
 
// A simple function to find median of arr[]. This is called
// only for an array of size 5 in this program.
static int findMedian(int arr[], int i,int n)
{
        Arrays.sort(arr, i, n);
        return arr[i+(n-i)/2];                    // sort the array and return middle element
}
 
 
// Returns k'th smallest element
// in arr[l..r] in worst case
// linear time. ASSUMPTION: ALL
// ELEMENTS IN ARR[] ARE DISTINCT
static int kthSmallestLiner(int arr[], int l, int r, int k)
{
    // If k is smaller than
    // number of elements in array
    if (k > 0 && k <= r - l + 1)
    {
        int n = r - l + 1 ; // Number of elements in arr[l..r]
 
        // Divide arr[] in groups of size 5,
        // calculate median of every group
        //  and store it in median[] array.
        int i;
         
         // There will be floor((n+4)/5) groups;
        int []median = new int[(n + 4) / 5];
        for (i = 0; i < n/5; i++)
            median[i] = findMedian(arr, l+i*5, l+i*5+5);
             
        // For last group with less than 5 elements
        if (i*5 < n)
        {
            median[i] = findMedian(arr, l+i*5, l+i*5+n%5);
            i++;
        }
 
        // Find median of all medians using recursive call.
        // If median[] has only one element, then no need
        // of recursive call
        int medOfMed = (i == 1)? median[i - 1]:
                                                kthSmallestLiner(median, 0, i - 1, i / 2);
 
        // Partition the array around a random element and
        // get position of pivot element in sorted array
        int pos = partition(arr, l, r, medOfMed);
 
        // If position is same as k
        if (pos-l == k - 1)
            return arr[pos];
        if (pos-l > k - 1) // If position is more, recur for left
            return kthSmallestLiner(arr, l, pos - 1, k);
 
        // Else recur for right subarray
        return kthSmallestLiner(arr, pos + 1, r, k - pos + l - 1);
    }
 
    // If k is more than number of elements in array
    return Integer.MAX_VALUE;
}
 
 
// It searches for x in arr[l..r], and
// partitions the array around x.
static int partition(int arr[], int l,
                        int r, int x)
{
    // Search for x in arr[l..r] and move it to end
    int i;
    for (i = l; i < r; i++)
        if (arr[i] == x)
        break;
    swap(arr, i, r);
 
    // Standard partition algorithm
    i = l;
    for (int j = l; j <= r - 1; j++)
    {
        if (arr[j] <= x)
        {
            swap(arr, i, j);
            i++;
        }
    }
    swap(arr, i, r);
    return i;
}

    
}
