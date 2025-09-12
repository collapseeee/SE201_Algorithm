public class MaxSumArray {
    public static void main(String[] args) {
        int[] arr = {6,7,3,2}; // Output = 36
        System.out.println(maxSumPossible(arr));
    }
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
}
