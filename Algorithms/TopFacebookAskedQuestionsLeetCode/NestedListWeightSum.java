package Algorithms.TopFacebookAskedQuestionsLeetCode;
/**You are given a nested list of integers nestedList. Each element is either an integer or a list 
 * whose elements may also be integers or other lists.

The depth of an integer is the number of lists that it is inside of. For example, the nested list
 [1,[2,2],[[3],2],1] has each integer's value set to its depth.

Return the sum of each integer in nestedList multiplied by its depth.

 

Example 1:


Input: nestedList = [[1,1],2,[1,1]]
Output: 10
Explanation: Four 1's at depth 2, one 2 at depth 1. 1*2 + 1*2 + 2*1 + 1*2 + 1*2 = 10.
Example 2:


Input: nestedList = [1,[4,[6]]]
Output: 27
Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3. 1*1 + 4*2 + 6*3 = 27.
Example 3:

Input: nestedList = [0]
Output: 0 */
import java.util.*;

  // This is the interface that allows for creating nested lists.
  // You should not implement it, or speculate about its implementation
   interface NestedInteger {
    
 
      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();
 
      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();
 
      // Set this NestedInteger to hold a single integer.
      public void setInteger(int value);
 
      // Set this NestedInteger to hold a nested list and adds a nested integer to it.
      public void add(NestedInteger ni);
 
      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return empty list if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
  }
 
public class NestedListWeightSum {

    /**Tc = O(n) 
     * n => no of individual elements
     * 
     * same as level order traversal in binary trees 
    */
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null){
            return 0;
        }

        int sum = 0;
        int level = 1;

        Queue<NestedInteger> queue = new LinkedList<NestedInteger>(nestedList);
        while(queue.size() > 0){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                NestedInteger ni = queue.poll();

                if(ni.isInteger()){
                    sum += ni.getInteger() * level;
                }else{
                    queue.addAll(ni.getList());
                }
            }

            level++;
        }

        return sum;
    }

    public static void main(String[] args) {
        
    }
    
}
