
    import java.util.*;

    interface PalindromeStrategy {
        boolean isPalindrome(String input);
    }

    class StackStrategy implements PalindromeStrategy {
        public boolean isPalindrome(@org.jetbrains.annotations.NotNull String input) {
            Stack<Character> stack = new Stack<>();
            String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            for (char c : cleaned.toCharArray()) {
                stack.push(c);
            }
            for (char c : cleaned.toCharArray()) {
                if (c != stack.pop()) {
                    return false;
                }
            }
            return true;
        }
    }

    class DequeStrategy implements PalindromeStrategy {
        public boolean isPalindrome(String input) {
            Deque<Character> deque = new ArrayDeque<>();
            String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            for (char c : cleaned.toCharArray()) {
                deque.addLast(c);
            }
            while (deque.size() > 1) {
                if (!deque.removeFirst().equals(deque.removeLast())) {
                    return false;
                }
            }
            return true;
        }
    }

    public class PalindromeStratergy {

        private PalindromeStrategy strategy;

        public PalindromeStratergy(PalindromeStrategy strategy) {
            this.strategy = strategy;
        }

        public void setStrategy(PalindromeStrategy strategy) {
            this.strategy = strategy;
        }

        public boolean checkPalindrome(String input) {
            return strategy.isPalindrome(input);
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter a string:");
            String input = sc.nextLine();

            System.out.println("Choose Strategy:");
            System.out.println("1. Stack Strategy");
            System.out.println("2. Deque Strategy");

            int choice = sc.nextInt();

            PalindromeStrategy strategy;

            if (choice == 1) {
                strategy = new StackStrategy();
            } else {
                strategy = new DequeStrategy();
            }

            PalindromeStratergy app = new PalindromeStratergy(strategy);

            if (app.checkPalindrome(input)) {
                System.out.println("The given string is a Palindrome.");
            } else {
                System.out.println("The given string is NOT a Palindrome.");
            }

            sc.close();
        }
    }

