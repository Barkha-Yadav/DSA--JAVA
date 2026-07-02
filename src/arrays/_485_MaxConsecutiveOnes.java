package arrays;

// Leetcode 485: Max Consecutive Ones
// Time Complexity : O(N) - for both approaches
// Space Complexity : O(1) - for both approaches
public class _485_MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = {1,1,0,1,1,1};

        System.out.println("Max consecutive one's in the above array are: "+findMaxConsecutiveOnes(arr));

        System.out.println("Max consecutive ones using second approach: "+findMaxConsecutiveOnes2(arr));
    }

    // Approach: 1
    // two pointer approach
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

    // Approach 2:
    // a simpler for loop
    public static int findMaxConsecutiveOnes2(int[] nums){
        int count = 0;
        int maxCount = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
                maxCount = Math.max(count,maxCount);
            }
            else{
                count = 0;
            }
        }
        return maxCount;
    }
}
