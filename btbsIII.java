class Solution {
    public int maxProfit(int[] prices) {
        // Tc: O(n) Sc: O(1)
        if (prices == null || prices.length == 0)
            return 0;

        int firstBuy = Integer.MAX_VALUE;
        int firstProfit = 0;
        int secondBuy = Integer.MAX_VALUE;
        int secondProfit = 0;

        for (int price : prices) {

            firstBuy = Math.min(firstBuy, price);

            firstProfit = Math.max(firstProfit, price - firstBuy);

            secondBuy = Math.min(secondBuy, price - firstProfit);

            secondProfit = Math.max(secondProfit, price - secondBuy);
        }

        return secondProfit;
    }

}

/*
 * //DP Solution
 * 
 * class Solution {
 * public int maxProfit(int[] prices) {
 * // Tc: O(n) Sc: O(n)
 * int n = prices.length;
 * if (n == 0)
 * return 0;
 * 
 * int[] dp1 = new int[n];
 * int[] dp2 = new int[n];
 * 
 * int minPrice = prices[0];
 * for (int i = 1; i < n; i++) {
 * minPrice = Math.min(minPrice, prices[i]);
 * dp1[i] = Math.max(dp1[i - 1], prices[i] - minPrice);
 * }
 * 
 * int maxPrice = prices[n - 1];
 * for (int i = n - 2; i >= 0; i--) {
 * maxPrice = Math.max(maxPrice, prices[i]);
 * dp2[i] = Math.max(dp2[i + 1], maxPrice - prices[i]);
 * }
 * 
 * int maxProfit = 0;
 * for (int i = 0; i < n; i++) {
 * maxProfit = Math.max(maxProfit, dp1[i] + dp2[i]);
 * }
 * 
 * return maxProfit;
 * }
 * 
 * }
 * 
 */

/*
 * //Bruteforce solution - TLE
 * class Solution {
 * public int maxProfit(int[] prices) {
 * //Tc: O(n^4) Sc: O(1)
 * int n = prices.length;
 * int maxProfit = 0;
 * 
 * for (int i = 0; i < n; i++) {
 * for (int j = i + 1; j < n; j++) {
 * 
 * int profit1 = prices[j] - prices[i];
 * 
 * for (int k = j + 1; k < n; k++) {
 * for (int l = k + 1; l < n; l++) {
 * 
 * int profit2 = prices[l] - prices[k];
 * 
 * int totalProfit = profit1 + profit2;
 * maxProfit = Math.max(maxProfit, totalProfit);
 * }
 * }
 * 
 * maxProfit = Math.max(maxProfit, profit1);
 * }
 * }
 * 
 * return maxProfit;
 * 
 * }
 * }
 * 
 */