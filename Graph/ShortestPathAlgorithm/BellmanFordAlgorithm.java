package ShortestPathAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BellmanFordAlgorithm {
    Map<String, List<String[]>> adjacencyList; 
    public BellmanFordAlgorithm() {
        adjacencyList = new HashMap<>();
    }
    public void addEdge(String startNode, String destinationNode, int weight) { // Store each edge by Node -> Neighbor Node, Weight.
        adjacencyList.putIfAbsent(startNode, new ArrayList<>());
        adjacencyList.putIfAbsent(destinationNode, new ArrayList<>());
        adjacencyList.get(startNode).add(new String[]{destinationNode, ""+weight});
    }
    public void performBellmanFord(String startNode) {
        Map<String, String[]> shortestDistance = new HashMap<>(); // Store shortest path by Node -> Distance Value, Predecessor, Path.
        // Initialize by set start node distance value to 0 and other nodes to MAX_INTEGER.
        for (String node : adjacencyList.keySet()) {
            shortestDistance.putIfAbsent(node, new String[]{""+Integer.MAX_VALUE , null, null});
        }
        shortestDistance.put(startNode, new String[]{""+0, null, "A"});

        // Perform Relaxation
        for (int i=1; i<adjacencyList.keySet().size(); i++) {
            boolean update = false;
            for (String u : adjacencyList.keySet()) {
                int du = Integer.parseInt(shortestDistance.get(u)[0]);
                for (String[] neighbor : adjacencyList.get(u)) {
                    String v = neighbor[0];
                    int weight_uv = Integer.parseInt(neighbor[1]);
                    int newDistance = du + weight_uv;
                    int curDistance = Integer.parseInt(shortestDistance.get(v)[0]);
                    
                    if (newDistance < curDistance) {
                        String prevPathU = shortestDistance.get(u)[2];
                        String currPath = "";
                        if (prevPathU == null) {
                            currPath = u + " -> " + v; 
                        } else {
                            currPath = prevPathU + " -> " + v;
                        }
                        shortestDistance.put(v, new String[]{""+newDistance, u, currPath});
                        update = true;
                    }
                }
            }
            if (!update) break; // If no relaxation, The shortest path is already provided. -> Break the loop
        }

        // Print Result
        for (String node : shortestDistance.keySet()) {
            String distance = shortestDistance.get(node)[0];
            String path = shortestDistance.get(node)[2];
            System.out.println("Node " + node + "'s Shortest Distance is " + distance + ". Path: " + path);
        }
    }
    public static void main(String[] args) {
        BellmanFordAlgorithm graph = new BellmanFordAlgorithm();
        graph.addEdge("A", "B", 2);
        graph.addEdge("A", "C", 3);
        graph.addEdge("A", "F", 3);
        graph.addEdge("B", "D", -1);
        graph.addEdge("C", "D", 3);
        graph.addEdge("C", "E", -1);
        graph.addEdge("D", "F", 3);
        graph.addEdge("F", "E", -2);
        graph.performBellmanFord("A");
    }
}
