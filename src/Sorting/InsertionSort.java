package Sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {13,46,24,52,20,9};
        System.out.println("Before sorting: "+ Arrays.toString(arr));
        insertionSorting(arr);
        System.out.println("After sorting: "+Arrays.toString(arr));
    }

    // time complexity: best case O(n) when the array is already sorted
    // average and worst case: O(n*n)
    public static void insertionSorting(int[] arr){
        // insertion sort is taking an element and placing it in the correct position
        for(int i=0;i<arr.length;i++){
            int j = i;
            while(j>0 && arr[j-1]>arr[j]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
    }
}
