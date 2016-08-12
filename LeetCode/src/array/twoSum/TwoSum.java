package array.twoSum;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		int[] res = new int[2];
		if (nums == null) {
			return null;
		}
		int len = nums.length;
		if (len < 2) {
			return null;
		}
		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				if (nums[i] + nums[j] == target) {
					res[0] = i;
					res[1] = j;
					return res;
				}
			}
		}
		return res;
	}
}
