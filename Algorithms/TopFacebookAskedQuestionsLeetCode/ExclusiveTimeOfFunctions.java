package Algorithms.TopFacebookAskedQuestionsLeetCode;
import java.util.*;
/**On a single-threaded CPU, we execute a program containing n functions. Each function has a unique 
 * ID between 0 and n-1.

Function calls are stored in a call stack: when a function call starts, its ID is pushed onto the 
stack, and when a function call ends, its ID is popped off the stack. The function whose ID is at 
the top of the stack is the current function being executed. Each time a function starts or ends, 
we write a log with the ID, whether it started or ended, and the timestamp.

You are given a list logs, where logs[i] represents the ith log message formatted as a string 
"{function_id}:{"start" | "end"}:{timestamp}". For example, "0:start:3" means a function call with 
function ID 0 started at the beginning of timestamp 3, and "1:end:2" means a function call with 
function ID 1 ended at the end of timestamp 2. Note that a function can be called multiple times,
 possibly recursively.

A function's exclusive time is the sum of execution times for all function calls in the program. 
For example, if a function is called twice, one call executing for 2 time units and another call 
executing for 1 time unit, the exclusive time is 2 + 1 = 3.

Return the exclusive time of each function in an array, where the value at the ith index represents
 the exclusive time for the function with ID i.

 

Example 1:


Input: n = 2, logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
Output: [3,4]
Explanation:
Function 0 starts at the beginning of time 0, then it executes 2 for units of time and reaches the 
end of time 1.
Function 1 starts at the beginning of time 2, executes for 4 units of time, and ends at the end of 
time 5.
Function 0 resumes execution at the beginning of time 6 and executes for 1 unit of time.
So function 0 spends 2 + 1 = 3 units of total time executing, and function 1 spends 4 units of total
 time executing.
Example 2:

Input: n = 1, logs = ["0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"]
Output: [8]
Explanation:
Function 0 starts at the beginning of time 0, executes for 2 units of time, and recursively calls 
itself.
Function 0 (recursive call) starts at the beginning of time 2 and executes for 4 units of time.
Function 0 (initial call) resumes execution then immediately calls itself again.
Function 0 (2nd recursive call) starts at the beginning of time 6 and executes for 1 unit of time.
Function 0 (initial call) resumes execution at the beginning of time 7 and executes for 1 unit of 
time.
So function 0 spends 2 + 4 + 1 + 1 = 8 units of total time executing. */

class Log {
    public int id;
    public boolean isStart;
    public int time;
    
    public Log(String content) {
        String[] strs = content.split(":");
        id = Integer.valueOf(strs[0]);
        isStart = strs[1].equals("start");
        time = Integer.valueOf(strs[2]);
    }
}

public class ExclusiveTimeOfFunctions {

    /**Extract the log parsing logic as a inner class.
Calculate the function's running time when encounter an "end" log entry. If current ended func 
has a main func still running (in the stack), subtract the running time advance. So we don't need 
to use a "prev" variable.
Another idea is using a field in the inner class to track the real running time for a function. 
I believe this way would be the most straightforward for myself.
Both methods follows the O(n) time complexity, and O(n/2) extra space consumption. */

    /**TC = O(n) 
     * Sc = O(n/2)
    */
    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<Log> stack = new ArrayDeque<>();
        int[] result = new int[n];
        for (String content : logs) {
            Log log = new Log(content);
            if (log.isStart) {
                stack.push(log);
            } else {
                Log top = stack.pop();
                result[top.id] += (log.time - top.time + 1);
                // System.out.println(top.id + " " + result[top.id]);
                if (!stack.isEmpty()) {
                    result[stack.peek().id] -= (log.time - top.time + 1);
                    // System.out.println(stack.peek().id + " " + result[stack.peek().id]);
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        
    }
    
}
