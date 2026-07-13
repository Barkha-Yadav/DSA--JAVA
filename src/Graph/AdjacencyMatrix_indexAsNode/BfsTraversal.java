package Graph.AdjacencyMatrix_indexAsNode;

import java.util.*;

public class BfsTraversal {
    private final List<List<Integer>> matrix;

    public BfsTraversal(int n){
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

    // time complexity: O(N^2)
    // space complexity: O(N)
    public List<Integer> bfs(Integer startPoint){
        List<Integer> bfsResult = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
//        List<Integer> visited = new ArrayList<>();
        // we are using boolean array because the list is taking O(N) time in searching using .contains() method
        boolean[] visited = new boolean[matrix.size()];

        queue.add(startPoint);
        visited[startPoint] = true;

        while(! queue.isEmpty()){
            Integer currNode = queue.poll();
            bfsResult.add(currNode);

            for(int i=0;i<matrix.size();i++){
                if(matrix.get(currNode).get(i)==1 && !visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

        return bfsResult;
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

        g.addEdge(1,2);
        g.addEdge(1,6);
        g.addEdge(2,3);
        g.addEdge(2,4);
        g.addEdge(6,7);
        g.addEdge(6,9);
        g.addEdge(4,5);
        g.addEdge(7,8);
        g.addEdge(5,8);

        g.printMatrixGraph();

        int startPoint1 = 1;
        List<Integer> result1 = g.bfs(startPoint1);
        System.out.print("BFS traversal with start point "+startPoint1+": ");
        g.printList(result1);

        int startPoint2 = 6;
        List<Integer> result2 = g.bfs(startPoint2);
        System.out.print("BFS traversal with start point "+startPoint2+": ");
        g.printList(result2);
    }
}
