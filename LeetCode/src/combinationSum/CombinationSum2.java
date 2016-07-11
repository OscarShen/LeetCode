package combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();// 结果
		List<Integer> temp = new ArrayList<>();
		Arrays.sort(candidates);// 先进行排序
		findComb(candidates, target, 0, 0, res, temp);
		return res;
	}

	private void findComb(int[] candidates, int taget, int level, int sum, List<List<Integer>> res,
			List<Integer> temp) {
		if (sum == taget) {
			res.add(new ArrayList<>(temp));
			return;
		} else if (sum > taget) {
			return;
		} else {
			for (int i = level; i < candidates.length; i++) {
				temp.add(candidates[i]);
				findComb(candidates, taget, i, sum + candidates[i], res, temp);
				temp.remove(temp.size() - 1);
			}
		}
	}
}
