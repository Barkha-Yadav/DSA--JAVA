package Graph.AdjacencyMatrix_StringAsNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphStructure {
    private final int[][] matrix;
    private final HashMap<String,Integer> cityToIndex;
    private final List<String> indexToCity;
    private int currIndex = 0;

    public GraphStructure(int n){
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
    }

    public static void main(String[] args) {
        int n = 9;
        GraphStructure g = new GraphStructure(n);
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
    }
}
