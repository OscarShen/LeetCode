
#include <string>
#include <stack>
#include <sstream>
using namespace std;

int str2num(const string &s) {
	int num;
	istringstream ss(s);
	ss >> num;
	return num;
}

string decodeString(string s) {
	stack<string> stack1;
	string ts;
	string tn;
	size_t i = 0;
	while (i < s.size()) {
		if (isdigit(s[i])) {
			while (i < s.size() && isdigit(s[i])) {
				tn += s[i];
				++i;
			}
			stack1.push(tn);
			tn.clear();
			continue;
		}
		else if (islower(s[i]) || isupper(s[i])) {
			while (i < s.size() && (islower(s[i]) || isupper(s[i]))) {
				ts += s[i];
				++i;
			}
			stack1.push(ts);
			ts.clear();
			continue;
		}
		else if (s[i] == '[') {
			++i;
		}
		else if (s[i] == ']') {
			ts = stack1.top();
			stack1.pop();
			tn = stack1.top();
			stack1.pop();
			string tmp;
			if (isdigit(tn[0])) {
				int count = str2num(tn);
				for (int i = 0; i < count; ++i)
					tmp += ts;
				++i; // 只有碰到数字才+
			}
			else
				tmp = tn + ts;

			stack1.push(tmp);
			ts.clear();
			tn.clear();
		}
	}
	stack<string> tempStack;
	while (!stack1.empty()) {
		tempStack.push(stack1.top());
		stack1.pop();
	}
	while (!tempStack.empty()) {
		ts += tempStack.top();
		tempStack.pop();
	}
	return ts;
}