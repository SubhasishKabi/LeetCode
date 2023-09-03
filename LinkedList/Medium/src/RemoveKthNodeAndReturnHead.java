class RemoveKthNodeAndReturnHead {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null || n < 0) return null;

            ListNode slowPointer = head;
            ListNode fastPointer = head;

            for (int i = 0; i < n; i++) {
                if (fastPointer == null) {
                    return head;
                }
                fastPointer = fastPointer.next;
            }

            if (fastPointer == null) {
                head = head.next;
                return head;
            }

            ListNode prev = null;

            while (fastPointer != null) {
                prev = slowPointer;
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next;
            }

            prev.next = slowPointer.next;
            return head;
        }
    }

    public static void main(String[] args) {
        // Create a sample linked list
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int k = 2;

        Solution solution = new Solution();
        ListNode result = solution.removeNthFromEnd(head, k);

        // Print the modified linked list
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
        System.out.println("null");
    }
}
