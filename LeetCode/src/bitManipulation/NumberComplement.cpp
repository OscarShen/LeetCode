class Solution {
public:
    int findComplement(int num) {
    	int res = 0, cursor = 0, temp = num;
    	while (temp != 0) {
    		++cursor;
    		temp >>= 1;
    	}
    	for (int i = 0; i<cursor; ++i) {
    		if (!(num & 0x00000001)) {
    			res += (1 << i);
    		}
    		num >>= 1;
    	}
    	return res;
    }
};