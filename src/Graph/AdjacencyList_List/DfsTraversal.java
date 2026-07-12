package Graph.AdjacencyList_List;

import java.util.ArrayList;
import java.util.List;

public class DfsTraversal {
    private final List<List<Integer>> adjList;

    // n is the number of vertices/nodes we are adding empty list to each node
    // initially no vertex are connected to other
    public DfsTraversal(int n){
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

    public void dfs(Integer node, List<Integer> visited, List<Integer> dfsTraversalResult){
        visited.add(node);
        dfsTraversalResult.add(node);

        List<Integer> neighbours = adjList.get(node);
        if(neighbours!=null){
            for(Integer neighbour: neighbours){
                if(! visited.contains(neighbour)){
                    dfs(neighbour,visited,dfsTraversalResult);
                }
            }
        }
    }

    // time complexity: O(N)+O(2E)
    // space complexity: O(N)
    public List<Integer> dfsOfGraph(Integer startPoint){
        List<Integer> dfsTraversalResult = new ArrayList<>();
        List<Integer> visited = new ArrayList<>();

        dfs(startPoint,visited,dfsTraversalResult);
        return dfsTraversalResult;
    }

    public void printList(List<Integer> list){
        for(Integer i: list){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int n = 9;
//            1
//           / \
//          2   3---4
//         / \  /   /
//        5   6 7---8
        DfsTraversal g = new DfsTraversal(n);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 5);
        g.addEdge(2, 6);
        g.addEdge(3, 4);
        g.addEdge(3, 7);
        g.addEdge(4, 8);
        g.addEdge(7, 8);

        g.printGraph();

        List<Integer> result = g.dfsOfGraph(1);
        System.out.print("DFS traversal with start point 1: ");
        g.printList(result);

        List<Integer> result2 = g.dfsOfGraph(3);
        System.out.print("DFS traversal with start point 3: ");
        g.printList(result2);
    }
}
