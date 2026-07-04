package arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class _88_MargeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3; // number of elements in num1 array

        int[] nums2 = {2,5,6};
        int n = 3; // number of elements in num2 array

        merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }

    // time complexity: O(m+n)
    // space complexity: O(1)
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int p = m+n-1;

        while(p2>=0){
            if((p1>=0) && (nums1[p1]>nums2[p2])){
                nums1[p] = nums1[p1];
                p1--;
            }
            else{
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }
    }
}
