// LeetCode 876 - Middle of the Linked List
// Date: 15/09/2025
// Link: https://leetcode.com/problems/middle-of-the-linked-list/
// Tags: Linked List / Two-Pass / Iteration
//
// Description:
//   Given the head of a singly-linked list, return the middle node of the list.
//   If there are two middle nodes, return the second one.
//
// Approach (Two-Pass):
//   1) First pass: Traverse the list to count the total number of nodes.
//   2) Second pass: Traverse again up to length / 2 to reach the middle node.
//   3) Return the middle node.
//
// Time Complexity: O(n)  (two passes over the list)
// Space Complexity: O(1) (constant extra space)


import java.util.*;


public class MiddleNode {

    // Function to find the middle node
    public static ListNode middleNode(ListNode head) {
        int length = 0;
        ListNode current = head;

        // 1️⃣ Count the length of the list
        while (current != null) {
            length++;
            current = current.next;
        }

        // 2️⃣ Go to the middle node
        current = head;
        int middle = length / 2;
        for (int i = 0; i < middle; i++) {
            current = current.next;
        }

        return current;
    }

    // Helper to build linked list from input
    public static ListNode buildList(String[] parts) {
        ListNode head = null, tail = null;
        for (String part : parts) {
            ListNode node = new ListNode(Integer.parseInt(part));
            if (head == null) head = tail = node;
            else { tail.next = node; tail = node; }
        }
        return head;
    }

    // Helper to print linked list as array
    public static void printList(ListNode head) {
        System.out.print("[");
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val);
            temp = temp.next;
            if (temp != null) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input linked list
        System.out.println("Enter linked list values (space-separated):");
        String[] parts = sc.nextLine().split(" ");
        ListNode head = buildList(parts);

        // Find middle node
        ListNode middle = middleNode(head);

        // Print result from middle node onward
        System.out.println("Middle node and following list:");
        printList(middle);

        sc.close();
    }
}
