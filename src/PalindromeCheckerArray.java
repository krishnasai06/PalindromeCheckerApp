import java.util.Scanner;

class PalindromeCheckerArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- UC4: Palindrome Checker (Two-Pointer Method) ---");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // 1. Convert string to character array (char[])
        // We normalize to lowercase to ensure 'A' matches 'a'
        char[] charArray = input.toLowerCase().toCharArray();

        // 2. Initialize Two Pointers
        int left = 0;
        int right = charArray.length - 1;
        boolean isPalindrome = true;

        // 3. Two-Pointer Logic
        while (left < right) {
            // Compare characters at current pointer positions
            if (charArray[left] != charArray[right]) {
                isPalindrome = false;
                break; // Exit loop immediately on first mismatch
            }
            // Move pointers towards the middle
            left++;
            right--;
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