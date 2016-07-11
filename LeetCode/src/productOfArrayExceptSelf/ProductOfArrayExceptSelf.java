package productOfArrayExceptSelf;

public class ProductOfArrayExceptSelf {
	/**
	 * ��nums�ֳ���������
	 * 
	 * @param nums
	 * @return
	 */
	public int[] productExceptSelf(int[] nums) {
		int l = nums.length;
		int[] output = new int[l];
		output[0] = 1;
		for (int i = 1; i < l; i++) {
			output[i] = output[i - 1] * nums[i - 1];// �洢�����ĳ˻������Ժ�Ҫ�ã��ȴ���������
		}
		int rp = 1;// �����洢�ұ���ĳ˻���һ�ξͿ����滻 rightProduct
		for (int i = l - 1; i >= 0; i--) {
			output[i] *= rp;
			rp *= nums[i];// �õ�һ�Σ��滻����һ��
		}
		return output;
	}
}
