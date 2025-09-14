package GreedyAddedTestcase;

public class MaxSumArrayTestcase {
    public static int maxSumPossible(int[] input) {
        // Insertion sort descending.
        for (int i=1; i<input.length; i++) {
            int key = input[i];
            int j = i-1;
            while (j>=0 && input[j] > key) {
                input[j+1] = input[j];
                j = j-1;
            }
            input[j+1] = key;
        }
        // Sum
        int result = 0;
        for (int i=0; i<input.length; i++) {
            result += input[i]*i;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.print(maxSumPossible(new int[]{10}) + ", ");
        System.out.print(maxSumPossible(new int[]{10,20,30,40,50})  + ", ");
        System.out.print(maxSumPossible(new int[]{50,40,30,20,10})  + ", ");
        System.out.print(maxSumPossible(new int[]{30,50,10,40,20})  + ", ");
        System.out.print(maxSumPossible(new int[]{-10,-20,-30,-40,-50})  + ", ");
        System.out.print(maxSumPossible(new int[]{0,-10,0,-20,0,-30,0,-40,0,-50, 0}) + ", ");
        System.out.print(maxSumPossible(new int[]{0,10,0,20,0,30,0,40,0,50,0} ) + ", ");
        System.out.print(maxSumPossible(new int[]{5,5,5,5,5,5,5,5,5}));
    }
}
