import java.util.Scanner;

public class LinkedListBasedPalindromChecker {

    // Inner class representing a Node in the Singly Linked List
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        // Step 1: Convert String to Linked List
        Node head = convertToLinkedList(input);

        // Step 2: Check for Palindrome
        if (isPalindrome(head)) {
            System.out.println("\"" + input + "\" is a palindrome.");
        } else {
            System.out.println("\"" + input + "\" is NOT a palindrome.");
        }
        scanner.close();
    }

    // --- LOGIC FOR UC8 ---

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        // 1. Find the middle using Fast and Slow pointers
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse the second half of the list in-place
        Node prev = null;
        Node current = slow;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        // 3. Compare the two halves
        Node left = head;
        Node right = prev; // Head of the reversed second half

        while (right != null) {
            if (left.data != right.data) {
                return false; // Found a mismatch
            }
            left = left.next;   // Moving the pointer (Node to Node)
            right = right.next; // Moving the pointer (Node to Node)
        }

        return true;
    }

    // Helper method to build the Linked List from user input
    private static Node convertToLinkedList(String str) {
        if (str.isEmpty()) return null;
        Node head = new Node(str.charAt(0));
        Node current = head;
        for (int i = 1; i < str.length(); i++) {
            current.next = new Node(str.charAt(i));
            current = current.next;
        }
        return head;
    }
}