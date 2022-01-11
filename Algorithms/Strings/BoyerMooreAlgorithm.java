package Algorithms.Strings;
/**
 * pattern matching algorithm 
 * 
 * Boyer Moore is a combination of the following two approaches. 
1) Bad Character Heuristic 
2) Good Suffix Heuristic 
Both of the above heuristics can also be used independently to search a pattern in a text. Let us
 first understand how two independent approaches work together in the Boyer Moore algorithm. If we 
 take a look at the Naive algorithm, it slides the pattern over the text one by one. KMP algorithm 
 does preprocessing over the pattern so that the pattern can be shifted by more than one. The Boyer 
 Moore algorithm does preprocessing for the same reason. It processes the pattern and creates 
 different arrays for each of the two heuristics. At every step, it slides the pattern by the max of 
 the slides suggested by each of the two heuristics. So it uses greatest offset suggested by the two 
 heuristics at every step. 
Unlike the previous pattern searching algorithms, the Boyer Moore algorithm starts matching from the
 last character of the pattern.
In this post, we will discuss the bad character heuristic and the Good Suffix heuristic in the next
 post. 
 

Bad Character Heuristic


The idea of bad character heuristic is simple. The character of the text which doesn’t match with 
the current character of the pattern is called the Bad Character. Upon mismatch, we shift the pattern
 until – 
1) The mismatch becomes a match
2) Pattern P moves past the mismatched character.
Case 1 – Mismatch become match 
We will lookup the position of the last occurrence of the mismatched character in the pattern, and if
 the mismatched character exists in the pattern, then we’ll shift the pattern such that it becomes
  aligned to the mismatched character in the text T. 
 

Boyer Moore Algorithm for Pattern Searching
case 1
G C A A T G C C T A T 
T A T G T G 

Explanation: In the above example, we got a mismatch at position 3. Here our mismatching character 
is “A”. Now we will search for last occurrence of “A” in pattern. We got “A” at position 1 in pattern
 (displayed in Blue) and this is the last occurrence of it. Now we will shift pattern 2 times so 
 that “A” in pattern get aligned with “A” in text.
Case 2 – Pattern move past the mismatch character 
We’ll lookup the position of last occurrence of mismatching character in pattern and if character 
does not exist we will shift pattern past the mismatching character. 
 

Boyer Moore Algorithm for Pattern Searching
case2
G C A A T G C C T A T 
    T A T G T G 
Explanation: Here we have a mismatch at position 7. The mismatching character “C” does not exist in 
pattern before position 7 so we’ll shift pattern past to the position 7 and eventually in above 
example we have got a perfect match of pattern (displayed in Green). We are doing this because “C” 
does not exist in the pattern so at every shift before position 7 we will get mismatch and our search
 will be fruitless.
In the following implementation, we preprocess the pattern and store the last occurrence of every 
possible character in an array of size equal to alphabet size. If the character is not present at all, 
then it may result in a shift by m (length of pattern). Therefore, the bad character heuristic takes
 O(n/m)  time in the best case.
 */
public class BoyerMooreAlgorithm {

    static int NO_OF_CHARS = 256;
      
    //A utility function to get maximum of two integers
    public static int max (int a, int b) { return (a > b)? a: b; }
 
     //The preprocessing function for Boyer Moore's
     //bad character heuristic
    public static void badCharHeuristic( char []str, int size,int badchar[])
    {
 
      // Initialize all occurrences as -1
      for (int i = 0; i < NO_OF_CHARS; i++)
           badchar[i] = -1;
 
      // Fill the actual value of last occurrence
      // of a character (indices of table are ascii and values are index of occurrence)
      for (int i = 0; i < size; i++)
           badchar[str[i]] = i;
    }
 
     /* A pattern searching function that uses Bad
     Character Heuristic of Boyer Moore Algorithm */
    public static void search( char txt[],  char pat[])
    {
        int m = pat.length;
        int n = txt.length;
 
        int badchar[] = new int[NO_OF_CHARS];
 
      /* Fill the bad character array by calling
         the preprocessing function badCharHeuristic()
         for given pattern */
        badCharHeuristic(pat, m, badchar);
 
        int s = 0;  // s is shift of the pattern with
                  // respect to text
       //there are n-m+1 potential allignments
        while(s <= (n - m))
        {
          int j = m-1;
 
          /* Keep reducing index j of pattern while
             characters of pattern and text are
             matching at this shift s */
          while(j >= 0 && pat[j] == txt[s+j])
              j--;
 
          /* If the pattern is present at current
             shift, then index j will become -1 after
             the above loop */
          if (j < 0)
          {
              System.out.println("Patterns occur at shift = " + s);
 
              /* Shift the pattern so that the next
                 character in text aligns with the last
                 occurrence of it in pattern.
                 The condition s+m < n is necessary for
                 the case when pattern occurs at the end
                 of text */
              //txt[s+m] is character after the pattern in text
              s += (s+m < n)? m-badchar[txt[s+m]] : 1;
 
          }
 
          else
              /* Shift the pattern so that the bad character
                 in text aligns with the last occurrence of
                 it in pattern. The max function is used to
                 make sure that we get a positive shift.
                 We may get a negative shift if the last
                 occurrence  of bad character in pattern
                 is on the right side of the current
                 character. */
              s += max(1, j - badchar[txt[s+j]]);
              //System.out.print(badchar[txt[s+j]] + " " + txt[s+j]);
        }
    }

    public static void main(String[] args) {

        char txt[] = "ABAAABCDABC".toCharArray();
        char pat[] = "ABC".toCharArray();
        search(txt, pat);
        
    }
    
}
