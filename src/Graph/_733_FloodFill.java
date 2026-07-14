package Graph;

import java.util.Arrays;

public class _733_FloodFill {
    public static void main(String[] args) {
        int[][] arr = {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };
        int sr = 2;
        int sc = 0;
        int color = 3;

        int[][] ans = floodFill(arr, sr, sc, color);

        for (int[] an : ans) {
            System.out.println(Arrays.toString(an));
        }
    }

    // time complexity: O(m*n)
    // space complexity: O(m*n) because of recursion stack
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor = image[sr][sc];
        int[] delRow = {-1,0,+1,0};
        int[] delCol = {0,+1,0,-1};
        dfs(sr,sc,image,delRow,delCol,initialColor, color);
        return image;
    }

    public static void dfs(int newRow, int newCol, int[][] image, int[] delRow, int[] delCol, int initialColor, int color){
        image[newRow][newCol] = color;
        for(int i=0;i<4;i++){
            int nRow = newRow + delRow[i];
            int nCol = newCol + delCol[i];
            if(nRow>=0 && nCol>=0 && nRow<image.length && nCol<image[0].length && image[nRow][nCol]==initialColor && image[nRow][nCol]!=color){
                dfs(nRow,nCol,image,delRow,delCol,initialColor,color);
            }
        }
    }
}
