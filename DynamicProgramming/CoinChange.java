public class CoinChange {
    public static void main(String[] args) {
        int[] coin1 = {1,2,5};
        System.out.println(CoinChangeWays(5,coin1));

        int[] coin2 = {1,2,3};
        System.out.println(CoinChangeWays(4,coin2));
        
        int[] coin3 = {2,5,3,6};
        System.out.println(CoinChangeWays(10,coin3));
    }
    public static int CoinChangeWays(int sum, int[] coinArr) {
        int[] coinCounterArr = new int[sum+1];
        coinCounterArr[0] = 1;
        for (int coin : coinArr) {
            for (int j=coin; j<=sum; j++) {
                coinCounterArr[j] += coinCounterArr[j-coin];
            }
        }
        return coinCounterArr[sum];
    }
}
