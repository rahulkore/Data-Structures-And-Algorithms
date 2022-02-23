package Algorithms.AdvanceDataStructure;
import java.util.*;
/**Segment tree for range queries */
public class SegmentTree {

    private static int n;
    int[] a = new int[n];
    int[] seg = new int[4*n];
    /**Tc = O(2*n-1) */
    public void build(int ind, int low , int high){
        if(low == high){
            seg[ind] = a[low];
        }
        int mid = (low + high)/2;
        build(2*ind+1,low,mid);
        build(2*ind+2,mid+1,high);
        seg[ind] = Math.max(seg[2*ind+1],seg[2*ind+2]);

    }

    public int query(int ind,int low,int high,int l,int r){
        if(low>=l && high<=r){
            return seg[ind];
        }
        if(high<l || low>r) return Integer.MIN_VALUE;
        int mid = (low+high)/2;
        int left = query(2*ind+1,low,mid,l,r);
        int right = query(2*ind+2,mid+1,high,l,r);
        return Math.max(left,right);
    }

    public static void main(String[] args) {
          
    }
    
}
