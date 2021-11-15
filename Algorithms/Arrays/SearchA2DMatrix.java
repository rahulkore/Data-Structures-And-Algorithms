package Algorithms.Arrays;
/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
 

Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 */
public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length ==0) return false;
        int n = matrix.length;
        int m = matrix[0].length;
        int l = 0;
        int h = n*m - 1;
        while(l<=h){
            int mid = (l+h)/2;
            if(matrix[mid/m][mid%m] == target){
                return true;
            }
            if(target < matrix[mid/m][mid%m]){
                h = mid-1;
            }else{
                l = mid+1;
            }
        }
        return false;
    }

    public boolean searchMatrixDownLeftSearch(int[][] matrix, int target) {
        if(matrix == null || matrix.length ==0) return false;
        int n = matrix.length;
        int m = matrix[0].length;
        /**
        Below is another method based upon down left search 
        */
        int i = 0;
        int j = matrix[0].length-1;
        while(i<n && j>=0){
            if(target == matrix[i][j]) return true;
            if(target < matrix[i][j]) j--;
            else i++;
        }
        return false;
    }
    public static void main(String[] args) {
        
    }
    
}
