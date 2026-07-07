package Graph;

import java.util.*;

public class _547_NumberOfProvinces {
    HashMap<Integer, List<Integer>> adjList;
    Set<Integer> visited = new HashSet<>();

    public _547_NumberOfProvinces(){
        adjList = new HashMap<>();
    }

    public void addVertex(Integer vertex){
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(Integer source,Integer destination){
        addVertex(source);
        addVertex(destination);
        adjList.get(source).add(destination);
        adjList.get(destination).add(source);
    }

    public void dfs(int startPoint){
        Stack<Integer> stack = new Stack<>();

        stack.push(startPoint);

        while(! stack.isEmpty()){
            Integer currentVertex = stack.pop();

            if(! visited.contains(currentVertex)){
                // System.out.print(currentVertex+" ");
                visited.add(currentVertex);

                List<Integer> neighbours = adjList.get(currentVertex);
                if(neighbours != null){
                    for(Integer neighbour: neighbours){
                        stack.push(neighbour);
                    }
                }
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        // creation of adjacency list for the graph
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected.length;j++){
                if(isConnected[i][j] == 1 && i!=j){
                    addEdge(i+1,j+1);
                }
            }
        }

        int count = 0;
        for(int i=1;i<=isConnected.length;i++){
            if(! visited.contains(i)){
                count++;
                dfs(i);
            }
        }
        return count;
    }

    public void printGraph(){
        for(Integer i: adjList.keySet()){
            System.out.println(i+" -> "+adjList.get(i));
        }
    }

    // time complexity: O(N^2)
    // space complexity: O(N^2)
    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};

        _547_NumberOfProvinces g = new _547_NumberOfProvinces();

        int provinces = g.findCircleNum(isConnected);
        System.out.println("Number of provinces : "+provinces);
    }
}
