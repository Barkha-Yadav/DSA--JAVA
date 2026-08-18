package Recursion;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {5,4,3,2,1};
        System.out.println(Arrays.toString(arr));
        reverseArr(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {10,9,8,7,6};
        System.out.println();
        System.out.println(Arrays.toString(arr2));
        revBetter(arr2);
        System.out.println(Arrays.toString(arr2));
    }
    public static void reverseArr(int[] arr, int left, int right){
        if(left>=right) return;
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        reverseArr(arr,left+1,right-1);
    }

    public static void revBetter(int[] arr){
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
