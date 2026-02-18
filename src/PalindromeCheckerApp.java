import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        // UC1: Application Entry & Welcome Message
        String appName = "PalindromeChecker App";
        String version = "1.0.0";

        System.out.println("-------------------------------------------");
        System.out.println("Welcome to the " + appName);
        System.out.println("Version: " + version);
        System.out.println("-------------------------------------------");

        // UC2: Print a Hardcoded Palindrome Result
        String inputUC2 = "madam";
        if (inputUC2.equals("madam")) {
            System.out.println("UC2: " + inputUC2 + " is a palindrome.");
        } else {
            System.out.println("UC2: " + inputUC2 + " is not a palindrome.");
        }

        // UC3: Palindrome Check Using String Reverse
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

        // UC4: Character Array Based Palindrome Check (Two-Pointer Technique)
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

        // UC5: Stack-Based Palindrome Checker
        String inputUC5 = "madam";
        Stack<Character> stackUC5 = new Stack<>();
        for (int i = 0; i < inputUC5.length(); i++) {
            stackUC5.push(inputUC5.charAt(i));
        }

        String reversedUC5 = "";
        while (!stackUC5.isEmpty()) {
            reversedUC5 += stackUC5.pop();
        }
        System.out.println("UC5: Stack Result match: " + inputUC5.equals(reversedUC5));

        // UC6: Queue + Stack Based Palindrome Check
        String inputUC6 = "madam";
        Stack<Character> stackUC6 = new Stack<>();
        Queue<Character> queueUC6 = new LinkedList<>();

        for (int i = 0; i < inputUC6.length(); i++) {
            stackUC6.push(inputUC6.charAt(i));
            queueUC6.add(inputUC6.charAt(i));
        }

        boolean isPalUC6 = true;
        while (!stackUC6.isEmpty()) {
            if (!stackUC6.pop().equals(queueUC6.remove())) {
                isPalUC6 = false;
                break;
            }
        }
        System.out.println("UC6: Queue+Stack Result match: " + isPalUC6);

        // UC7: Deque-Based Optimized Palindrome Checker
        String inputUC7 = "madam";
        Deque<Character> deque = new ArrayDeque<>();


        for (int i = 0; i < inputUC7.length(); i++) {
            deque.addLast(inputUC7.charAt(i));
        }

        boolean isPalUC7 = true;

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                isPalUC7 = false;
                break;
            }
        }
        System.out.println("UC7: Deque (Front & Rear) Result: " + isPalUC7);

    }
}