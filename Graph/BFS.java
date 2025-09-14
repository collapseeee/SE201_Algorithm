import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BFS {
    private Map<Integer, List<Integer>> adjacencyList;

    public BFS() {
        adjacencyList = new HashMap<>();
    }

    public void addEdge(int source, int destination) {
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.get(source).add(destination);
    }

    public void breadthFirstSearch(int startNode) {
        Set<Integer> visitedNodes = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startNode);
        visitedNodes.add(startNode);
        System.out.print("BFS starts from: " + startNode + "\nVisit sequence: " );

        while(!queue.isEmpty()) {
            int currentNode = queue.poll();
            System.out.print(currentNode + " ");

            List<Integer> neighbors = adjacencyList.getOrDefault(currentNode, new ArrayList<>());
            for (int neighbor : neighbors) {
                if (!visitedNodes.contains(neighbor)) {
                    queue.add(neighbor);
                    visitedNodes.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS graph = new BFS();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(3, 7);
        graph.addEdge(4, 8);
        graph.addEdge(4, 9);
        graph.addEdge(5, 10);
        graph.addEdge(5, 11);
        
        graph.breadthFirstSearch(1);
    }
}
