//TC: O(n), where n is the length of the given prices array
//SC: O(1)
//running on leetcode: yes
class Solution {
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length<=1){
            return 0;
        }
        int min_price = prices[0];
        int max_profit = 0; //Integer.MIN_VALUE;
        for (int i=1; i<prices.length; i++){
            min_price = Math.min(prices[i],min_price);
            max_profit = Math.max(max_profit, (prices[i]-min_price));
        }
        return max_profit;
    }
}
