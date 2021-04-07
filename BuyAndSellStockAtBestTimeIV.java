//TC: O(N*k)
//SC: O(k)
//Did it run successfully on Leetcode? :Yes
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        // if k > prices.length/2, then we can just take all profits
        if (k > prices.length/2){
            int profit = 0;
            for (int i = 0; i < prices.length -1 ; i++){
                if (prices[i] < prices[i+1])
                   profit = profit + (prices[i+1] - prices[i]);
            }
            return profit;
        }
        
        int[] buy = new int[k+1];
        int[] sell = new int[k+1];
        Arrays.fill(buy, Integer.MAX_VALUE);
        for (int i = 0; i < prices.length; i++){   //O(N)
            for ( int j = 1; j < buy.length; j++){ //O(k)
                buy[j] = Math.min(buy[j], prices[i] - sell[j-1]);
                sell[j] = Math.max(sell[j], prices[i] - buy[j]);
            }
        }
        return sell[k];
    }
}

// 1 ,2, 3, 4, 5, 6
