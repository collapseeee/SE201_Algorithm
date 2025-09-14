package Leetcode;

public class PowerOfTwoLeetcode {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(2));
        System.out.println(isPowerOfTwo(536870912));
    }
    public static boolean isPowerOfTwo(int n) {
        Double result = Math.log(n)/Math.log(2);
        System.out.println(result);
        if (result - Math.floor(result) == 0) return true;
        else return false;
    }
}
