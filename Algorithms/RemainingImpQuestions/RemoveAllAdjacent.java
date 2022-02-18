package Algorithms.RemainingImpQuestions;
import java.util.*;
/**You are given a string s and an integer k, a k duplicate removal consists of choosing k 
 * adjacent and equal letters from s and removing them, causing the left and the right side 
 * of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It is guaranteed 
that the answer is unique.

 

Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
Example 3:

Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"
 */
class node{
    char ch;
    int freq;
    
    node(char _ch, int _freq){
        ch = _ch;
        freq = _freq;
    }
    
    public int getFreq(){
        return freq;
    }
    
    public char getChar(){
        return ch;
    }
}
public class RemoveAllAdjacent {

    public String removeDuplicates(String s, int k) {
        
        LinkedList<node> st = new LinkedList<>();
        for(char c : s.toCharArray()){    
            if(!st.isEmpty() && st.peekLast().getChar() == c){
                st.peekLast().freq++;
            }else{
                st.add(new node(c,1));
            }
            if(st.peekLast().getFreq() == k){
                st.pollLast();
            }
        }
        String ans = "";
        while(!st.isEmpty()){
            ans += String.valueOf(st.peekFirst().getChar()).repeat(st.peekFirst().getFreq());
            st.pollFirst();
        }
        return ans;
    }

    public static void main(String[] args) {
        
    }
    
}
