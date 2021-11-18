package Algorithms.StackAndQueue;
import java.util.*;
/**
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.

Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).

You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.

There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return -1.

Example
Example1

Input:
2 // next n * (n - 1) lines 
0 knows 1
1 does not know 0
Output: 1
Explanation:
Everyone knows 1,and 1 knows no one.
Example2

Input:
3 // next n * (n - 1) lines 
0 does not know 1
0 does not know 2
1 knows 0
1 does not know 2
2 knows 0
2 knows 1
Output: 0
Explanation:
Everyone knows 0,and 0 knows no one.
0 does not know 1,and 1 knows 0.
2 knows everyone,but 1 does not know 2.
 */
public class TheCelebrityProblem {

    Stack<Integer> st = new Stack<>();
    public boolean knows(int a , int b){
        /** helper function that tells whether a know b or not  */
        /** we can use an adjacency list over here to check the same  */
        /** for now just asume that the function works  */
        return true;// false ;
    }
    public int findCelebrity(int n) {
        // Write your code here
        for(int i=0;i<n;i++)
            st.push(i);
        while(st.size()!=1){
            int a = st.pop();
            int b = st.pop();
            if(knows(a,b)){
                st.push(b);
            }else{
                st.push(a);
            }
        }
        int potentialCelebrity =  st.pop();
        for(int i=0;i<n;i++){
            if(i!=potentialCelebrity && knows(potentialCelebrity,i))
                return -1;
            if(i!=potentialCelebrity && !knows(i,potentialCelebrity))
                return -1;
        }
        return potentialCelebrity;
   }
    public static void main(String[] args) {
        
    }
    
}
