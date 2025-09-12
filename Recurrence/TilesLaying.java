public class TilesLaying {
    public static void main(String[] args) {
        System.out.println(layingTile(8));
        layingTilePrint(8, "");
    }
    public static int layingTile(int n) {
        if (n== 0)
            return 0;
        if (n==1)
            return 1;
        if (n==2) 
            return 2;
        if (n==3) 
            return 4;
        return layingTile(n-1) + layingTile(n-2) + layingTile(n-3);
    }
    public static void layingTilePrint(int n, String tile) {
        if (n == 0) {
            System.out.println(tile);
            return;
        }
        if (n >= 1) layingTilePrint(n - 1, tile + "X ");
        if (n >= 2) layingTilePrint(n - 2, tile + "XX ");
        if (n >= 3) layingTilePrint(n - 3, tile + "XXX ");
    }
}
