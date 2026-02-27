
    import java.util.*;

    interface PalindromeAlgorithm {
        boolean isPalindrome(String input);
    }

    class ReverseStringAlgorithm implements PalindromeAlgorithm {
        public boolean isPalindrome(String input) {
            String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            String reversed = new StringBuilder(cleaned).reverse().toString();
            return cleaned.equals(reversed);
        }
    }

    class StackAlgorithm implements PalindromeAlgorithm {
        public boolean isPalindrome(String input) {
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

    class TwoPointerAlgorithm implements PalindromeAlgorithm {
        public boolean isPalindrome(String input) {
            String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            int left = 0;
            int right = cleaned.length() - 1;
            while (left < right) {
                if (cleaned.charAt(left) != cleaned.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }

    public class UseCase13PalindromeCheckerApp {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a string:");
            String input = sc.nextLine();

            List<PalindromeAlgorithm> algorithms = new ArrayList<>();
            algorithms.add(new ReverseStringAlgorithm());
            algorithms.add(new StackAlgorithm());
            algorithms.add(new TwoPointerAlgorithm());

            String[] names = {
                    "Reverse String Algorithm",
                    "Stack Algorithm",
                    "Two Pointer Algorithm"
            };

            for (int i = 0; i < algorithms.size(); i++) {
                long start = System.nanoTime();
                boolean result = algorithms.get(i).isPalindrome(input);
                long end = System.nanoTime();
                long duration = end - start;

                System.out.println("Algorithm: " + names[i]);
                System.out.println("Result: " + (result ? "Palindrome" : "Not Palindrome"));
                System.out.println("Execution Time (nanoseconds): " + duration);
                System.out.println();
            }

            sc.close();
        }
    }

