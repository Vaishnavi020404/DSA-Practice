// Date: Friday, August 8, 2025
// Problem: Reverse Words in a String (LeetCode 151)
// Link: https://leetcode.com/problems/reverse-words-in-a-string/

// Description:
// Given a string s, reverse the order of words. Remove extra spaces so that
// there is only one space between words and no leading/trailing spaces.

// Approach:
// 1. Trim the string (remove leading/trailing spaces).
// 2. Split by "\\s+" to handle multiple spaces between words.
// 3. Iterate from last word to first, appending to a StringBuilder.
// 4. Return the built string after trimming any trailing space.
// NOTE: Regex "\\s+" is crucial to merge multiple spaces into one.
// For Java, O(1) space in-place is not possible due to immutability of String.

// Time Complexity: O(N)   — split + build result
// Space Complexity: O(N)  — array of words + StringBuilder
import java.util.Scanner;
public class ReverseString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string of words: ");
        String s = sc.nextLine();
        System.out.println(reverseWords(s));
    } 
    static String reverseWords(String s) {
        String[] words=s.trim().split("\\s+");
        StringBuilder sb=new StringBuilder();
        for(int i=words.length-1;i>=0;i--){
            sb.append(words[i]);
            sb.append(" ");
        }
       
     return sb.toString().trim();   

    }
    
}
