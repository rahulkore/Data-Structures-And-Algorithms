package Algorithms.Arrays;
import java.util.*;
public class CommonElementsInThreeSortedArrays {
    /**
     * Time complexity = O(n1+n2+n3)
     * Space Complexity = O(n1+n2+n3)
     * @param nums1
     * @param nums2
     * @param nums3
     * @return
     */
    public static int[] commonElements(int nums1[], int nums2[], int nums3[]) {
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        Map<Integer,Integer> map3 = new HashMap<>();
        for(int i=0;i<nums1.length;i++)
        map1.put(nums1[i], map1.getOrDefault(nums1[i], 0)+1);
        for(int i=0;i<nums2.length;i++)
        map2.put(nums2[i], map2.getOrDefault(nums2[i], 0)+1);
        for(int i=0;i<nums3.length;i++)
        map3.put(nums3[i], map3.getOrDefault(nums3[i], 0)+1);
        List<Integer> ans = new ArrayList<>();
        for (int ele : nums1) {
            if(map1.get(ele)!=null && map2.get(ele)!=null && map3.get(ele)!=null){
                ans.add(ele);
                map1.remove(ele);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Time Complexity = O(n1+n2+n3)
     * Space Complexity = O(1)
     */
    public static List<Integer> commonEfficient(int nums1[], int nums2[], int nums3[]) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n3 = nums3.length;
        int i =0,j=0,k=0;
        List<Integer> ans = new ArrayList<>();
        while(i<n1 && j<n2 && k<n3){
            if(nums1[i]==nums2[j] && nums2[j]==nums3[k]){
                ans.add(nums1[i]);
                i++;
                j++;
                k++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else if(nums2[j] < nums3[k]){
                j++;
            }else{
                k++;
            }
            int a = nums1[i-1];
            while(nums1[i]==a) i++;
            int b = nums2[j-1];
            while(nums2[j]==b) j++;
            int c = nums3[k-1];
            while(nums3[k]==c) k++;
        }
        if(ans.size()==0) return new ArrayList<>();
        else return ans;
    }
    public static void main(String[] args) {
        
    }
    
}
