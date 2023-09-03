public class MiddleNode {
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

    // Solution class (you can include this class here or keep it in a separate file)
    public static class Solution {
        public ListNode middleNode(ListNode head) {
            if (head == null) {
                return null;
            }

            ListNode slowPointer = head;
            ListNode fastPointer = head;

            while (fastPointer != null && fastPointer.next != null) {
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next.next;
            }
            return slowPointer;
        }
    }

    public static void main(String[] args) {
        // Test case 1: List with odd number of nodes
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        Solution solution = new Solution();
        ListNode middleNode1 = solution.middleNode(list1);
        System.out.println("Middle node of list1: " + middleNode1.val); // Output should be 3

        // Test case 2: List with even number of nodes
        ListNode list2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode middleNode2 = solution.middleNode(list2);
        System.out.println("Middle node of list2: " + middleNode2.val); // Output should be 3

        // Test case 3: Empty list
        ListNode list3 = null;
        ListNode middleNode3 = solution.middleNode(list3);
        System.out.println("Middle node of list3: " + (middleNode3 != null ? middleNode3.val : "null")); // Output should be null
    }
}
