package Algorithms.Arrays;
import java.util.*;

public class CountOfNextSmallerElementAfterSelf {

    class Item{
        int val;
        int index;
        
        Item(int val,int index){
            this.val = val;
            this.index = index;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Item[] items = new Item[n];
        for(int i=0;i<n;i++){
            items[i]= new Item(nums[i],i);
        }
        int[] count = new int[n];
        mergeSort(items,0,n-1,count);
        List<Integer> list = new ArrayList<>(n);
        for(int num : count){
            list.add(num);
        }
        return list;
    }
    
    public void mergeSort(Item[] items,int left,int right,int[] count){
        if(right<=left){
            return;
        }
        
        int mid = (left+ right)/2;
        
        mergeSort(items,left,mid,count);
        mergeSort(items,mid+1,right,count);
        merge(items,left,mid,right,count);
        
    }
    
    public void merge(Item[] items, int left, int mid, int right,int[] count){
        int i = left;
        int j=mid+1;
        Item[] temp = new Item[right-left+1];
        int tempPtr = 0;
        int rightSmallerNums =0;
        while(i<=mid && j<=right){
            if(items[j].val<items[i].val){
                // since right element is lesser than left element it would jump over to the other side of left
                rightSmallerNums++; 
                temp[tempPtr++] = items[j++];
                
            }
            else{
                //there would be no jump to the left from right element.
                count[items[i].index]+=rightSmallerNums; //add to their count
                temp[tempPtr++]=items[i++];
            }
        }
        
        
        while(i<=mid){
            count[items[i].index]+=rightSmallerNums;
            temp[tempPtr++]=items[i++];
        }
        
        while(j<=right){
            temp[tempPtr++]=items[j++];
        }
        //transfer all elements back to original array.
        tempPtr=0;
        for(int k=left;k<=right;k++){
            items[k]=temp[tempPtr++];
        }
        
        
    }
    public static void main(String[] args) {
        
    }
    
}
