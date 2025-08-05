/*
6/8/25
     Problem: Leetcode 1662 - Check If Two String Arrays are Equivalent
     Link: https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/

    Logic:
    - Concatenate all strings from each array using StringBuilder
    - Compare the final strings using `.toString().equals()`

    ⏱ Time Complexity: O(n + m)
        - where n = total length of strings in word1
                m = total length of strings in word2
     Space Complexity: O(n + m)
*/
import java.util.*;
public class StringArrayEquality {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements in word1 array: ");
        int n1 = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] word1 = new String[n1];
        System.out.println("Enter elements of word1:");
        for (int i = 0; i < n1; i++) {
            word1[i] = sc.nextLine();
        }

        System.out.print("Enter number of elements in word2 array: ");
        int n2 = sc.nextInt();
        sc.nextLine();

        String[] word2 = new String[n2];
        System.out.println("Enter elements of word2:");
        for (int i = 0; i < n2; i++) {
            word2[i] = sc.nextLine();
        }

        boolean result = arrayStringsAreEqual(word1, word2);
        System.out.println("Are the two string arrays equal? " + result);
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        for (String str : word1) {
            sb1.append(str);
        }

        StringBuilder sb2 = new StringBuilder();
        for (String str : word2) {
            sb2.append(str);
        }

        return sb1.toString().equals(sb2.toString());
    }

    
}
