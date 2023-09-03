import java.util.HashMap;
import java.util.Map;

class SolutionD {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }


        throw new IllegalArgumentException("No solution found");
    }

    public static void main(String[] args) {
        SolutionD solution = new SolutionD();
        int[] nums = {2,7, 11,7,7, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);

        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}
