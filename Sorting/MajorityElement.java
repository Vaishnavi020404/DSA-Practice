// Problem: Majority Element (LeetCode 169)
//  https://leetcode.com/problems/majority-element
//  Status: Solved

//  What I Tried:

//  Brute Force Approach:
// - For every element, count how many times it appears by checking the whole array
// - If its count > n/2, return it as the majority
// - Time: O(n²), Space: O(1)
// - Too slow for large inputs and not efficient

//  Optimized: Boyer-Moore Voting Algorithm
// - Start with a candidate and a count = 0
// - Traverse the array:
//     If count is 0 → choose current element as candidate
//     If current == candidate → count++
//     Else → count--
// - In the end, the candidate will be the majority element (guaranteed to exist in this problem)
// - Time: O(n), Space: O(1)
// -  Very efficient: no extra space, no sorting, no map

//  What I Learned:
// - Boyer-Moore is a smart way to find majority without extra memory

import java.util.Scanner;

public class MajorityElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter number of elements to find the number in majority : ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Brute Force Approach
        System.out.println("Brute Force Result: " + bruteForce(nums));

        // Optimized Approach
        System.out.println("Optimized Result: " + boyerMoore(nums));

    }
    

    //brute-force approach
    static int bruteForce(int[] n) {
        
        for(int i=0;i<n.length;i++){
            int count=0;
            for(int j=0;j<n.length;j++){
                if(n[j]==n[i]){
                    count++;
                }
            }
            if(count>n.length/2){
                return n[i];
            }
            
        }
        return -1;        
    }

    //optimized approach->Boyer-Moore Voting Algorithm
    static int boyerMoore(int[] nums) {
    int count = 0, candidate = -1;

    for (int num : nums) {
        if (count == 0) {
            candidate = num;
        }
        if (num == candidate) {
            count++;
        } else {
            count--;
        }
    }

    return candidate;
}

}
    
