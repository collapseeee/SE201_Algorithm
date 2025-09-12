

public class Heritage {
    public static void main(String[] args) {
        int[] estates = {200,300,400,500};
        int[] estates2 = {100,300,400,50};
        canInherit(estates);
        canInherit(estates2);
    }

    public static void canInherit(int[] estates) {
        // Insertion sort descending.
        for (int i=1; i<estates.length; i++) {
            int key = estates[i];
            int j = i-1;
            while (j>=0 && estates[j] < key) {
                estates[j+1] = estates[j];
                j = j-1;
            }
            estates[j+1] = key;
        }
        // Split into two knapsacks to store and compare estate.
        int knapsack1 = 0;
        int knapsack2 = 0;
        for (int i=0; i<estates.length; i++) {
            if (knapsack1<=knapsack2) knapsack1+=estates[i];
            else knapsack2+=estates[i];
        }
        if (knapsack1==knapsack2) System.out.println("Daughters will get the estates.");
        else System.out.println("Temple will get the estates.");
    }
}
