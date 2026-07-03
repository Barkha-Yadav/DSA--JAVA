package arrays;

import java.util.Arrays;

public class _977_SquaresOfASortedArray {
    public static void main(String[] args) {
        int[] nums = {-7,-3,2,3,11};

        // trying it just to check how to deal when the methods are not static i.e via creating the objects
        _977_SquaresOfASortedArray sq = new _977_SquaresOfASortedArray();
        int[] result = sq.sortedSquares(nums);
        System.out.println(Arrays.toString(result));

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
}
