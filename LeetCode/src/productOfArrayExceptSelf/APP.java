package productOfArrayExceptSelf;

public class APP {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		int[] nums1 = { 1, 2, 3, 0 };
		ProductOfArrayExceptSelf poaes = new ProductOfArrayExceptSelf();
		for (int i : poaes.productExceptSelf(nums)) {
			System.out.print(i + "\t");
		}
		System.out.println();
		for (int i : poaes.productExceptSelf(nums1)) {
			System.out.print(i + "\t");
		}
	}
}
