package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println("X = " + romanToInt("X"));
        System.out.println("MCMXCIV = " + romanToInt("MCMXCIV"));
        System.out.println("III = " + romanToInt("III"));
        System.out.println("MMMCCCXXXIII  = " + romanToInt("MMMCCCXXXIII"));
        System.out.println("MMMCMXCIX = " + romanToInt("MMMCMXCIX"));
        System.out.println("CLVIII = " + romanToInt("CLVIII"));
        System.out.println("CDXLIV = " + romanToInt("CDXLIV"));
        System.out.println("XLII = " + romanToInt("XLII"));
    }
    public static int romanToInt(String s) {
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int result = 0;

        if (s.length() == 1) {
            return roman.get(s.charAt(0));
        }

        for (int i=0; i<s.length()-1; i++) {
            int currVal = roman.get(s.charAt(i));
            int nextVal = roman.get(s.charAt(i+1));
            if (currVal >= nextVal) result += currVal;
            else {
                result += nextVal-currVal;
                i++;
            }
        }

        int lastVal = roman.get(s.charAt(s.length()-1));
        if (roman.get(s.charAt(s.length()-2)) >= lastVal) result += lastVal;

        return result;
    }
}
