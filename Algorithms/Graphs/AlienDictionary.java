package Algorithms.Graphs;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
/**
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

You may assume all letters are in lowercase.
The dictionary is invalid, if a is prefix of b and b is appear before a.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return the smallest in normal lexicographical order
Example
Example 1:

Input：["wrt","wrf","er","ett","rftt"]
Output："wertf"
Explanation：
from "wrt"and"wrf" ,we can get 't'<'f'
from "wrt"and"er" ,we can get 'w'<'e'
from "er"and"ett" ,we can get 'r'<'t'
from "ett"and"rftt" ,we can get 'e'<'r'
So return "wertf"
Example 2:

Input：["z","x"]
Output："zx"
Explanation：
from "z" and "x"，we can get 'z' < 'x'
So return "zx"
 */
public class AlienDictionary {

    private static int getInt(char c){
        return (c-'a');
    }
    private static boolean checkCycle(int node,  List<List<Integer>> adj, 
    int vis[], int dfsVis[],Stack<Integer> st) {
        vis[node] = 1; 
        dfsVis[node] = 1; 
        
        for(Integer it: adj.get(node)) {
            if(vis[it] == 0) {
                if(checkCycle(it, adj, vis, dfsVis,st) == true) {
                    return true; 
                }
            } else if(dfsVis[it] == 1) {
                return true; 
            }
        }   
        dfsVis[node] = 0;
        st.push(node);
        return false; 
    }
    public String alienOrder(String[] words) {
        // Write your code here

        int n = words.length;
        List<List<Integer>> adj = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for(int i =0 ;i<26;i++){
            adj.add(new ArrayList<>());
        }
        int present[] = new int[26];
        int[] visited  = new int[26];
        int[] dfsVis = new int[26];
        for(int i=0;i<n;i++){
            for(char ch : words[i].toCharArray()){
                present[getInt(ch)] = 1;
            }
        }
        for(int i=0;i<n-1;i++){
            char[] s1 = words[i].toCharArray();
            char[] s2 = words[i+1].toCharArray();
            int m = s1.length;
            for(int j=0;j<m;j++){
                if(j>=s2.length){
                    return "";
                }
                if(s1[j] != s2[j]){
                    adj.get(getInt(s1[j])).add(getInt(s2[j]));
                    break;
                }
            }
        }
        for(int i=0;i<26;i++){
            if(present[i]==1 && visited[i] ==0){
                if(checkCycle(i, adj, visited, dfsVis, st)){
                    return "";
                }
            }
        }
        String ans = "";
        while(!st.isEmpty()){
            ans += (char)(st.pop() + 'a');
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
