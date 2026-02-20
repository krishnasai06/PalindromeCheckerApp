
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

    public class QueueandStackBasedPalindromeChecker{
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("--- UC6: Palindrome Checker (Stack + Queue) ---");
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();

            // Normalize input: remove spaces and ignore case
            String cleanInput = input.replaceAll("\\s+", "").toLowerCase();

            // 1. Initialize Data Structures
            Stack<Character> stack = new Stack<>();
            Queue<Character> queue = new LinkedList<>(); // Queue is an interface in Java

            // 2. Load characters into both structures
            for (int i = 0; i < cleanInput.length(); i++) {
                char ch = cleanInput.charAt(i);
                stack.push(ch);    // LIFO (Last-In, First-Out)
                queue.add(ch);     // FIFO (First-In, First-Out)
            }

            boolean isPalindrome = true;

            // 3. Compare Dequeue (Queue) output with Pop (Stack) output
            while (!stack.isEmpty()) {
                // queue.remove() gets the FIRST character added
                // stack.pop() gets the LAST character added
                if (!stack.pop().equals(queue.remove())) {
                    isPalindrome = false;
                    break;
                }
            }

            // 4. Display result
            if (isPalindrome) {
                System.out.println("Result: '" + input + "' is a Palindrome.");
            } else {
                System.out.println("Result: '" + input + "' is NOT a Palindrome.");
            }

            scanner.close();
        }
    }

