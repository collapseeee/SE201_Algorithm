package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        List<List<Integer>> result = generate(10);
        for (List<Integer> l: result) {
            for (int i=0; i<l.size(); i++) {
                System.out.print(l.get(i) + " ");
            }
            System.out.println();
        }
        List<List<Integer>> result2 = generate(4);
        for (List<Integer> l: result2) {
            for (int i=0; i<l.size(); i++) {
                System.out.print(l.get(i) + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalList = new ArrayList<>();
        pascalList.add(Arrays.asList(1)); // 0
        if (numRows<2) return pascalList; 
        pascalList.add(Arrays.asList(1 , 1)); // 1
        for (int i=2; i<numRows; i++) {
            List<Integer> tempList = new ArrayList<>();
            tempList.add(1);
            for (int j=0; j<i-1; j++) {
                tempList.add(pascalList.get(i-1).get(j)+pascalList.get(i-1).get(j+1));
            }
            tempList.add(1);
            pascalList.add(tempList);
        }
        return pascalList;
    }
}
