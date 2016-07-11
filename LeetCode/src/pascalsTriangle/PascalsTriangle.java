package pascalsTriangle;

import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
	public List<Integer> getRow(int rowIndex) {
		//rowIndex小于零时
		if (rowIndex < 0) {
			return null;
		}
		//初始化。因Array.asList()方法不能使用基本数据类型，故使用包装类 。
		Integer[] nums = new Integer[rowIndex + 1];
		Integer[] temp = new Integer[rowIndex + 1];
		nums[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			nums[i] = 0;
		}
		
		//遍历，将第i+1层的数据存于temp中，i+1层的数据全部计算完毕，再将temp的数据复制到nums中。
		for (int i = 1; i < rowIndex + 1; i++) {
			temp[0] = nums[0];
			for (int j = 1; j <= i; j++) {
				temp[j] = nums[j - 1] + nums[j];
			}
			System.arraycopy(temp, 0, nums, 0, i + 1);
		}
		//Array.asList()方法不能使用基本数据类型。
		return Arrays.asList(nums);
	}
}
