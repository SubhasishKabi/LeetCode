import java.lang.reflect.Array;
import java.util.Arrays;

class SolutionB {
    public void moveZeroesToEnd(int[] nums) {
        int count = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]!= 0){
                nums[count] = nums[i];
                count++;
            }
        }
        for(int i = count; i< nums.length; i++){
            nums[i]=0;
        }
    }

    public static void main(String[] args) {
        int [] nums = {1,0,0,2,5,6};
        SolutionB a = new SolutionB();
        System.out.println(Arrays.toString(nums));
        a.moveZeroesToEnd(nums);
        System.out.println(Arrays.toString(nums));
    }
}