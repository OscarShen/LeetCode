class Solution {
public:
    int hammingDistance(int x, int y) {
    	int count = 0;
    	while (x != 0 || y != 0) {
    		if ((x & 0x00000001) != (y & 0x00000001))
    			++count;
    		x >>= 1;
    		y >>= 1;
    	}
    	return count;
    }
};