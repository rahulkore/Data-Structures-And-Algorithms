package Algorithms.Arrays;
import java.util.*;
/**
 * union of two sorted arrays using merge operation of merge sort algorithm.
 */
public class UnionOfTwoSortedArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int a=0, b=0;
        int lastNumber =-1;
        List<Integer> ans = new ArrayList<>();
        while(a<nums1.length && b<nums2.length) {
        	if(nums1[a]==nums2[b]) {
                if(nums1[a]!=lastNumber){                        
        		    ans.add(nums1[a]);
                    lastNumber = nums1[a];
                }
                a++;
                b++;
        	}else if(nums1[a]<nums2[b]){
                if(nums1[a]!=lastNumber){
                    ans.add(nums1[a]);
                    lastNumber = nums1[a];
                }
                a++;
            }else{
                if(nums2[b]!=lastNumber){
                    ans.add(nums2[b]);
                    lastNumber = nums2[b];
                }
                b++;
            }
        }
        int response[] = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            response[i] = ans.get(i);
        }
        return response;        
        
    }
    public static void main(String[] args) {
        
    }
    
}
