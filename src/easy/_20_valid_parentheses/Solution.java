package easy._20_valid_parentheses;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        boolean result = isValid("()[]{}");
        System.out.println(result);
    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char check = s.charAt(i);
            if (check == '(' || check == '[' || check == '{') {
                stack.push(check);
            } else {
                Character charFromStack;
                try {
                    charFromStack = stack.pop();
                } catch (Exception e) {
                    return false;
                }

                if (charFromStack == '(' && check != ')') {
                    return false;
                } else if (charFromStack == '[' && check != ']') {
                    return false;
                } else if (charFromStack == '{' && check != '}') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
