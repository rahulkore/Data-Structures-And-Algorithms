package Algorithms.matrix;

import java.util.PriorityQueue;
import java.util.*;

/**
 * Print all elements in sorted order from row and column wise sorted matrix
Difficulty Level : Medium
Last Updated : 17 Dec, 2021
Given an n x n matrix, where every row and column is sorted in non-decreasing order. Print all elements of matrix in sorted order.

Example: Input: 
mat[][]  =  { {10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 50},
            };

Output:
Elements of matrix in sorted order
10 15 20 25 27 29 30 32 33 35 37 39 40 45 48 50
 */
public class PrintEleInSortedOrderUsingMatrix {

    static final int INF = Integer.MAX_VALUE;
    static final int N = 4;

    /**
     * START : 
     * matrix is row and column wise sorted 
     * Naive Solution using recursion 
     * Tc = O(n3)
     */
    // A utility function to youngify a Young Tableau.
    // This is different from standard youngify.
    // It assumes that the value at mat[0][0] is infinite.
    static void youngify(int mat[][], int i, int j)
    {
        // Find the values at down and right sides of mat[i][j]
        int downVal = (i + 1 < N) ?
                    mat[i + 1][j] : INF;
        int rightVal = (j + 1 < N) ?
                     mat[i][j + 1] : INF;
 
        // If mat[i][j] is the down right corner element,
        // return
        if (downVal == INF && rightVal == INF)
        {
            return;
        }
 
        // Move the smaller of two values
        // (downVal and rightVal) to mat[i][j]
        // and recur for smaller value
        if (downVal < rightVal)
        {
            mat[i][j] = downVal;
            mat[i + 1][j] = INF;
            youngify(mat, i + 1, j);
        }
        else
        {
            mat[i][j] = rightVal;
            mat[i][j + 1] = INF;
            youngify(mat, i, j + 1);
        }
    }
 
    // A utility function to extract
    // minimum element from Young tableau
    static int extractMin(int mat[][])
    {
        int ret = mat[0][0];
        mat[0][0] = INF;
        youngify(mat, 0, 0);
        return ret;
    }
 
    // This function uses extractMin()
    // to print elements in sorted order
    static void printSorted(int mat[][])
    {
        System.out.println("Elements of matrix in sorted order n");
        for (int i = 0; i < N * N; i++)
        {
            System.out.print(extractMin(mat) + " ");
        }
    }


    /**
     * END : 
     * matrix is row and column wise sorted 
     * Naive Solution using recursion 
     * Tc = O(n3)
     */



    /**
     * START :
     * matrix is row and column wise sorted
     * Optimized solution using min heaps 
     * Tc=O(n2log(n))
     * 
     */
    public static int[][] printSortedOptimized(int[][] mat){
        class Entry{
            int val;
            int r;
            int c;
            Entry(int _val, int _r, int _c){
                this.val = _val;
                this.r = _r;
                this.c = _c;
            }
        }
        int rows = mat.length;
        int cols = mat[0].length;
        PriorityQueue<Entry> pq = new PriorityQueue<>((a,b) -> a.val-b.val);
        for(int i=0;i<rows;i++){
            pq.offer(new Entry(mat[i][0],i,1)); // current row and next col
        }
        int[][] sorted = new int[rows][cols];
        for(int i =0 ; !pq.isEmpty() ; i++){
            Entry e = pq.poll();
            sorted[i/cols][i%cols] = e.val;

            if(e.c < cols){
                pq.offer(new Entry(mat[e.r][e.c],e.r,e.c+1));
            }
        }

        return sorted;
        
    }

    /**
     * END :
     * matrix is row and column wise sorted
     * Optimized solution using min heaps 
     * Tc=O(n2log(n))
     * 
     */

    /**
     * START :
     * matrix is row and column wise sorted , find kth smallest element
     * Optimized solution using min heaps 
     * Tc=O(n2log(n))
     * 
     */
    public int kthSmallest(int[][] matrix, int k) {
        class Entry{
            int val;
            int r;
            int c;
            Entry(int _val, int _r, int _c){
                this.val = _val;
                this.r = _r;
                this.c = _c;
            }
        }
        int[][] mat = matrix;
        int rows = mat.length;
        int cols = mat[0].length;
        PriorityQueue<Entry> pq = new PriorityQueue<>((a,b) -> a.val-b.val);
        for(int i=0;i<rows;i++){
            pq.offer(new Entry(mat[i][0],i,1)); // current row and next col
        }
        // int[][] sorted = new int[rows][cols];
        int cnt =0;
        int ans = 0;
        for(int i =0 ; !pq.isEmpty() ; i++){
            cnt++;
            Entry e = pq.poll();
            if(cnt==k){
                 ans=e.val;
                 break;
            }
            // sorted[i/cols][i%cols] = e.val;
            if(e.c < cols){
                pq.offer(new Entry(mat[e.r][e.c],e.r,e.c+1));
            }
        }
        return ans;
    }
    /**
     * END :
     * matrix is row and column wise sorted , find kth smallest element
     * Optimized solution using min heaps 
     * Tc=O(n2log(n))
     * 
     */


    /**
     * START :
     * matrix is row wise sorted and rotated
     * Optimized solution using min heaps 
     * Tc=O(n2log(n))
     * 
     */
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
    public static int[][] printSortedAnotherVariation(int[][] mat){
        class Entry{
            int val;
            int r;
            int c;
            int initc;
            Entry(int _val, int _r, int _c, int _initc){
                this.val = _val;
                this.r = _r;
                this.c = _c;
                this.initc = _initc;
            }
        }
        int rows = mat.length;
        int cols = mat[0].length;
        PriorityQueue<Entry> pq = new PriorityQueue<>((a,b) -> b.val-a.val);
        for(int i=0;i<rows;i++){
            int c = findMax(mat[i]);
            pq.offer(new Entry(mat[i][c],i,c,c)); // current row and next col
        }
        int[][] sorted = new int[rows][cols];
        for(int i =0 ; !pq.isEmpty() ; i++){
            Entry e = pq.poll();
            sorted[i/cols][i%cols] = e.val;

            int c = e.c - 1;
			if (c < 0) c = cols - 1; // wrap around

            if(c != e.initc){
                pq.offer(new Entry(mat[e.r][c],e.r,c,e.initc));
            }
        }

        return sorted;

    }
    /**
     * END :
     * matrix is row wise sorted and rotated
     * Optimized solution using min heaps 
     * Tc=O(n2log(n))
     * 
     */

    public static void main(String[] args) {

        int[][] given = { 
        {10, 20, 30, 40},
        {15, 25, 35, 45},
        {27, 29, 37, 48},
        {32, 33, 39, 50},
      };
		int[][] expected = { 
        {10, 15, 20, 25},
        {27, 29, 30, 32},
        {33, 35, 37, 39},
        {40, 45, 48, 50},
      };
		int[][] sorted = printSortedOptimized(given);
		System.out.println(Arrays.deepToString(sorted));
		System.out.println(Arrays.deepEquals(sorted, expected));
        

        int[][] given1 = {
			{41, 45, 20, 21},
			{1, 2, 3, 4},
			{30, 42, 43, 29},
			{16, 17, 19, 10},
		};
		int[][] expected1 = {
			{45, 43, 42, 41},
			{30, 29, 21, 20},
			{19, 17, 16, 10},
			{4, 3, 2, 1}
		};
		int[][] sorted1 = printSortedAnotherVariation(given1);
		System.out.println(Arrays.deepToString(sorted1));
		System.out.println(Arrays.deepEquals(sorted1, expected1));
    }
    
}
