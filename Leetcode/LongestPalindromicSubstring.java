package Leetcode;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;

/* 672115014 Nattikorn Sae-sue
 * Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/submissions/1733637531
 */

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc"));
    } 

    public static String longestPalindrome(String s) {
        if (s.length() < 2) return s;

        int bestStart = 0;
        int bestEndInclusive = 0;

        for (int center = 0; center<s.length(); center++) {
            // Odd length
            int start = center;
            int end = center;
            while (start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)) {
                if ((end-start)>(bestEndInclusive-bestStart)) {
                    bestStart = start;
                    bestEndInclusive = end;
                }
                start--;
                end++;
            }

            // Even Length
            start = center;
            end = center+1;
            while (start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)) {
                if ((end-start)>(bestEndInclusive-bestStart)) {
                    bestStart = start;
                    bestEndInclusive = end;
                }
                start--;
                end++;
            }
        }
        return s.substring(bestStart, bestEndInclusive+1);
    }
    
    /* 
    public static String longestPalindromeFirstApproach(String s) {
        List<List<String>> palindromeList = new ArrayList<>();
        if (s.length()==1) return s;
        if (s.length()==2) {
            if (s.charAt(0) == s.charAt(1)) return s;
            else return String.valueOf(s.charAt(0));
        }
        for (int i=0; i<s.length()-2; i++) {
            if (s.charAt(i) == s.charAt(i+2)) {
                palindromeList.add(Arrays.asList(s.substring(i, i+3), ""+i, ""+(i+2)));
            }
            if (s.charAt(i) == s.charAt(i+1)) {
                palindromeList.add(Arrays.asList(s.substring(i, i+2), ""+i, ""+(i+1)));
            }
        }   
        if (s.charAt(s.length()-2) == s.charAt(s.length()-1)) palindromeList.add(Arrays.asList(s.substring(s.length()-2, s.length()), ""+(s.length()-2) , ""+(s.length()-1)));

  
        for (int i = 0; i < palindromeList.size(); i++) {
            List<String> p = palindromeList.get(i);
            try {
                int startIndex = Integer.parseInt(p.get(1));
                int endIndex = Integer.parseInt(p.get(2));
                if (s.charAt(startIndex - 1) == s.charAt(endIndex + 1)) {
                    palindromeList.add(Arrays.asList(
                        s.substring(startIndex - 1, endIndex + 2),
                        "" + (startIndex - 1),
                        "" + (endIndex + 1)
                    ));
                }
            } catch (StringIndexOutOfBoundsException e) {
                continue;
            }
        }

        Collections.sort(palindromeList,(a,b) -> Integer.compare(b.get(0).length(), a.get(0).length()));

        for(List<String> p: palindromeList) {
            System.out.println(p.get(0) + ", Starting Index: " + p.get(1) + " Ending Index: " + p.get(2));
        }

        if (palindromeList.isEmpty()) return String.valueOf(s.charAt(0));
        else return palindromeList.get(0).get(0);
    }
    */
}
