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
        String reversed = "";
        for (int i = original.length() - 1; i >= 0; i--) {
            reversed += original.charAt(i);
        }

        if (original.equals(reversed)) {
            System.out.println("UC3: " + original + " is a palindrome.");
        } else {
            System.out.println("UC3: " + original + " is not a palindrome.");
        }


        String inputUC4 = "racecar";
        char[] charArray = inputUC4.toCharArray();
        int start = 0;
        int end = charArray.length - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (charArray[start] != charArray[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        System.out.println("UC4: Is " + inputUC4 + " a palindrome? " + isPalindrome);

    }
}
