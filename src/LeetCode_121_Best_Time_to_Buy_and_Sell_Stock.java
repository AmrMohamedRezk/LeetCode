public class LeetCode_121_Best_Time_to_Buy_and_Sell_Stock {

	public int maxProfit(int[] prices) {
		if(prices==null)
			return 0;
		int min = prices[0];
		int max = 0;
		for (int i = 1; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			max = Math.max(max, prices[i]-min);
		}
		return max;
	}
	public static void main(String[] args) {
		
	}
}
