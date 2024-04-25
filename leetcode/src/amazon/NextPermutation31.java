package amazon;

import java.util.Arrays;

public class NextPermutation31 {
	
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }
        int upPoint = i - 1;
        if (upPoint >= 0) {
	        i = len - 1;
	        while (i > 0 && nums[i] <= nums[upPoint]) {
	            i--;
	        }
	        swap(nums, upPoint, i);
        }
        reverse(nums, upPoint + 1, len - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
	

	public static void main(String[] args) {
		int[] nums = new int[] {1,2};
		new NextPermutation31().nextPermutation(nums);
		System.out.println(Arrays.toString(nums));

	}

}
