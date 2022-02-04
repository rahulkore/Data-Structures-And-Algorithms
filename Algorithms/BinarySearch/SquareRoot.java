package Algorithms.BinarySearch;

public class SquareRoot {

    public int bs(int x){
        long l = 1, h = x, ans=0;
        while(l<=h){
            long m = (l+h) / 2;
            if((int)m*m == x){
                return (int)m;
            }
            if(x < m*m){
                h=m-1;
            }else{
                l=m+1;
                ans = m; // Since we need floor, we update answer when mid*mid is
            // smaller than x, and move closer to sqrt(x) 
            }
        }
        return (int)ans;
    }
    public int mySqrt(int x) {
        //return bs(x);
        /**
        Above approach is O(logn)
        Below approach is in O(1)
        */
        int sqr = (int)Math.sqrt(x);
        return sqr;
    }
    public static void main(String[] args) {
        
    }
    
}
