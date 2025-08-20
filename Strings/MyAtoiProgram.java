import java.util.Scanner;

public class MyAtoiProgram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string to convert: ");
        String input = sc.nextLine();

        int result = myAtoi(input);
        System.out.println("Converted integer: " + result);

    }

    public static int myAtoi(String s) {
        int i = 0, n = s.length(), sign = 1, num = 0;

        // Skip leading spaces
        while (i < n && s.charAt(i) == ' ') i++;

        // Handle sign
        if (i < n && s.charAt(i) == '-') { sign = -1; i++; }
        else if (i < n && s.charAt(i) == '+') i++;

        // Read digits and build number
        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int digit = s.charAt(i) - '0';

            // Overflow check
            if (num > (Integer.MAX_VALUE - digit) / 10)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            num = num * 10 + digit;
            i++;
        }

        return num * sign;
    }

    
}
