package Graph.AdjacencyList_HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DfsTraversal {
    private final HashMap<String, List<String>> adjList;

    public DfsTraversal(){
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

    // time complexity: O(N)+O(2E)
    // space complexity: O(N)
    public List<String> dfsOfGraph(String startPoint){
        List<String> dfsResult = new ArrayList<>();
        List<String> visited = new ArrayList<>();

        dfs(startPoint,visited,dfsResult);
        return dfsResult;
    }

    public void dfs(String node, List<String> visited, List<String> dfsResult){
        visited.add(node);
        dfsResult.add(node);

        List<String> neighbours = adjList.get(node);
        if(neighbours!=null){
            for(String neighbour: neighbours){
                if(! visited.contains(neighbour)){
                    dfs(neighbour,visited,dfsResult);
                }
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
        DfsTraversal g = new DfsTraversal();
//            A
//           / \
//          B   C---D
//         / \  /    \
//        E   F G-----H
        g.addEdge("A", "B");
        g.addEdge("A", "C");
        g.addEdge("B", "E");
        g.addEdge("B", "F");
        g.addEdge("C", "D");
        g.addEdge("C", "G");
        g.addEdge("D", "H");
        g.addEdge("G", "H");

        g.printGraph();

        String startPoint1 = "A";
        List<String> result1 = g.dfsOfGraph(startPoint1);
        System.out.print("DFS traversal taking "+startPoint1+" as start point: ");
        g.printList(result1);

        String startPoint2 = "H";
        List<String> result2 = g.dfsOfGraph(startPoint2);
        System.out.print("DFS traversal taking "+startPoint2+" as start point: ");
        g.printList(result2);
    }
}
