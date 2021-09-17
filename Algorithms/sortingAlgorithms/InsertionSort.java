package Algorithms.sortingAlgorithms;


/**
Time complexity analysis 
Best Case => n (when all the elements are sorted)

worst Case => n^2
 */
public class InsertionSort {

    static void insertionSort(int a[]){
        int i,j,val;
        for(i = 0;i<a.length-1;i++){
            val = a[i+1];
            for(j =i;j>=0;j--){
                if(a[j]>val){
                    a[j+1] = a[j];
                }else{
                    break;
                }
            }
            a[j+1]=val;
        }
    }

    public static void main(String[] args) {
        int elements[]= {59,23,65,12,38,80,30,45,35};
        insertionSort(elements);
        for (int i : elements) {
            System.out.println(i);   
        }
    }
    
}
