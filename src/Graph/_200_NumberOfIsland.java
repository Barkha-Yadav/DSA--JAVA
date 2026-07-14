package Graph;

public class _200_NumberOfIsland {
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        int num_islands = numIslands(grid);
        System.out.println("Number of islands: "+num_islands);
    }

    // time complexity: O(m*n)
    // space complexity: O(m*n)
    public static int numIslands(char[][] grid){
        int count = 0;
        if(grid==null || grid.length==0 || grid[0].length==0) return 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]=='0') return;

        grid[i][j] = '0';

        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
}
