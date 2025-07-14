// LeetCode Problem: 905. Sort Array By Parity  
// Link: https://leetcode.com/problems/sort-array-by-parity/  
// Approach: Two Pointers, O(n) Time, O(1) Space (ignoring output array)  
//  
// ✅ What to Remember:
// - Fill even numbers from the start (left pointer) and odd numbers from the end (right pointer).
// - Avoid overwriting: don't use the same loop variable 'i' to fill both sides.
// i is only for reading from nums.
// left and right are for writing into ans.
// If you use i directly for writing into ans[i], you lose control over where even numbers go and where odd numbers go. For example:
// First you may write an even number at ans[0].
// Then an odd number might overwrite ans[1] or even ans[0] again — because i doesn’t know or care whether it’s even or odd.
// That’s why we separate reading from writing:
// i → reads each number one by one.
// left → writes from the front.
// right → writes from the end.


import java.util.Arrays;
import java.util.Scanner;

public class SortByParity {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the length of the array: ");
        int n=sc.nextInt();
        int[] nums=new int[n];
        System.out.println("Enter the elements of the array: ");
        for(int i=0;i<n;i++)
        {
            nums[i]=sc.nextInt();
        }    

        System.out.println(Arrays.toString(sortArrayByParity(nums)));
    }
    static int[] sortArrayByParity(int[] nums) {
        int[] ans=new int[nums.length];
        int left=0;
        int right=nums.length-1;
        for(int i=0;i<nums.length;i++){            
            if(nums[i]%2==0){                
                ans[left]=nums[i];
                left++;
            }else{
                ans[right]=nums[i];
                right--;
            }
        }
        return ans;
        
    }    
    
}

//one of my doubts that i got cleared through chatgpt:

// ## ✅ Doubt: When Do I Need to Store the Returned Value in a New Variable Before Printing?

// **Where I Was Confused:**
// I didn’t understand why sometimes directly writing:

// ```java
// System.out.println(Arrays.toString(findNumbers(nums)));
// ```

// was not working.

// ---

// ### **Structured Explanation:**

// 1️⃣ **When You Are Returning a New Array**

// * Example: `int[] findNumbers(nums)` → returns a new array.
// * **You must store this array in a variable first before printing it, especially using `Arrays.toString()`.**
// * Why? Because `System.out.println()` needs to know what value it is printing.
// * ✅ Correct usage:

//   ```java
//   int[] result = findNumbers(nums);
//   System.out.println(Arrays.toString(result));
//   ```

// ---

// 2️⃣ **When You Are Modifying the Old Array and Returning It**

// * Example: `sortArray(nums)` → modifies and returns `nums` itself.
// * You **can** store it in a variable, but it’s not compulsory because `nums` is already updated.
// * ✅ Both work:

//   ```java
//   sortArray(nums);
//   System.out.println(Arrays.toString(nums));
//   ```

//   OR

//   ```java
//   int[] result = sortArray(nums);
//   System.out.println(Arrays.toString(result));
//   ```

// ---

// 3️⃣ **When You Are Returning Just a Value (Like int or String)**

// * Example: `int missingNumber(nums)` → returns an `int`.
// * **You do not need to store it unless you want to use it later.**
// * ✅ Works directly:

//   ```java
//   System.out.println("The Missing Number is " + missingNumber(nums));
//   ```

// ---

// ### ✅ Summary:

// | Return Type      | Store Before Printing?      | Example Use                                  |
// | ---------------- | --------------------------- | -------------------------------------------- |
// | New Array        | Yes, recommended            | `Arrays.toString(findNumbers(nums))`         |
// | Old Array Sorted | Optional                    | `Arrays.toString(nums)`                      |
// | Single Value     | No need to store (optional) | `"Missing Number is " + missingNumber(nums)` |


