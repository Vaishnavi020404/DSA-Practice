// LeetCode 92 - Reverse Linked List II
// Date: 02/12/2025,solved again on 9/12/25
// Link: https://leetcode.com/problems/reverse-linked-list-ii/
// Tags: Linked List / Pointer Manipulation
// Approach:
//   1) Use a dummy node to safely handle reversing from the head
//   2) Move a pointer `prev` to (left - 1)th position
//   3) Start reversing links between left & right using the classic sublist reversal trick
//   4) Reconnect the reversed part back
// Time Complexity: O(n)
// Space Complexity: O(1)
//===========================================================
import java.util.*;

public class ReverseBetweenList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Reverse Between function
    public static ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || head.next == null || left == right)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Move prev to node BEFORE left
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // curr starts at left
        ListNode curr = prev.next;

        // Reverse between left and right
        for (int i = 0; i < right - left; i++) {
            ListNode temp = prev.next;
            prev.next = curr.next;
            curr.next = curr.next.next;
            prev.next.next = temp;
        }

        return dummy.next;
    }

    // Print the list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // List Input
        System.out.println("Enter numbers separated by space:");
        String[] parts = sc.nextLine().split(" ");

        ListNode head = null, tail = null;

        for (String p : parts) {
            ListNode node = new ListNode(Integer.parseInt(p));
            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        // Left & Right input
        System.out.print("Enter left index: ");
        int left = sc.nextInt();

        System.out.print("Enter right index: ");
        int right = sc.nextInt();

        // Reverse a portion & print
        head = reverseBetween(head, left, right);
        printList(head);

        sc.close();
    }
}

// ##  First: What the hell is the **goal**?

// You have a linked list.
// You want to **reverse only a portion** of it — from position `left` to `right`.

// Example:
// `1 → 2 → 3 → 4 → 5`
// Reverse between `2` and `4` →
// **Result:** `1 → 4 → 3 → 2 → 5`

// Simple. But doing this *in-place* is where the fun begins.

// ---

// ##  Key idea: We don’t rotate the whole list.

// We **take nodes one by one** from inside the range and **shove them to the front of that range**.

// This technique is called **head insertion**.

// It’s like you’re rearranging a group photo by **pulling people from the middle and making them stand in front**.

// ---

// ##  Now let’s decode YOUR code step by step

// ###  Step 1: Create a dummy so no head-edge-cases kill us

// ```java
// ListNode dummy = new ListNode(0);
// dummy.next = head;
// ```

// Dummy is an imaginary friend attached before head.
// It protects us from left = 1 issues.

// ### Step 2: Move `prev` to the node *before* the left position

// ```java
// ListNode prev = dummy;
// for(int i = 0; i < left; i++){
//     prev = prev.next;
// }
// ```

// **prev** ends up here:

// ```
// ... → prev → [left] → [left+1] → ... → [right]
// ```

// Remember:
// `prev.next` = first node of the region we want to reverse.

// ---

// ###  Step 3: Set `curr` = first node inside the reversing zone

// ```java
// ListNode curr = prev.next;
// ```

// Visually:

// ```
// prev → curr → next → next2 → ...
// ```

// ---

// ## Now comes the black magic: **this loop**

// ```java
// for(int i = 0; i <= right-left; i++){
//     ListNode temp = prev.next;
//     prev.next = curr.next;
//     curr.next = curr.next.next;
//     prev.next.next = temp;
// }
// ```

// Let’s break this into human terms.

// We are repeatedly:

// 1. **grab the node after curr**
// 2. **cut it out**
// 3. **paste it right after prev**

// Imagine your list segment is:

// ```
// prev → A → B → C → D → ...
//          ↑ curr
// ```

// Loop iteration does:

// * take B (curr.next)
// * move it in front of A
// * result becomes:

// ```
// prev → B → A → C → D...
//          ↑ curr
// ```

// Next iteration moves C in front →
// Now you get:

// ```
// prev → C → B → A → D...
//          ↑ curr
// ```

// Next iteration moves D in front →
// Boom, reversed.

// ---

// ## Visual timeline (chef’s kiss)

// Suppose reversing 2–4 in:

// `1 → 2 → 3 → 4 → 5`

// `prev` at 1
// `curr` at 2

// ### Loop 1:

// * Take 3
// * Insert after 1
//   List becomes:
//   `1 → 3 → 2 → 4 → 5`

// ### Loop 2:

// * Take 4
// * Insert after 1
//   List becomes:
//   `1 → 4 → 3 → 2 → 5`

// Done. Reversed segment.

// ---

// ## Why does this feel hard?

// Because:

// * It’s pointer manipulation
// * You're rewiring a freaking spiderweb
// * It's abstract as hell until you draw it

// But the core idea is simple:

// > **Repeatedly take the next node and put it at the front of the reversing section.**

