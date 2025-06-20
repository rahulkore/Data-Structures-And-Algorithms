package Algorithms.Topg;

public class WordBreak140 {
    public static void main(String[] args) {
        
    }
}
/**
 * Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]
Example 2:

Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: []


Solution Intuition 

DFS + Memoization 
Check for individual sub string , if the substring present in dict then make a recursive call for 
the other part of the string. such that if substring(0,i) present then make recursive call 
for substring(i, n) and add in result by appending substring(0,i), memoize the result for all 
substring and check before making the call. 

Let n be the length of the input string.

Time complexity: O(n⋅2^n)

While memoization avoids redundant computations, it does not change the overall 
number of subproblems that need to be solved. In the worst case, there are still unique 2 n
possible substrings that need to be explored, leading to an exponential time complexity. For each subproblem, O(n) work is performed, so the overall complexity is O(n⋅2 
n).

Space complexity: O(n⋅2^n)

The recursion stack can grow up to a depth of n, where each recursive call consumes 
additional space for storing the current state.
The memoization map needs to store the results for all possible substrings, which can be up to 2n
  substrings of size n in the worst case, resulting in an exponential space complexity.
 */
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> mem = new HashMap<>();
        return helper(s, wordDict, mem);
    }

    private List<String> helper(String s, List<String> wordDict, Map<String, List<String>> mem) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() == 0) {
            return res;
        }
        if(mem.containsKey(s)) {
            return mem.get(s);
        }
        if(wordDict.contains(s)) {
            res.add(s);
        }
        for(int i = 1 ; i < s.length() ; i++) {
            String t = s.substring(i);
            if(wordDict.contains(t)) {
                List<String> temp = helper(s.substring(0 , i) , wordDict, mem);
                if(temp.size() != 0) {
                    for(int j = 0 ; j < temp.size() ; j++) {
                        res.add(temp.get(j) + " " + t);
                    }
                }
            }
        }
        mem.put(s , res);
        return res;
    }
}