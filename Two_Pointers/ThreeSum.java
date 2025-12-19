//===========================================================
// LeetCode 15 - 3Sum (User Inputs Array of Integers)
// Date: 19/12/2025
// Link: https://leetcode.com/problems/3sum/
// Tags: Two Pointers / Array / User Input
// Approach Summary & Notes for Revision:
//   1) Take user input to form the integer array.
//   2) Two approaches:
//        - Two-pointer after sorting (skip duplicates, early stopping)
//        - HashSet for automatic duplicate removal
//   3) Time Complexity:
//        - Two-pointer: O(n^2)
//        - HashSet: O(n^2)
//   4) Space Complexity:
//        - Two-pointer: O(1) extra
//        - HashSet: O(n) extra
//===========================================================

import java.util.*;

public class ThreeSum{

    // Two-pointer approach (optimal interview-ready)
    public static List<List<Integer>> threeSumTwoPointer(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicates
            if (nums[i] > 0) break; // early stopping

            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) left++;
                else right--;
            }
        }

        return result;
    }

    // HashSet approach (auto removes duplicates)
    public static List<List<Integer>> threeSumHashSet(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    set.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < 0) left++;
                else right--;
            }
        }

        return new ArrayList<>(set);
    }

    // Main method for user input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter elements one by one:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("\n--- Two-Pointer Approach ---");
        List<List<Integer>> res1 = threeSumTwoPointer(nums);
        for (List<Integer> triplet : res1) {
            System.out.println(triplet);
        }

        System.out.println("\n--- HashSet Approach ---");
        List<List<Integer>> res2 = threeSumHashSet(nums);
        for (List<Integer> triplet : res2) {
            System.out.println(triplet);
        }

        sc.close();
    }
}


// Example 1 — Why -2 is correct
// nums = [-3, -2, -1, 0, 1]
// length = 5


// Outer loop: for i = 0; i < nums.length - 2; i++ → i = 0,1,2 ✅

// i=0 → left = 1, right = 4 → okay

// i=1 → left = 2, right = 4 → okay

// i=2 → left = 3, right = 4 → okay

// i=3 → left = 4, right = 4 → no room, cannot form 3 numbers → stop

// ✅ -2 ensures we always have 2 elements after i, no invalid triplet.

// Example 2 — What happens if you do -1
// i < nums.length - 1 → i = 0,1,2,3


// i=3 → left = 4, right = 4 → left == right → inner while(left < right) fails

// Does not crash because while-loop prevents executing invalid access

// But it’s messy and not textbook correct.

// ✅ Correct is -2 for safety and clarity.

// Key takeaway:

// -2 → correct, safe, textbook

// -1 → sometimes works because your inner while(left < right) protects you, but not recommended.


// ================================
// List<Integer>

// A List<Integer> is a list (or array-like collection) of integers.

// Example:

// List<Integer> triplet = Arrays.asList(1, 2, 3);


// Here, triplet contains three numbers: 1, 2, 3.

// List<List<Integer>>

// A List<List<Integer>> is a list of lists of integers.

// Example:

// List<List<Integer>> allTriplets = new ArrayList<>();
// allTriplets.add(Arrays.asList(-1,0,1));
// allTriplets.add(Arrays.asList(-1,-1,2));


// Each inner list is one triplet, outer list stores all triplets.

// Set<List<Integer>>

// A Set<List<Integer>> is like List<List<Integer>>, but it automatically removes duplicates.

// Example:

// Set<List<Integer>> set = new HashSet<>();
// set.add(Arrays.asList(-1,0,1));
// set.add(Arrays.asList(-1,0,1)); // ignored automatically


// Only one [-1,0,1] is kept.