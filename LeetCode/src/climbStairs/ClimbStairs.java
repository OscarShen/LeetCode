package climbStairs;

public class ClimbStairs {
	public int climbStairs(int n) {
		if (n == 0 || n == 1 || n == 2) {
			return n;
		}
		int one_step_before = 2;
		int two_step_before = 1;
		int all_ways = 3;

		for (int i = 3; i <= n; i++) {
			all_ways = one_step_before + two_step_before;
			two_step_before = one_step_before;
			one_step_before = all_ways;
		}
		return all_ways;
	}
}
