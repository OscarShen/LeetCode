#include <vector>
using std::vector;

int binary_search(vector<int>& nums, int target, int left, int right);
vector<int> search_range(vector<int>& nums, int target) {
	vector<int> res{ -1,-1 };
	int n = nums.size();
	if (n == 0 || nums[0] > target || nums[n - 1] < target)
		return res;
	int pivot = binary_search(nums, target, 0, n - 1);
	if (pivot == -1)
		return res;
	int left = pivot, right = pivot;
	while (left>=0)
	{
		if (nums[left] != target)
			break;
		--left;
	}
	while (right<n)
	{
		if (nums[right] != target)
			break;
		++right;
	}
	res[0] = left + 1;
	res[1] = right - 1;
	return res;
}

int binary_search(vector<int>& nums, int target, int left, int right) {
	if (left > right)
		return -1;
	int mid = (left + right) / 2;
	if (target == nums[mid])
		return mid;
	else if (target > nums[mid])
		return binary_search(nums, target, mid + 1, right);
	else
		return binary_search(nums, target, left, mid - 1);
}