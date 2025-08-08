// Date: Friday, August 8, 2025

// Problem Link: https://leetcode.com/problems/find-the-difference/
// Description: Find the single extra character in a shuffled string.
// Time Complexity: O(N + M)
// Space Complexity: O(1)

//The approach learned:This approach uses a sum of ASCII values but has a logical error, starting with the shorter string first and subtracting the longer one. This will result in a negative sum, which may produce an incorrect character.

import java.util.Scanner;
public class DifferenceInString{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the two strings you want to find the difference in: ");
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        char c = findTheDifference(s1, s2);
        System.out.println(c);

        }
    
    static char findTheDifference(String s, String t) {
        int sum=0;
        for(char ch: t.toCharArray()){
            sum+=ch;
        }
        for(char ch: s.toCharArray()){
            sum-=ch;
        }
        return (char) sum;
        
    }
}