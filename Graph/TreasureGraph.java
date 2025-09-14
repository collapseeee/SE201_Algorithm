import java.util.Arrays;

public class TreasureGraph {

    private int numberOfRows;
    private int numberOfColumns;
    private int[][] adjacencyMatrix; // Graph representation in dense form

    public TreasureGraph(int[][] routeGrid) {
        this.numberOfRows = routeGrid.length;
        this.numberOfColumns = routeGrid[0].length;

        int numberOfVertices = numberOfRows * numberOfColumns;
        adjacencyMatrix = new int[numberOfVertices][numberOfVertices];

        buildAdjacencyMatrix();
    }

    private void buildAdjacencyMatrix() {
        for (int rowIndex = 0; rowIndex < numberOfRows; rowIndex++) {
            for (int columnIndex = 0; columnIndex < numberOfColumns; columnIndex++) {
                int currentVertex = rowIndex * numberOfColumns + columnIndex;

                // Move right
                if (columnIndex + 1 < numberOfColumns) {
                    int rightVertex = rowIndex * numberOfColumns + (columnIndex + 1);
                    adjacencyMatrix[currentVertex][rightVertex] = 1; // Edge weight
                }

                // Move down
                if (rowIndex + 1 < numberOfRows) {
                    int downVertex = (rowIndex + 1) * numberOfColumns + columnIndex;
                    adjacencyMatrix[currentVertex][downVertex] = 1; // Edge weight
                }
            }
        }
    }

    public void printAdjacencyMatrix() {
        for (int[] row : adjacencyMatrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        int[][] routeGrid = {
            {2, 2, 3, 4, 2},
            {1, 2, 2, 4, 5},
            {6, 5, 6, 1, 5},
            {3, 6, 5, 4, 3}
        };

        TreasureGraph graph = new TreasureGraph(routeGrid);
        graph.printAdjacencyMatrix();
    }
}
