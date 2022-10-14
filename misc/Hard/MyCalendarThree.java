package misc.Hard;
import java.util.*;
/**
Summarize
This is to find the maximum number of concurrent ongoing event at any time.

We can log the start & end of each event on the timeline, each start add a new ongoing event at that time, each end terminate an ongoing event. Then we can scan the timeline to figure out the maximum number of ongoing event at any time.

The most intuitive data structure for timeline would be array, but the time spot we have could be very sparse, so we can use sorted map to simulate the time line to save space.
*/


public class MyCalendarThree {

    private TreeMap<Integer, Integer> timeline = new TreeMap<>();
    
    public int book(int s, int e) {
        timeline.put(s, timeline.getOrDefault(s, 0) + 1); // 1 new event will be starting at [s]
        timeline.put(e, timeline.getOrDefault(e, 0) - 1); // 1 new event will be ending at [e];
        // System.out.println(timeline.get(s) + " " + timeline.get(e));
        int ongoing = 0, k = 0;
        for (int v : timeline.values())
            k = Math.max(k, ongoing += v);
        return k;
    }

    public static void main(String[] args) {
        
    }
    
}
