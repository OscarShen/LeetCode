#include <vector>	
using namespace std;

vector<int> plusOne(vector<int>& digits) {
	int n = digits.size(), carry = 1;
	for (int i = n - 1; i >= 0; i--) {
		++digits[i];
		carry = digits[i] / 10;
		if (carry)
			digits[i] = 0;
		else
			return digits;
	}
	vector<int> res;
	res.push_back(1);
	for (int t : digits)
		res.push_back(t);
	return res;
}