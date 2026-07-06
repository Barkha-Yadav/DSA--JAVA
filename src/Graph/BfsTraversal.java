package Graph;

import java.util.*;

public class BfsTraversal {
    private final Map<Integer, List<Integer>> adjList;

    public BfsTraversal(){
        adjList = new HashMap<>();
    }

    public void addVertex(Integer vertex){
        adjList.putIfAbsent(vertex,new ArrayList<>());
    }

    public void addEdge(Integer source, Integer destination){
        addVertex(source);
        addVertex(destination);

        adjList.get(source).add(destination);
        adjList.get(destination).add(source);
    }

    public void printGraph(){
        for(Integer i: adjList.keySet()){
            System.out.println(i+" -> "+adjList.get(i));
        }
    }

    public void bfs(Integer startPoint){
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(startPoint);
        visited.add(startPoint);

        System.out.print("BFS: ");
        while(! queue.isEmpty()){
            Integer current = queue.poll();
            System.out.print(current+" ");

            List<Integer> neighbours = adjList.get(current);

            if(neighbours != null){
                for(Integer neighbour: neighbours){
                    if(!visited.contains(neighbour)){
                        queue.add(neighbour);
                        visited.add(neighbour);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        BfsTraversal g = new BfsTraversal();

        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,4);
        g.addEdge(3,4);

        g.printGraph();

        g.bfs(0);
    }
}
