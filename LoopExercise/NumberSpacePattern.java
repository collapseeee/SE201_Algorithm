import java.util.Scanner;

public class NumberSpacePattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of n: ");
        int n = sc.nextInt();
        System.out.println("\n\n");

        for (int i=1; i<=n; i++) {
            for (int j=1; j<i; j++) {
                System.out.print(" ");
            }
            System.out.print(i);
            System.out.println();
        }
        sc.close();
    }
}
