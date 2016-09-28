#include <vector>
#include <iostream>
using namespace std;

void reverse(vector<int>& nums, int left, int right)
{
	int count = (right - left + 1) / 2;
	for (int i = 0; i < count; ++i)
		swap(nums[left + i], nums[right - i]);
}

void getNext(vector<int>& nums)
{
	int n = nums.size(), cur1 = n - 1, cur2 = n - 1;
	while (cur1 != 0 && nums[cur1] < nums[cur1 - 1])
		--cur1;
	if (cur1 == 0) {
		reverse(nums, 0, n - 1);
		return;
	}
	while (cur1 != cur2&&nums[cur2] < nums[cur1 - 1])
		--cur2;
	swap(nums[cur1 - 1], nums[cur2]);
	reverse(nums,cur1,n-1);
}

vector<vector<int>> permute(vector<int>& nums)
{
	vector<vector<int>> res;
	int n = nums.size();
	if (n == 0)
		return res;
	int count = 1;
	for (int i = 1; i <= n; ++i)
		count *= i;
	for (int i = 0; i < count; ++i) {
		vector<int> temp = nums;
		res.push_back(temp);
		getNext(nums);
	}
	return res;
}
