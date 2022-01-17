package Algorithms.Strings;

public class MinCharAtFrontToMakePalindrome {

    public static int[] computeLPSArray(String str)
{
    int n = str.length();
    int lps[] = new int[n];
    int i = 1, j = 0;
    lps[0] = 0; // lps[0] is always 0
     
    while (i < n)
    {
        if (str.charAt(i) == str.charAt(j))
        {
            j++;
            lps[i] = j;
            i++;
        }
        else
        {
            // This is tricky. Consider the example.
            // AAACAAAA and i = 7. The idea is similar
            // to search step.
            if (j != 0)
            {
                j = lps[j - 1];
                 
                // Also, note that we do not increment
                // i here
            }
            else
            {
                lps[i] = 0;
                i++;
            }
        }
    }
    return lps;
}
 
// Method returns minimum character to be added at
// front to make string palindrome
static int getMinCharToAddedToMakeStringPalin(String str)
{
    StringBuilder s = new StringBuilder();
    s.append(str);
     
    // Get concatenation of string, special character
    // and reverse string
    String rev = s.reverse().toString();
    s.reverse().append("$").append(rev);
     
    // Get LPS array of this concatenated string
    int lps[] = computeLPSArray(s.toString());
    return str.length() - lps[s.length() - 1];
}
 
    public static void main(String[] args) {
        
    }
    
}
