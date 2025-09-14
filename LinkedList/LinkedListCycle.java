/**
 * LeetCode 141 - Linked List Cycle
 * Date: 15/09/2025
 * Link: https://leetcode.com/problems/linked-list-cycle/
 * Tags: Linked List / Two-Pointer / Floyd's Cycle Detection
 *
 * Description:
 *   This program detects whether a singly-linked list has a cycle.
 *   A singly-linked list is a series of nodes where each node has:
 *     1) an integer value `val`
 *     2) a reference `next` pointing to the next node (or null if end)
 *   In Java, this is defined as:
 *     class ListNode {
 *         int val;       // value stored in the node
 *         ListNode next; // pointer to the next node
 *         ListNode() {}  // default constructor
 *         ListNode(int val) { this.val = val; } // constructor with value
 *         ListNode(int val, ListNode next) { this.val = val; this.next = next; } // value + next pointer
 *     }
 *
 *   The algorithm used is Floyd's Cycle Detection (Fast & Slow Pointer):
 *     - We use two pointers, slow and fast:
 *         slow moves 1 step at a time
 *         fast moves 2 steps at a time
 *     - If there is a cycle, slow and fast will eventually meet.
 *     - If fast reaches the end (null), there is no cycle.
 *
 * Approach:
 *   1) Initialize two pointers, slow and fast, to the head of the list.
 *   2) Traverse the list:
 *        - Move slow by 1 node
 *        - Move fast by 2 nodes
 *        - If slow == fast → cycle detected
 *   3) If fast reaches null → no cycle
 *
 * Time Complexity: O(n)  - Each node is visited at most once
 * Space Complexity: O(1) - Only two pointers used, no extra memory
 */

import java.util.*;

public class LinkedListCycle {

    // Node class
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    // Function to detect cycle
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true; // cycle detected
        }
        return false; // no cycle
    }

    // Simple main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter numbers separated by space:");
        String[] parts = sc.nextLine().split(" ");

        System.out.println("Enter position to connect tail (-1 for no cycle):");
        int pos = sc.nextInt();

        ListNode head = null, tail = null;
        List<ListNode> nodes = new ArrayList<>();

        // Build linked list
        for (String part : parts) {
            ListNode node = new ListNode(Integer.parseInt(part));
            nodes.add(node);

            if (head == null) head = tail = node;
            else {
                tail.next = node;
                tail = node;
            }
        }

        // Create cycle if position is valid
        if (pos >= 0 && pos < nodes.size()) {
            tail.next = nodes.get(pos);
        }

        // Detect cycle
        boolean cycle = hasCycle(head);
        System.out.println("Cycle detected? " + cycle);

        sc.close();
    }
}