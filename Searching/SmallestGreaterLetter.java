// Find Smallest Letter Greater Than Target (LeetCode 744)
// Link: https://leetcode.com/problems/find-smallest-letter-greater-than-target/
// Time Complexity: O(log n)
// Space Complexity: O(1)
//
// 🔍 What to Remember & Why:
// - Array is sorted and contains lowercase letters.
// - You need to find the letter **strictly greater** than target.
// - If not found, return the first element (array is circular).
// - Use Binary Search; wrap using start % length.  
// if start is of arr.length,then it becomes 0 and comes at index 0;
//eg:length is 3 and start shifts from 2 to 3 that is outside of the array,so 3%3=0


//if u forcefull and directly return arr[0],it will not work when u actually have the answer(i hope i will undertsand this when i try to revise this 2000 years later)
//Always remember:

// Use <= when the question says: “greater than target (not greater than or equal)**”.

// | Condition                   | Should return | Why?                    |
// | --------------------------- | ------------- | ----------------------- |
// | `target == arr[last index]` | `arr[0]`      | No char greater than it |
// | `target > arr[last index]`  | `arr[0]`      | Still no char greater   |


import java.util.Scanner;

public class SmallestGreaterLetter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        char[] letters = new char[n];
        System.out.println("Enter characters in sorted order:");
        for (int i = 0; i < n; i++) {
            letters[i] = sc.next().charAt(0);
        }

        System.out.print("Enter target character: ");
        char target = sc.next().charAt(0);

        char result = nextGreatestLetter(letters, target);
        System.out.println("The next greatest letter is: " + result);
    }

    public static char nextGreatestLetter(char[] arr, char target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return arr[start % arr.length];  // wrap around if needed
    }
}
