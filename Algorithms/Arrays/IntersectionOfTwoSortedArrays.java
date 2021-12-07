package Algorithms.Arrays;

import java.util.Arrays;
/**
 * intersection of two sorted arrays using the merge operation of merge sort
 */
public class IntersectionOfTwoSortedArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1); // sort if not sorted
        Arrays.sort(nums2); // sort if not sorted
        int a=0, b=0;
        int qtd=0;
        int lastNumber =-1;
        while(a<nums1.length && b<nums2.length) {
        	if(nums1[a]==nums2[b]) {
                if(nums1[a]!=lastNumber){                        
        		    nums1[qtd]=nums1[a];
            		qtd++;
                    lastNumber = nums1[a];
                }
                a++;
                b++;
                if(a>=nums1.length||b>=nums2.length){
                    break;
                }
        	}
        	while(a<nums1.length&&nums1[a]<nums2[b]) {
                a++;
        	}
            if(a>=nums1.length){
                break;
            }
        	while(b<nums2.length&&nums1[a]>nums2[b]) {
                b++;
        	}
        }
        int[] response = new int[qtd];
        for(int i=0; i< qtd; i++) {
        	response[i] = nums1[i];
        }
        return response;        
        
    }
    public static void main(String[] args) {
        
    }
    
}
