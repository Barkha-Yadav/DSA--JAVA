package Graph.AdjacencyList_HashMap;

import java.util.*;

public class BfsTraversal {
    private final HashMap<String, List<String>> adjList;

    public BfsTraversal(){
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
    public List<String> bfs(String startPoint){
        List<String> bfsResult = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        List<String> visited = new ArrayList<>();

        queue.add(startPoint);
        visited.add(startPoint);

        while (! queue.isEmpty()){
            String currNode = queue.poll();
            bfsResult.add(currNode);

            List<String> neighbours = adjList.get(currNode);
            if(neighbours!=null){
                for(String neighbour: neighbours){
                    if(! visited.contains(neighbour)){
                        visited.add(neighbour);
                        queue.add(neighbour);
                    }
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
        BfsTraversal g = new BfsTraversal();
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
        List<String> bfs1 = g.bfs(startPoint1);
        System.out.print("BFS traversal taking "+startPoint1+" as starting node: ");
        g.printList(bfs1);

        String startPint2 = "H";
        List<String > bfs2 = g.bfs(startPint2);
        System.out.print("BFS traversal taking "+startPint2+" as starting node: ");
        g.printList(bfs2);
    }
}
