package arrays;

import java.util.Arrays;

public class _1089_DuplicateZeros {
    public static void main(String[] args) {
        int[] arr = {1,0,2,3,0,4,5,0};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));

        // we are taking a new array because in first function call the arr is modified
        int[] arr2 = {1,0,2,3,0,4,5,0};
        duplicateZeros2(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    // Approach 1: Brute Force
    // time complexity: O(N)
    // space Complexity: O(N) but we have to do this in-place
    public static void duplicateZeros(int[] arr) {
        int l = 0;

        int numZero = 0;
        for(int num: arr){
            if(num == 0) numZero++;
        }

        int[] duplicate = new int[arr.length + numZero];
        for (int j : arr) {
            if (j != 0) {
                duplicate[l] = j;
                l++;
            } else {
                duplicate[l] = 0;
                duplicate[l + 1] = 0;
                l += 2;
            }
        }

        for(int i=0;i<arr.length;i++){
            arr[i] = duplicate[i];
        }
    }

    // Approach 2: Two Pointers back-traversal
    // time complexity: O(N)
    // space complexity: O(1) i.e in-place
    static void duplicateZeros2(int[] nums){
        int zeros = 0;
        for(int num: nums){
            if(num == 0) zeros++;
        }

        // traversing back
        for(int i=nums.length-1;i>=0;i--){
            int targetIndex = i+zeros;
            if(targetIndex < nums.length) nums[targetIndex] = nums[i];

            if(nums[i]==0){
                zeros--;
                if(i+zeros<nums.length) nums[i+zeros] = 0;
            }
        }
    }
}
