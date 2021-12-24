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

    
    private static int[] Heap;
    private static int size;
    private static int maxsize;

    public MaxHeaps(int maxsize)    
    {
        // This keyword refers to current instance itself
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize];
    }

    private static int parent(int pos) { return (pos - 1) / 2; }
 
    private static int leftChild(int pos) { return (2 * pos + 1); }
 
    private static int rightChild(int pos) { return (2 * pos) + 2; }

    private static void swap(int fpos, int spos)
    {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    public static void insert(int element)
    {
        if(size == maxsize){
            System.out.println("over flow");
            return;
        }
        Heap[size] = element;
        // Traverse up and fix violated property
        int current = size;
        while (current!=0 && Heap[current] > Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }

    public static void decreaseKey(int i, int new_val){

        Heap[i] = new_val;
        while (i!=0 && Heap[i] > Heap[parent(i)]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public static int extractMax(){
        if(size <= 0){
            return Integer.MIN_VALUE;
        }
        if(size == 1){
            size--;
            return Heap[0];
        }
        int root = Heap[0];
        Heap[0] = Heap[size-1];
        size--;
        maxHeapify(0);
        return root;
    }

    public static void deleteKey(int i){
        decreaseKey(i, Integer.MIN_VALUE);
        extractMax();
    }

    public static void maxHeapify(int i){

        int l = leftChild(i);
        int r = rightChild(i);
        int largest = i;
        if(l<size && Heap[l] > Heap[i])
        largest=l;
        if(r<size && Heap[r] > Heap[largest])
        largest=r;
        if(largest != i){
            swap(i,largest);
            maxHeapify(largest);
        }

    }
    public static void main(String[] arg)
    {
        MaxHeaps maxHeap = new MaxHeaps(10);
        // Display message for better readability
        int nums[] = {1,2,3,4,5,6,7,8,9,10};
        for(int ele : nums){
            maxHeap.insert(ele);
        }
        for(int i =0 ;i<nums.length;i++){
            System.out.println(maxHeap.extractMax());
        }
       
    }
    
}
