// 4-8-25
//  LeetCode Problem: 1108. Defanging an IP Address
// Link: https://leetcode.com/problems/defanging-an-ip-address/
// -----------------------------------------------------------------------

// Main Concept:
// String manipulation using StringBuilder
// Iterating through characters and conditionally appending to a new string
// -----------------------------------------------------------------------
// Logic Used:
// Loop through each character of the input string
// If the character is '.', append "[.]" to the result
// Otherwise, append the character itself
// Use StringBuilder for efficient string concatenation
// -----------------------------------------------------------------------
// Time Complexity:
// O(n), where n = length of the input string
// Space Complexity:
// O(n), for storing the final defanged string in StringBuilder


import java.util.Scanner;

public class DefangIPAddress {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a valid IP address: ");
        String ipAddress = sc.nextLine();

        String result = defangIPaddr(ipAddress);

        // Output
        System.out.println("Defanged IP address: " + result);

        
    }

    public static String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                sb.append("[.]");
            } else {
                sb.append(address.charAt(i));
            }
        }

        return sb.toString();
    }

    }


