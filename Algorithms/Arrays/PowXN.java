package Algorithms.Arrays;
/**
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

 

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
 */
public class PowXN {

    public double myPow(double x, int n) {
        double ans = 1.0;
        long nn = n;
        if(nn<0) nn= -1*nn;
        while(nn>0){
            if(nn%2==0){
                x*=x;
                nn/=2;
            }else{
                ans*=x;
                nn-=1;
            }
            System.out.println(nn+" "+x+" "+ans);
        }
        if(n<0) return (double)(1.0)/(double)(ans);
        return ans;
    }
    public static void main(String[] args) {
        
    }
    
}
