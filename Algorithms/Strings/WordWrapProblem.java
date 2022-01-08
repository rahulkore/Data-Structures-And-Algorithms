package Algorithms.Strings;
/**
 * Given a sequence of words, and a limit on the number of characters that can be put in one line
 *  (line width). Put line breaks in the given sequence such that the lines are printed neatly. 
 * Assume that the length of each word is smaller than the line width.
The word processors like MS Word do task of placing line breaks. The idea is to have balanced lines. 
In other words, not have few lines with lots of extra spaces and some lines with small amount of 
extra spaces. 
 

The extra spaces includes spaces put at the end of every line except the last one.  
The problem is to minimize the following total cost.
 Cost of a line = (Number of extra spaces in the line)^3
 Total Cost = Sum of costs for all lines

For example, consider the following string and line width M = 15
 "Geeks for Geeks presents word wrap problem" 
     
Following is the optimized arrangement of words in 3 lines
Geeks for Geeks
presents word
wrap problem 

The total extra spaces in line 1, line 2 and line 3 are 0, 2 and 3 respectively. 
So optimal value of total cost is 0 + 2*2 + 3*3 = 13
Please note that the total cost function is not sum of extra spaces, but sum of cubes (or square is 
also used) of extra spaces. The idea behind this cost function is to balance the spaces among lines.
 For example, consider the following two arrangement of same set of words:
1) There are 3 lines. One line has 3 extra spaces and all other lines have 0 extra spaces. Total extra
 spaces = 3 + 0 + 0 = 3. Total cost = 3*3*3 + 0*0*0 + 0*0*0 = 27.
2) There are 3 lines. Each of the 3 lines has one extra space. Total extra spaces = 1 + 1 + 1 = 3
. Total cost = 1*1*1 + 1*1*1 + 1*1*1 = 3.
Total extra spaces are 3 in both scenarios, but second arrangement should be preferred because extra
 spaces are balanced in all three lines. The cost function with cubic sum serves the purpose because
  the value of total cost in second scenario is less.

  Given an array nums[] of size n, where nums[i] denotes the number of characters in one word. Let K be the limit on the number of characters that can be put in one line (line width). Put line breaks in the given sequence such that the lines are printed neatly.
Assume that the length of each word is smaller than the line width. When line breaks are inserted there is a possibility that extra spaces are present in each line. The extra spaces include spaces put at the end of every line except the last one. 

You have to minimize the following total cost where total cost = Sum of cost of all lines, where cost of line is = (Number of extra spaces in the line)2.

Example 1:

Input: nums = {3,2,2,5}, k = 6
Output: 10
Explanation: Given a line can have 6
characters,
Line number 1: From word no. 1 to 1
Line number 2: From word no. 2 to 3
Line number 3: From word no. 4 to 4
So total cost = (6-3)2 + (6-2-2-1)2 = 32+12 = 10.
As in the first line word length = 3 thus
extra spaces = 6 - 3 = 3 and in the second line
there are two word of length 2 and there already
1 space between two word thus extra spaces
= 6 - 2 -2 -1 = 1. As mentioned in the problem
description there will be no extra spaces in
the last line. Placing first and second word
in first line and third word on second line
would take a cost of 02 + 42 = 16 (zero spaces
on first line and 6-2 = 4 spaces on second),
which isn't the minimum possible cost.
Example 2:

Input: nums = {3,2,2}, k = 4
Output: 5
Explanation: Given a line can have 4 
characters,
Line number 1: From word no. 1 to 1
Line number 2: From word no. 2 to 2
Line number 3: From word no. 3 to 3
Same explaination as above total cost
= (4 - 3)2 + (4 - 2)2 = 5.

 */
public class WordWrapProblem {

    final static int MAX = Integer.MAX_VALUE;

    // A utility function to print the solution
    public static int printSolution (int p[], int n)
    {
        int k;
        if (p[n] == 1)
        k = 1;
        else
        k = printSolution (p, p[n]-1) + 1;
        System.out.println("Line number" + " " + k + ": " +
                    "From word no." +" "+ p[n] + " " + "to" + " " + n);
        return k;
    }

    // l[] represents lengths of different words in input sequence.
// For example, l[] = {3, 2, 2, 5} is for a sentence like
// "aaa bb cc ddddd". n is size of l[] and M is line width
// (maximum no. of characters that can fit in a line)
    public static void solveWordWrap (int l[], int n, int M)
    {
        // For simplicity, 1 extra space is used in all below arrays
    
        // extras[i][j] will have number of extra spaces if words from i
        // to j are put in a single line
        int extras[][] = new int[n+1][n+1];
    
        // lc[i][j] will have cost of a line which has words from
        // i to j
        int lc[][]= new int[n+1][n+1];
    
        // c[i] will have total cost of optimal arrangement of words
        // from 1 to i
        int c[] = new int[n+1];
    
        // p[] is used to print the solution.
        int p[] =new int[n+1];
    
        // calculate extra spaces in a single line. The value extra[i][j]
        // indicates extra spaces if words from word number i to j are
        // placed in a single line
        for (int i = 1; i <= n; i++)
        {
            extras[i][i] = M - l[i-1];
            for (int j = i+1; j <= n; j++)
            extras[i][j] = extras[i][j-1] - l[j-1] - 1;
        }

        for(int i=0;i<extras.length;i++){
            for(int j=0;j<extras[0].length;j++){
                System.out.print(extras[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("+++++++++++++++++++++++++++");
        
        // Calculate line cost corresponding to the above calculated extra
        // spaces. The value lc[i][j] indicates cost of putting words from
        // word number i to j in a single line
        for (int i = 1; i <= n; i++)
        {
            for (int j = i; j <= n; j++)
            {
                if (extras[i][j] < 0)
                    lc[i][j] = MAX;
                else if (j == n && extras[i][j] >= 0)
                    lc[i][j] = 0;
                else
                    lc[i][j] = extras[i][j]*extras[i][j];
            }
        }

        for(int i=0;i<lc.length;i++){
            for(int j=0;j<lc[0].length;j++){
                System.out.print(lc[i][j] + " ");
            }
            System.out.println();
        }
        
        // Calculate minimum cost and find minimum cost arrangement.
        // The value c[j] indicates optimized cost to arrange words
        // from word number 1 to j.
        c[0] = 0;
        for (int j = 1; j <= n; j++)
        {
            c[j] = MAX;
            for (int i = 1; i <= j; i++)
            {
                if (c[i-1] != MAX && lc[i][j] != MAX &&
                (c[i-1] + lc[i][j] < c[j]))
                {
                    c[j] = c[i-1] + lc[i][j];
                    p[j] = i;
                }
            }

        }
        System.out.println("+++++++++++++++");
        for (int i : c) {
            System.out.print(i + " ");
        }
        System.out.println("+++++++++++++++");
        for (int i : p) {
            System.out.print(i + " ");
        }
        printSolution(p, n);
    }

    public static void main(String[] args) {

        int l[] = {3, 2, 2, 5};
        int n = l.length;
        int M = 6;
        solveWordWrap (l, n, M);
        
    }
    
}
