package arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class _977_SquaresOfASortedArray {
    public static void main(String[] args) {
        int[] nums = {-7,-3,2,3,11};

        // trying it just to check how to deal when the methods are not static i.e via creating the objects
        _977_SquaresOfASortedArray sq = new _977_SquaresOfASortedArray();
        int[] result = sq.sortedSquares(nums);
        System.out.println(Arrays.toString(result));

        // System.out.println(Arrays.toString(nums)); array modified

        int[] nums2 = {-5,-2,0,1,9,21};
        // using approach 2
        System.out.println(Arrays.toString(sq.sortedSquares2(nums2)));
        // System.out.println(Arrays.toString(nums)); approach 2 does not modify the array

    }

    // Approach 1
    // time complexity: O(NlogN) because of .sort() function it uses dual pivot quick sort under the hood
    // space complexity: O(N) because of the recursion stack that .sort() is using
    public int[] sortedSquares(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    // Approach 2
    // time complexity: O(N)
    // space complexity: O(N)
    public int[] sortedSquares2(int[] nums){
        int l = 0;
        int r = nums.length-1;
        int[] result = new int[nums.length];
        int in = result.length-1;
        while(l<=r){
            if((nums[l]*nums[l])>=(nums[r]*nums[r])){
                result [in] = nums[l]*nums[l];
                l++;
            }
            else{
                result[in] = nums[r]*nums[r];
                r--;
            }
            in--;
        }
        return result;
    }
}
