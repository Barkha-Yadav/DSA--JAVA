package Graph;

import java.util.ArrayList;
import java.util.Collections;

public class GraphStructure_AdjacencyMatrix {

    // time complexity: O(1) when we check if an edge exists between two vertex/nodes
    // space complexity: O(V^2)
    public ArrayList<ArrayList<Integer>> createGraph(int v, int[][] edges){
        //create a matrix
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        // initialize all the rows with 0
        for(int i=0;i<v;i++){
            ArrayList<Integer> row = new ArrayList<>(Collections.nCopies(v,0));
            matrix.add(row);
        }

        // make int matrix[source][destination] = 1 where the edge exists
        for(int[] i : edges){
            int source = i[0]; // source
            int destination = i[1]; // destination
            matrix.get(source).set(destination,1);
            matrix.get(destination).set(source,1);
        }
        return matrix;
    }

    public static void main(String[] args) {
        GraphStructure_AdjacencyMatrix g = new GraphStructure_AdjacencyMatrix();
        int v = 3;
        int[][] edges = {
                {0,1},
                {0,2},
                {1,2}
        };

        ArrayList<ArrayList<Integer>> adjMatrix = g.createGraph(v,edges);

        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++) System.out.print(adjMatrix.get(i).get(j)+" ");
            System.out.println();
        }
    }
}
