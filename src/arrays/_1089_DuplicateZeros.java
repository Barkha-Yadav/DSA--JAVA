package arrays;

import java.util.Arrays;

public class _1089_DuplicateZeros {
    public static void main(String[] args) {
        int[] arr = {1,0,2,3,0,4,5,0};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
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
}
