
import java.util.ArrayList;

public class TreasureGame {
    public static void main(String[] args) {
        int[][] route = {{2,2,3,4,2},
                         {1,2,2,4,5},
                         {6,5,6,1,5},
                         {3,6,5,4,3}};
        System.out.println(bestRoute(route));
    }
    public static ArrayList<Integer> bestRoute(int[][] input) {
        ArrayList<Integer> result = new ArrayList<>(); // Return result always column+row-2
        result.add(input[0][0]);
        int row = 0;
        int column = 0;
        for (int i = 0; i < (input.length+input[0].length-2); i++) {
            if (row == input.length-1) { // Reach Row Bound
                column++;
                result.add(input[row][column]);
            } else if (column == input[0].length-1) { // Reach Column Bound
                row++;
                result.add(input[row][column]);
            } else { // Not Reach Bound
                if (input[row+1][column] > input[row][column+1]) { // If Down > Right
                    row++;
                    result.add(input[row][column]);
                } else {
                    column++;
                    result.add(input[row][column]);
                }
            }  
        }
        return result;
    }
}
