import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TreasureLinkedList {
    private int totalRows;
    private int totalColumns;
    private Map<String, LinkedList<String>> adjacencyList; // adjacency list

    public TreasureLinkedList(int[][] routeGridInput) {
        this.totalRows = routeGridInput.length;
        this.totalColumns = routeGridInput[0].length;
        this.adjacencyList = new HashMap<>();
        buildGraph();
    }

    // Build graph where moves are only to the right and down
    private void buildGraph() {
        for (int rowIndex = 0; rowIndex < totalRows; rowIndex++) {
            for (int columnIndex = 0; columnIndex < totalColumns; columnIndex++) {
                String currentNode = "(" + rowIndex + "," + columnIndex + ")";
                adjacencyList.putIfAbsent(currentNode, new LinkedList<>());

                // Move right
                if (columnIndex + 1 < totalColumns) {
                    String rightNeighbor = "(" + rowIndex + "," + (columnIndex + 1) + ")";
                    adjacencyList.get(currentNode).add(rightNeighbor);
                }

                // Move down
                if (rowIndex + 1 < totalRows) {
                    String downNeighbor = "(" + (rowIndex + 1) + "," + columnIndex + ")";
                    adjacencyList.get(currentNode).add(downNeighbor);
                }
            }
        }
    }

    // Print adjacency list
    public void printGraph() {
        for (Map.Entry<String, LinkedList<String>> entry : adjacencyList.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }


    public static void main(String[] args) {
        int[][] routeGrid = {
            {2, 2, 3, 4, 2},
            {1, 2, 2, 4, 5},
            {6, 5, 6, 1, 5},
            {3, 6, 5, 4, 3}
        };
        TreasureLinkedList g = new TreasureLinkedList(routeGrid);
        g.printGraph();
    }
}