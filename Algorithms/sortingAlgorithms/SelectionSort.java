package Algorithms.sortingAlgorithms;

public class SelectionSort {

    static void selectionSort(int a[]){

        for (int i = 0; i < a.length-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < a.length; j++)
                if (a[j] < a[min_idx])
                    min_idx = j;
 
            // Swap the found minimum element with the first
            // element
            int temp = a[min_idx];
            a[min_idx] = a[i];
            a[i] = temp;
        }
    }

    public static void main(String[] args) {
        int elements[]= {59,23,65,12,38,80,30,45,35};
        selectionSort(elements);
        for (int i : elements) {
            System.out.println(i);   
        }
    }
    
}
