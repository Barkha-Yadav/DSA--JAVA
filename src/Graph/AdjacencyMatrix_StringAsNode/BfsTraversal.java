package Graph.AdjacencyMatrix_StringAsNode;

import java.util.*;

public class BfsTraversal {
    private final int[][] matrix;
    private final HashMap<String,Integer> cityToIndex;
    private final List<String> indexToCity;
    private int currIndex = 0;

    public BfsTraversal(int n){
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
    public List<String> bfs(String startPoint){
        List<String> bfsResult = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        boolean[] visited = new boolean[matrix.length];

        Integer node = cityToIndex.get(startPoint);
        queue.add(startPoint);
        visited[node] = true;

        while(! queue.isEmpty()){
            String currNode = queue.poll();
            bfsResult.add(currNode);

            for(int i=0;i<matrix.length;i++){
                if(matrix[cityToIndex.get(currNode)][i]==1 && !visited[i]){
                    visited[i] = true;
                    queue.add(indexToCity.get(i));
                }
            }
        }
        return bfsResult;
    }

    public void printList(List<String> list){
        for(String s: list){
            System.out.print(s+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 9;
        BfsTraversal g = new BfsTraversal(n);
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
        List<String> result1 = g.bfs(startPoint1);
        System.out.print("BFS traversal with starting point "+startPoint1+": ");
        g.printList(result1);

        String startPoint2 = "I";
        List<String> result2 = g.bfs(startPoint2);
        System.out.print("BFS traversal with starting point "+startPoint2+": ");
        g.printList(result2);
    }
}
