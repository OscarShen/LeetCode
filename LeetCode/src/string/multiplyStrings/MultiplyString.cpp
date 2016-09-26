#include <string>
#include <vector>
#include <iostream>
using namespace std;

string multiply(string num1, string num2) {
	if (num1 == "0" || num2 == "0")
		return "0";
	int n1 = num1.size(), n2 = num2.size(), product, carry, i, j;
	vector<int> res(n1+n2);
	for (i = n1 - 1; i >= 0; --i) {
		carry = 0;
		for (j = n2 - 1; j >= 0; --j) {
			product = carry + (int)(num1[i] - '0')*(int)(num2[j] - '0') + res[i + j + 1];
			carry = product / 10;
			res[i + j + 1] = product % 10;
		}
		res[i + j + 1] = carry;
	}

	int cur = 0;
	while (cur < n1 + n2&&res[cur] == 0)
		++cur;
	string str;
	while (cur < n1 + n2) {
		str.push_back(res[cur] + '0');
		++cur;
	}
	return str;
}