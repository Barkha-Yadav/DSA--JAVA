package Graph;

import java.util.*;

public class DfsTraversal {
    private Map<Integer, List<Integer>> adjList;

    public DfsTraversal(){
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

    public void dfs(int startPoint){
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        stack.push(startPoint);

        System.out.print("DFS traversal: ");
        while(! stack.isEmpty()){
            Integer current = stack.pop();

            if(! visited.contains(current)){
                System.out.print(current+" ");
                visited.add(current);

                List<Integer> neighbours = adjList.get(current);
                if(neighbours != null){
                    for(Integer neighbour: neighbours){
                        stack.push(neighbour);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        DfsTraversal g = new DfsTraversal();

        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(2,4);

        g.printGraph();
        g.dfs(0);
    }
}
