#include <vector>
using namespace std;

void backTrace(vector<vector<int>>& res, const vector<int>& nums, vector<int>& v, int k) {
	if (k > nums.size())
		return;
	for (int i = k; i < nums.size(); ++i) {
		v.push_back(nums[i]);
		res.push_back(v);
		backTrace(res, nums, v, i + 1);
		v.pop_back();
	}
}

vector<vector<int>> subsets(vector<int>& nums) {
	vector<vector<int>> res;
	vector<int> v;
	res.push_back(v);
	backTrace(res, nums, v, 0);
	return res;
}