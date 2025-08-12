/*
  Problem: Longest Common Prefix (LeetCode 14)
  Date: 12 Aug 2025
  Link: https://leetcode.com/problems/longest-common-prefix/

  
  FIRST APPROACH (Brute Force - Your Original Idea)
  Idea:
    1. Pick the first string.
    2. Compare each character with the corresponding character 
       in every other string.
    3. Stop when a mismatch is found or we reach the end of any string.
    4. This works, but it checks each character for each string repeatedly.

  Time Complexity: O(N * M) 
    - N = number of strings
    - M = length of the shortest string
  Space Complexity: O(1)

  SECOND APPROACH (Optimized - Sorting Method)
  Idea:
    1. Sort the array of strings.
    2. The longest common prefix must be common between 
       the first and last strings (because sorting puts
       the most different ones far apart).
    3. Compare only those two strings to get the prefix.

  Time Complexity: O(N * log N) due to sorting
  Space Complexity: O(1)
*/

import java.util.*;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            strs[i] = sc.nextLine();
        }

        // Using Brute Force
        String bruteForceResult = longestCommonPrefixBruteForce(strs);
        System.out.println("\nBrute Force Result: " + bruteForceResult);

        // Using Optimized
        String optimizedResult = longestCommonPrefixOptimized(strs);
        System.out.println("Optimized Result: " + optimizedResult);
    }

    // First Approach: Brute Force
    static String longestCommonPrefixBruteForce(String[] strs) {
        
        String prefix=strs[0];

        if (strs == null || strs.length == 0) return "";

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<strs.length;i++){
            sb.setLength(0);
            for(int j=0;j<strs[i].length() && j<prefix.length();j++){
                if(prefix.charAt(j)==strs[i].charAt(j)){
                    sb.append(strs[i].charAt(j));
                }else{
                    break;
                }

            }
            
            prefix=sb.toString();
        }
        return prefix;
    }
    
    // Second Approach: Optimized using sorting
    static String longestCommonPrefixOptimized(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];

        int i = 0;
        while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)) {
            i++;
        }
        return first.substring(0, i);
    }


}


//Explanationf or time complexity of optimized solution:
// The time complexity of the code is O(NlogN).

// Simple Explanation
// The code has two main parts:

// Sorting the array: This is the most time-consuming step. The computer has to look at every single string and compare them to put them in the correct order. The method used, Arrays.sort(), is very efficient, but its time to complete still grows based on the number of strings, which we call N. For a sorting algorithm, this is typically N multiplied by the logarithm of N, or O(NlogN).

// Finding the prefix: After sorting, the code only needs to look at the first and last strings. It then checks each character of these two strings one by one. The time this takes depends on the length of the strings, which we can call M. This is a much faster operation than the sorting step, so its time complexity is just O(M).

// Since the sorting step O(NlogN) takes much longer than the prefix-finding step O(M) for a large number of strings, the overall time complexity is determined by the sorting. Therefore, the code's complexity is O(NlogN).


//Sorting Algorithm Used
// The Arrays.sort() method for an array of strings in Java uses a highly optimized version of Merge Sort or Timsort, depending on the Java version. Timsort is a hybrid sorting algorithm derived from Merge Sort and Insertion Sort, designed to perform well on many kinds of real-world data.






