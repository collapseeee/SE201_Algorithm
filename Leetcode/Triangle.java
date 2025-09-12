package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        System.out.println(minimumTotal(Arrays.asList(
            Arrays.asList(2),
            Arrays.asList(3, 4),
            Arrays.asList(6, 5, 7),
            Arrays.asList(4, 1, 8, 3)
        )));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(triangle.get(0));
        for (int i=1; i<triangle.size(); i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j=0; j<triangle.get(i).size(); j++) {
                if (j == 0) {
                    // first element, only one parent
                    temp.add(result.get(i - 1).get(j) + triangle.get(i).get(j));
                } else if (j == triangle.get(i).size() - 1) {
                    // last element, only one parent
                    temp.add(result.get(i - 1).get(j - 1) + triangle.get(i).get(j));
                } else {
                    // middle elements, two parents
                    int minParent = Math.min(result.get(i - 1).get(j - 1), result.get(i - 1).get(j));
                    temp.add(minParent + triangle.get(i).get(j));
                }
            }
            result.add(temp);
        }
        
        /* for (List<Integer> l : result) {
            for (int i=0; i<l.size(); i++) {
                System.out.print(l.get(i) + " ");
            }
            System.out.println();
        }
        */

        return Collections.min(result.get(result.size()-1));
    }
}
