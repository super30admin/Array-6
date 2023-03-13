// Time Complexity :  O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];   
        int profit = 0;
        for (int i=1;i<prices.length;i++){
            if (prices[i] < minPrice){
                minPrice=prices[i];
            } else {
                profit = Math.max(profit, prices[i]-minPrice);
            }
        }
        return profit;
    }
}