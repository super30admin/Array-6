//Time Complexity O(N)
//Space Complexity O(N) 
//Leetcode tested

public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0) return 0;
        int[] left= new int[n];
        int[] right= new int[n];
        int min = prices[0];
        for (int i = 1; i < n; i++) {
            if(prices[i] < min) min = prices[i];
            left[i] = Math.max(left[i-1],prices[i] - min);
        }
        int max = prices[n-1];
        for (int i = n-2; i >=0; i--) {
            if(prices[i] > max) max = prices[i];
            right[i] = Math.max(right[i+1],max - prices[i]);
        }
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit,left[i]+right[i]);
        }
        return maxProfit;
    }
}
