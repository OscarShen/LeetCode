
#include <vector>
using namespace std;

int removeDuplicates(vector<int>& nums) {
	if (nums.size() <= 2)
		return nums.size();
	vector<int> v;
	v.push_back(nums[0]);
	auto it = nums.cbegin() + 1;
	int count = 1, res = 1;
	while (it != nums.cend()) {
		if (*it == *(it - 1)) {
			if (count == 2) {
				;
			}
			else {
				count = 2;
				++res;
				v.push_back(*it);
			}
		}
		else {
			count = 1;
			++res;
			v.push_back(*it);
		}
		++it;
	}
	nums = v;
	return res;
}

int removeDuplicates2(vector<int>& nums) {
	int i = 0;
	for (int n : nums)
		if (i < 2 || n > nums[i - 2])
			nums[i++] = n;
	return i;
}