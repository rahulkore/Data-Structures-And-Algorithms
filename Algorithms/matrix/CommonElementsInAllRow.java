package Algorithms.matrix;
import java.util.*;
/**
 * Given an m x n matrix, find all common elements present in all rows in O(mn) time and one traversal of matrix.
Example: 

Input:
mat[4][5] = {{1, 2, 1, 4, 8},
             {3, 7, 8, 5, 1},
             {8, 7, 7, 3, 1},
             {8, 1, 2, 7, 9},
            };

Output: 
1 8 or 8 1
8 and 1 are present in all rows.
 */
public class CommonElementsInAllRow {
    /**
     * A simple solution is to consider every element and check if it is present in all rows. If present, then print it. 
A better solution is to sort all rows in the matrix and use similar approach as discussed here. Sorting will take O(mnlogn) time and finding common elements will take O(mn) time. So overall time complexity of this solution is O(mnlogn)
Can we do better than O(mnlogn)? 
The idea is to use maps. We initially insert all elements of the first row in an map. For every other element in remaining rows, we check if it is present in the map. If it is present in the map and is not duplicated in current row, we increment count of the element in map by 1, else we ignore the element. If the currently traversed row is the last row, we print the element if it has appeared m-1 times before. 
Below is the implementation of the idea:
     * 
     */
    static void printCommonElements(int mat[][])
    {
        int M = mat.length;
        int N = mat[0].length;
    
        Map<Integer,Integer> mp = new HashMap<>();
        
        // initialize 1st row elements with value 1
        for (int j = 0; j < N; j++)
            mp.put(mat[0][j],1);
            
        // traverse the matrix
        for (int i = 1; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                // If element is present in the map and
                // is not duplicated in current row.
                if (mp.get(mat[i][j]) != null && mp.get(mat[i][j]) == i)
                {
                    // we increment count of the element
                    // in map by 1
                    mp.put(mat[i][j], i + 1);
    
                    // If this is last row
                    if (i == M - 1)
                        System.out.print(mat[i][j] + " ");
                }
            }
        }
    }
    public static void main(String[] args) {

        int mat[][] =
                    {
                        {1, 2, 1, 4, 8},
                        {3, 7, 8, 5, 1},
                        {8, 7, 7, 3, 1},
                        {8, 1, 2, 7, 9},
                    };
 
    printCommonElements(mat);
        
    }
    
}

