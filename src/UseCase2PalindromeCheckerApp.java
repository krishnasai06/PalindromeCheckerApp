void main() {
    String original = "madam";
    String reversed = "";

    // Reverse the string
    for (int i = original.length() - 1; i >= 0; i--) {
        reversed += original.charAt(i);
    }

    // Check if the string is a palindrome
    if (original.equals(reversed)) {
        IO.println("The given string is a Palindrome");
    } else {
        IO.println("The given string is not a Palindrome");
    }
}
