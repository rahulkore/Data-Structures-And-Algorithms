package misc;
import java.util.*;
public class MinStack {

    Stack<Long> st = new Stack<>();
    Long min = Long.MAX_VALUE;

    public MinStack() {
        
    }
    
    public void push(int value) {
        Long val = Long.valueOf(value);
        if(st.isEmpty()){
            min = val;
            st.push(val);
            return;
        }
        if(val < min){
            st.push(2*val-min);
            min = val;
            return;
        }
        st.push(val);
    }
    
    public void pop() {
        Long val = st.pop();
        if(val < min){
            min = 2*min - val;
        }
        
    }
    
    public int top() {
        if(st.peek() < min){
            return min.intValue();
        }
        return st.peek().intValue();
    }
    
    public int getMin() {
        return min.intValue();
    }
    public static void main(String[] args) {
        
    }
    
}
