// LeetCode 19 - Remove Nth Node From End of List
// Date: 15/09/2025
// Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
// Tags: Linked List / Two-Pointer / Dummy Node / Iteration
//
// Description:
//   Given the head of a singly-linked list, remove the n-th node from the end of the list
//   and return the head of the modified list.
//
// Approach (Two-Pointer):
//   1) Use a dummy node to handle edge cases (like removing the head).
//   2) Initialize two pointers: first and second at dummy.
//   3) Move first pointer n+1 steps ahead.
//   4) Move both pointers until first reaches the end. Second will be just before the node to remove.
//   5) Remove the n-th node by changing second.next to second.next.next.
//   6) Return dummy.next as the new head.
//
// Time Complexity: O(n)  (visit each node once)
// Space Complexity: O(1) (constant extra space)

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class RemoveNthNode {

    // Function to remove the N-th node from end
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node to handle edge cases (like removing head)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy, second = dummy;

        // Move first pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Move both pointers until first reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Remove the nth node
        second.next = second.next.next;

        return dummy.next;
    }

    // Helper: Build linked list from input
    public static ListNode buildList(String[] parts) {
        ListNode head = null, tail = null;
        for (String part : parts) {
            ListNode node = new ListNode(Integer.parseInt(part));
            if (head == null) head = tail = node;
            else { tail.next = node; tail = node; }
        }
        return head;
    }

    // Helper: Print linked list as array
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

        // Input n
        System.out.println("Enter n (position from end to remove):");
        int n = sc.nextInt();

        // Remove nth node
        head = removeNthFromEnd(head, n);

        // Print result
        System.out.println("Linked list after removing the " + n + "-th node from end:");
        printList(head);

        sc.close();
    }
}
