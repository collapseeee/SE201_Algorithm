package Leetcode;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(")[]{} -> " + isValid(")[]{}")); 
        System.out.println("(){}[]" + isValid("(){}[]")); 
        System.out.println("()(){}{}[][]((({{[[]]}}))) -> " + isValid("()(){}{}[][]((({{[[]]}})))"));
        System.out.println("()(){}{}[][]((({{[[]]}})))] -> " + isValid("()(){}{}[][]((({{[[]]}})))]"));
        System.out.println("{ -> " + isValid("{"));
        System.out.println("] -> " + isValid("]"));
        System.out.println("({[([{ -> " + isValid("({[([{"));
    }
    public static boolean isValid(String s) {
        Stack stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char currChar = s.charAt(i);
            if (currChar=='(' || currChar=='[' || currChar=='{') {
                stack.push(currChar);
            } else if (currChar == ')' || currChar == ']' || currChar == '}') {
                if (stack.isEmpty()) return false;
                char poppedChar = (char) stack.pop();
                if (currChar == ')' && poppedChar != '(') return false;
                if (currChar == ']' && poppedChar != '[') return false;
                if (currChar == '}' && poppedChar != '{') return false;
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
}
