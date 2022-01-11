package Algorithms.Strings;
/**
 * pattern matching algorithm 
 * 
 * Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

 

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Example 3:

Input: haystack = "", needle = ""
Output: 0
 */
public class Kmp {

    /**
     * lps => longest prefix suffix
     * Tc = O(m+n)
     * Sc = O(m)
     * @param lps
     * @param pattern
     */
    public static void constructLps(int[] lps,String pattern){
        int i=1;
        int j=0;
        int n = lps.length;
        while(i<n){
            if(pattern.charAt(i) == pattern.charAt(j)){
                j++;
                lps[i] = j;
                i++;
            }else {
                if(j!=0){
                    j = lps[j-1]; // if j!=0 then make j equals index in prev value
                }else{
                    lps[i]=j; // if j==0 then just assign in lps
                    i++;
                }
            }
        }
    }
    public static int kmp(String haystack,String needle,int[] lps){
        int i=0;
        int j=0;
        int N = haystack.length();
        int M = needle.length();
        while(i<N){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }
            if(j == M){// meands pattern found
                // j = lps[j-1]
                return i-j;
            }else if(i < N && (haystack.charAt(i) != needle.charAt(j))){
                if(j!=0){
                    j = lps[j-1]; // same like in lps calculation
                }else{
                    i++;
                }
            }
        }
        return -1;
    }
    public static int strStr(String haystack, String needle) {
        if(needle == null || needle.length()==0) return 0;
        if(haystack == null || haystack.length()==0) return -1;
        int[] lps = new int[needle.length()];
        constructLps(lps,needle);
        return kmp(haystack,needle,lps);
    }

    public static void main(String[] args) {

        String haystack = "hello";
        String needle = "ll";
        int indx = strStr(haystack, needle);
        System.out.println(indx);
    }
    
}
