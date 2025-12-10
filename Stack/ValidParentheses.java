import java.util.*;

public class ValidParentheses {

    // Function to check if parentheses are valid
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            // If opening bracket, push
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            // If closing bracket
            else {
                // If stack is empty, invalid
                if (stack.isEmpty()) return false;

                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // If stack empty → valid, else invalid
        return stack.isEmpty();
    }

    // ✅ Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter parentheses string: ");
        String input = sc.nextLine();

        if (isValid(input)) {
            System.out.println("✅ Valid Parentheses");
        } else {
            System.out.println("❌ Invalid Parentheses");
        }

        sc.close();
    }
}
