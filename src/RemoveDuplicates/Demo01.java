package removeDuplicates;

public class Demo01 {
	public static void main(String[] args) {
		int[] nums = { 1, 1, 2, 2, 3, 4, 5 };
		System.out.println(removeDuplicates(nums));
		;
	}

	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				continue;
			} else {
				nums[count] = nums[i];
				count++;
			}
		}
		return count;
	}
}
