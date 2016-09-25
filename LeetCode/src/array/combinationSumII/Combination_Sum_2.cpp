#include <vector>	
#include <iostream>
#include <algorithm>

using namespace std;

//递归体
void getSum(vector<int>& candidates, int target, int pos, vector<int>& temp, vector<vector<int>>& res) {
	if (target < 0)
		return;
	if (target == 0) {
		res.push_back(vector<int>(temp));
		return;
	}
	int prev = -1;
	//DFS（也是俗称暴力解法）
	for (int i = pos; i < candidates.size(); ++i) {
		if (prev != candidates[i]) {
			temp.push_back(candidates[i]);
			getSum(candidates, target - candidates[i], i + 1, temp, res);
			temp.pop_back();
			prev = candidates[i];
		}
	}
}

vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
	sort(candidates.begin(), candidates.end());
	vector<vector<int>> res;
	getSum(candidates, target, 0, vector<int>(), res);
	return res;
}