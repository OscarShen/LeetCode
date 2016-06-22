package ProductOfArrayExceptSelf;

public class ProductOfArrayExceptSelf {
	/**
	 * 把nums分成两次来乘
	 * 
	 * @param nums
	 * @return
	 */
	public int[] productExceptSelf(int[] nums) {
		int l = nums.length;
		int[] output = new int[l];
		output[0] = 1;
		for (int i = 1; i < l; i++) {
			output[i] = output[i - 1] * nums[i - 1];// 存储左边数的乘积，由于以后还要用，先存在数组中
		}
		int rp = 1;// 用来存储右边数的乘积，用一次就可以替换 rightProduct
		for (int i = l - 1; i >= 0; i--) {
			output[i] *= rp;
			rp *= nums[i];// 用掉一次，替换成下一个
		}
		return output;
	}
}
