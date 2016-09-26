#include <string>
using namespace std;

string longestPalindrome(string s) {
	int maxLength = 0, startPos = 0;
	int n = s.size();

	//从第一个元素开始遍历
	for (int i = 0; i < n; ++i) {
		int left = i, right = i, tempLength = 0;
		//此s[i]为中心元素
		while (left - 1 >= 0 && right + 1 < n && s[left - 1] == s[right + 1]) {
			--left;
			++right;
		}
		tempLength = right - left + 1;
		if (tempLength > maxLength) {
			maxLength = tempLength;
			startPos = left;
		}

		//以s[i]及s[i+1]为中心
		if (i + 1 >= n || s[i] != s[i + 1])
			continue;
		left = i, right = i + 1;
		while (left - 1 >= 0 && right + 1 < n && s[left - 1] == s[right + 1]) {
			--left;
			++right;
		}
		tempLength = right - left + 1;
		if (tempLength > maxLength) {
			maxLength = tempLength;
			startPos = left;
		}
	}
	return s.substr(startPos, maxLength);
}