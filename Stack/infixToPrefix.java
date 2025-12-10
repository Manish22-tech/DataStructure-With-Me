import java.util.*;

class Solution {

    // Precedence function
    static int precedence(char ch) {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        if (ch == '^') return 3;
        return -1;
    }

    // Convert Infix to Prefix
    static String infixToPrefix(String infix) {

        // Step 1: Reverse infix
        StringBuilder rev = new StringBuilder(infix).reverse();

        // Step 2: Replace brackets
        for (int i = 0; i < rev.length(); i++) {
            if (rev.charAt(i) == '(')
                rev.setCharAt(i, ')');
            else if (rev.charAt(i) == ')')
                rev.setCharAt(i, '(');
        }

        // Step 3: Convert reversed infix to postfix
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < rev.length(); i++) {
            char ch = rev.charAt(i);

            // If operand, add to postfix
            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            }

            // If '(' push
            else if (ch == '(') {
                stack.push(ch);
            }

            // If ')', pop till '('
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // remove '('
            }

            // If operator
            else {
                while (!stack.isEmpty() && precedence(stack.peek()) > precedence(ch)) {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        // Step 4: Reverse postfix to get prefix
        return postfix.reverse().toString();
    }

    // Main function
    public static void main(String[] args) {
        String infix = "(A-B/C)*(A/K-L)";
        System.out.println("Prefix: " + infixToPrefix(infix));
    }
}
