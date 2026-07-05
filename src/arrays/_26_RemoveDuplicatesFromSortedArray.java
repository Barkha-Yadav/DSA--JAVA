package arrays;

import java.util.Arrays;

public class _26_RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,2,2,3,3,3,4,8,8,8,10};

        System.out.println(Arrays.toString(arr));
        System.out.println("Unique elements in above array is: "+removeDuplicates(arr));
    }
    public static int removeDuplicates(int[] nums) {
        int k = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] != nums[i-1]){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
