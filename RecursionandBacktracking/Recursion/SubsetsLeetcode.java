// LeetCode 78 - Subsets
// Date: 07/01/2026
// Link: https://leetcode.com/problems/subsets/
// Tags: Array / Backtracking / Bit Manipulation
// Approach 1 - Iterative:
//   1) Start with an empty subset [[]]
//   2) For each number in the array:
//        a) Get the current size of outer list
//        b) For each existing subset:
//            - Create a copy of the subset
//            - Add the current number to the copy
//            - Add the new subset to outer list
//   3) Return the outer list containing all subsets
// Time Complexity: O(n × 2^n) where n = array length
//   - We generate 2^n subsets
//   - Each subset takes O(n) time to copy on average
// Space Complexity: O(n × 2^n)
//   - We store 2^n subsets



//   - Each subset has average size n/2

// Approach 2 - Recursive (Backtracking):
//   1) Use a helper function with index and current subset
//   2) Base case: when index reaches array length, add current to output
//   3) Recursive case:
//        a) Include current element: add to current, recurse, remove (backtrack)
//        b) Exclude current element: recurse without adding
// Time Complexity: O(n × 2^n)
//   - 2^n recursive calls (include/exclude for each element)
//   - Each call copies current list O(n)
// Space Complexity: O(n × 2^n) for output + O(n) recursion stack

import java.util.*;

public class SubsetsLeetcode {

    // Main method for testing
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array elements separated by space:");
        String[] input = sc.nextLine().split(" ");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        // SubsetsLeetcode solution = new SubsetsLeetcode();        
        System.out.println("\nIterative Method:");
        List<List<Integer>> result1 = subsetsIterative(nums);
        System.out.println(result1);
        
        System.out.println("\nRecursive Method:");
        List<List<Integer>> result2 = subsetsRecursive(nums);
        System.out.println(result2);

        sc.close();
    }

    // APPROACH 1: ITERATIVE METHOD
    static List<List<Integer>> subsetsIterative(int[] nums) {
        List<List<Integer>> outer = new ArrayList<>();
        
        outer.add(new ArrayList<>());  // Start with empty subset
        
        for (int num : nums) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        
        return outer;
    }

    // APPROACH 2: RECURSIVE METHOD (BACKTRACKING)
   static List<List<Integer>> subsetsRecursive(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        helper(nums, output, 0, new ArrayList<>());
        return output;
    }

    private static void helper(int[] nums, List<List<Integer>> output, int index, List<Integer> current) {
        // Base case: reached end of array
        if (index == nums.length) {
            output.add(new ArrayList<>(current));  // Add copy of current subset
            return;
        }
        
        // Choice 1: Include current element
        current.add(nums[index]);
        helper(nums, output, index + 1, current);
        
        // Backtrack: Remove the element
        current.remove(current.size() - 1);
        
        // Choice 2: Exclude current element
        helper(nums, output, index + 1, current);
    }

    
}