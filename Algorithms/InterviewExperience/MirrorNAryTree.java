package Algorithms.InterviewExperience;

// Java program to check two n-ary trees are mirror.

import java.io.*;
import java.util.*;

/**
 * The main approach is to use one list of stack and one list of queue to store to 
 * value of nodes given in the form of two arrays.

1. Initialize both the lists with empty stack and empty queues respectively.

2. Now, iterate over the lists
    Push all connected nodes of each node of first tree in list of stack and second 
    tree list of queue.
    
3. Now iterate over the array and pop item from both stack and queue and check if
 they are same, if not same then return 0.

 */
class MirrorNAryTree {

	// Function to check given two trees     are mirror
	// of each other or not
	static int checkMirrorTree(int n, int e, int[] A, int[] B) {

		//Lists to store nodes of the tree
		List<Stack<Integer>> s = new ArrayList<>();
		List<Queue<Integer>> q = new ArrayList<>();

		// initializing both list with empty stack and queue
		for (int i = 0; i <= n; i++) {
			s.add(new Stack<>());
			Queue<Integer> queue = new LinkedList<>();
			q.add(queue);
		}

		// add all nodes of tree 1 to list of stack and tree 2 to list of queue
		for (int i = 0; i < 2 * e; i += 2) {
			s.get(A[i]).push(A[i + 1]);
			q.get(B[i]).add(B[i + 1]);
		}

		// now take out the stack and queues
		// for each of the nodes and compare them
		// one by one
		for (int i = 1; i <= n; i++) {
			while (!s.get(i).isEmpty() && !q.get(i).isEmpty()) {
				int a = s.get(i).pop();
				int b = q.get(i).poll();

				if (a != b) {
					return 0;
				}
			}
		}

		return 1;
	}

	public static void main (String[] args) {
		int n = 3;
		int e = 2;
		int A[] = { 1, 2, 1, 3 };
		int B[] = { 1, 3, 1, 2 };

		if (checkMirrorTree(n, e, A, B) == 1) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}
}
