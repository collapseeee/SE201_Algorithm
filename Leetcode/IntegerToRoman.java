package Leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println("158 = " + intToRoman(158));
        System.out.println("444 = " + intToRoman(444));
        System.out.println("42 = " + intToRoman(42));
        System.out.println("1 = " + intToRoman(1));
        System.out.println("3999 = " + intToRoman(3999));
        System.out.println("9 = " + intToRoman(9));
        System.out.println("90 = " + intToRoman(90));
    }
    public static String intToRoman(int num) {
        Map<Integer, String> roman = new LinkedHashMap<>(); // 13 Entries
        roman.put(1000, "M");
        roman.put(900, "CM");
        roman.put(500, "D");
        roman.put(400, "CD");
        roman.put(100, "C");
        roman.put(90, "XC");
        roman.put(50, "L");
        roman.put(40, "XL");
        roman.put(10, "X");
        roman.put(9, "IX");
        roman.put(5, "V");
        roman.put(4, "IV");
        roman.put(1, "I");

        String result = "";

        for (Integer key : roman.keySet()) {
            result += roman.get(key).repeat((int) num/key);
            num%=key;
        }
        return result;
    }
}
