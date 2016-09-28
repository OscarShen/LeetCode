#include <vector>
#include <algorithm>

using namespace std;

void reverse(vector<int>& nums, int left, int right)
{
	int count = (right - left + 1) / 2;
	for (int i = 0; i < count; ++i)
		swap(nums[left + i], nums[right - i]);
}

bool getNext(vector<int>& nums)
{
	int n = nums.size(), cur1 = n - 1, cur2 = n - 1;
	while (cur1 != 0 && nums[cur1] <= nums[cur1 - 1])
		--cur1;
	if (cur1 == 0) {
		reverse(nums, 0, n - 1);
		return false;
	}
	while (cur1 != cur2&&nums[cur2] <= nums[cur1 - 1])
		--cur2;
	swap(nums[cur1 - 1], nums[cur2]);
	reverse(nums, cur1, n - 1);
	return true;
}

vector<vector<int>> permuteUnique(vector<int>& nums)
{
	vector<vector<int>> res;
	int n = nums.size();
	if (n == 0)
		return res;
	sort(nums.begin(), nums.end());
	while (true) {
		res.push_back(nums);
		if (!getNext(nums))
			return res;
	}
}