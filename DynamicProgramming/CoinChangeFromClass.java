import java.util.ArrayList;
import java.util.List;

public class CoinChangeFromClass {
    public static void main(String[] args) {
        int[] coin1 = {1,2,3};
        System.out.println("All possible ways: " + CoinChangeWays(4, coin1));

        int[] coin2 = {2,5,3,6};
        System.out.println("All possible ways: " + CoinChangeWays(10, coin2));
    }
    public static int CoinChangeWays(int sum, int[] coinArr) {
        int[][] possibleList = new int[coinArr.length][sum+1];
        for (int i=0; i<coinArr.length; i++) {
            possibleList[i][0] = 1;
        }

        int baseCoin = coinArr[0];
        for (int j=baseCoin; j<=sum; j+=baseCoin) {
            possibleList[0][j] = possibleList[0][j-baseCoin];
        }

        for (int c=1; c<coinArr.length; c++) {
            int coin = coinArr[c];
            for (int value=1; value<=sum; value+=1) {
                if (value>=coin) {
                    possibleList[c][value] = possibleList[c][value-coin] + possibleList[c-1][value];
                } else {
                    possibleList[c][value] = possibleList[c-1][value];
                }
            }
        }

        for (int[] l: possibleList) {
            for (int k=0; k<l.length-1; k++) {
                System.out.print("" + l[k] + ",");
            }
            System.out.print(""+l[l.length-1]);
            System.out.println();
        }

        return possibleList[coinArr.length-1][sum];
    }
}
