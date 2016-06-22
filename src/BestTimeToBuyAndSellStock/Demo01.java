package BestTimeToBuyAndSellStock;

public class Demo01 {
	public int maxProfit(int[] prices) {
		int length = prices.length;

		if (length <= 1) {
			return 0;
		}

		int minPrice = prices[0];
		int maxProfit = 0;
		for (int i = 1; i < length; i++) {
			minPrice = Math.min(minPrice, prices[i]);
			maxProfit = Math.max(maxProfit, prices[i] - minPrice);
		}

		return maxProfit;
	}
}
