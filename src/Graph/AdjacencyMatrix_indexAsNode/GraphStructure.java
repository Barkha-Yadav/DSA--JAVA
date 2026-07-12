package Graph.AdjacencyMatrix_indexAsNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GraphStructure {
    private final List<List<Integer>> matrix;

    public GraphStructure(int n){
        matrix = new ArrayList<>();
        for(int i=0;i<n+1;i++){ // n+1 because our graph is one based graph
            List<Integer> row = new ArrayList<>(Collections.nCopies(n+1,0));
            matrix.add(row);
        }
    }

    public void addEdge(Integer source, Integer destination){
        matrix.get(source).set(destination,1);
        matrix.get(destination).set(source,1);
    }

    public void addEdge(List<List<Integer>> edges){
        for(List<Integer> pair: edges){
            Integer source = pair.get(0);
            Integer destination = pair.get(1);

            matrix.get(source).set(destination,1);
            matrix.get(destination).set(source,1);
        }
    }

    public void printMatrixGraph(){
        System.out.println("Matrix representation: ");
        System.out.println();
        System.out.print("     ");
        for(int i=1;i<matrix.size();i++){
            System.out.printf("%-5d",i);
        }
        System.out.println();
        for(int i=1;i<matrix.size();i++){
            System.out.printf("%-5d",i);
            for(int j=1;j<matrix.get(i).size();j++){
                System.out.printf("%-5d",matrix.get(i).get(j));
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 9;
//        1
//       /  \
//      2    6
//     / \  /  \
//     3  4 7   9
//       /   \
//       5 __ 8
        GraphStructure g = new GraphStructure(n);

        g.addEdge(1,2);
        g.addEdge(1,6);
        g.addEdge(2,3);
        g.addEdge(2,4);
        g.addEdge(6,7);
        g.addEdge(6,9);
        g.addEdge(4,5);
        g.addEdge(7,8);
        g.addEdge(5,8);

        System.out.print("Using .addEdge source and destination passed as parameter ");
        g.printMatrixGraph();

        // immutable list
//        List<List<Integer>> edges = List.of(
//                List.of(1,2),
//                List.of(1,6),
//                List.of(2,3),
//                List.of(2,4),
//                List.of(6,7),
//                List.of(6,9),
//                List.of(4,5),
//                List.of(7,5),
//                List.of(5,8)
//        );
//        g.addEdge(edges);
//        System.out.print("Using .addEdge and passing array list as a parameter ");
//        g.printMatrixGraph();

        // mutable doubly array list can be described as
//        List<List<Integer>> edges = new ArrayList<>(List.of(
//                new ArrayList<>(List.of(1,2)),
//                new ArrayList<>(List.of(1,4)),
//        )
//        );
    }
}
