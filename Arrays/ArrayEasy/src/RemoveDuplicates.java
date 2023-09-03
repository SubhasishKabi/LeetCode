import java.util.Arrays;

class SolutionA {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;

        int i = 0;
        for(int j = 1; j < nums.length; j++) {
            if(nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}

public class RemoveDuplicates {
    public static void main(String[] args) {
        SolutionA solution = new SolutionA();

        int[] nums = {1, 1, 2, 2, 2, 3, 4, 4, 5, 5, 5};
        System.out.println(Arrays.toString(nums));
        int newLength = solution.removeDuplicates(nums);

        System.out.println("New length: " + newLength);
        System.out.print("Updated array: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println('\n');
        System.out.println(Arrays.toString(nums));
    }
}
