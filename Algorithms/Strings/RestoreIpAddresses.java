package Algorithms.Strings;
import java.util.*;
/**
 * generate all valid IP addresses
 */
public class RestoreIpAddresses {

    public static void restore(String s){
        List<String> ans = new ArrayList<>();
        helper(s,0,0,"",ans);
    }

    public static void helper(String s,int i,int par,String ans,List<String> res){
        if(i == s.length() || par==4){
            if(i == s.length() && par==4){
                res.add(ans.substring(0,ans.length()-1));
            }
            return;
        }
        helper(s,i+1,par+1,ans+s.charAt(i)+".",res);
        if(i+2<=s.length() && isvalid(s.substring(i,i+2)))
            helper(s,i+2,par+1,ans+s.substring(i,i+2)+".",res);
        if(i+3<=s.length() && isvalid(s.substring(i,i+3)))
            helper(s,i+3,par+1,ans+s.substring(i,i+3)+".",res);
    }
    public static boolean isvalid(String str){
        if(str.charAt(0) == '0'){
            return false;
        }
        return Integer.parseInt(str)<=255;
    }
    public static void main(String[] args) {
        
    }
    
}
