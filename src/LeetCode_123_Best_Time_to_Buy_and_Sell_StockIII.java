public class LeetCode_123_Best_Time_to_Buy_and_Sell_StockIII {
	public int maxProfit(int[] prices) {
		int[] before = new int[prices.length];
		int[] after = new int[prices.length];
		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			before[i] = Math.max(before[i - 1], prices[i] - min);
		}
		int max = prices[prices.length - 1];
		for (int i = prices.length - 2; i >= 0; i--) {
			max = Math.max(max, prices[i]);
			after[i] = Math.max(after[i + 1], max - prices[i]);
		}
		max = Integer.MIN_VALUE;
		for (int i = 0; i < prices.length; i++)
			max = Math.max(max, before[i] + after[i]);
		return max;
	}
}
