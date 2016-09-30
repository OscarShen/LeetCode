#include <string>	
using namespace std;

int lengthOfLastWord(string s) {
	auto iter1 = s.rbegin(), iter2 = s.rend();
	int res = 0;
	while (iter1 != iter2 && (*iter1) != ' ')
		++iter1;
	while (iter1 != iter2 && (*iter1) != ' ') {
		++iter1;
		++res;
	}
	return res;
}