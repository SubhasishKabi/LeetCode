class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListLoop {
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            // If the two pointers meet, there is a loop.
            if (slowPointer == fastPointer) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test the hasCycle function here
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        // Create a cycle in the linked list (4 -> 2)
        node4.next = node2;

        boolean hasCycleResult = hasCycle(node1);
        System.out.println("Has Cycle: " + hasCycleResult); // Output should be true
    }
}
