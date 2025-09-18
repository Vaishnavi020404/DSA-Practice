// LeetCode 234 - Palindrome Linked List
// Date: 15/09/2025
// Link: https://leetcode.com/problems/palindrome-linked-list/
// Tags: Linked List / Two Pointers / Reverse / Compare
//
// Description:
//   Given the head of a singly linked list, return true if it is a palindrome.
//
// Approach (Two Pointer + Reverse Half):
//   1) Use fast and slow pointers to find the middle of the list.
//   2) Reverse the second half of the list.
//   3) Compare the first and reversed second half node by node.
//   4) If all matched, return true; otherwise, false.
//
// Time Complexity: O(n)   (one pass to find middle, one pass to reverse, one pass to compare)
// Space Complexity: O(1)  (no extra space used apart from pointers)
import java.util.*;

public class PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
        ListNode slow=head,fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode prev=null;
        while(slow!=null){
            ListNode temp=slow.next;
            slow.next=prev;
            prev=slow;
            slow=temp;
        }

        while(prev!=null){
            if(head.val!=prev.val){
                return false;
            }
            head=head.next;
            prev=prev.next;
        }return true;     
       
    }

     public static ListNode buildList(String[] parts){
            ListNode head=null, tail=null;
            for(String part:parts){
                ListNode node=new ListNode(Integer.parseInt(part));
                if(head==null) head=tail=node;
                else{
                    tail.next=node;
                    tail=node;
                }
            }
            return head;
        }

        public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter linked list values(space-seperated):");
        String[] parts=sc.nextLine().split(" ");

        ListNode head=buildList(parts);
        boolean palindrome=isPalindrome(head);

        System.out.println("The linked list is palindrome or not: "+palindrome);
        sc.close();
    }
}

// Problem with Reversing the Second Half:
// When you reverse, you’re literally changing the direction of the links.
// If you don’t handle the next pointer carefully, you can lose track of the remaining list.
// This is dangerous because linked lists don’t allow random access—you can’t just “go back” like in arrays.
// So, the main challenge is:
// 👉 How do I reverse without breaking the chain?

// Walkthrough
// Imagine the second half: 4 -> 5 -> null
// Initially: prev = null, slow = 4.
// First iteration:
// temp = 5 (save next)
// slow.next = null (reverse pointer, now 4 -> null)
// prev = 4
// slow = 5

// Second iteration:
// temp = null (save next)
// slow.next = 4 (reverse pointer, now 5 -> 4)
// prev = 5
// slow = null (end loop)

// Now prev points to the head of reversed list: 5 -> 4 -> null. ✅

// Why it Feels Tricky
// Pointer juggling – you must save slow.next before reversing, otherwise the rest of the list is lost.
// Order of updates – slow.next = prev must come after saving slow.next.
// Mental model – unlike arrays, you can’t visualize indexes, so it feels abstract until you dry run.

// 💡 Tip for Notes:Reversing the second half is tricky because:
// If we directly change slow.next, we lose the remaining nodes.
// That’s why we first store it in temp.
// Then we carefully re-wire one link at a time until the entire second half is reversed.

