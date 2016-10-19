#include <vector>
using namespace std;


class Solution {
public:
	void sortColors(vector<int>& nums) {
		int cur = 1;
		while (cur < nums.size()) {
			int temp = cur;
			while (nums[temp] < nums[temp - 1] && temp > 0) {
				swapNums(nums[temp], nums[temp - 1]);
				--temp;
			}
			++cur;
		}
	}

	void swapNums(int& i, int& j) {
		int temp = std::move(i);
		i = std::move(j);
		j = std::move(temp);
	}
};