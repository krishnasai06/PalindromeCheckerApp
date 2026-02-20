
import java.util.Scanner;
import java.util.Stack;
    public class StackBasedPalindromeChecker {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("--- UC5: Palindrome Checker (Stack-Based) ---");
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();

            // 1. Prepare the string (remove spaces and ignore case)
            String cleanInput = input.replaceAll("\\s+", "").toLowerCase();

            // 2. Initialize the Stack data structure
            Stack<Character> stack = new Stack<>();

            // 3. Push Operation: Insert each character into the stack
            for (int i = 0; i < cleanInput.length(); i++) {
                stack.push(cleanInput.charAt(i));
            }

            // 4. Pop Operation: Build the reversed string
            StringBuilder reversedString = new StringBuilder();
            while (!stack.isEmpty()) {
                // pop() removes the top element (the most recently added)
                reversedString.append(stack.pop());
            }

            // 5. Compare and Print Result
            if (cleanInput.equals(reversedString.toString())) {
                System.out.println("Result: '" + input + "' is a Palindrome.");
            } else {
                System.out.println("Result: '" + input + "' is NOT a Palindrome.");
            }

            scanner.close();
        }
    }

