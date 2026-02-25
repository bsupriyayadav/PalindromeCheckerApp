import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Deque;
import java.util.ArrayDeque;

// Node class for UC8: Singly Linked List
class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        // --- UC1: Application Entry & Welcome Message ---
        String appName = "PalindromeChecker App";
        String version = "1.0.0";

        System.out.println("-------------------------------------------");
        System.out.println("Welcome to the " + appName);
        System.out.println("Version: " + version);
        System.out.println("-------------------------------------------");

        // --- UC2: Print a Hardcoded Palindrome Result ---
        String inputUC2 = "madam";
        if (inputUC2.equals("madam")) {
            System.out.println("UC2: " + inputUC2 + " is a palindrome.");
        } else {
            System.out.println("UC2: " + inputUC2 + " is not a palindrome.");
        }

        // --- UC3: Palindrome Check Using String Reverse ---
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

        // --- UC4: Character Array Based Palindrome Check (Two-Pointer Technique) ---
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

        // --- UC5: Stack-Based Palindrome Checker ---
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

        // --- UC6: Queue + Stack Based Palindrome Check ---
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

        // --- UC7: Deque-Based Optimized Palindrome Checker ---
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

        // --- UC8: Linked List Based Palindrome Checker ---
        String inputUC8 = "racecar";

        Node head = null;
        Node tail = null;
        for (char c : inputUC8.toCharArray()) {
            Node newNode = new Node(c);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null;
        Node current = slow;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        Node firstHalf = head;
        Node secondHalf = prev;
        boolean isPalUC8 = true;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                isPalUC8 = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        System.out.println("UC8: Singly Linked List (In-place Reversal) Result: " + isPalUC8);
        System.out.println("-------------------------------------------");

        // --- UC9: Recursive Palindrome Checker ---
        String inputUC9 = "racecar";
        boolean isPalUC9 = checkRecursive(inputUC9, 0, inputUC9.length() - 1);
        System.out.println("UC9: Recursive Result for " + inputUC9 + ": " + isPalUC9);

        System.out.println("-------------------------------------------");
    }

    public static boolean checkRecursive(String str, int s, int e) {

        if (s >= e) {
            return true;
        }

        if (str.charAt(s) != str.charAt(e)) {
            return false;
        }

        return checkRecursive(str, s + 1, e - 1);
    }
}