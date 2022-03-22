package Algorithms.TopFacebookAskedQuestionsLeetCode;

public class CuttingRibbons {

    public boolean isCutPossible(int[] ribbons, int length, int k) {
        int count = 0;
        for (int ribbon: ribbons) {
            count += (ribbon / length);
            if(count>=k) return true;
        } 
        return count >= k;
    }

    public int maxLength(int[] ribbons, int k) {
        int l = 1;
        int r = (int) 1e5 + 1;
        while (l <= r) {
            int mid = (l+r)/2;
            
            if (isCutPossible(ribbons, mid, k)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l - 1; // since the loop gets over when l crosses r , so l-1 is the answer 
    }

    public static void main(String[] args) {
        
    }
    
}
