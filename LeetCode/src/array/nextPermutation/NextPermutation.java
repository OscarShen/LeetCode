package array.nextPermutation;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
		if (nums == null)
			return;
		int n = nums.length;
		if (n == 1)
			return;
		int i = 0;
		for (i = n - 1; i > 0; i--) {
			if (nums[i] > nums[i - 1])
				break;
		}
		if (i == 0) {
			for (int half = n / 2, k = 0; k < half; k++) {
				int temp = nums[k];
				nums[k] = nums[n - k - 1];
				nums[n - k - 1] = temp;
			}
			return;
		}

		int k;
		for (k = n - 1; k >= i; k--) {
			if (nums[k] <= nums[i - 1]) {
				continue;
			}
			int temp = nums[k];
			nums[k] = nums[i - 1];
			nums[i - 1] = temp;
			break;
		}
		
		for (int l = (n + i) / 2, cur = i; cur < l; cur++) {
			int temp = nums[cur];
			nums[cur] = nums[n - 1 - cur + i];
			nums[n - 1 - cur + i] = temp;
		}
	}
	public static void main(String[] args) {
		int[] nums = { 2, 3, 1 };
		new NextPermutation().nextPermutation(nums);
		for (int t : nums)
			System.out.print(t + " ");
	}
}
