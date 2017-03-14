class Solution {
public:
int findMaxConsecutiveOnes(vector<int>& nums) {
	int res = 0;
	int currentMax = 0;
	int n = nums.size();
	for (int i = 0; i<n; ++i) {
		if (nums[i]) {
			++currentMax;
		}
		else {
			res = currentMax > res ? currentMax : res;
			currentMax = 0;
		}
	}
	res = currentMax > res ? currentMax : res;
	return res;
}

};