package GreedyAddedTestcase;

public class MinSquarePaperCuttingTestcase {
    public static int minSquare(double w, double h) {
        if (w < 0 || h < 0) return -1;
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

    public static void main(String[] args) {
        System.out.print(minSquare(10.0, 10.0) + ", ");
        System.out.print(minSquare(-1.0, 2.0) + ", ");
        System.out.print(minSquare(1.0, -2.0) + ", ");
        System.out.print(minSquare(-1.0, -2.0) + ", ");
        System.out.print(minSquare(13.5, 29.5) + ", ");
        System.out.print(minSquare(13.5, 13.5) + ", ");
        System.out.print(minSquare(13.0, 29.0) + ", ");
        System.out.print(minSquare(29.0, 13.0) + ", ");
        System.out.print(minSquare(1031.0, 417.0) + ", ");
        System.out.print(minSquare(25.0, 1.0));
    }
}
