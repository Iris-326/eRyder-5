import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Checker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Parentheses Balance Checker ===");
        System.out.print("Enter a string containing only parentheses (e.g., (){}[]): ");
        String input = scanner.nextLine();

        if (isBalanced(input)) {
            System.out.println("The parentheses are BALANCED and PROPERLY PAIRED.");
        } else {
            System.out.println("The parentheses are NOT BALANCED or NOT PROPERLY PAIRED.");
        }
        scanner.close();
    }

    public static boolean isBalanced(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (!isMatchingPair(top, ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }
}

