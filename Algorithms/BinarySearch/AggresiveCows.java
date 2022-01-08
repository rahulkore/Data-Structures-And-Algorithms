package Algorithms.BinarySearch;

import java.util.Arrays;

public class AggresiveCows {

    boolean isPossible(int a[], int n, int cows, int minDist) {
        int cntCows = 1; 
        int lastPlacedCow = a[0];
        for(int i = 1;i<n;i++) {
            if(a[i] - lastPlacedCow >= minDist) {
                cntCows++;
                lastPlacedCow = a[i]; 
            }
        }
        if(cntCows >= cows) return true;
        return false; 
    }

    public void aggresiveCows(int a[],int n, int cows){
        Arrays.sort(a);
        int low = 1, high = a[n-1] - a[0]; 
    	    while(low <= high) {
    	        int mid = (low + high) >> 1; 
    	        
    	        if(isPossible(a,n,cows,mid)) {
    	            low = mid + 1;
    	        }
    	        else {
    	            high = mid - 1; 
    	        }
    	    }
    	    System.out.println(high);
    }
    public static void main(String[] args) {
        
    }
    
}
