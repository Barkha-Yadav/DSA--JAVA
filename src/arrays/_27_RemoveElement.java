package arrays;

public class _27_RemoveElement {
    public static void main(String[] args) {
        int[] arr = {0,1,2,2,3,0,4,2};
        int val = 2;

        System.out.println("The number of elements in array except "+val+" in count are: "+removeElement(arr,val));

        // because in java the arrays are pass by reference i.e the swap function we perform in approach 1 changes the value in the original array arr
        int[] arr2 = {0,1,2,2,3,0,4,2};
        System.out.println("Tune number of elements in array except "+val+" in count are: "+removeElement2(arr2,val));
    }

    // Approach 1
    // this approach includes unnecessary complexity to the code like swap and count
    // time complexity: O(N)
    // space complexity: O(1)
    public static int removeElement(int[] nums, int val) {
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            if(nums[r] == val) r--;
            else if(nums[l] == val){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
            }
            else l++;
        }

        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != val) count++;
            else break;
        }
        return count;
    }

    // Approach 2
    // using fast and slow  pointer
    // time complexity: O(N)
    // space complexity: O(1)
    public static int removeElement2(int[] nums, int val){
        int k = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
