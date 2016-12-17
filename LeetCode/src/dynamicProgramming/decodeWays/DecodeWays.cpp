
#include <string>
#include <vector>
using namespace std;

int numDecodings(string s) {
	if (s.length() == 0 || s[0] == '0')
		return 0;
	else if (s.size() == 1)
		return 1;
	else if (s.size() == 2)
	{
		if (s[1] == '0' && s[0] - '0' >= 3)
			return 0;
		return s[1] == '0' ? 1 : ((s[0] - '0') * 10 + s[1] - '0' <= 26 ? 2 : 1);
	}
	vector<int> ways(s.size(), 0);
	ways[0] = 1;
	ways[1] = s[1] == '0' ? 1 : ((s[0] - '0') * 10 + s[1] - '0' <= 26 ? 2 : 1);

	for (size_t i = 2; i < s.size(); ++i)
	{
		if (s[i - 1] == '0' && s[i - 2] - '0' >= 3)
			return 0;
		if (s[i] != '0') {
			ways[i] += ways[i - 1];
		}
		if (s[i - 1] != '0' && (s[i-1] - '0') * 10 + s[i] - '0' <= 26) {
			ways[i] += ways[i - 2];
		}
	}
	return ways.back();
}

void main() {
	string s("17");
	auto res = numDecodings(s);
}