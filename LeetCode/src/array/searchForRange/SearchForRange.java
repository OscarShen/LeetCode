package array.searchForRange;

public class SearchForRange {
	public int[] searchRange(int[] nums, int target) {
		int[] res = { -1, -1 };
		if (nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length - 1])
			return res;
		int n = nums.length;
		int pivot = binarySearch(nums, target, 0, n - 1);
		if (pivot == -1)
			return res;
		int left = pivot, right = pivot;
		while (left >= 0) {
			if (nums[left] != target)
				break;
			left--;
		}
		while (right < n) {
			if (nums[right] != target)
				break;
			right++;
		}
		res[0] = left + 1;
		res[1] = right - 1;
		return res;
	}

	private int binarySearch(int[] nums, int target, int left, int right) {
		if (left > right)
			return -1;
		int mid = (left + right) / 2;
		if (target == nums[mid])
			return mid;
		else if (target > nums[mid])
			return binarySearch(nums, target, mid + 1, right);
		else
			return binarySearch(nums, target, left, mid - 1);
	}

	@SuppressWarnings("unused")
	private int binarySearch2(int[] nums, int target, int left, int right) {
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] < target)
				left = mid + 1;
			else if (nums[mid] > target)
				right = mid - 1;
			else if (nums[mid] == target)
				return mid;
		}
		return -1;
	}
}
