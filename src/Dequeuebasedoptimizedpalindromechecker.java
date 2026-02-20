import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

    public class Dequeuebasedoptimizedpalindromechecker {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("--- UC7: Palindrome Checker (Deque-Based) ---");
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();

            // Normalize the string (lowercase and remove non-alphanumeric for robustness)
            String cleanInput = input.toLowerCase().replaceAll("[^a-z0-9]", "");

            // 1. Initialize the Deque
            // ArrayDeque is generally faster than LinkedList for stack/queue operations
            Deque<Character> deque = new ArrayDeque<>();

            // 2. Insert characters into the Deque
            for (char ch : cleanInput.toCharArray()) {
                deque.addLast(ch);
            }

            boolean isPalindrome = true;

            // 3. Compare Front and Rear elements
            // A palindrome must match from both ends until 0 or 1 character is left
            while (deque.size() > 1) {
                char first = deque.removeFirst();
                char last = deque.removeLast();

                if (first != last) {
                    isPalindrome = false;
                    break;
                }
            }

            // 4. Display Result
            if (isPalindrome) {
                System.out.println("Result: '" + input + "' is a Palindrome.");
            } else {
                System.out.println("Result: '" + input + "' is NOT a Palindrome.");
            }

            scanner.close();
        }
    }

