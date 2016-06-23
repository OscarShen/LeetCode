package bestTimeToBuyAndSellStockIII;

public class BestTimeToBuyAndSellStockIII {
	private int first_start = 0;
	private int first_end = 0;

	public int maxProfit(int[] prices) {
		int first = first_Profit(prices);
		int second = second_Profit(prices);
		return first + second;
	}

	public int second_Profit(int[] prices) {
		int[] left_prices = new int[first_start + 1];
		System.arraycopy(prices, 0, left_prices, 0, first_start + 1);
		int second_thisProfit1 = first_Profit(left_prices);

		int[] right_prices = new int[prices.length - first_end + 1];
		System.arraycopy(prices, first_end, right_prices, 0, prices.length
				- first_end + 1);
		int sendcond_thisProfit2 = first_Profit(right_prices);
		return second_thisProfit1 > sendcond_thisProfit2 ? second_thisProfit1
				: sendcond_thisProfit2;
	}

	public int first_Profit(int[] prices) {
		int first_maxProfit = 0;
		int first_thisProfit = 0;
		int[] profits = new int[prices.length];

		for (int i = 0; i < prices.length - 1; i++) {
			profits[i] = prices[i + 1] + prices[i];
			first_thisProfit += profits[i];
			if (first_thisProfit > first_maxProfit) {
				first_maxProfit = first_thisProfit;
				first_end = i;
			}
			if (first_thisProfit < 0) {
				first_thisProfit = 0;
			}
		}

		first_thisProfit = 0;
		for (int i = first_end; i >= 0; i--) {
			first_thisProfit += profits[i];
			if (first_thisProfit == first_maxProfit) {
				first_start = i;
				break;
			}
		}

		return first_maxProfit;
	}
}
