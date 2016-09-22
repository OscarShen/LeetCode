package array.removeElement;

import org.junit.Test;

public class RemoveElement {
	public int removeElement(int[] nums, int val) {
		if (nums == null || nums.length == 0 || (nums.length == 1 && nums[0] == val))
			return 0;
		int cur1 = 0, cur2 = nums.length - 1;
		while (cur1 < cur2) {
			while (nums[cur2] == val) {
				cur2--;
				if (cur2 == -1)
					return 0;
			}
			if (cur1 < cur2 && nums[cur1] == val) {
				nums[cur1] = nums[cur2];
				nums[cur2--] = val;
			}
			++cur1;
		}
		while (nums[cur2] == val) {
			cur2--;
			if (cur2 == -1)
				return 0;
		}
		return cur2 + 1;
	}

	@Test
	public void test() {
		int[] nums = { 2, 4, 4, 4, 0 };
		int val = 4;
		int res = removeElement(nums, val);
		System.out.println(res);
	}
}
