import java.util.ArrayList;

public class CatalanNumber {
    public static void main(String[] args) {
        catalanNumberRecursiveTime(18);
        catalanNumberDynamicTime(18);
    }
    public static int catalanNumberRecursive(int n) {
        if (n == 0) {
            return 1;
        }
        int result = 0;
        for (int i=0; i<n; i++) {
            result += catalanNumberRecursive(i)*catalanNumberRecursive(n-1-i);
        }
        return result;
    }
    public static void catalanNumberRecursiveTime(int n) {
        long startTime = System.currentTimeMillis();
        System.out.println(catalanNumberRecursive(n));
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");
    }


    public static int catalanNumberDynamic(int n) {
        ArrayList<Integer> arr = new ArrayList<>(n);
        arr.add(1);
        if(n==0) {
            return 1;
        }
        for (int i=1; i<=n; i++) {
            int temp = 0;
            for (int j=0; j<i; j++) {
                temp += arr.get(j)*arr.get(i-1-j);
            }
            arr.add(i, temp);
        }
        return arr.get(n);
    }
    public static void catalanNumberDynamicTime(int n) {
        long startTime = System.currentTimeMillis();
        System.out.println(catalanNumberDynamic(n));
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");
    }
}
