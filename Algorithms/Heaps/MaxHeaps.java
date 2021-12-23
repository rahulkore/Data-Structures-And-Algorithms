package Algorithms.Heaps;
import java.util.*;
/**
 * A max-heap is a complete binary tree in which the value in each internal node is greater than or
 *  equal to the values in the children of that node. Mapping the elements of a heap into an array is 
 * trivial: if a node is stored an index k, then its left child is stored at index 2k+1 and its right 
 * child at index 2k+2.
 * 
 * A-Max Heap is a Complete Binary Tree. A-Max heap is typically represented as an array. 
 * The root element will be at Arr[0]. Below table shows indexes of other nodes for the ith node, 
 * i.e., Arr[i]: 

Arr[(i-1)/2] Returns the parent node. 
Arr[(2*i)+1] Returns the left child node. 
Arr[(2*i)+2] Returns the right child node.
Operations on Max Heap are as follows:

getMax(): It returns the root element of Max Heap. The Time Complexity of this operation is O(1).
extractMax(): Removes the maximum element from MaxHeap. The Time Complexity of this Operation is 
O(Log n) as this operation needs to maintain the heap property by calling the heapify() method after 
removing the root.
 insert(): Inserting a new key takes O(Log n) time. We add a new key at the end of the tree. 
 If the new key is smaller than its parent, then we don’t need to do anything. Otherwise, 
 we need to traverse up to fix the violated heap property.
 */
public class MaxHeaps {

    private int[] Heap;
    private int size;
    private int maxsize;

    public MaxHeaps(int maxsize)    
    {
        // This keyword refers to current instance itself
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize];
    }

    // Method 1
    // Returning position of parent
    private int parent(int pos) { return (pos - 1) / 2; }
 
    // Method 2
    // Returning left children
    private int leftChild(int pos) { return (2 * pos + 1); }
 
    // Method 3
    // Returning right children
    private int rightChild(int pos)
    {
        return (2 * pos) + 2;
    }

    // Method 4
    // Returning true of given node is leaf
    private boolean isLeaf(int pos)
    {
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }
 
    // Method 5
    // Swapping nodes
    private void swap(int fpos, int spos)
    {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }


    // Method 6
    // Recursive function to max heapify given subtree
    private void maxHeapify(int pos)
    {
        if (isLeaf(pos))
            return;
 
        if (Heap[pos] < Heap[leftChild(pos)]
            || Heap[pos] < Heap[rightChild(pos)]) {
 
            if (Heap[leftChild(pos)]
                > Heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            }
            else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }

    // Method 7
    // Inserts a new element to max heap
    public void insert(int element)
    {
        Heap[size] = element;
 
        // Traverse up and fix violated property
        int current = size;
        while (Heap[current] > Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }

     // Method 8
    // To display heap
    public void print()
    {
       
      for(int i=0;i<size/2;i++){
 
            System.out.print("Parent Node : " + Heap[i] );
             
            if(leftChild(i)<size) //if the child is out of the bound of the array
               System.out.print( " Left Child Node: " + Heap[leftChild(i)]);
             
            if(rightChild(i)<size) //if the right child index must not be out of the index of the array
                System.out.print(" Right Child Node: "+ Heap[rightChild(i)]);
             
                System.out.println(); //for new line
             
        }
           
    }


    // Method 9
    // Remove an element from max heap
    public int extractMax()
    {
        int popped = Heap[0];
        Heap[0] = Heap[size-1];
        size--;
        maxHeapify(1);
        return popped;
    }

    // Method 10
    // main dri er method
    public static void main(String[] arg)
    {
        // Display message for better readability
        System.out.println("The Max Heap is ");
 
        MaxHeaps maxHeap = new MaxHeaps(15);
 
        // Inserting nodes
        // Custom inputs
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);
 
        // Calling maxHeap() as defined above
        maxHeap.print();
 
        // Print and display the maximum value in heap
        System.out.println("The max val is "
                           + maxHeap.extractMax());
    }
    
}
