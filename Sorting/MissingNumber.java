// Link: https://leetcode.com/problems/missing-number/
// Time Complexity: O(n)
// Space Complexity: O(1)
//ALso contians the brute force method  tried:
// 1️⃣ Brute Force Approach: O(n²) Time, O(1) Space

// What to Remember & Why:
// Array contains numbers from 0 to n → 1 number is missing.
// Check nums[i] < nums.length → Prevents ArrayIndexOutOfBounds as nums[i] can be n.
// nums[i] != i → That’s how we detect which number is missing.

 

import java.util.Scanner;
public class MissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array (n): ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter " + n + " elements (numbers from 0 to n, missing one number):");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }


        System.out.println("The Missing Number is " + missingNumber(nums));

    }



    // // 1️⃣ Brute Force Approach that I tried first
    //     static int bruteForce(int[] nums) {
    //         int n = nums.length;
    //         for (int i = 0; i <= n; i++) {
    //             boolean found = false;
    //             for (int j = 0; j < n; j++) {
    //                 if (nums[j] == i) {
    //                     found = true;
    //                     break;
    //                 }
    //             }
    //             if (!found) {
    //                 return i;
    //             }
    //         }
    //         return -1; 
    //     }

    // 2️⃣ Optimized Cyclic Sort Approach
        static int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i];
            if (nums[i] < nums.length && nums[i] != nums[nums[i]]) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j) {
                return j;
            }
        }
        return nums.length;
        }



}
