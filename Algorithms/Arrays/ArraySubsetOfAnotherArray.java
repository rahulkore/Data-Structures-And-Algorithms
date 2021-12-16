package Algorithms.Arrays;

public class ArraySubsetOfAnotherArray {

    /**
     * Naive Approach 
     * Tc = O(n2)
     * Sc = O(1)
     * use two for loops and do linear search 
     */

     /**
      * 1st optimize approach 
        Tc = O(nlogn + mlogn)
        first sort the power array
        then apply binary search  
      */

      /**
       * 2nd Optimize approach 
       * Tc = O(nlogn + mlogm)
       * First sort both the arrays , 
       * then apply merge operation of merge sort and keep a check 
       * if the first array gets exhausted without having all the elements from the 
       * second array then it is not a subset 
       * Sc = 
       * 
       */

       /**
        * 3rd optimize approach 
        Tc = O(n)
        Sc = O(n)
        create a hashmap for the first array 
        and then check whether all the elements of second array are present in the first array or not 
        * 
        */
    public static void main(String[] args) {
        
    }
    
}
