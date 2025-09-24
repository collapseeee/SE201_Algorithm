package ShortestPathAlgorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraAlgorithmWithTestcases {
    Map<String, List<String[]>> adjacencyList; 

    public DijkstraAlgorithmWithTestcases() {
        adjacencyList = new HashMap<>();
    }
    public void addEdge(String source, String destination, int weight) {
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.putIfAbsent(destination, new ArrayList<>()); // Last node.
        adjacencyList.get(source).add(new String[]{destination, ""+weight} );
    }
    public void dijkstra(String startNode) {
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
        System.out.println("Normal Weighted Graph");
        DijkstraAlgorithmWithTestcases tc1 = new DijkstraAlgorithmWithTestcases();
        tc1.addEdge("A", "B", 4);
        tc1.addEdge("A", "C", 4);
        tc1.addEdge("B", "C", 2);
        tc1.addEdge("C", "D", 3);
        tc1.addEdge("C", "E", 1);
        tc1.addEdge("C", "F", 6);
        tc1.addEdge("D", "F", 2);
        tc1.addEdge("E", "F", 3);
        tc1.dijkstra("A");
        
        System.out.println("Negative Weighted Graph");
        DijkstraAlgorithmWithTestcases tc2 = new DijkstraAlgorithmWithTestcases();
        tc2.addEdge("A", "B", -4);
        tc2.addEdge("A", "C", -4);
        tc2.addEdge("B", "C", -2);
        tc2.addEdge("C", "D", -3);
        tc2.addEdge("C", "E", -1);
        tc2.addEdge("C", "F", -6);
        tc2.addEdge("D", "F", -2);
        tc2.addEdge("E", "F", -3);
        tc2.dijkstra("A");

        System.out.println("Self-loop Weighted Graph");
        DijkstraAlgorithmWithTestcases tc3 = new DijkstraAlgorithmWithTestcases();
        tc3.addEdge("A", "B", 4);
        tc3.addEdge("A", "C", 4);
        tc3.addEdge("B", "B", 1);
        tc3.addEdge("B", "C", 2);
        tc3.addEdge("C", "C", 3);
        tc3.addEdge("C", "D", 3);
        tc3.addEdge("C", "E", 1);
        tc3.addEdge("C", "F", 6);
        tc3.addEdge("D", "F", 2);
        tc3.addEdge("E", "E", 2);
        tc3.addEdge("E", "F", 3);
        tc3.dijkstra("A");

        System.out.println("All-Weight-Are-Zero Graph ");
        DijkstraAlgorithmWithTestcases tc4 = new DijkstraAlgorithmWithTestcases();
        tc4.addEdge("A", "B", 0);
        tc4.addEdge("A", "C", 0);
        tc4.addEdge("B", "C", 0);
        tc4.addEdge("C", "D", 0);
        tc4.addEdge("C", "E", 0);
        tc4.addEdge("C", "F", 0);
        tc4.addEdge("D", "F", 0);
        tc4.addEdge("E", "F", 0);
        tc4.dijkstra("A");

        System.out.println("Disconnect Weighted Graph ");
        DijkstraAlgorithmWithTestcases tc5 = new DijkstraAlgorithmWithTestcases();
        tc5.addEdge("A", "B", 4);
        tc5.addEdge("A", "C", 4);
        tc5.addEdge("B", "C", 2);
        tc5.addEdge("D", "F", 2);
        tc5.addEdge("E", "F", 3);
        tc5.dijkstra("A");
    }
}
