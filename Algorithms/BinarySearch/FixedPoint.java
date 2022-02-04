package Algorithms.BinarySearch;

public class FixedPoint {

    static int binarySearch(int arr[], int low, int high)
    {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            if (mid == arr[mid])
                return mid;
            int res = -1;
            if (mid + 1 <= arr[high])
                res = binarySearch(arr, (mid + 1), high);
            if (res != -1)
                return res;
            if (mid - 1 >= arr[low])
                return binarySearch(arr, low, (mid - 1));
        }
 
        /* Return -1 if there is no Fixed Point */
        return -1;
    }
    public static int main(String[] args) {
        int[] nums = {0, 2, 5, 8, 17};
        int fixedPoint = binarySearch(nums,0,nums.length-1);
        return fixedPoint;
    }
    
}
