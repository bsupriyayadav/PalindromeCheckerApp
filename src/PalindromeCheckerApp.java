import java.util.Stack; // Required for UC5
public class PalindromeCheckerApp {
    public static void main(String[] args) {

        String appName = "PalindromeChecker App";
        String version = "1.0.0";

        System.out.println("-------------------------------------------");
        System.out.println("Welcome to the " + appName);
        System.out.println("Version: " + version);
        System.out.println("-------------------------------------------");


        String inputUC2 = "madam";
        if (inputUC2.equals("madam")) {
            System.out.println("UC2: " + inputUC2 + " is a palindrome.");
        } else {
            System.out.println("UC2: " + inputUC2 + " is not a palindrome.");
        }


        String original = "madam";
        String reversedUC3 = "";
        for (int i = original.length() - 1; i >= 0; i--) {
            reversedUC3 += original.charAt(i);
        }

        if (original.equals(reversedUC3)) {
            System.out.println("UC3: " + original + " is a palindrome.");
        } else {
            System.out.println("UC3: " + original + " is not a palindrome.");
        }


        String inputUC4 = "racecar";
        char[] charArray = inputUC4.toCharArray();
        int start = 0;
        int end = charArray.length - 1;
        boolean isPalUC4 = true;

        while (start < end) {
            if (charArray[start] != charArray[end]) {
                isPalUC4 = false;
                break;
            }
            start++;
            end--;
        }
        System.out.println("UC4: Is " + inputUC4 + " a palindrome? " + isPalUC4);


        String inputUC5 = "madam";
        Stack<Character> stack = new Stack<>();


        for (int i = 0; i < inputUC5.length(); i++) {
            stack.push(inputUC5.charAt(i));
        }


        String reversedUC5 = "";
        while (!stack.isEmpty()) {
            reversedUC5 += stack.pop();
        }

        if (inputUC5.equals(reversedUC5)) {
            System.out.println("UC5: " + inputUC5 + " is a palindrome (Stack Method).");
        } else {
            System.out.println("UC5: " + inputUC5 + " is not a palindrome (Stack Method).");
        }

    }
}