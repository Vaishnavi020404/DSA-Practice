/*
5/8/25
     Problem: Leetcode 709 - To Lower Case
    🔗 Link: https://leetcode.com/problems/to-lower-case/

    👨‍💻 Main Logic:
    - Traverse each character of the string
    - If it's an uppercase letter ('A' to 'Z'), convert to lowercase by adding 32 (ASCII logic)
    - Else, keep the character as is
    - Use StringBuilder for efficient appending

    ⏱ Time Complexity: O(n)
    💾 Space Complexity: O(n)
*/

import java.util.*;
public class ToLowerCase{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String result = toLowerCase(input);
        System.out.println("Converted lowercase string: " + result);
    }


    // ✅ Your exact function
     static String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                sb.append((char)(ch + 32));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }


}