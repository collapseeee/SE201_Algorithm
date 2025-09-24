package ShortestPathAlgorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstrasAlgorithm {
    Map<String, List<String[]>> adjacencyList; 

    public DijkstrasAlgorithm() {
        adjacencyList = new HashMap<>();
    }
    public void addEdge(String source, String destination, int weight) {
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.putIfAbsent(destination, new ArrayList<>()); // Last node.
        adjacencyList.get(source).add(new String[]{destination, ""+weight} );
    }
    public void performDijkstra(String startNode) {
        Map<String, String[]> distance = new HashMap<>(); // Store Node -> Distance, Path
        // Initializing, Assign infinity distance values to all nodes.
        for (String node : adjacencyList.keySet()) {
            distance.put(node,new String[]{""+Integer.MAX_VALUE, node});
        }
        // Assign 0 distance values to starting node, and add starting node to path.
        System.out.println("Dijkstra Algorithm starting node => " + startNode + ".");
        distance.put(startNode,new String[]{"0", startNode});

        // PriorityQueue enqueue first node
        PriorityQueue<String[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> Integer.parseInt(a[1])));
        pq.add(new String[]{startNode, "0"});

        while(!pq.isEmpty()) {
            String[] current = pq.poll();
            String currentNode = current[0];
            int currentDistance = Integer.parseInt(current[1]);

            if (currentDistance > Integer.parseInt(distance.get(currentNode)[0])) continue;

            for (String node[] : adjacencyList.getOrDefault(currentNode, new ArrayList<>())) {
                String neighbor = node[0];
                int weight = Integer.parseInt(node[1]);
                int newDistance = currentDistance+weight;
                
                if (newDistance < Integer.parseInt(distance.get(neighbor)[0])) {
                    String newPath = distance.get(currentNode)[1] + ", " + neighbor;
                    distance.put(neighbor, new String[]{""+newDistance, newPath});
                    pq.add(new String[]{neighbor, ""+newDistance});
                }
            }
        }
        for (Map.Entry<String, String[]> entry : distance.entrySet()) {
            System.out.println("Node: " + entry.getKey() + ", Shortest distance: " + entry.getValue()[0] + ", Path: " + entry.getValue()[1]);
        }
        System.out.println("==========================================================");
    }
    public static void main(String[] args) {
        DijkstrasAlgorithm graph = new DijkstrasAlgorithm();
        graph.addEdge("A", "B", 2);
        graph.addEdge("A", "C", 1);
        graph.addEdge("B", "A", 2);
        graph.addEdge("B", "C", 5);
        graph.addEdge("B", "D", 6);
        graph.addEdge("B", "E", 2);
        graph.addEdge("C", "A", 1);
        graph.addEdge("C", "B", 5);
        graph.addEdge("C", "E", 7);
        graph.addEdge("D", "B", 6);
        graph.addEdge("D", "F", 1);
        graph.addEdge("E", "B", 2);
        graph.addEdge("E", "C", 7);
        graph.addEdge("E", "F", 4);
        graph.addEdge("F", "D", 1);
        graph.addEdge("F", "E", 4);
        graph.addEdge("F", "G", 3);
        graph.addEdge("G", "F", 3);
        graph.performDijkstra("A");
    }
}
