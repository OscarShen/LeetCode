#include <vector>
using namespace std;

// use theorem
vector<int> grayCode(int n) {
	vector<int> res;
	for (int i = 0; i < 1 << n; ++i)
		res.push_back(i ^ i >> 1);
	return res;
}

// do not use theorem
vector<int> grayCode2(int n) {
	if (n == 0)
		return vector<int>{0};
	vector<int> &&res = grayCode2(n - 1);
	for (int i = res.size() - 1; i >= 0; --i) {
		int cur = res[i] + (1 << (n - 1));
		res.push_back(cur);
	}
	return res;
}