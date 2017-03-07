class Solution {
public:
    string reverseString(string s) {
        size_t i = s.size();
        size_t half = i / 2;
        for(size_t j = 0; j<half; ++j){
            char c = s[j];
            s[j] = s[i - 1 - j];
            s[i - 1 - j] = c;
        }
        return s;
    }
};