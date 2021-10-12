package Algorithms.Recursion;
import java.util.*;
/**
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.
 */
public class PalindromePartitioning {

    private boolean ispalindrome(String s , int start , int end){
        char[] str = s.toCharArray();
        while(start <= end){
            if(str[start++] != str[end--]) {return false;}
        }
        return true;
    }
    private void palindromepartitioning(String s , int ind, List<List<String>> ans , List<String> ds){
        if(ind == s.length()){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = ind ; i< s.length() ; i++){
            if(ispalindrome(s,ind,i)){
                ds.add(s.substring(ind,i+1));
                palindromepartitioning(s,i+1,ans,ds);
                ds.remove(ds.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        palindromepartitioning(s,0,ans,new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) {
        
    }
    
}
