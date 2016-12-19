#include <string>
#include <vector>
using namespace std;

string getPermutation(int n, int k) {
	vector<int> factorial;
	factorial.push_back(1);
	for (int i = 1; i <= n; ++i)
	{
		factorial.push_back(factorial.back()*i);
	}

	string res("");
	--k;
	vector<bool> sign(n + 1, false);
	for (int i = n; i > 0; --i)
	{
		int t = k / factorial[i - 1];
		if (t > 0)
		{
			int count = 0, j = 1;
			for (; j <= n; ++j)
			{
				if (!sign[j])
					if (++count == t + 1)
						break;
			}
			res.push_back(j + '0');
			sign[j] = true;
		}
		else
		{
			for (int j = 1; j <= n; ++j)
				if (!sign[j]) {
					res.push_back(j + '0');
					sign[j] = true;
					break;
				}
		}
		k %= factorial[i - 1];
	}
	return res;
}
