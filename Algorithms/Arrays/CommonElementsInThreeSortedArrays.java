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
        int prev1=Integer.MIN_VALUE,prev2=Integer.MIN_VALUE,prev3=Integer.MIN_VALUE;
        List<Integer> ans = new ArrayList<>();
        while(i<n1 && j<n2 && k<n3){
            if(nums1[i]==nums2[j] && nums2[j]==nums3[k]){
                ans.add(nums1[i]);
                prev1=nums1[i];
                prev2=nums2[j];
                prev3=nums3[k];
                i++;
                j++;
                k++;
            }else if(nums1[i] < nums2[j]){
                prev1=nums1[i];
                i++;
            }else if(nums2[j] < nums3[k]){
                prev2=nums2[j];
                j++;
            }else{
                prev3=nums3[k];
                k++;
            }
            while(i<n1 && nums1[i]==prev1) i++;
            while(j<n2 && nums2[j]==prev2) j++;
            while(k<n3 && nums3[k]==prev3) k++;
        }
        if(ans.size()==0) return new ArrayList<>();
        else return ans;
    }
    public static void main(String[] args) {

        int ar1[] = { 1, 5, 10, 20, 40, 80, 80 };
        int ar2[] = { 6, 7, 20, 80, 80, 100 };
        int ar3[] = { 3, 4, 15, 20, 30, 70, 80, 80, 120 };
        List<Integer> ans = commonEfficient(ar1,ar2,ar3);
        for(Integer ele : ans)
        System.out.println(ele);
    }
    
}
