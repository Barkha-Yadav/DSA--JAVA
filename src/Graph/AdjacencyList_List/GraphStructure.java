package Graph.AdjacencyList_List;

import java.util.ArrayList;
import java.util.List;

public class GraphStructure {
    private final List<List<Integer>> adjList;

    // n is the number of vertices/nodes we are adding empty list to each node
    // initially no vertex are connected to other
    public GraphStructure(int n){
        adjList = new ArrayList<>();
        for(int i=0;i<n+1;i++){ // n+1 because the nodes are starting from 1
            List<Integer> row = new ArrayList<>();
            adjList.add(row);
        }
    }

    // no need to addVertex() because we are taking nodes as 0 1 2 and so on
    // if the vertex starts from 1 then we increase the size of list by n+1 and leave the 0th index empty

    public void addEdge(Integer source, Integer destination){
        adjList.get(source).add(destination);
        // undirected graph so we add both to the list of each other
        adjList.get(destination).add(source);
    }

    public void printGraph(){
        for(int i=0;i<adjList.size();i++){
            System.out.println(i+" -> "+adjList.get(i));
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

        g.printGraph();
    }
}
