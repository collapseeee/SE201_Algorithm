
import java.util.ArrayList;

public class DepositInterest {
    public static void main(String[] args) {
        ArrayList<Double> a = new ArrayList<>();
        a.add(1000.0);
        int n = 4;
        for (int i=1; i<=n; i++) {
            a.add(a.get(i-1)*1.08);
        }
        System.out.println(a.get(n));
    }
}
