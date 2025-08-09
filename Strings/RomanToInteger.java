// Date: Friday, August 9, 2025

// Problem Link: 13. https://leetcode.com/problems/roman-to-integer/
// Description: Converts a Roman numeral string to its integer equivalent.
// Time Complexity: O(N)
// Space Complexity: O(1)

// The entire logic hinges on this one idea: if a Roman numeral has a smaller value than the one that comes after it, you subtract it. Otherwise, you add it.
// the Roman numeral system has a conditional rule for when to subtract. The subtraction rule only applies in specific cases.
// Here's the logic:
// Addition (The Default): You always add a numeral's value to the total unless its value is smaller than the next numeral's value. For example, in "VI", the V (5) is not smaller than the I (1), so you simply add 5 + 1.
// Subtraction (The Exception): You subtract a numeral's value only when a smaller numeral appears directly before a larger one. For example, in "IV", the I (1) is smaller than the V (5). This is a signal to subtract the I's value from the total.

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class RomanToInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a Roman numeral: ");
        String romanNumeral = scanner.nextLine();
        scanner.close();
        int result = romanToInt(romanNumeral);

        System.out.println("The integer value is: " + result);
    }
    static int romanToInt(String s) {
        Map<Character,Integer> romanMap=new HashMap<>();
        romanMap.put('I',1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int sum=0;
        for(int i=0;i<s.length()-1;i++){

            int currentValue=romanMap.get(s.charAt(i));
            int nextValue=romanMap.get(s.charAt(i+1));
            if(currentValue>=nextValue){
                sum+=currentValue
                ;
            }else{
                sum-=currentValue;
            }
            
        }

        
        sum+=romanMap.get(s.charAt(s.length()-1));
        return sum;
    }
}
