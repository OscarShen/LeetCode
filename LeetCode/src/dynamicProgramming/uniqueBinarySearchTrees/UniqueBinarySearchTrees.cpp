#include <vector>

int numTrees(int n) {
	std::vector<int> v(n + 1, 0);
	v[1] = 1;
	v[0] = 1;
	for (int i = 2; i <= n; ++i) {
		int count = 0;
		for (int j = 1; j <= i; ++j) {
			count += v[j - 1] * v[i - j];
		}
		v[i] = count;
	}
	return v[n];
}