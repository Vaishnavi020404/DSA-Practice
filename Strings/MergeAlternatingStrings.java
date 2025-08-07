/*
7/8/25

🔍 Problem: LeetCode 1768 - Merge Strings Alternately
🔗 Link: https://leetcode.com/problems/merge-strings-alternately/

Approach:
- Use two pointers to iterate through both strings.
- Append characters alternately from both strings into StringBuilder.
- If one string is exhausted, append the rest of the other using substring.

✅ Time Complexity: O(n + m)
n = length of word1

m = length of word2

raversing both strings exactly once using index pointers (i and j), and adding each character to the StringBuilder → linear time.

✅ Space Complexity: O(n + m)
 StringBuilder to store the merged result, which will hold all characters of word1 and word2 → total of n + m characters.

*/
import java.util.Scanner;
public class MergeAlternatingStrings {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter the first word: ");
        String word1 = scanner.nextLine();

        System.out.print("Enter the second word: ");
        String word2 = scanner.nextLine();

        // Calling merge function
        String result = mergeAlternately(word1, word2);

        // Printing the result
        System.out.println("Merged string: " + result);

        scanner.close();
    }

    static String mergeAlternately(String word1, String word2) {
        StringBuilder sb=new StringBuilder();
        int i=0;
        int j=0;
        while(i<word1.length() && j<word2.length()){
            sb.append((word1.charAt(i)));
            sb.append((word2.charAt(j)));
            i++;
            j++;
        }
        if(i<word1.length()){
            sb.append(word1.substring(i));
        }
        if(j<word2.length()){
            sb.append(word2.substring(j));
        }

        return sb.toString();
    }

}


