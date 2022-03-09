package Algorithms.TopAmazonAskedQuestionsLeetCode;
import java.util.*;
/**You have n processes forming a rooted tree structure.
 *  You are given two integer arrays pid and ppid, where pid[i] is the ID of the ith 
 * process and ppid[i] is the ID of the ith process's parent process.

Each process has only one parent process but may have multiple children processes.
 Only one process has ppid[i] = 0, which means this process has no parent process
  (the root of the tree).

When a process is killed, all of its children processes will also be killed.

Given an integer kill representing the ID of a process you want to kill, return 
a list of the IDs of the processes that will be killed. You may return the answer 
in any order. */
public class KillProcess {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        // map from pid to its children
        Map<Integer, List<Integer>> pidChildren = new HashMap();
        
        for(int i = 0; i < ppid.size(); i++) {
            pidChildren.computeIfAbsent(ppid.get(i), k-> new ArrayList<Integer>()).add(pid.get(i));
        }
        
        Queue<Integer> q = new ArrayDeque();
        q.offer(kill);
        
        List<Integer> res = new ArrayList();
        res.add(kill);
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            if(pidChildren.containsKey(cur)) {
                List<Integer> children = pidChildren.get(cur);
                for(int child: children) {
                    res.add(child);
                    q.offer(child);
                }
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        
    }
    
}
