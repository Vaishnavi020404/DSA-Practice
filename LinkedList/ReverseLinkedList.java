
// LeetCode 206 - Reverse Linked List
// Date: 14/09/2025,resolved on 1/12/25
// Link: https://leetcode.com/problems/reverse-linked-list/
// Tags: Linked List / Two-Pointer / Iteration
// Approach: 
//   1) Use 3 pointers: prev, curr, temp
//   2) Traverse the list, reverse the links one by one
//   3) Move prev and curr forward
//   4) When curr becomes null, prev is the new head
// Time Complexity: O(n)  (visit each node once)
// Space Complexity: O(1) (constant extra space)
//===========================================================
import java.util.*;

public class ReverseLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next)
         { this.val = val;
             this.next = next; }
    }

    // Reverse function
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Simple input for interview
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

                // Reverse & print
        head = reverseList(head);
        printList(head);

        sc.close();


    }}