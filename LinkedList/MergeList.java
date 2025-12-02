// LeetCode 21 - Merge Two Sorted Lists
// Date: 15/09/2025,solved again on 2/12/25
// Link: https://leetcode.com/problems/merge-two-sorted-lists/
// Tags: Linked List / Two-Pointer / Iteration
// Approach:
//   1) Create a dummy node to start the merged list
//   2) Use a current pointer to build the new list
//   3) Compare nodes from both lists one by one
//        - Append the smaller node to current
//        - Move the pointer of the chosen list forward
//   4) After one list ends, append the remaining nodes of the other list
//   5) Return dummy.next as the head of merged list
// Time Complexity: O(n + m)  (n and m are lengths of the two lists)
// Space Complexity: O(1)      (in-place, no extra memory except dummy)

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeList {

    // Function to merge two sorted lists
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode();
        ListNode current = temp;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) current.next = l1;
        if (l2 != null) current.next = l2;

        return temp.next;
    }

    // Helper function to build linked list from input
    public static ListNode buildList(String[] parts) {
        ListNode head = null, tail = null;
        for (String part : parts) {
            ListNode node = new ListNode(Integer.parseInt(part));
            if (head == null) head = tail = node;
            else { tail.next = node; tail = node; }
        }
        return head;
    }

    // Helper function to print linked list as array
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

        // Input first list
        System.out.println("Enter first sorted list (space-separated):");
        String[] parts1 = sc.nextLine().split(" ");
        ListNode l1 = buildList(parts1);

        // Input second list
        System.out.println("Enter second sorted list (space-separated):");
        String[] parts2 = sc.nextLine().split(" ");
        ListNode l2 = buildList(parts2);

        // Merge lists
        ListNode merged = mergeTwoLists(l1, l2);

        // Print result
        System.out.println("Merged list:");
        printList(merged);

        sc.close();
    }
}


//  FIRST: WHAT IS A “LIST NAME” IN LINKED LISTS?

// There is no separate thing called a “list name.”

// A linked list is just a chain of nodes, and the word “list1” or “l1” is simply:

// a pointer to the FIRST node in that chain.

// That’s it.
// A “list” is just:

// pointer → first node → next → next → next → null


// There is no magical list object.
// No array-like container.
// No list box behind the scenes.

// There is ONLY the first node.

// So when you say:

// ListNode l1;


// You are basically saying:

// “Here’s a variable that will point to the start of some chain of nodes.”