package Algorithms.Arrays;
/**
 * given an array of size n and a number k find all elements that appear more than n/k times
 * 
 * We can solve this problem using boyer moore voting algorithm 
 * 
 * It is the same as we did in majority element where k=2 and k=3 
 * 
 * But if k > 3 then we will need to use class and implement the same algorithms as follows 
 * 
 * Time complexity is O(nk)
 * Space complexity is O(k)
 */
class eleCount {
    int ele;
    int count;
}
public class MajorityElementK {

    public static void getNbyKElement(int[] nums, int k){
        eleCount[] temp = new eleCount[k-1];
        for(int i=0 ; i<k-1 ; i++){
            temp[i] = new eleCount();
            temp[i].count = 0;
        }

        for(int i=0;i<nums.length;i++){
            int j;
            for(j=0;j<k-1;j++){
                if(nums[i] == temp[j].ele){
                    temp[j].count++;
                    break;
                }
            }

            if(j==k-1){
                int l;
                for(l=0;l<k-1;l++){
                    if(temp[l].count == 0){
                        temp[l].ele = nums[i];
                        temp[l].count = 1;
                        break;
                    }
                }

                if(l==k-1){
                    for(l=0;l<k-1;l++){
                        temp[l].count -=1 ;
                    }
                }
            }
        }

        for(int i=0;i<k-1;i++){
            int actual=0;
            for(int j=0;j<nums.length;j++){
                if(temp[i].ele == nums[j]){
                    actual+=1;
                }
            }
            if(actual >= Math.floor(nums.length/k)){
                System.out.println(temp[i].ele);
            }
        }
    }

    public static void main(String[] args) {
        
    }
    
}
