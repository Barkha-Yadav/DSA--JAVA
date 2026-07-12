package Graph.AdjacencyList_HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphStructure {
    private final HashMap<String, List<String>> adjList;

    public GraphStructure(){
        adjList = new HashMap<>();
    }

    public void addVertex(String vertex){
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(String source, String destination){
        addVertex(source);
        addVertex(destination);
        adjList.get(source).add(destination);
        adjList.get(destination).add(source);
    }

    public void printGraph(){
        for(String vertex: adjList.keySet()){
            System.out.println(vertex+" -> "+adjList.get(vertex));
        }
    }

    public static void main(String[] args) {
        GraphStructure g = new GraphStructure();
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
