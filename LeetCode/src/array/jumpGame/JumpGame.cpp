#include <vector>
using namespace std;

bool canJump(vector<int>& nums) {
	int cur = 0,n=nums.size();
	while (true) {
		int len = cur + nums[cur];
		if (len >= n - 1)
			return true;
		if (nums[cur] == 0)
			return false;
		int i, max = INT_MIN, pos = cur+1;
		for (i = pos; i <= len; ++i) {
			if (i + nums[i] >= max) {
				max = i + nums[i];
				pos = i;
			}
		}
		cur = pos;
	}
	return false;
}