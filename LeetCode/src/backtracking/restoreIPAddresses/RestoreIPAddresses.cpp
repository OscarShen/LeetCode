#include <vector>
#include <string>
using namespace std;

bool isValid(string num) {
	int n = atoi(num.c_str());
	if (num.length() == 1)
		return n >= 0 && n <= 9;
	else if (num.length() == 2)
		return n >= 10 && n <= 99;
	else if (num.length() == 3)
		return n >= 100 && n <= 255;
	return false;
}

void generateIP(vector<string> &v, vector<string> &ip, string &s, int i, int k) {
	if (i == s.size()) {
		if (k == 5) {
			string ip_ = ip[0];
			for (int i = 1; i < 4; ++i) {
				ip_ += "." + ip[i];
			}
			v.push_back(ip_);
		}
		return;
	}
	for (int j = 1; j <= 3 && i + j - 1 < s.size(); ++j) {
		string num = s.substr(i, j);
		if (isValid(num)) {
			ip.push_back(num);
			generateIP(v, ip, s, i + j, k + 1);
			ip.pop_back();
		}
	}
}

vector<string> restoreIpAddresses(string s) {
	if (s.size() < 4 || s.size() > 12)
		return vector<string>();
	vector<string> ip;
	vector<string> v;
	generateIP(v, ip, s, 0, 1);
	return v;
}
