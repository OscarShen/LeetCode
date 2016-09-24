package array.searchInsertPosition;

public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
		if (nums == null || nums.length == 0 || nums[0] > target)
			return 0;
		int pos = findPosition(nums, target, 0, nums.length - 1);
		while (pos > 0 && target == nums[pos - 1]) {
			pos--;
		}
		if (pos == nums.length - 1)
			if (target > nums[pos])
				pos++;
		return pos;
	}

	private int findPosition(int[] nums, int target, int left, int right) {
		if (right - left <= 1)
			return right;
		int mid = (left + right) / 2;
		if (target > nums[mid])
			return findPosition(nums, target, mid, right);
		else
			return findPosition(nums, target, left, mid);
	}
}
