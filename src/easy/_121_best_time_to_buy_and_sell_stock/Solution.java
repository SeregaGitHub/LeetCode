package easy._121_best_time_to_buy_and_sell_stock;

public class Solution {
    public static void main(String[] args) {

        int[] prices0 = {17, 16, 15, 10, 8, 7, 6};
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices11 = {7, 2, 5, 1, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};
        int[] prices22 = {7};
        int[] prices222 = {};

        System.out.println(maxProfit(prices1));
    }

    private static int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int totalResult = 0;

        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                int currentResult = prices[right] - prices[left];
                totalResult = Math.max(totalResult, currentResult);
            } else {
                left = right;
            }
            right++;
        }
        return totalResult;
    }
}
