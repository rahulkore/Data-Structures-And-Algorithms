package Algorithms.TopMicrosoftAskedQuestionsLeetCode;
import java.util.*;
public class Dummy {

    public static int[] solution(String[] queries, int diff){
        int n = queries.length;
        int ans[] = new int[n];
        int count=0;
        int k = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer,Set<Integer>> part = new HashMap<>();
        Set<Integer> s;
        for(String q  : queries){
            int num = Integer.parseInt(q.substring(1));
            // System.out.println(num);
            if(q.charAt(0) == '+'){
                if(map.containsKey(num-diff)){
                    count += map.get(num-diff);
                    String key = String.valueOf(num) + " " + String.valueOf(num-diff);
                    s = part.get(num-diff);
                    if(s == null) s = new HashSet<>();
                    s.add(num);
                    part.put(num-diff, s);

                    s = part.get(num);
                    if(s == null) s = new HashSet<>();
                    s.add(num-diff);
                    part.put(num, s);
                }
                if(map.containsKey(num+diff)){
                    count += map.get(num+diff);
                    String key = String.valueOf(num) + " " + String.valueOf(num+diff);
                    s = part.get(num+diff);
                    if(s == null) s = new HashSet<>();
                    s.add(num);
                    part.put(num+diff, s);

                    s = part.get(num);
                    if(s == null) s = new HashSet<>();
                    s.add(num+diff);
                    part.put(num, s);
                }
                map.put(num, map.getOrDefault(num,0)+1);
            }else{
                map.put(num, map.get(num)-1);
                if(part.get(num) != null) count-=part.get(num).size();
                if(map.get(num) == 0){
                    map.remove(num);
                    part.remove(num);
                } 
            }
            ans[k++] = count;
        }
        return ans;

    }
    public static void main(String[] args) {
        String[] q = {"+2" , "+2", "+4" , "+3" ,"+2", "-2"};
        String[] q2 = {"+2" , "+2", "+4" , "+3" ,"+1", "-2"};
        String[] q1 = {"+4" , "+5" , "+2" , "-4"};
        String[] q3 = {"+1", "+3", "+4", "-1","+1","+1","-1","+2","-4"};
        int diff = 1;
        int[] ans = solution(q3,2);
        for(int i = 0;i<ans.length ; i++){
            System.out.println(ans[i]);
        }
    }
    
}
