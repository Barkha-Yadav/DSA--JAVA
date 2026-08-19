package Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {13,46,24,52,20,9};
        System.out.println("Before sorting: "+Arrays.toString(arr));
        selectionSorting(arr);
        System.out.println("After sorting: "+Arrays.toString(arr));
    }

    // time complexity: O(n*n) for all worst best and average case
    // space complexity: O(1) in-place swapping
    public static void selectionSorting(int[] arr){
        // selection sort says take the smallest to le left most
        // i.e find smallest and swap
        for(int i=0;i<arr.length;i++){
            int min = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            // swap(i,min)
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        return;
    }
}
