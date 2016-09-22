package _math.divideTwoIntegers;

public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		int nega = 0;
		int res = 0;
		int count = 0;
		if (dividend == Integer.MIN_VALUE) {
			if (divisor == -1)
				return Integer.MAX_VALUE;
			res = 1;
			dividend += Math.abs(divisor);
		}
		if (divisor == Integer.MIN_VALUE)
			return res;
		if (dividend < 0) {
			dividend = -dividend;
			nega++;
		}
		if (divisor < 0) {
			divisor = -divisor;
			nega++;
		}
		while (divisor <= (dividend >> 1)) {
			divisor <<= 1;
			count++;
		}
		while (count >= 0) {
			if (dividend >= divisor) {
				dividend -= divisor;
				res += 1 << count;
			}
			divisor >>= 1;
			count--;
		}
		if (nega == 1)
			return -res;
		else
			return res;
	}
}
