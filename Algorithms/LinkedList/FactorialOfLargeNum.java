package Algorithms.LinkedList;
import java.util.*;
/**
 * find factorial of a large number
 */
public class FactorialOfLargeNum {

    
    public static void findFactorial(int n){
        ListNode tail = new ListNode(1);
        ListNode start= new ListNode(0);
        start.next = tail;
        for(int i =2;i<=n;i++)
        multiply(tail, i, start);
        display(start.next);
        System.out.println();
        //displayfromlast(tail);
    }
    public static void display(ListNode start){
        while(start!=null){
            System.out.print(start.val + " ");
            start=start.next;
        }
    }
    
    public static void displayfromlast(ListNode tail){
        while(tail!=null){
            System.out.print(tail.val + " ");
            tail=tail.prev;
        }
    }
    public static void multiply(ListNode tail , int n, ListNode start){
        ListNode temp = tail;
        ListNode prev = tail;
        int c = 0;
        while(temp!=null){
            int data = temp.val*n + c;
            temp.val = data%10;
            c=data/10;
            prev=temp;
            temp=temp.prev;
        }
        while(c!=0){
            ListNode node = new ListNode(c%10);
            prev.prev = node;
            node.next = prev;
            c=c/10;
            prev=prev.prev;
        }
        start.next = prev;
    }
    public static void main(String[] args) {
        findFactorial(10);
    }
    
}
