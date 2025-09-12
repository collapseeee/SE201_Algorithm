public class TowersOfHanoi {
    public static void main(String[] args) {
        towersOfHanoi(3, 'A', 'C', 'B');
    }
    public static void towersOfHanoi(int n, char start, char end, char helper) {
        if (n == 1) {
            System.out.println("Move disk: " + n + ", from: " + start + " to " + end);
            return;
        }
        towersOfHanoi(n-1, start, helper, end);
        System.out.println("Move disk: " + n + ", from: " + start + " to " + end);
        towersOfHanoi(n-1, helper, end, start);
    }
}
