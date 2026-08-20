package Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3,1,2,4,1,5,6,2,4};
        System.out.println("Before sorting: "+ Arrays.toString(arr));
        mergeSort(arr,0,arr.length-1);
        System.out.println("After sorting: "+Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int low, int high){
        if(low>=high) return;
        int mid = low + (high-low)/2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }

    public static void merge(int[] arr, int low, int mid, int high){
        int[] temp = new int[high-low+1];
        int lptr = low;
        int rptr = mid+1;
        int i = 0;
        while(lptr<=mid && rptr<=high){
            if(arr[lptr]<=arr[rptr]){
                temp[i] = arr[lptr];
                lptr++;
            }
            else{
                temp[i] = arr[rptr];
                rptr++;
            }
            i++;
        }
        while(lptr<=mid){
            temp[i] = arr[lptr];
            lptr++;
            i++;
        }
        while(rptr<=high){
            temp[i] = arr[rptr];
            rptr++;
            i++;
        }

        for(int index=low;index<=high;index++){
            arr[index] = temp[index-low];
        }
        return;
    }
}
