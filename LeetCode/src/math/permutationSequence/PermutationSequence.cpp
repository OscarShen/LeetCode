#include <vector>	
#include <string>
using namespace std;

class Solution {
public:
	string getPermutation(int n, int k) {
		int sum[10]{ 1 };
		vector<bool> isUsed(10, false);
		string res;
		for (int i = 1; i < 10; ++i)
			sum[i] = sum[i - 1] * i;
		for (int i = n - 1; i >= 0; --i) {
			if (k >= sum[i]) {
				int temp = k / sum[i] + 1;
				int j = 1;
				while (true) {
					if (!isUsed[j])
						++j;
					if (j == temp)
						break;
				}
				res.push_back(j + '0');
				isUsed[j] = true;
				k %= sum[i];
			}
			else {
				int j = 1;
				while (isUsed[j])
					++j;
				res.push_back(j + '0');
				isUsed[j] = true;
			}
		}
		return res;
	}
};