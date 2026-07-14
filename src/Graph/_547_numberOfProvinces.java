package Graph;

public class _547_numberOfProvinces {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };

        int provinces = findCircleNum(matrix);
        System.out.println("Provinces: "+provinces);
    }

    // time complexity: O(N^2)
    // space complexity: O(N)
    // O(N) SC for the visited array and O(N) SC for the call stack of the recursive dfs to reach the dead end
    public static int findCircleNum(int[][] isConnected) {
        int count = 0;
        boolean[] visited = new boolean[isConnected.length];
        for(int i=0;i<isConnected.length;i++){
            if(! visited[i]){
                dfs(i,visited,isConnected);
                count++;
            }
        }
        return count;
    }

    public static void dfs(int node, boolean[] visited, int[][] matrix){
        visited[node] = true;

        for(int i=0;i<matrix.length;i++){
            if(matrix[node][i]==1 && !visited[i]){
                dfs(i, visited, matrix);
            }
        }
    }
}
