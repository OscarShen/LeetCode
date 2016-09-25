package array.combinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> res = new ArrayList<>();
		getSum(candidates, target, 0, new ArrayList<>(), res);
		return res;
	}

	private void getSum(int[] candidates, int target, int pos, List<Integer> temp, List<List<Integer>> res) {
		if (target == 0) {
			res.add(new ArrayList<Integer>(temp));
			return;
		}

		if (target < 0)
			return;

		int prev = -1;
		for (int i = pos; i < candidates.length; ++i) {
			if (prev != candidates[i]) {
				temp.add(candidates[i]);
				getSum(candidates, target - candidates[i], i + 1, temp, res);
				temp.remove(temp.size() - 1);
				prev = candidates[i];
			}
		}
	}
}
