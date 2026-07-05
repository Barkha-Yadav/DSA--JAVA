package arrays;

public class _1346_CheckIfNAndItsDoubleExists {
    public static void main(String[] args) {
        int[] arr = {10,2,5,3};
        System.out.println(checkIfExist(arr));
    }

    // Approach 1
    // time complexity: O(N^2)
    // space complexity: O(1)
    public static boolean checkIfExist(int[] arr) {
        boolean sqExists = false;

        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if((arr[i] == 2*arr[j]) || (arr[j] == 2*arr[i])){
                    sqExists = true;
                    break;
                }
            }
        }
        return sqExists;
    }
}
