package DataStructures;

class DoubleEndQueue {
    static final int MAX = 4;
    int r,f;
    int q[] = new int[MAX];

    DoubleEndQueue(){
        r = MAX/2;
        f = MAX/2;
    }

    boolean isEmpty(){
        return (r==f);
    }

    void insertLeft(int ele){
        if(f<0){
            System.out.print("queue overflow");
            return;
        }
        q[f--] = ele;
    }

    void insertRight(int ele){
        if(r>=MAX-1){
            System.out.print("queue overflow");
            return;
        }
        q[++r] = ele;
    }

    int deleteLeft(){
        if(isEmpty()){
            System.out.print("queue underflow");
            return -1;
        }
        return q[++f];
    }

    int deleteRight(){
        if(isEmpty()){
            System.out.print("queue underflow");
            return -1;
        }
        return q[r--];
    }

    void dispay() {
        for(int i =f+1 ; i<=r; i++){
            System.out.print(q[i]);
        }
    }
}

public class DoubleEndedQueue {

    public static void main(String[] args) {
        DoubleEndQueue dq = new DoubleEndQueue();
        dq.insertLeft(1);
        dq.insertLeft(3);
        dq.insertRight(2);
        dq.insertLeft(4);

        dq.dispay();

        dq.deleteLeft();
        dq.deleteRight();

        dq.dispay();
    }
    
}
