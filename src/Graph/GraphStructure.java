package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphStructure {
    private Map<Integer, List<Integer>> adjList; // instance variable as this in declared directly inside the class not inside any method/ function

    // constructor to initialize HashMap
    public GraphStructure(){
        adjList = new HashMap<>();
    }

    // method to add new vertex in the graph
    public void addVertex(Integer vertex){
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    // method to join vertices / add edges in the graph
    public void addEdge(Integer source, Integer destination){
        // make sure the source and destination vertices exists
        addVertex(source);
        addVertex(destination);

        // adding the vertices to each other list because we are taking undirected graph
        adjList.get(source).add(destination);
        adjList.get(destination).add(source);
    }

    public void printGraph(){
        for(Integer i: adjList.keySet()){
            System.out.println(i+" -> "+adjList.get(i));
        }
    }

    public static void main(String[] args) {
        // we are making object because we are going to access non static methods inside the static one
        GraphStructure g = new GraphStructure();

        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(2,4);
        g.addEdge(3,4);
        g.addEdge(3,5);

        g.printGraph();
    }
}
