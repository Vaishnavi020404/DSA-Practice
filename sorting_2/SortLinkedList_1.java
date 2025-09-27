//===========================================================
// LeetCode 148 - Sort List
// Date: 27/09/2025
// Link: https://leetcode.com/problems/sort-list/
// Tags: Linked List / Merge Sort
// Approach: 
//   1) Use Merge Sort to sort a singly-linked list in O(n log n) time.
//   2) Find the middle using slow and fast pointers to split the list.
//   3) Recursively sort each half and merge them.
// Time Complexity: O(n log n) due to merge sort recursion
// Space Complexity: O(log n) due to recursion stack
//===========================================================

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class SortLinkedList_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //--------------- Input Section ----------------
        System.out.println("Enter the number of nodes in the linked list:");
        int n = sc.nextInt();

        if (n == 0) {
            System.out.println("Sorted List: []");
            sc.close();
            return;
        }

        System.out.println("Enter the node values:");
        ListNode head = new ListNode(sc.nextInt()); // first node
        ListNode current = head;                     // pointer to build the list
        for (int i = 1; i < n; i++) {
            current.next = new ListNode(sc.nextInt());
            current = current.next;
        }

        //--------------- Processing Section ----------------
        head = sortList(head);

        //--------------- Output Section ----------------
        System.out.println("Sorted Linked List:");
        current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }

        sc.close();
    }

    //===========================================================
    // Merge Sort Function
    //===========================================================
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // Step 1: Find the middle of the list using slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Split the list into two halves
        ListNode mid = slow.next;
        slow.next = null;

        // Step 3: Recursively sort each half
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        // Step 4: Merge the two sorted halves
        return merge(left, right);
    }

    //===========================================================
    // Merge Two Sorted Linked Lists
    //===========================================================
    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if (l1 != null) tail.next = l1;
        if (l2 != null) tail.next = l2;

        return dummy.next;
    }
}
