import java.util.Scanner ;
    public class LinkedListBasedPalindromChecker  {

        // Static inner Node class
        static class ListNode {
            char data;
            ListNode next;

            ListNode(char data) {
                this.data = data;
                this.next = null;
            }
        }

        // Append node at end
        public static ListNode append(ListNode head, char data) {
            ListNode newNode = new ListNode(data);

            if (head == null) {
                return newNode;
            }

            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
            return head;
        }

        // Reverse linked list
        public static ListNode reverse(ListNode head) {
            ListNode prev = null;
            ListNode current = head;

            while (current != null) {
                ListNode nextNode = current.next;
                current.next = prev;
                prev = current;
                current = nextNode;
            }

            return prev;
        }

        // Check palindrome
        public static boolean isPalindrome(ListNode head) {

            if (head == null || head.next == null) {
                return true;
            }

            ListNode slow = head;
            ListNode fast = head;

            // Find middle
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // Reverse second half
            ListNode secondHalf = reverse(slow);
            ListNode firstHalf = head;

            // Compare halves
            while (secondHalf != null) {
                if (firstHalf.data != secondHalf.data) {
                    return false;
                }
                firstHalf = firstHalf.next;
                secondHalf = secondHalf.next;
            }

            return true;
        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            ListNode head = null;

            System.out.print("Enter a string: ");
            String input = sc.nextLine();

            // Convert string to linked list
            for (int i = 0; i < input.length(); i++) {
                head = append(head, input.charAt(i));
            }

            // Check palindrome
            if (isPalindrome(head)) {
                System.out.println("The string is a Palindrome.");
            } else {
                System.out.println("The string is NOT a Palindrome.");
            }

            sc.close();
        }
    }

