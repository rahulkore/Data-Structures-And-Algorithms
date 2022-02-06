package Algorithms.Dynamic;
import java.util.*;
/**A frog is crossing a river. The river is divided into some number of units, and at each unit,
 *  there may or may not exist a stone. The frog can jump on a stone, but it must not jump into 
 * the water.
 * 

Given a list of stones' positions (in units) in sorted ascending order, determine if the frog can 
cross the river by landing on the last stone. Initially, the frog is on the first stone and assumes
 the first jump must be 1 unit.

If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. 
The frog can only jump in the forward direction. 

Example 1:

Input: stones = [0,1,3,5,6,8,12,17]
Output: true
Explanation: The frog can jump to the last stone by jumping 1 unit to the 2nd stone, then 
2 units to the 3rd stone, then 2 units to the 4th stone, then 3 units to the 6th stone, 4 
units to the 7th stone, and 5 units to the 8th stone.
Example 2:

Input: stones = [0,1,2,3,4,8,9,11]
Output: false
Explanation: There is no way to jump to the last stone as the gap between the 5th and 6th 
stone is too large.
*/
public class FrogJumpHard {

    int max;
    HashSet<Integer> set;
    HashMap<String,Boolean> map;
    public boolean canCross(int[] stones) {
        max = stones[stones.length-1];
        set = new HashSet<>();
        for(int x : stones)
            set.add(x);
        
        map = new HashMap<>();
        return jump(0, 0);
    }
    
    private boolean jump(int curStone, int k) {
        if(curStone == max) {
            return true;
        }
         
        if(!set.contains(curStone)) {
            return false;
        }
        
        String key = curStone + "_" + k;
        if(map.containsKey(key)) {
            return map.get(key);
        }
        
        boolean res = false;
        for(int i=k-1; i<=k+1; i++) {
            if(i<=0) {
                continue;
            }
            
            res |= jump(curStone+i, i);
        }
        
        map.put(key, (res ? true : false));
        return map.get(key);
    }

    public static void main(String[] args) {
        
    }
    
}

/**
 * class Solution {
private:
    int t[2002][2002];
    bool solve(vector<int>& arr, int last, int curr, unordered_map <int,int> &mp) {

        if(curr == arr.size()-1) return true; // reached at last Index
        if(t[last][curr] != -1) return t[last][curr];
        
        int lastJump = arr[curr] - arr[last];
        if(lastJump <= 0) return false;
        bool A = false, B = false, C = false;
        int val = arr[curr]+lastJump;
        if(mp.find(val-1) != mp.end()) 
            A = solve(arr, curr, mp[val-1], mp);
        if(mp.find(val) != mp.end())
            B = solve(arr, curr, mp[val], mp);
        if(mp.find(val+1) != mp.end())
            C = solve(arr, curr, mp[val+1], mp);
            
        return t[last][curr] = A || B || C;
    }
public:
    bool canCross(vector<int>& stones) {
        unordered_map <int,int> mp;
        for(int i=0; i<stones.size(); i++) mp[stones[i]] = i;
        memset(t, -1, sizeof(t));
        if(mp.find(1) == mp.end()) return false;
        return solve(stones, 0, 1, mp);
    }
};
 */
