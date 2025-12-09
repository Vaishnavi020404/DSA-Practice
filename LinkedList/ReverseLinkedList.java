// LeetCode 206 - Reverse Linked List
// Date: 14/09/2025, solved again on 2/12/25 and 9/12/25
// Link: https://leetcode.com/problems/reverse-linked-list/
// Tags: Linked List / Two-Pointer / Iteration / Recursion
//
// Iterative Approach:
//   YouTube Reference: https://www.youtube.com/watch?v=auoTGovuo9A
//   1) Use 3 pointers: prev, curr, next
//   2) Traverse the list, reverse the links one by one
//   3) Move prev and curr forward
//   4) When curr becomes null, prev is the new head
//   Time Complexity: O(n), Space Complexity: O(1)
//
// Recursive Approach:
//   YouTube Reference: https://www.youtube.com/watch?v=RreHsOfi14w
//   1) Base case: if head is null or only one node, return head
//   2) Recursively reverse the rest of the list
//   3) Make next node point to current node (head.next.next = head)
//   4) Break original link (head.next = null)
//   5) Return new head of reversed list
//   Time Complexity: O(n), Space Complexity: O(n) due to recursion stack

import java.util.*;

public class ReverseLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Iterative reversal
    public static ListNode reverseIterative(ListNode head) {
        ListNode prev = null, curr = head;


//Iterative
// ListNode prev = null, curr = head;
// while (curr != null) { ... }


// Only head == null matters for safety.

// Why not head.next == null?

// The while loop handles all cases, including a single-node list.

// If the list has one node, curr != null → enters loop once → curr.next = prev (null) → prev = curr → curr = next (null) → loop ends. Works perfectly without a special check.



        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Recursive reversal
    public static ListNode reverseRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

// head == null → the list is empty. There’s nothing to reverse, so return null.
// head.next == null → the list has only one node. A single node reversed is still itself, so return it.
// Why both?
// The recursion works by reversing the “rest of the list” (head.next).
// If you don’t check head.next == null, the recursion would keep calling itself on the last node’s next (which is null), and that would still work but adds an unnecessary extra call.
// Including both makes the base case safe and clean, stopping recursion exactly when it should.

        ListNode newHead = reverseRecursive(head.next);
        head.next.next = head; //(head.next).next = head
        head.next = null;
        return newHead;
    }

    // Print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }




// Recursive: needs both checks to stop recursion properly.

// Iterative: loop logic naturally handles single-node lists, so only head == null is “special.”
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers separated by space:");
        String[] parts = sc.nextLine().split(" ");

        ListNode head = null, tail = null;
        for (String part : parts) {
            ListNode node = new ListNode(Integer.parseInt(part));
            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        // Reverse using iterative method
        ListNode iterReversed = reverseIterative(head);
        System.out.print("Iteratively reversed list: ");
        printList(iterReversed);

        // To demonstrate recursive reversal, recreate original list
        head = null;
        tail = null;
        for (String part : parts) {
            ListNode node = new ListNode(Integer.parseInt(part));
            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        // Reverse using recursive method
        ListNode recurReversed = reverseRecursive(head);
        System.out.print("Recursively reversed list: ");
        printList(recurReversed);

        sc.close();
    }
}
