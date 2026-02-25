import java.util.*;

// Node class for UC8: Singly Linked List
class Node {
    char data;
    Node next;
    Node(char data) { this.data = data; this.next = null; }
}

// --- UC11, UC12, & UC13 Strategy Pattern Components ---

// Strategy Interface
interface PalindromeStrategy {
    boolean check(String str);
}

// Concrete Strategy: Stack-Based
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) stack.push(c);
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) reversed.append(stack.pop());
        return str.equals(reversed.toString());
    }
}

// Concrete Strategy: Deque-Based
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String str) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : str.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }
}

// Context Class
class PalindromeContext {
    private PalindromeStrategy strategy;
    public void setStrategy(PalindromeStrategy strategy) { this.strategy = strategy; }
    public boolean executeStrategy(String str) { return strategy.check(str); }
}

// Service Class
class PalindromeService {
    public boolean checkPalindrome(String str) {
        if (str == null) return false;
        String clean = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int l = 0, r = clean.length() - 1;
        while (l < r) {
            if (clean.charAt(l++) != clean.charAt(r--)) return false;
        }
        return true;
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        // UC1: Application Entry
        System.out.println("-------------------------------------------");
        System.out.println("Welcome to the PalindromeChecker App");
        System.out.println("Version: 1.0.0");
        System.out.println("-------------------------------------------");

        // UC2 - UC7: Basic and Collection-based checks
        String in2 = "madam";
        System.out.println("UC2: Hardcoded result: " + in2.equals("madam"));

        String in3 = "madam", rev3 = "";
        for (int i = in3.length() - 1; i >= 0; i--) rev3 += in3.charAt(i);
        System.out.println("UC3: String Reverse Result: " + in3.equals(rev3));

        String in4 = "racecar";
        char[] arr4 = in4.toCharArray();
        int s4 = 0, e4 = arr4.length - 1;
        boolean is4 = true;
        while (s4 < e4) { if (arr4[s4++] != arr4[e4--]) { is4 = false; break; } }
        System.out.println("UC4: Two-Pointer Result: " + is4);

        // UC8: Linked List (Fast/Slow Pointer)

        String in8 = "racecar";
        Node head = null, tail = null;
        for (char c : in8.toCharArray()) {
            Node n = new Node(c);
            if (head == null) { head = n; tail = n; } else { tail.next = n; tail = n; }
        }
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) { slow = slow.next; fast = fast.next.next; }
        Node prev = null, curr = slow;
        while (curr != null) { Node next = curr.next; curr.next = prev; prev = curr; curr = next; }
        Node f = head, s = prev;
        boolean is8 = true;
        while (s != null) { if (f.data != s.data) { is8 = false; break; } f = f.next; s = s.next; }
        System.out.println("UC8: Linked List Result: " + is8);

        // UC9 & UC10: Recursive and Normalized
        String in9 = "racecar";
        System.out.println("UC9: Recursive Result: " + checkRecursive(in9, 0, in9.length() - 1));

        String in10 = "A man a plan a canal Panama";
        String clean10 = in10.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println("UC10: Normalized Result: " + checkRecursive(clean10, 0, clean10.length() - 1));

        // UC11 & UC12: OOP and Strategy
        PalindromeService service = new PalindromeService();
        System.out.println("UC11: OOP Service Result: " + service.checkPalindrome("Step on no pets"));

        PalindromeContext ctx = new PalindromeContext();
        ctx.setStrategy(new DequeStrategy());
        System.out.println("UC12: Strategy Pattern (Deque) Result: " + ctx.executeStrategy("radar"));

        // --- UC13: Performance Comparison ---
        System.out.println("\n--- UC13: Performance Comparison ---");
        String testInput = "redivider"; // 9 characters

        // Measure Stack Strategy
        long startTime = System.nanoTime();
        ctx.setStrategy(new StackStrategy());
        ctx.executeStrategy(testInput);
        long endTime = System.nanoTime();
        System.out.println("Stack Strategy Time: " + (endTime - startTime) + " ns");

        // Measure Deque Strategy
        startTime = System.nanoTime();
        ctx.setStrategy(new DequeStrategy());
        ctx.executeStrategy(testInput);
        endTime = System.nanoTime();
        System.out.println("Deque Strategy Time: " + (endTime - startTime) + " ns");

        // Measure Recursive Method
        startTime = System.nanoTime();
        checkRecursive(testInput, 0, testInput.length() - 1);
        endTime = System.nanoTime();
        System.out.println("Recursive Method Time: " + (endTime - startTime) + " ns");

        System.out.println("-------------------------------------------");
    }

    // Helper for Recursive calls
    public static boolean checkRecursive(String str, int s, int e) {
        if (s >= e) return true;
        if (str.charAt(s) != str.charAt(e)) return false;
        return checkRecursive(str, s + 1, e - 1);
    }
}