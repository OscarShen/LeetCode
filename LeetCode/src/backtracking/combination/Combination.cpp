#include <vector>
#include <iostream>
using namespace std;

void backTracing(vector<vector<int>>& res, vector<int>& v, int n, int k) {
	int size = v.size();
	if (size == k) {
		res.push_back(v);
		return;
	}
	if (v[size - 1] == n)
		return;
	else {
		for (int i = v[size - 1] + 1; i <= n + size - k + 1; ++i) {
			v.push_back(i);
			backTracing(res, v, n, k);
			v.pop_back();
		}
	}
}

vector<vector<int>> combine(int n, int k) {
	vector<vector<int>> res;
	vector<int> v;
	for (int i = 1; i <= n - k + 1; ++i) {
		v.push_back(i);
		backTracing(res, v, n, k);
		v.pop_back();
	}
	return res;
}