package Algorithms.Heaps;
import java.util.*;
/**
 * A Binary Heap is a Binary Tree with following properties.
1) It’s a complete tree (All levels are completely filled except possibly the last level and the 
last level has all keys as left as possible). This property of Binary Heap makes them suitable to 
be stored in an array.

2) A Binary Heap is either Min Heap or Max Heap. In a Min Binary Heap, the key at root must be minimum
keys present in Binary Heap. The same property must be recursively true for all nodes in Binary Tree.
 Max Binary Heap is similar to MinHeap.


 How is Binary Heap represented?
A Binary Heap is a Complete Binary Tree. A binary heap is typically represented as an array.

The root element will be at Arr[0].
Below table shows indexes of other nodes for the ith node, i.e., Arr[i]:
Arr[(i-1)/2]	Returns the parent node
Arr[(2*i)+1]	Returns the left child node
Arr[(2*i)+2]	Returns the right child node


Operations on Min Heap:
1) getMini(): It returns the root element of Min Heap. Time Complexity of this operation is O(1).

2) extractMin(): Removes the minimum element from MinHeap. 
Time Complexity of this Operation is O(Logn) as this operation needs to maintain the heap property
 (by calling heapify()) after removing root.

3) decreaseKey(): Decreases value of key. The time complexity of this operation is O(Logn). 
If the decreases key value of a node is greater than the parent of the node, then we don’t need 
to do anything. Otherwise, we need to traverse up to fix the violated heap property.

4) insert(): Inserting a new key takes O(Logn) time. We add a new key at the end of the tree. 
IF new key is greater than its parent, then we don’t need to do anything. Otherwise, we need to
 traverse up to fix the violated heap property.

5) delete(): Deleting a key also takes O(Logn) time. We replace the key to be deleted with minum 
infinite by calling decreaseKey(). After decreaseKey(), the minus infinite value must reach root, 
so we call extractMin() to remove the key.


 */
public class MinHeaps {

    private int[] Heap;
    private int size;
    private int maxsize;

    public MinHeaps(int maxsize)    
    {
        // This keyword refers to current instance itself
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize];
    }

    private int parent(int pos) { return (pos - 1) / 2; }
 
    private int leftChild(int pos) { return (2 * pos + 1); }
 
    private int rightChild(int pos) { return (2 * pos) + 2; }

    private void swap(int fpos, int spos)
    {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    public void insert(int element)
    {
        if(size == maxsize){
            System.out.println("over flow");
            return;
        }
        Heap[size] = element;
        // Traverse up and fix violated property
        int current = size;
        while (current!=0 && Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }

    public void decreaseKey(int i, int new_val){

        Heap[i] = new_val;
        while (i!=0 && Heap[i] < Heap[parent(i)]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public int extractMin(){
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
        minHeapify(0);
        return root;
    }

    public void deleteKey(int i){
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

    public void minHeapify(int i){

        int l = leftChild(i);
        int r = rightChild(i);
        int smallest = i;
        if(l<size && Heap[l] < Heap[i])
        smallest=l;
        if(r<size && Heap[r] < Heap[smallest])
        smallest=r;
        if(smallest != i){
            swap(i,smallest);
            minHeapify(smallest);
        }

    }
    public static void main(String[] args) {
        
    }
    
}
