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

    
