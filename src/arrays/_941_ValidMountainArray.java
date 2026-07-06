package arrays;

import java.util.Arrays;

public class _941_ValidMountainArray {
    public static void main(String[] args) {
        int[] arr = {0,3,2,1};
        System.out.println(Arrays.toString(arr));
        if(validMountainArray(arr)){
            System.out.println("Valid Mountain array");
        }
        else{
            System.out.println("Not a mountain array");
        }
    }

    // Approach 1
    // time complexity: O(N)
    // space complexity: O(1)
    public static boolean validMountainArray(int[] arr) {
        if(arr.length<3) return false;
        int k = 0;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]==arr[i+1]) return false;
            if(arr[i]>arr[i+1]){
                k=i;
                if(k==0 || k==arr.length-1) return false;
                break;
            }
        }
        for(int j=k;j<arr.length-1;j++){
            if(arr[j]<arr[j+1]) return false;
        }
        return true;
    }
}
