package Algorithms.Arrays;
import java.util.*;
/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans  = new ArrayList<>();
        List<Integer> row,prev = null;
        for(int i=0;i<numRows;i++){
            row = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    row.add(1);
                }else{
                    row.add(prev.get(j-1) + prev.get(j));
                }
            }
            prev=row;
            ans.add(row);
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
    
}
