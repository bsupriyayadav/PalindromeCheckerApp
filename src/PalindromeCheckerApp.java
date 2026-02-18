import java.util.*;

public class PalindromeCheckerApp {
    public static void main(String[] args) {

        String appName = "PalindromeChecker App";
        String version = "1.0.0";

        System.out.println("-------------------------------------------");
        System.out.println("Welcome to the " + appName);
        System.out.println("Version: " + version);
        System.out.println("-------------------------------------------");


        String input = "madam";

        if (input.equals("madam")) {
            System.out.println(input + " is a palindrome.");
        } else {
            System.out.println(input + " is not a palindrome.");
        }


        String original = "madam";
        String reversed = "";

        for (int i = original.length() - 1; i >= 0; i--) {
            reversed += original.charAt(i);
        }

        if (original.equals(reversed)) {
            System.out.println(original + " is a palindrome (Reversed Check).");
        } else {
            System.out.println(original + " is not a palindrome (Reversed Check).");
        }

    }
}
