package array.bestTimeToBuyAndSellStockII;

public class BestTimeToBuyAndSellStockII {
	public int maxProfit(int[] prices) {
		if (prices.length == 0 || prices.length == 1) {
			return 0;
		}

		int maxProfit = 0;

		for (int i = 1; i < prices.length; i++) {
			int dayProfit = prices[i] - prices[i - 1];
			if (dayProfit > 0) {
				maxProfit += dayProfit;
			}
		}
		return maxProfit;
	}
}
