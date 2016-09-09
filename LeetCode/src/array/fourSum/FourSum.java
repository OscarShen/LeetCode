package array.fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < nums.length - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			for (int j = i + 1; j < nums.length; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1])
					continue;
				int k = j + 1, l = nums.length - 1;
				while (k < l) {
					if (k > j + 1 && nums[k] == nums[k - 1]) {
						k++;
						continue;
					}
					if (l < nums.length - 1 && nums[l] == nums[l + 1]) {
						l--;
						continue;
					}
					int sum = nums[i] + nums[j] + nums[k] + nums[l];
					if (sum < target) {
						k++;
					} else if (sum > target) {
						l--;
					} else {
						List<Integer> tempList = new ArrayList<>();
						tempList.add(nums[i]);
						tempList.add(nums[j]);
						tempList.add(nums[k]);
						tempList.add(nums[l]);
						res.add(tempList);
						k++;
					}
				}
			}
		}
		return res;
	}
}
