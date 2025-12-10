import java.util.*;

class Solution {

    // Function to return precedence of operators
    static int precedence(char ch) {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        if (ch == '^') return 3;
        return -1;
    }

    // Function to convert Infix to Postfix
    static String infixToPostfix(String exp) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            // If operand, add to postfix
            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            }

            // If '(', push to stack
            else if (ch == '(') {
                stack.push(ch);
            }

            // If ')', pop until '(' is found
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // Remove '('
            }

            // If operator
            else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    // Main function
    public static void main(String[] args) {
        String infix = "A+B*(C-D)";
        System.out.println("Postfix: " + infixToPostfix(infix));
    }
}
