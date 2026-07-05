package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class _1346_CheckIfNAndItsDoubleExists {
    public static void main(String[] args) {
        int[] arr = {10,2,5,3};
        System.out.println(Arrays.toString(arr));

        // using approach 1
        System.out.println(checkIfExist(arr));

        // using approach 2
        System.out.println(checkIfExist2(arr));

        // using approach 3
        System.out.println(checkIfExist3(arr));
    }

    // Approach 1
    // time complexity: O(N^2)
    // space complexity: O(1)
    public static boolean checkIfExist(int[] arr) {
        boolean double_exists = false;

        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if((arr[i] == 2*arr[j]) || (arr[j] == 2*arr[i])){
                    double_exists = true;
                    break;
                }
            }
        }
        return double_exists;
    }

    // Approach 2
    // time complexity: O(N)
    // space complexity: O(N) - in worst case each element of arr is stored into the map
    public static boolean checkIfExist2(int[] arr){
        boolean double_exists = false;

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            // even number
            if(arr[i]%2 == 0){
                if(map.containsKey(arr[i]/2) || map.containsKey(arr[i]*2)){
                    double_exists = true;
                    break;
                }
            }
            // odd number
            else{
                if(map.containsKey(arr[i]*2)){
                    double_exists = true;
                    break;
                }
            }
            map.put(arr[i],i);
        }
        return double_exists;
    }

    // Approach 3
    // time complexity: O(N)
    // space complexity: O(N) but less overhead than map as it do not contain pairs
    public static boolean checkIfExist3(int[] arr){
        HashSet<Integer> seen = new HashSet<>();

        for(int num: arr){
            if((seen.contains(num*2)) || (num%2==0 && seen.contains(num/2))){
                return true;
            }
            seen.add(num);
        }

        return false;
    }
}
