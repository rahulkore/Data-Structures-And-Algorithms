package Algorithms.TopMicrosoftAskedQuestionsLeetCode;
import java.util.*;
/**
 * spiral traversal 
 */
public class SpiralTraversal {

    public List<Integer> spiralOrder(int[][] matrix) {
        
        if(matrix.length == 0)
            return new ArrayList<>();
        if(matrix[0].length==0)
            return new ArrayList<>();
        int minr = 0;
        int minc = 0;
        int maxr = matrix.length-1;
        int maxc = matrix[0].length-1;
        int cnt = 0;
        List<Integer> ans  = new ArrayList<>();
        int tne = (matrix.length)*(matrix[0].length);
        while(cnt < tne ){

            // Top right to left 
            for(int i=minr , j=minc ; j<=maxc && cnt<tne ; j++){
                // System.out.print(matrix[i][j]);
                ans.add(matrix[i][j]);
                cnt++;
            }

            minr++;

            for(int i=minr , j=maxc ; i<=maxr && cnt<tne ; i++){
                // System.out.print(matrix[i][j]);
                ans.add(matrix[i][j]);
                cnt++;
            }

            maxc--;

            for(int i=maxr , j=maxc ; j>=minc && cnt<tne ; j--){
                // System.out.print(matrix[i][j]);
                ans.add(matrix[i][j]);
                cnt++;
            }

            maxr--;

            for(int i=maxr , j=minc ; i>=minr && cnt<tne ; i--){
                // System.out.print(matrix[i][j]);
                ans.add(matrix[i][j]);
                cnt++;
            }

            minc++;


        }

        return ans;
        
    }
    public static void main(String[] args) {
        
    }
    
}
