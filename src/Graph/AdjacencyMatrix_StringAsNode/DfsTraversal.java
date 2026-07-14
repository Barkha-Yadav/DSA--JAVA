package Graph.AdjacencyMatrix_StringAsNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DfsTraversal {
    private final int[][] matrix;
    private final HashMap<String,Integer> cityToIndex;
    private final List<String> indexToCity;
    private int currIndex = 0;

    public DfsTraversal(int n){
        matrix = new int[n][n];
        cityToIndex = new HashMap<>();
        indexToCity = new ArrayList<>();
    }

    public void addVertex(String vertex){
        if(! indexToCity.contains(vertex)){
            cityToIndex.put(vertex,currIndex);
            indexToCity.add(vertex);
            currIndex++;
        }
    }

    public void addEdge(String source, String destination){
        addVertex(source);
        addVertex(destination);

        int u = cityToIndex.get(source);
        int v = cityToIndex.get(destination);

        matrix[u][v] = 1;
        matrix[v][u] = 1;
    }

    public void printGraph(){
        System.out.println("Matrix Representation: ");
        System.out.println();
        System.out.print("     ");

        for(int i=0;i<matrix.length;i++){
            System.out.printf("%-5s",indexToCity.get(i));
        }

        System.out.println();
        for(int i=0;i<matrix.length;i++){
            System.out.printf("%-5s",indexToCity.get(i));
            for(int j=0;j<matrix.length;j++){
                System.out.printf("%-5d",matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    // time complexity: O(N^2)
    // space complexity: O(N)
    public List<String> dfsOfGraph(String startPoint){
        List<String> dfsResult = new ArrayList<>();
        boolean[] visited = new boolean[matrix.length];
        dfs(startPoint,visited,dfsResult);
        return dfsResult;
    }

    public void dfs(String node, boolean[] visited, List<String> dfsResult){
        visited[cityToIndex.get(node)] = true;
        dfsResult.add(node);

        for(int i=0;i< matrix.length;i++){
            if(matrix[cityToIndex.get(node)][i]==1 && !visited[i]){
                dfs(indexToCity.get(i),visited,dfsResult);
            }
        }
    }

    public void printList(List<String> list){
        for(String s: list){
            System.out.print(s+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 9;
        DfsTraversal g = new DfsTraversal(n);
//        A
//       /  \
//      B    H
//     / \  /  \
//    C  D E   I
//       /  \
//      F____G
        g.addEdge("A","B");
        g.addEdge("A","H");
        g.addEdge("B","C");
        g.addEdge("B","D");
        g.addEdge("D","F");
        g.addEdge("E","G");
        g.addEdge("F","G");
        g.addEdge("H","E");
        g.addEdge("H","I");

        g.printGraph();

        String startPoint1 = "A";
        List<String> result1 = g.dfsOfGraph(startPoint1);
        System.out.print("DFS traversal with start point "+startPoint1+": ");
        g.printList(result1);

        String startPoint2 = "I";
        List<String> result2 = g.dfsOfGraph(startPoint2);
        System.out.print("DFS traversal with start point "+startPoint2+": ");
        g.printList(result2);
    }
}
