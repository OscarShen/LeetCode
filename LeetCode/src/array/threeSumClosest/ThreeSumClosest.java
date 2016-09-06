package array.threeSumClosest;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int n = nums.length;
		int res = 0;
		int closest = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int j = i + 1, k = n - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum > target) {
					if (sum - target < closest) {
						res = sum;
						closest = sum - target;
					}
					k--;
				} else if (sum < target) {
					if (target - sum < closest) {
						res = sum;
						closest = target - sum;
					}
					j++;
				} else
					return sum;
			}
		}
		return res;
	}
}
