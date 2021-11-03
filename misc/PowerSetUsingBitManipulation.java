package misc;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class PowerSetUsingBitManipulation {

    public static List<String> main(String[] args) {
        String str = "abc";
        int n = str.length();
        char[] s = str.toCharArray();
        List<String> ans = new ArrayList<>();
        for(int num = 0; num < (1 << n); num++) {
            String sub = ""; 
            for(int i = 0;i<n;i++) {
                if((num & (1<<i)) !=0) {
                    sub += s[i];
                }
            }
            if(sub.length() > 0)
                ans.add(sub);
        }
        return ans;
    }
    
}
