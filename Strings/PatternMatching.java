
import java.util.*;
class PatternMatching {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter haystack: ");
        String haystack = sc.nextLine();

        System.out.print("Enter needle: ");
        String needle = sc.nextLine();

        // Call function
        int result = strStr(haystack, needle);

        // Print result
        System.out.println("First occurrence index: " + result);
    }

   //Brute-Force method
    static int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    //USING KMP OR RABIN-KARP ALGORITHM

    
}
