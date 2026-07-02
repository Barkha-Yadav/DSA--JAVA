package arrays;

// Leetcode 485: Max Consecutive Ones
// Time Complexity : O(N)
// Space Complexity : O(1)
public class _485_MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = {1,1,0,1,1,1};

        System.out.println("Max consecutive one's in the above array are: "+findMaxConsecutiveOnes(arr));
    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int l = 0;
        int r = 0;
        int len = 0;
        int maxLen = 0;
        while(r<nums.length){
            if(nums[r] != 1){
                l = r+1;
                r++;
                len = 0;
            }
            else{
                len = r-l+1;
                maxLen = Math.max(maxLen,len);
                r++;
            }
        }
        return maxLen;
    }
}
