package BinarySearch;

public class _74_SearchA2DMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 34;

        System.out.println(searchMatrix(arr, target));
    }

    // time complexity: O(log(m*n))
    // space complexity: O(1)
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length; // rows
        int m = matrix[0].length; // cols

        int l = 0;
        int r = m*n-1;

        while(l<=r){
            int mid = l+(r-l)/2;
            int midValue = matrix[mid/m][mid%m];
            if(midValue == target) return true;
            else if(midValue > target) r = mid-1;
            else l = mid+1;
        }
        return false;
    }
}
