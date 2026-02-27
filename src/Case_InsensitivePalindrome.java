
    import java.util.Scanner;

    public class Case_InsensitivePalindrome {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("--- UC10: Case-Insensitive & Space-Ignored Checker ---");
            System.out.print("Enter your text: ");
            String input = scanner.nextLine();

            // Step 1: Normalization (The core of UC10)
            // .toLowerCase() handles the case-insensitivity
            // .replaceAll("[^a-zA-Z0-9]", "") removes spaces, commas, etc.
            String normalized = input.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

            // Step 2: Validate the processed string
            if (checkPalindrome(normalized)) {
                System.out.println("Result: Success! It is a palindrome.");
            } else {
                System.out.println("Result: Failed. It is NOT a palindrome.");
            }

            scanner.close();
        }

        /**
         * Iterative check for the normalized string
         */
        public static boolean checkPalindrome(String str) {
            if (str.isEmpty()) return true;

            int left = 0;
            int right = str.length() - 1;

            while (left < right) {
                if (str.charAt(left) != str.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }



