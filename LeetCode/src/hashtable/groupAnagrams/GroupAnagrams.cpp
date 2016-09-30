#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
using namespace std;


vector<vector<string>> groupAnagrams(vector<string>& strs) {
	unordered_map<string, vector<string>> container;
	for (auto str : strs) {
		string s = str;
		sort(s.begin(),s.end());
		container[s].push_back(str);
	}
	vector<vector<string>> res;
	for (auto pair : container) {
		res.push_back(pair.second);
	}
	return res;
}