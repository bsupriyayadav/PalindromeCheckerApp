import java.util.*;

// Node class for UC8: Singly Linked List
class Node {
    char data;
    Node next;
    Node(char data) { this.data = data; this.next = null; }
}

// --- UC11 & UC12: Object-Oriented & Strategy Pattern Components ---

// Strategy Interface for UC12
interface PalindromeStrategy {
    boolean check(String str);
}

// Concrete Strategy 1: Stack-Based
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

// Concrete Strategy 2: Deque-Based
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

// Context Class for UC12
class PalindromeContext {
    private PalindromeStrategy strategy;
    public void setStrategy(PalindromeStrategy strategy) { this.strategy = strategy; }
    public boolean executeStrategy(String str) { return strategy.check(str); }
}

// Service Class for UC11
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

        // UC2: Hardcoded
        String in2 = "madam";
        System.out.println("UC2: Hardcoded '" + in2 + "' is palindrome: " + in2.equals("madam"));

        // UC3: String Reverse
        String in3 = "madam", rev3 = "";
        for (int i = in3.length() - 1; i >= 0; i--) rev3 += in3.charAt(i);
        System.out.println("UC3: Reverse match: " + in3.equals(rev3));

        // UC4: Two-Pointer (Array)
        String in4 = "racecar";
        char[] arr4 = in4.toCharArray();
        int s4 = 0, e4 = arr4.length - 1;
        boolean is4 = true;
        while (s4 < e4) { if (arr4[s4++] != arr4[e4--]) { is4 = false; break; } }
        System.out.println("UC4: Two-pointer Result: " + is4);

        // UC5: Stack-Based
        Stack<Character> st5 = new Stack<>();
        for (char c : "madam".toCharArray()) st5.push(c);
        String res5 = "";
        while (!st5.isEmpty()) res5 += st5.pop();
        System.out.println("UC5: Stack result match: " + "madam".equals(res5));

        // UC6: Queue + Stack
        String in6 = "madam";
        Stack<Character> st6 = new Stack<>();
        Queue<Character> q6 = new LinkedList<>();
        for (char c : in6.toCharArray()) { st6.push(c); q6.add(c); }
        boolean is6 = true;
        while (!st6.isEmpty()) { if (!st6.pop().equals(q6.remove())) { is6 = false; break; } }
        System.out.println("UC6: Queue+Stack match: " + is6);

        // UC7: Deque
        Deque<Character> dq7 = new ArrayDeque<>();
        for (char c : "madam".toCharArray()) dq7.addLast(c);
        boolean is7 = true;
        while (dq7.size() > 1) { if (!dq7.removeFirst().equals(dq7.removeLast())) { is7 = false; break; } }
        System.out.println("UC7: Deque result: " + is7);

        // UC8: Linked List (Fast/Slow Pointer & In-place Reversal)

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

        // UC9: Recursive
        String in9 = "racecar";
        System.out.println("UC9: Recursive Result: " + checkRecursive(in9, 0, in9.length() - 1));

        // UC10: Case & Space Ignored
        String in10 = "A man a plan a canal Panama";
        String clean10 = in10.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println("UC10: Normalized Result: " + checkRecursive(clean10, 0, clean10.length() - 1));

        // UC11: OOP Service
        PalindromeService service = new PalindromeService();
        System.out.println("UC11: OOP Service Result: " + service.checkPalindrome("Step on no pets"));

        // UC12: Strategy Pattern

        PalindromeContext ctx = new PalindromeContext();
        ctx.setStrategy(new DequeStrategy());
        System.out.println("UC12: Strategy Pattern (Deque) Result: " + ctx.executeStrategy("radar"));

        System.out.println("-------------------------------------------");
    }

    // Helper for Recursive calls
    public static boolean checkRecursive(String str, int s, int e) {
        if (s >= e) return true;
        if (str.charAt(s) != str.charAt(e)) return false;
        return checkRecursive(str, s + 1, e - 1);
    }
}