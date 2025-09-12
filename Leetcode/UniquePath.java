package Leetcode;

public class UniquePath {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));
        System.out.println(uniquePaths(3,2));
    }

    public static int uniquePaths(int m, int n) {
        int[][] possibleArray = new int[m][n];
        for (int firstRow=0; firstRow<possibleArray[0].length; firstRow++) {
            possibleArray[0][firstRow] = 1;
        }
        for (int firstCol=0; firstCol<possibleArray.length; firstCol++) {
            possibleArray[firstCol][0] = 1;
        }
        for (int i=1; i<possibleArray.length; i++) {
            for (int j=1; j<possibleArray[i].length; j++) {
                possibleArray[i][j] = possibleArray[i-1][j] + possibleArray[i][j-1];
            }
        }
        return possibleArray[m-1][n-1];
    }
}
