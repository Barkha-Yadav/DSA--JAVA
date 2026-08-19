package Sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {13,46,24,52,20,9};
        System.out.println("Before sorting: "+ Arrays.toString(arr));
        bubbleSorting(arr);
        System.out.println("After sorting: "+Arrays.toString(arr));
    }

    // time complexity: worst and average case: O(n*n)
    // best case: O(n) because of swapCount variable
    public static void bubbleSorting(int[] arr){
        // bubble sort is opposite of selection sort
        // push the max to last by adjacent swapping
        int swapCount = 0;
        for(int j=arr.length-1;j>=1;j--){
            for(int i=0;i<j;i++){
                if(arr[i]>arr[i+1]){
                    // swap
                    swapCount++;
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            if(swapCount==0) break;
        }
    }
}
