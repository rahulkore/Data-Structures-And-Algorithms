package Algorithms.TopAmazonAskedQuestionsLeetCode;

/**There are ‘N’ cities numbered from 1 to ‘N’ and ‘M’ roads. Each road connectss two different 
 * cities and described as a two-way road using three integers (‘U’, ‘V’, ‘W’) which represents 
 * the cost ‘W’ to connect city ‘U’ and city ‘V’ together.
Now, you are supposed to find the minimum cost so that for every pair of cities, there exists a 
path of connections (possibly of length 1) that connects those two cities together. The cost is
 the sum of the connection costs used. If the task is impossible, return -1. 
 Sample Input 1 :
2
5 6
1 2 6
2 3 5
3 4 4
1 4 1
1 3 2
3 5 3
3 1
1 2 4
Sample Output 1 :
11
-1*/
 
import java.util.*;
class Dsu{
    int parent[];
    int size[];
    
    Dsu(int n){
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    public int findParent(int x){
        if(parent[x] == x) return x;
        else return parent[x] = findParent(parent[x]);
    }
    
    public void unionbySize(int x,int y){
        int pu = findParent(x);
        int pv = findParent(y);
        if(size[pu] < size[pv]){
            parent[pu] = pv;
            size[pv] += size[pu];
        }else{
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
    
    
}
public class ConnectingCitiesWithMinimumCost {

    public static int getMinimumCost(int n, int m, int[][] connections) {
        // Write your code here.
        int ans=0;
        if(m < n-1)
            return -1;
        Dsu obj = new Dsu(n);
        Arrays.sort(connections , (a,b) -> a[2]-b[2]);
        int edgeCount=0;
        for(int[] edge : connections){
            if(edge[0] == edge[1])
                continue;
            if(obj.findParent(edge[0]-1) != obj.findParent(edge[1]-1)){
                edgeCount +=1;
                ans+=edge[2];
                obj.unionbySize(edge[0]-1,edge[1]-1);
            }
        }
        
        return edgeCount == n-1 ? ans : -1;
    }
    
}
