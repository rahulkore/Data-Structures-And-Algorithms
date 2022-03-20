package Algorithms.TopFacebookAskedQuestionsLeetCode;
import java.util.*;
/**Given a list of accounts where each element accounts[i] is a list of strings, where the first 
 * element accounts[i][0] is a name, and the rest of the elements are emails representing emails 
 * of the account.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person if 
there is some common email to both accounts. Note that even if two accounts have the same name, 
they may belong to different people as people could have the same name. A person can have any 
number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element of each 
account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.

 

Example 1:

Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John",
"johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary",
"mary@mail.com"],["John","johnnybravo@mail.com"]]
Explanation:
The first and second John's are the same person as they have the common email "johnsmith@mail.com".
The third John and Mary are different people as none of their email addresses are used by other
 accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], 
['John', 'johnnybravo@mail.com'], 
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be 
accepted. */
class DSU{
    int[] parent;
    int [] size;
    DSU(int n){
        parent = new int[n];
        size = new int[n];
        for(int i = 0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    public int findParent(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }
    public void unionBySize(int u,int v){
        int pu = findParent(u);
        int pv = findParent(v);
        if(size[pu] < size[pv]){
            parent[pu]=pv;
            size[pv]+=size[pu];
        }else{
            parent[pv] = pu;
            size[pu]+=size[pv];
        }
    }

}
public class AccountsMerge {


    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU uf = new DSU(n);
        Map<String, Integer> emailsRecord = new HashMap();
        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String currEmail = account.get(j);
                if (emailsRecord.containsKey(currEmail)) {
                    uf.unionBySize(emailsRecord.get(currEmail), i);
                } else {
                    emailsRecord.put(currEmail, i);
                }
            }
        }
        
        Map<Integer, TreeSet<String>> mergedAccountsMap = new HashMap();
        for (String email : emailsRecord.keySet()) {
            int parent = uf.findParent(emailsRecord.get(email));
            mergedAccountsMap.putIfAbsent(parent, new TreeSet());
            mergedAccountsMap.get(parent).add(email);
        }
        
        List<List<String>> result = new ArrayList();
        for (int parent : mergedAccountsMap.keySet()) {
            List<String> currAccount = new ArrayList(mergedAccountsMap.get(parent));
            currAccount.add(0, accounts.get(parent).get(0));
            result.add(currAccount);
        }
        
        return result;
    }

    public static void main(String[] args) {
        
    }
    
}
