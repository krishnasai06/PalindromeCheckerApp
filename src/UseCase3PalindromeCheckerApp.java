import java.util.Scanner;

public class UseCase3PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Palindrome Checker (String Reverse Method) ---");
        System.out.print("Enter a string to check: ");
        String original = scanner.nextLine();

        // 1. Logic to reverse the string using a loop
        String reversed = "";

        // We start from the last index and move to 0
        for (int i = original.length() - 1; i >= 0; i--) {
            // Note: String concatenation (+) creates a new object each time
            // due to String Immutability.
            reversed += original.charAt(i);
        }

        System.out.println("Reversed String: " + reversed);

        // 2. Compare original and reversed using .equals()
        // We use .equalsIgnoreCase to make the check user-friendly (e.g., 'Racecar')
        if (original.equalsIgnoreCase(reversed)) {
            System.out.println("Result: The string is a Palindrome.");
        } else {
            System.out.println("Result: The string is NOT a Palindrome.");
        }

        scanner.close();
    }
}