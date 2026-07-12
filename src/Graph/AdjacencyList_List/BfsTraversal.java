package Graph.AdjacencyList_List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BfsTraversal {
    private final List<List<Integer>> adjList;

    // n is the number of vertices/nodes we are adding empty list to each node
    // initially no vertex are connected to other
    public BfsTraversal(int n){
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

    public List<Integer> bfs(Integer startPoint){
        List<Integer> bfsTraversalResult = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> visited = new ArrayList<>();

        queue.add(startPoint);
        visited.add(startPoint);

        while(! queue.isEmpty()){
            Integer currentNode = queue.poll();
            bfsTraversalResult.add(currentNode);

            List<Integer> neighbours = adjList.get(currentNode);

            if(neighbours!=null){
                for(Integer neighbour: neighbours){
                    if(! visited.contains(neighbour)){
                        queue.add(neighbour);
                        visited.add(neighbour);
                    }
                }
            }
        }
        return bfsTraversalResult;
    }

    public void printList(List<Integer> list){
        for(Integer i: list){
            System.out.print(i+" ");
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
        BfsTraversal g = new BfsTraversal(n);
        g.addEdge(1, 2);
        g.addEdge(1, 6);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(6, 7);
        g.addEdge(6, 9);
        g.addEdge(4, 5);
        g.addEdge(7, 8);
        g.addEdge(5, 8);

        g.printGraph();

        List<Integer> startPoint1= g.bfs(1);
        System.out.print("BFS traversal with start point 1: ");
        g.printList(startPoint1);

        List<Integer> startPoint6 = g.bfs(6);
        System.out.print("BFS traversal with start point 6: ");
        g.printList(startPoint6);
    }
}
