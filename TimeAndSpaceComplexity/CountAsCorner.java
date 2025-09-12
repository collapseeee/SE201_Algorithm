import java.util.Scanner;

public class CountAsCorner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of n for array n*n: ");
        int n = sc.nextInt();
        int[][] A = new int[n][n];
        System.out.println("Enter the elements of the array A: ");
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        sc.close();
        int[][] S = countOnes(A, n);
        System.out.println("\nResult: ");
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(S[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static int[][] countOnes(int[][] A, int n) {
        int[][] S = A;
        for (int i = 0; i < n; i++) { // track current row
            for (int j = 0; j < n; j++) { // track current column
                if (i>0) { 
                    S[i][j] += S[i-1][j];
                }
                if (j>0) {
                    S[i][j] += S[i][j-1];
                }
                if (i>0 && j>0) {
                    S[i][j] -= S[i-1][j-1];
                }
            }
        }
        return S;
    }
}