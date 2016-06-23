package climbStairs;

public class ClimbStairs {
	public int climbStairs(int n) {
		if (n == 0 || n == 1 || n == 2) {
			return n;
		}
		int one = 2;
		int two = 1;
		int all = 3;
		for (int i = 3; i <= n; i++) {
			all = one + two;
			two = one;
			one = all;
			
		}
		return all;
	}
}
