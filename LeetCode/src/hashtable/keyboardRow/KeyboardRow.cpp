class Solution {
public:
	vector<string> findWords(vector<string>& words) {
		std::unordered_set <char> row1 = { 'q','w','e','r','t','y','u','i','o','p' };
		std::unordered_set <char> row2 = { 'a','s','d','f','g','h','j','k','l' };
		std::unordered_set <char> row3 = { 'z','x','c','v','b','n','m' };
		std::vector<std::string> res;
		for (std::string &str : words) {
			bool inRow1 = true, inRow2 = true, inRow3 = true;
			for (char &c : str) {
				if (inRow1) {
					if (row1.find(tolower(c)) == row1.end())
						inRow1 = false;
				}
				if (inRow2) {
					if (row2.find(tolower(c)) == row2.end())
						inRow2 = false;
				}
				if (inRow3) {
					if (row3.find(tolower(c)) == row3.end())
						inRow3 = false;
				}
			}
			if (inRow1 || inRow2 || inRow3)
				res.push_back(str);
		}
		return res;
	}
};