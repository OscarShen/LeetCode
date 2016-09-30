#include <vector>
using namespace std;

int maxSubArray(vector<int>& nums) {
	int n = nums.size(), temp = INT_MIN, max = INT_MIN;
	temp = nums[0];
	max = nums[0];
	for (int i = 1; i < n; ++i) {
		if (temp < 0)
			temp = 0;
		temp += nums[i];
		if (temp > max)
			max = temp;
	}
	return max;
}