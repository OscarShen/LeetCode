#include <string>
#include <stack>
#include <vector>
#include <sstream>
using namespace std;

// too cumbersome
string simplifyPath(string path) {
	stack<string> stack;
	int begin = 0, length = 0;
	for (size_t i = 0; i < path.size(); ++i) {
		if (path[i] == '/') {
			if (length > 0) {
				stack.push(path.substr(begin, length));
			}
			begin = i + 1;
			length = 0;
		}
		else
			++length;
	}
	if (length > 0) {
		stack.push(path.substr(begin, length));
	}
	vector<string> v;
	int popNum = 0;
	while (!stack.empty()) {
		if (stack.top() == ".")
			stack.pop();
		else if (stack.top() == "..") {
			++popNum;
			stack.pop();
			while (!stack.empty() && popNum > 0 && stack.top() != "..") {
				if (stack.top() == ".") {
					stack.pop();
				}
				else {
					stack.pop();
					--popNum;
				}
			}
			if (stack.empty())
				popNum = 0;
		}
		else {
			v.push_back(stack.top());
			stack.pop();
		}
	}
	if (v.size() == 0)
		return "/";
	string res;
	for (auto it = v.crbegin(); it != v.crend(); ++it) {
		res += "/" + *it;
	}
	return res;
}

string simplifyPath1(string path) {
	string res, tmp;
	vector<string> stk;
	stringstream ss(path);
	while (getline(ss, tmp, '/')) {
		if (tmp == "" || tmp == ".") continue;
		if (tmp == ".." && !stk.empty()) stk.pop_back();
		else if (tmp != "..") stk.push_back(tmp);
	}
	for (auto str : stk) res += "/" + str;
	return res.empty() ? "/" : res;
}