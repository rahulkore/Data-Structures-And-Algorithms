package Algorithms.Strings;
/**
 * Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
 */
public class LongestCommonPrefix {

    /** normal approach using character by character check */
    public int findMinLength(String[] strs){
        int res=Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++){
            res = Math.min(res,strs[i].length());
        }
        return res;
    }
    public String longestCommonPrefix(String[] strs) {
        int n = findMinLength(strs);
        String ans = "";
        for(int i=0;i<n;i++){
            char current  = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(current != strs[j].charAt(i)){
                    return ans;
                }
            }
            ans += current;
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
    
}
