package ShortestPathAlgorithm;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FloydWarshallAlgorithm {
    Map<String, List<String[]>> adjacencyList; 
    Map<String, Integer> nodeIndex;

    public FloydWarshallAlgorithm() {
        adjacencyList = new HashMap<>();
    }
    public void addEdge(String startNode, String destinationNode, int weight) { // Store each edge by Node -> Neighbor Node, Weight.
        adjacencyList.putIfAbsent(startNode, new ArrayList<>());
        adjacencyList.putIfAbsent(destinationNode, new ArrayList<>());
        adjacencyList.get(startNode).add(new String[]{destinationNode, ""+weight});
    }
    public void performFloydWarshall(String startNode) {
        // Map node and index for matrix performing.
        // Initialize Graph Matrix with distance value.
        int[][] distance = convertToMatrix();
        
        //Floyd-Warshall
        for (int k=0; k<distance.length; k++) {
            for (int i=0; i<distance.length; i++) {
                for (int j=0; j<distance.length; j++) {
                    if (distance[i][k]+distance[k][j] < distance[i][j]) distance[i][j] = distance[i][k]+distance[k][j];
                }
            }
        }
        print2DMatrix(distance);
    }
    public static void print2DMatrix(int[][] matrix) {
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                int value = matrix[i][j];
                if (value == Integer.MAX_VALUE/2) System.out.print("I ");
                else System.out.print(value + " ");
            }
            System.out.println();
        }
    }
    public int[][] convertToMatrix() {
        int size = adjacencyList.size();
        List<String> nodes = new ArrayList<>(adjacencyList.keySet());
        nodeIndex = new HashMap<>();
        // Assign index to each node
        for (int i = 0; i < nodes.size(); i++) {
            nodeIndex.put(nodes.get(i), i);
        }
        // Initialize matrix with infinity
        int INF = Integer.MAX_VALUE / 2; // avoid overflow
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(matrix[i], INF);
            matrix[i][i] = 0; // distance to itself = 0
        }
        // Fill in edges from adjacencyList
        for (String u : adjacencyList.keySet()) {
            int uIndex = nodeIndex.get(u);
            for (String[] edge : adjacencyList.get(u)) {
                String v = edge[0];
                int weight = Integer.parseInt(edge[1]);
                int vIndex = nodeIndex.get(v);
                matrix[uIndex][vIndex] = weight;
            }
        }
    return matrix;
    }

    public static void main(String[] args) {
        FloydWarshallAlgorithm graph = new FloydWarshallAlgorithm();
        graph.addEdge("1", "3", 3);
        graph.addEdge("2", "1", 2);
        graph.addEdge("3", "2", 7);
        graph.addEdge("3", "4", 1);
        graph.addEdge("4", "1", 6);
        graph.performFloydWarshall("1");
    }

}
