package LeetCode;

public class MaxProfit {

    //买卖股票的最佳时机
    public int maxProfit0(int[] prices) {
        int min_price = Integer.MAX_VALUE;
        int max_profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min_price) {
                min_price = prices[i];
            }
            if (max_profit < prices[i] - min_price) {
                max_profit = prices[i] - min_price;
            }
        }
        return max_profit;
    }

    public int maxProfit1(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length; ) {
            int price = prices[i];
            while (i < prices.length - 1 && prices[i] < prices[i + 1]) {
                i++;
            }
            profit = profit + prices[i] - price;
        }
        return profit;
    }

    public int maxProfit2(int[] prices) {
        int max_k = 2;
        int[][][] dp = new int[prices.length][max_k + 1][2];
        for (int i = 0; i < prices.length; i++) {
            for (int k = 1; k <= 2; k++) {
                if (i == 0) {
                    dp[0][k][1] = -prices[0];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);

//                dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
//                dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i]);
//                dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
//                dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[1]);
            }
        }
        return dp[prices.length - 1][2][0];
    }
}
