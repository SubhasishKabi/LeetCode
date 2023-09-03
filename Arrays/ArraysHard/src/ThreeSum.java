import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Removes the index out of bounds of the current window
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // If the current index element is greater, remove the previous index element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);

            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }

        return result;
    }
}

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        int[] result1 = solution.maxSlidingWindow(nums1, k1);
        System.out.println("Max sliding window for nums1: " + Arrays.toString(result1)); // Output should be [3,3,5,5,6,7]

        // Test case 2
        int[] nums2 = {9, 10, 9, -7, -4, -8, 2, -6};
        int k2 = 5;
        int[] result2 = solution.maxSlidingWindow(nums2, k2);
        System.out.println("Max sliding window for nums2: " + Arrays.toString(result2)); // Output should be [10, 10, 9, 2]

        // Test case 3
        int[] nums3 = {1, 2, 3, 4, 5};
        int k3 = 2;
        int[] result3 = solution.maxSlidingWindow(nums3, k3);
        System.out.println("Max sliding window for nums3: " + Arrays.toString(result3)); // Output should be [2, 3, 4, 5]

        // Test case 4
        int[] nums4 = {5, 4, 3, 2, 1};
        int k4 = 3;
        int[] result4 = solution.maxSlidingWindow(nums4, k4);
        System.out.println("Max sliding window for nums4: " + Arrays.toString(result4)); // Output should be [5, 4, 3]

        // Test case 5: Empty array
        int[] nums5 = {};
        int k5 = 2;
        int[] result5 = solution.maxSlidingWindow(nums5, k5);
        System.out.println("Max sliding window for nums5: " + Arrays.toString(result5)); // Output should be []

        // Test case 6: Negative numbers
        int[] nums6 = {-3, -1, -5, -7, -4, -2};
        int k6 = 4;
        int[] result6 = solution.maxSlidingWindow(nums6, k6);
        System.out.println("Max sliding window for nums6: " + Arrays.toString(result6)); // Output should be [-1, -1, -2]
    }
}
