package Algorithms.InterviewExperience;
import java.util.*;
/**You are given a string s and an integer k. You can choose any character of the 
 * string and change it to any other uppercase English character. You can perform this 
 * operation at most k times.

Return the length of the longest substring containing the same letter you can get after
 performing the above operations.

  */
public class MaxLengthWithSameCharAfterkReplacement {

    public int helper(String s, int k , char ch){
        int n = s.length();
        int l=0;
        int r=0;
        int cnt=0;
        int maxlen=0;
        while(r<n){
            if(ch != s.charAt(r)){
                cnt++;
            }
            while(cnt > k){
                if(s.charAt(l) != ch){
                    cnt--;
                }
                l++;
            }
            maxlen = Math.max(maxlen,r-l+1);
            r++;
        }
        return maxlen;
    }
    public int characterReplacement(String s, int k) {
        int maxlen=1;
        Set<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            set.add(s.charAt(i));
        }
        Iterator<Character> it = set.iterator();
        while(it.hasNext()){
            maxlen = Math.max(maxlen,helper(s,k,it.next()));
        }
        return maxlen;
    }

    public static void main(String[] args) {
        
    }
    
}
