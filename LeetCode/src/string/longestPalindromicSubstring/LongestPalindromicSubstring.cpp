#include <string>
using namespace std;

string longestPalindrome(string s) {
	int maxLength = 0, startPos = 0;
	int n = s.size();

	//�ӵ�һ��Ԫ�ؿ�ʼ����
	for (int i = 0; i < n; ++i) {
		int left = i, right = i, tempLength = 0;
		//��s[i]Ϊ����Ԫ��
		while (left - 1 >= 0 && right + 1 < n && s[left - 1] == s[right + 1]) {
			--left;
			++right;
		}
		tempLength = right - left + 1;
		if (tempLength > maxLength) {
			maxLength = tempLength;
			startPos = left;
		}

		//��s[i]��s[i+1]Ϊ����
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