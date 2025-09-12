public class MinSquarePaperCutting {
    public static void main(String[] args) {
        System.out.println("" + minSquare(13.0, 29.0));
        System.out.println("" + minSquare(4.0, 5.0));
    }
    public static int minSquare(double w, double h) {
        int count = 0;
        while (w>0 && h>0) {
            if (w>=h) {
                count += w/h;
                w = w%h;
            }
            else {
                count += h/w;
                h = h%w;
            }
        }
        return count;
    }
}
