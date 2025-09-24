import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BFSwithTestcases {
    private Map<Integer, List<Integer>> adjacencyList;

    public BFSwithTestcases() {
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
        System.out.print("BFS starts from: " + startNode + " Visit sequence: " );

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
        System.out.println();
    }

    public static void main(String[] args) {
        BFSwithTestcases tc1 = new BFSwithTestcases();
        tc1.addEdge(1, 2);
        tc1.addEdge(1, 3);
        tc1.addEdge(1, 4);
        tc1.addEdge(3, 5);
        tc1.breadthFirstSearch(1);

        BFSwithTestcases tc2 = new BFSwithTestcases();
        tc2.addEdge(1, 2);
        tc2.addEdge(2, 3);
        tc2.addEdge(3, 4);
        tc2.breadthFirstSearch(1);

        BFSwithTestcases tc3 = new BFSwithTestcases();
        tc3.addEdge(1, 2);
        tc3.addEdge(2, 3);
        tc3.addEdge(3, 4);
        tc3.addEdge(4, 1);
        tc3.breadthFirstSearch(1);

        BFSwithTestcases tc4 = new BFSwithTestcases();
        tc4.addEdge(1, 2);
        tc4.addEdge(2, 2);
        tc4.addEdge(2, 3);
        tc4.breadthFirstSearch(1);

        BFSwithTestcases tc5 = new BFSwithTestcases();
        tc5.addEdge(1, 2);
        tc5.addEdge(1, 3);
        tc5.addEdge(4, 5);
        tc5.addEdge(4, 6);
        tc5.breadthFirstSearch(1);
    }
}
