import java.util.Scanner;

public class DecryptMessage {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //--------------- Input Section ----------------
        System.out.println("Enter the encrypted message:");
        String encryptedMessage = sc.nextLine();

        //--------------- Processing Section ----------------
        String result = decryptMessage(encryptedMessage);

        //--------------- Output Section ----------------
        System.out.println("\nDecrypted Message:");
        System.out.println(result);

        sc.close();
    }

    public static String decryptMessage(String encryptedMessage) {
        if (encryptedMessage == null || encryptedMessage.isEmpty()) {
            return "";
        }

        // Step 1: (Optional) Expand if digits exist
        StringBuilder expanded = new StringBuilder();
        char prev = '\0';

        for (char c : encryptedMessage.toCharArray()) {
            if (Character.isDigit(c)) {
                int count = Character.getNumericValue(c);
                for (int i = 1; i < count; i++) {
                    expanded.append(prev);
                }
            } else {
                expanded.append(c);
                prev = c;
            }
        }

        // Step 2: Split into words
        String[] words = expanded.toString().trim().split("\\s+");

        // Step 3: Reverse order of words AND reverse letters inside each word
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(new StringBuilder(words[i]).reverse());
            if (i > 0) result.append(" ");
        }

        return result.toString();
    }
}
