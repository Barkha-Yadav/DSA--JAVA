package arrays;

// time complexity: O(N*d) == O(N) because the parameter is int and the max value for int is 2,147,483,647 which is 10 digits .. so the max comparisons in the while loop are 10 which is so small and can be ignored
// space complexity: O(1)
public class _1295_FindNumberWithEvenNumberOfDigits {
    public static void main(String[] args) {
        int[] nums = {12,345,2,6,7896};
        System.out.println("Numbers in the array with even digits are: "+findNumbers(nums));
    }

    static int findNumbers(int[] nums) {
        int evenCount = 0;

        for(int i=0;i<nums.length;i++){
            if(countDigits(nums[i])%2 == 0) evenCount++;
        }

        return evenCount;
    }

    static int countDigits(int n){
        int count = 0;
        while(n>0){
            count++;
            n /= 10;
        }
        return count;
    }
}
