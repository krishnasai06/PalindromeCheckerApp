
    import java.util.Scanner;

    public class RecursivePalindrome{

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("--- UC9: Recursive Palindrome Checker ---");
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();

            // Standardize input (optional: remove spaces/ignore case)
            String processed = input.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

            if (isPalindromeRecursive(processed)) {
                System.out.println("Result: \"" + input + "\" is a palindrome.");
            } else {
                System.out.println("Result: \"" + input + "\" is NOT a palindrome.");
            }

            scanner.close();
        }

        /**
         * Recursive method to check if a string is a palindrome.
         */
        public static boolean isPalindromeRecursive(String str) {
            // Base Case: If string has 0 or 1 characters, it's a palindrome
            if (str.length() <= 1) {
                return true;
            }

            // Check if first and last characters match
            if (str.charAt(0) == str.charAt(str.length() - 1)) {
                // Recursive Call: Shrink the string by removing first and last chars
                return isPalindromeRecursive(str.substring(1, str.length() - 1));
            }

            // If characters don't match, it's not a palindrome
            return false;
        }
    }

