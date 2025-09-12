
import java.util.ArrayList;
import java.util.HashMap;

public class Frog {
    public static void main(String[] args) {
        long startHashMap = System.currentTimeMillis();
        System.out.println("" + hashMapMethod(100000));
        long endHashMap = System.currentTimeMillis();
        System.out.println("HashMap Time taken: " + (endHashMap-startHashMap) + " millisecond.");

        long startArr = System.currentTimeMillis();
        System.out.println("" + arrayMethod(100000));
        long endArr = System.currentTimeMillis();
        System.out.println("Array Time taken: " + (endArr-startArr) + " millisecond.");
    }

    public static int hashMapMethod(int n) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(1,1);
        hm.put(2, 2);
        for(int i=3; i<=n; i++) {
            hm.put(i, hm.get(i-1)+hm.get(i-2));
        }
        return hm.get(n-1)+hm.get(n-2);
    }

    public static int arrayMethod(int n) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(0);
        a.add(1);
        a.add(2);
        for(int i=3; i<=n; i++) {
            a.add(a.get(i-1)+a.get(i-2));
        }
        return a.get(n-1)+a.get(n-2);
    }
}