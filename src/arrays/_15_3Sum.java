package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_3Sum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> ans = threeSum(nums);

        for(List<Integer> li: ans){
            System.out.print(li+" ");
            //System.out.print(Arrays.toString(li.toArray())+" ");
        }
    }

    // time complexity: O(N^2)
    // space complexity: O(N) because of recursion stack of .sort() function
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // it took O(NlogN)
        Arrays.sort(nums);

        for(int fix = 0;fix<nums.length-2;fix++){
            if(fix>0 && nums[fix]==nums[fix-1]) continue;
            int left = fix+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[fix]+nums[left]+nums[right];
                if(sum==0){
                    result.add(List.of(nums[fix],nums[left],nums[right]));
                    while(left<right && nums[left]==nums[left+1]) left++;
                    while(left<right && nums[right]==nums[right-1]) right--;
                    left++;
                    right--;
                }
                else if(sum>0) right--;
                else left++;
            }
        }
        return result;
    }
}
