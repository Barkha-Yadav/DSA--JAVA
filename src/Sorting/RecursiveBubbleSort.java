package Sorting;

import java.util.Arrays;

public class RecursiveBubbleSort {
    public static void main(String[] args) {
        int[] arr = {13,46,24,52,20,9};
        System.out.println("Before sorting: "+ Arrays.toString(arr));
        recBubbleSort(arr,arr.length-1);
        System.out.println("After sorting: "+Arrays.toString(arr));
    }

    public static void recBubbleSort(int[] arr, int range){
        if(range==1) return;

    }
}
