import java.util.Scanner;

// Service class (Not public)
class PalindromeService {
    public boolean check(String text) {
        if (text == null || text.isEmpty()) return true;
        String clean = text.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        int left = 0, right = clean.length() - 1;
        while (left < right) {
            if (clean.charAt(left++) != clean.charAt(right--)) return false;
        }
        return true;
    }
}

// Main class (Must match the filename)
public class ObjectOrientedPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PalindromeService service = new PalindromeService();

        System.out.print("Enter text: ");
        String input = scanner.nextLine();

        if (service.check(input)) {
            System.out.println("Result: Valid Palindrome");
        } else {
            System.out.println("Result: Invalid Palindrome");
        }
        scanner.close();
    }
}