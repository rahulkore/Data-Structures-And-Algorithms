package misc;
/**
 * Given two strings a and b, return the minimum number of times you should repeat string a so that string b is a substring of it. If it is impossible for b​​​​​​ to be a substring of a after repeating it, return -1.

Notice: string "abc" repeated 0 times is "",  repeated 1 time is "abc" and repeated 2 times is "abcabc".

 

Example 1:

Input: a = "abcd", b = "cdabcdab"
Output: 3
Explanation: We return 3 because by repeating a three times "abcdabcdabcd", b is a substring of it
 */
public class RabinKarpAlgorithm {

    private int BASE = 1000000;
    public int Rabin_Karp(String source, String target){
        if(source == "" || target == "") return -1;
        int m = target.length();
        int power = 1;
        for(int i = 0;i<m;i++){
            power = (power*31)%BASE;
        }
        int targetCode = 0;
        for(int i = 0;i<m;i++){
            targetCode = (targetCode*31+target.charAt(i))%BASE;
        }
        int hashCode = 0;
        for(int i = 0;i<source.length();i++){
            hashCode = (hashCode*31 + source.charAt(i))%BASE;
            if(i<m-1) continue;
            if(i>=m){
                hashCode = (hashCode-source.charAt(i-m)*power)%BASE;
            }
            if(hashCode<0)
                hashCode+=BASE;
            if(hashCode == targetCode){
                if(source.substring(i-m+1,i+1).equals(target)){
                    return i-m+1;
                }                    
            }
        }
        return -1;
    }
    public int repeatedStringMatch(String a, String b) {
        if(a == b) return 1;
        int count = 1;
        String source = a;
        while(source.length() < b.length()){
            count++;
            source+=a;
        }
        if(source == b) return count;
        if(Rabin_Karp(source,b) != -1) return count;
        if(Rabin_Karp(source+a,b) != -1) return count+1;
        return -1;
    }
    public static void main(String[] args) {
        
    }
    
}
