package Algorithms.Heaps;

class MinHeaps {

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
    
}

public class HeapSort {

    public static void main(String[] args) {
        MinHeaps minheap = new MinHeaps(10);
        int nums[] = {10,9,8,7,6,5,4,3,2,1};
        for(int ele : nums){
            minheap.insert(ele);
        }
        for(int i =0 ;i<nums.length;i++){
            System.out.println(minheap.extractMin());
        }
    }
    
}
