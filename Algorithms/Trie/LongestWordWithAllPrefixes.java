package Algorithms.Trie;

class Node {
    Node links[] = new Node[26]; 
    boolean flag = false; 
    
    public Node() {
        
    }
    
    boolean containsKey(char ch) {
        return (links[ch - 'a'] != null); 
    }
    Node get(char ch) {
        return links[ch-'a']; 
    }
    void put(char ch, Node node) {
        links[ch-'a'] = node; 
    }
    void setEnd() {
        flag = true; 
    }
    boolean isEnd() {
        return flag; 
    }
};
public class LongestWordWithAllPrefixes {

    public static Node root;

    LongestWordWithAllPrefixes(){
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public static void insert(String word) {
        Node node = root;
        for(int i = 0;i<word.length();i++) {
            if(!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node()); 
            }
            node = node.get(word.charAt(i)); 
        }
        node.setEnd(); 
    }
    public static boolean checkIfAllPrefixExists(String word) {
        Node node = root;
        boolean flag = true; 
        for(int i = 0;i<word.length() && flag;i++) {
            if(node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i)); 
                flag = flag & node.isEnd(); 
            }
            else {
                return false; 
            } 
        }
        return flag; 
    }
public static String completeString(int n, String[] a){
    for(String word : a) insert(word); 
    String longest = ""; 
    for(String word: a) {
        if(checkIfAllPrefixExists(word)) {
            if(word.length() > longest.length()) {
                longest = word; 
            }
            else if(word.length() == longest.length() && word.compareTo(longest) < 0) {
                longest = word; 
            }
        }
    }
    if(longest == "") return "None"; 
    return longest; 
}

    public static void main(String[] args) {
        
    }
    
}
