package Algorithms.TopMicrosoftAskedQuestionsLeetCode;
import java.util.*;
/**Given a string containing digits from 2-9 inclusive, return all possible letter combinations 
 * that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does
 not map to any letters.



 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"] */
public class LetterCombinationsOfAPhoneNumber {


    /**Level order traversal technique */
    public List<String> letterCombinations(String digits) {
		List<String> ans = new LinkedList<String>();
		if (digits.isEmpty())
			return ans;
		String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		ans.add(0, "");
		for (int i = 0; i < digits.length(); i++) {
			int x = Character.getNumericValue(digits.charAt(i));
			int size = ans.size();     // number of nodes/strings already in the queue
			for (int k = 1; k <= size; k++) {
				String t = ans.remove(0);
				for (char s : mapping[x].toCharArray())
					ans.add(t + s);
			}
		}
		return ans;
	}

    public static void main(String[] args) {
        
    }
    
}
