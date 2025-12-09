// LeetCode 2 - Add Two Numbers
// Date: 16/12/2025
// Link: https://leetcode.com/problems/add-two-numbers/
//
// Tags: Linked List / Math / Simulation
//
// Approach (Simple Flow):
//   1) Use a dummy node to start building the answer list
//   2) Move through both lists at the same time
//   3) Take each digit (use 0 if a list is finished)
//   4) Add the digits + carry
//   5) Make a new node with the last digit of the sum
//   6) Update carry for next step
//   7) Attach this new node to our result list
//   8) Continue until both lists + carry are done
//
// Time Complexity: O(n + m)   (we go through both lists once)
// Space Complexity: O(max(n, m)) for the output list
//

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddTwoNumbers {

    // --- Main Logic: Add two numbers stored in linked lists ---
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(); // starting point of result list
        ListNode current = dummy;        // we attach new nodes here
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int v1 = (l1 == null) ? 0 : l1.val;
            int v2 = (l2 == null) ? 0 : l2.val;

            int sum = v1 + v2 + carry;

            // new digit node
            current.next = new ListNode(sum % 10);

            // update carry
            carry = sum / 10;

            // move forward
            current = current.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }

    // --- Helper: Build list from string input like "2 4 3" ---
    public static ListNode buildList(String[] parts) {
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
        return head;
    }

    // --- Helper: Print list as [2, 4, 3] ---
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

    // --- Main: Simple and clean input/output ---
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first number (digits in reverse order, space-separated):");
        ListNode l1 = buildList(sc.nextLine().trim().split(" "));

        System.out.println("Enter second number (digits in reverse order, space-separated):");
        ListNode l2 = buildList(sc.nextLine().trim().split(" "));

        ListNode result = addTwoNumbers(l1, l2);

        System.out.println("Sum as linked list:");
        printList(result);

        sc.close();
    }
}
