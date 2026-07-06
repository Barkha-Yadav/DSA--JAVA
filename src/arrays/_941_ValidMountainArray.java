package arrays;

import java.util.Arrays;

public class _941_ValidMountainArray {
    public static void main(String[] args) {
        int[] arr = {0,3,2,1};
        System.out.println(Arrays.toString(arr));

        // Approach 1
        if(validMountainArray(arr)){
            System.out.println("Valid Mountain array");
        }
        else{
            System.out.println("Not a mountain array");
        }

        // Approach 2
        if(validMountainArray2(arr)) System.out.println("Valid Mountain Array");
        else System.out.println("Not a mountain array");
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

    // Approach 2
    // time complexity: O(N)
    // space complexity: O(1)
    public static boolean validMountainArray2(int[] arr){
        if(arr.length<3) return false;

        // think like 2 person climbing the mountain from both the ends and they are going to meet at the same point
        int l = 0;
        int r = arr.length-1;

        while(l<arr.length-1 && arr[l]<arr[l+1]){
            l++;
        }

        while(r>0 && arr[r]<arr[r-1]){
            r--;
        }

        return l>0 && r<arr.length-1 && l==r;
    }
}
