// LeetCode 19 - Remove Nth Node From End of List
// Date: 15/09/2025,solved again on 13/12/25
// Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
// Tags: Linked List / Two-Pointer / Dummy Node / Iteration
    // ------------------------------------------------------------
    // Approach 1: Two-Pointer (Optimal, One Pass)
    //
    // Description:
    //   Given the head of a singly-linked list, remove the n-th node
    //   from the end of the list and return the head of the modified list.
    //
    // Approach (Two-Pointer):
    //   1) Use a dummy node to handle edge cases (like removing the head).
    //   2) Initialize two pointers: first and second at dummy.
    //   3) Move first pointer n+1 steps ahead.
    //   4) Move both pointers until first reaches the end.
    //   5) Remove the n-th node by changing second.next to second.next.next.
    //   6) Return dummy.next as the new head.
    //
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ------------------------------------------------------------
    // Approach 2: Count Length (Your Original Logic)
    //
    // Description:
    //   1) Traverse the list to count total nodes.
    //   2) Calculate steps = length - n.
    //   3) Traverse again to the node just before the target.
    //   4) Adjust pointers to remove the node.
    //
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ------------------------------------------------------------
///**
//  * Definition for singly-linked list.
 

import java.util.*;

// ListNode definition
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class RemoveNthNode {


    public static ListNode removeNthFromEndTwoPointer(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return dummy.next;
    }


    public static ListNode removeNthFromEndCounting(ListNode head, int n) {
        ListNode current = head;
        int count = 1;

        while (current.next != null) {
            current = current.next;
            count++;
        }

        int steps = count - n;

        // If head needs to be removed
        if (steps == 0) {
            return head.next;
        }

        current = head;
        while (steps != 1) {
            current = current.next;
            steps--;
        }

        current.next = current.next.next;
        return head;
    }

    // Helper: Build linked list from user input
    public static ListNode buildList(String[] values) {
        ListNode head = null, tail = null;
        for (String val : values) {
            ListNode node = new ListNode(Integer.parseInt(val));
            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }
        return head;
    }

    // Helper: Print linked list
    public static void printList(ListNode head) {
        System.out.print("[");
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
            if (head != null) System.out.print(", ");
        }
        System.out.println("]");
    }

    // ------------------------------------------------------------
    // Main Driver
    // ------------------------------------------------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter linked list values (space-separated):");
        String[] parts = sc.nextLine().split(" ");
        ListNode head = buildList(parts);

        System.out.println("Enter n (position from end to remove):");
        int n = sc.nextInt();

        System.out.println("Choose approach:");
        System.out.println("1 -> Two-Pointer (Optimal, One Pass)");
        System.out.println("2 -> Counting Length (Two Pass)");
        int choice = sc.nextInt();

        if (choice == 1) {
            head = removeNthFromEndTwoPointer(head, n);
            System.out.println("Used Two-Pointer Approach");
        } else if (choice == 2) {
            head = removeNthFromEndCounting(head, n);
            System.out.println("Used Counting Approach");
        } else {
            System.out.println("Invalid choice");
            return;
        }

        System.out.println("Updated Linked List:");
        printList(head);

        sc.close();
    }
}


// ---

// # **Removing Nth Node from End – Interview Notes**

// ### **Problem**

// Given a singly-linked list, remove the n-th node from the end and return the head.

// ---

// ### **Three Approaches**

// | # | Method                                    | Key Idea                                                                               | Passes | Special Case                             | Notes                                                  |
// | - | ----------------------------------------- | -------------------------------------------------------------------------------------- | ------ | ---------------------------------------- | ------------------------------------------------------ |
// | 1 | **Count-Length (Your original approach)** | Count nodes, compute `length-n`, traverse again to delete                              | 2      | Handle head separately (`if steps == 0`) | Works, correct, slightly longer                        |
// | 2 | **Dummy Node (Optimal, One Pass)**        | Use dummy → slow/fast pointers, fast moves `n+1` steps ahead, slow stops before target | 1      | Handled automatically                    | Clean, elegant, optimal, no counting                   |
// | 3 | **Non-Dummy Two-Pointer (Hybrid)**        | Like dummy method but start at head, handle head as a special case                     | 1-2    | Check `if n == length`                   | Combines pointers + special case, works but less clean |

// ---

// ### **Key Insights**

// * Deleting a node requires **access to the previous node**.

// * **Head has no previous node**, so dummy node makes life easier.+

// * Dummy method is **optimal** because:

//   * One pass
//   * Handles head automatically
//   * No extra `if` or counting

// * Count-length method is valid but **two-pass** → breaks “optimality”.

// * Non-dummy pointer method is essentially a **hybrid**: pointers + special-case handling.

// ---

// ### **Memory Aid (Fast Recall)**

// * **Fast creates a gap** → distance `n+1`
// * **Slow stands before victim** → deletes node
// * Dummy = “head is just another node”
// * Count-length = “head is special → handle separately”



// ### **1️⃣ Count-Length Method (Original, Two Passes)**

// ```java
// int len = 0; ListNode temp = head;
// while(temp != null){ len++; temp = temp.next; }
// if(n == len) return head.next; // remove head
// temp = head;
// for(int i=1; i<len-n; i++) temp=temp.next;
// temp.next = temp.next.next;
// return head;
// ```

// ---

// ### **2️⃣ Dummy Node Method (Optimal, One Pass)**

// ```java
// ListNode dummy = new ListNode(0); dummy.next = head;
// ListNode fast=dummy, slow=dummy;
// for(int i=0;i<=n;i++) fast=fast.next;
// while(fast!=null){ fast=fast.next; slow=slow.next; }
// slow.next = slow.next.next;
// return dummy.next;
// ```

// ---

// ### **3️⃣ Non-Dummy Pointer Method (Hybrid, One Pass + Special Case)**

// ```java
// int len=0; ListNode temp=head;
// while(temp!=null){ len++; temp=temp.next; }
// if(n==len) return head.next; // remove head
// ListNode fast=head, slow=head;
// for(int i=0;i<n;i++) fast=fast.next;
// while(fast.next!=null){ fast=fast.next; slow=slow.next; }
// slow.next=slow.next.next;
// return head;
// ```

// ---

// ✅ **Super short memory hook:**

// * **Count-Length:** Two passes, handle head separately
// * **Dummy Node:** One pass, no special case, elegant
// * **Non-Dummy Hybrid:** One pass, handle head separately

