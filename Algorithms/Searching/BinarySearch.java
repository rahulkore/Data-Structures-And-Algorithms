package Algorithms.Searching;

public class BinarySearch {


    /**
     * Iterative approach
     * @param a
     * @param l
     * @param h
     * @param ele
     * @return
     */
    static boolean binarySearchIterative(int a[],int l,int h,int ele){
        if(l>h){
            return false;
        }
        int m = (l+h)/2;
        if(ele == a[m]){
            return true;
        }else if(ele < a[m]){
            return binarySearchIterative(a, l, m-1, ele);
        }else{
            return binarySearchIterative(a, m+1, h, ele);
        }
    }


    /**
     * Non iterative approach
     * @param a
     * @param l
     * @param h
     * @param ele
     * @return
     */
    static boolean binarySearch(int a[], int l, int h,int ele){

        while(l<=h){
            int m = (l+h)/2;
            if(ele == a[m])
                return true;
            else if(ele < a[m])
                h = m-1;
            else l = m+1;
        }
        return false;
    }

    public static void main(String[] args) {
        int elements[]= {59,23,65,12,38,80,30,45,35};
        System.out.println(binarySearch(elements,0,elements.length-1,37));
        System.out.println(binarySearchIterative(elements,0,elements.length-1,38)); 

    }
    
}
