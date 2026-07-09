package Graph;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphStructure_adjMatrix_CityAsNodes {
    private final int[][] matrix;
    private final HashMap<String,Integer> cityToIndex;
    private final ArrayList<String> indexToCity;
    private int currentIndex;

    public GraphStructure_adjMatrix_CityAsNodes(int v){
        matrix = new int[v][v];
        cityToIndex = new HashMap<>();
        indexToCity = new ArrayList<>();
    }

    public void addCity(String city){
        if(! cityToIndex.containsKey(city)){
            cityToIndex.put(city,currentIndex);
            indexToCity.add(city);
            currentIndex++;
        }
    }

    public void addEdge(String city1, String city2){
        addCity(city1);
        addCity(city2);

        Integer source = cityToIndex.get(city1);
        Integer destination = cityToIndex.get(city2);

        matrix[source][destination] = 1;
        matrix[destination][source] = 1;
    }

    public void printGraph(){
        System.out.println("Matrix Representation of Graph: ");
        System.out.println();
        System.out.print("          ");
        for(String city: indexToCity){
            System.out.printf("%-10s",city);
        }
        System.out.println();
        for(int i=0;i<currentIndex;i++){
            System.out.printf("%-10s",indexToCity.get(i));
            for(int j=0;j<currentIndex;j++){
                System.out.printf("%-10d",matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int v = 3;
        GraphStructure_adjMatrix_CityAsNodes g = new GraphStructure_adjMatrix_CityAsNodes(v);

        // undirected graph
        g.addEdge("Delhi","Mumbai");
        g.addEdge("Delhi","Chennai");
        g.addEdge("Mumbai","Chennai");

        g.printGraph();
    }

//    Matrix Representation of Graph:
//
//              Delhi     Mumbai    Chennai
//    Delhi     0         1         1
//    Mumbai    1         0         1
//    Chennai   1         1         0
}
