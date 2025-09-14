import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class DFS {
    private Map<Integer, List<Integer>> adjacencyList;

    public DFS() {
        adjacencyList = new HashMap<>();
    }

    public void addEdge(int source, int destination) {
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.get(source).add(destination);
    }

    public void depthFirstSearch(int startNode) {
        Set<Integer> visitedNodes = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(startNode);
        System.out.print("DFS starts from: " + startNode + "\nVisit sequence: " );

        while(!stack.isEmpty()) {
            int currentNode = stack.pop();

            if(!visitedNodes.contains(currentNode)) {
                visitedNodes.add(currentNode);
                System.out.print(currentNode + " ");

                List<Integer> neighbors = adjacencyList.getOrDefault(currentNode, new ArrayList<>());
                for (int i=neighbors.size()-1; i>=0; i--) {
                    if(!visitedNodes.contains(neighbors.get(i))) stack.push(neighbors.get(i));
                }
            }
        }
    }

    public static void main(String[] args) {
        DFS graph = new DFS();
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
        
        graph.depthFirstSearch(1);
    }
}
