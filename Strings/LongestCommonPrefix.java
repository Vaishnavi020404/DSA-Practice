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

  Time Complexity: O(M * log N) due to sorting
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

        if(strs.length==1){
            return strs[0];
        }

        if(strs.length==0){
            return "";
        }

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
