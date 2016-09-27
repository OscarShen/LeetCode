package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) {
			res.add(new ArrayList<>());
			return res;
		}
		int n = nums.length;
		int count = 1;
		for (int i = 1; i <= n; i++) {
			count *= i;
		}
		for (int i = 0; i < count; ++i) {
			List<Integer> temp = new ArrayList<>();
			for (int j = 0; j < n; ++j) {
				temp.add(nums[j]);
			}
			res.add(temp);
			getNext(nums);
		}
		return res;
	}

	//获取字典下一个排列
	private void getNext(int[] nums) {
		int n = nums.length;
		int cur1 = n - 1, cur2 = n - 1;
		while (cur1 > 0 && nums[cur1] < nums[cur1 - 1])
			--cur1;
		if (cur1 == 0) {
			reverse(nums, 0, n - 1);
			return;
		}
		while (cur1 != cur2 && nums[cur2] < nums[cur1 - 1])
			--cur2;
		int temp = nums[cur1 - 1];
		nums[cur1 - 1] = nums[cur2];
		nums[cur2] = temp;
		reverse(nums, cur1, n - 1);
	}

	private void reverse(int[] nums, int left, int right) {
		int count = (right - left + 1) / 2;
		for (int i = 0; i < count; ++i) {
			int temp = nums[left + i];
			nums[left + i] = nums[right - i];
			nums[right - i] = temp;
		}
	}
}
