package array.threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int j = i + 1, k = n - 1;
			while (j < k) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					j++;
					continue;
				}
				if (k < n - 1 && nums[k] == nums[k + 1]) {
					k--;
					continue;
				}

				int sum = nums[i] + nums[j] + nums[k];
				if (sum > 0)
					k--;
				else if (sum < 0)
					j++;
				else {
					List<Integer> temp = new ArrayList<>();
					temp.add(nums[i]);
					temp.add(nums[j]);
					temp.add(nums[k]);
					res.add(temp);
					j++;
				}
			}
		}
		return res;
	}
}
