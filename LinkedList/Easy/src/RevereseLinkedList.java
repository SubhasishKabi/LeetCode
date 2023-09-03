public class RevereseLinkedList {
    // Definition for singly-linked list
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode temp = head;
            ListNode prev = null;
            ListNode after;
            while (temp != null) {
                after = temp.next;
                temp.next = prev;
                prev = temp;
                temp = after;
            }
            return prev;
        }
    }

    public static void main(String[] args) {
        // Test case 1: Reverse a list with multiple nodes
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        Solution solution = new Solution();
        ListNode reversedList1 = solution.reverseList(list1);
        printList(reversedList1); // Output should be: 5 -> 4 -> 3 -> 2 -> 1

        // Test case 2: Reverse an empty list
        ListNode list2 = null;
        ListNode reversedList2 = solution.reverseList(list2);
        printList(reversedList2); // Output should be: null

        // Test case 3: Reverse a list with a single node
        ListNode list3 = new ListNode(42);
        ListNode reversedList3 = solution.reverseList(list3);
        printList(reversedList3); // Output should be: 42
    }

    // Helper function to print the reversed list
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
