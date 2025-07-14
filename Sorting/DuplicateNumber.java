// ✅ Problem: Find the Duplicate Number (LeetCode 287)
// https://leetcode.com/problems/find-the-duplicate-number
// ⚙️ Status: Not Fully Solved Yet (Brute Force + Cyclic Sort Attempt)
// I attempted this problem using two approaches:

// Brute Force Method:
// ✅ Simple nested loop to check every pair.
// ❌ Time Complexity: O(n²), not efficient for large inputs.
// ❌ Doesn't work for all edge cases reliably.

// Cyclic Sort Method:
// ✅ Runs in O(n) time.
// ❌ Not allowed in this specific problem because it modifies the input array, which the problem restricts





// import java.util.Scanner;

// public class DuplicateNumber {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter size of array (n + 1): ");
//         int n = sc.nextInt();

//         int[] nums = new int[n];
//         System.out.println("Enter " + n + " elements (numbers from 1 to n, with one number repeated):");
//         for (int i = 0; i < n; i++) {
//             nums[i] = sc.nextInt();
//         }

//         System.out.println("The Duplicate Number is: " + bruteForce(nums));
//     }
//     static int bruteForce(int[] nums) {
//         for(int i=0;i<nums.length;i++){
//             for(int j=i+1;j<nums.length;j++){
//                 if(nums[i]==nums[j]){
//                     return nums[i];
//                 }
//             }
//         }return -1;
        
//     }

//     static int cyclicSort(int[] nums){
//         int i=0;
//         while(i<nums.length){
//             int correctIndex=nums[i]-1;
//             if(nums[i]!=nums[correctIndex]){
//                 int temp=nums[i];
//                 nums[i]=nums[correctIndex];
//                 nums[correctIndex]=temp;
//             }else{
//                 i++;
//             }
//         }

        
//     }
// }
