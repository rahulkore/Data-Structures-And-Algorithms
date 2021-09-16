package Algorithms.sortingAlgorithms;

public class BubbleSort {

    static void bubbleSort(int a[]){
        int i,j,temp;
        int exchange = 1;
        for(i=0;i<a.length-1 && exchange ==1 ;i++){
            exchange = 0;
            for(j=0;j<a.length-1;j++){
                if(a[j] > a[j+1]){
                    exchange = 1;
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int elements[]= {59,23,65,12,38,80,30,45,35};
        bubbleSort(elements);
        for (int i : elements) {
            System.out.println(i);   
        }
    }
}
