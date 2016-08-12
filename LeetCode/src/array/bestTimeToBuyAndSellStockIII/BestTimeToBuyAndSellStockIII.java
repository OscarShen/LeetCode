package array.bestTimeToBuyAndSellStockIII;

public class BestTimeToBuyAndSellStockIII {
	public int maxProfit(int[] prices) {
		int n = prices.length;
		int[] preProfit = new int[n];
		int[] postProfit = new int[n];

		if (n < 2) {
			return 0;
		}

		int curMin = prices[0];
		for (int i = 1; i < n; i++) {
			curMin = Math.min(curMin, prices[i]);
			preProfit[i] = Math.max(preProfit[i - 1], prices[i] - curMin);
		}

		int curMax = prices[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			curMax = Math.max(curMax, prices[i]);
			postProfit[i] = Math.max(postProfit[i + 1], curMax - prices[i]);
		}

		int maxProfit = 0;
		for (int i = 0; i < n; i++) {
			maxProfit = Math.max(maxProfit, preProfit[i] + postProfit[i]);
		}

		return maxProfit;
	}
}
