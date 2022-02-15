package Algorithms.RemainingImpQuestions;
/**You are given an integer length and an array updates where 
 * updates[i] = [startIdxi, endIdxi, inci].

You have an array arr of length length with all zeros, and you have some operation 
to apply on arr. In the ith operation, you should increment all the elements arr[startIdxi], 
arr[startIdxi + 1], ..., arr[endIdxi] by inci.

Return arr after applying all the updates. 
Input: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
Output: [-2,0,3,5,3]
*/
public class RangeAddition {

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        for(int[] update : updates){
            int start = update[0];
            int end = update[1];
            int inc = update[2];
            
            result[start] += inc;
            
            if(end < length -1)
                result[end+1] -= inc;
            
        }
        
        int cumulative = 0;
        for(int i = 0 ; i < length; i++){
            cumulative += result[i];
            result[i] = cumulative;
        }
        
        return result;
    }
    
}
