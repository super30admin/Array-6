// Time: O(n)
// Space: O(n)

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        if (prices.length < 2) return 0;
        int [] buy = new int [prices.length];
        int [] sell = new int [prices.length];
        buy[0] = -prices[0];
        sell[0] = 0;
        buy[1] = Math.max(buy[0], 0-prices[1]);
        sell[1] = Math.max(sell[0], prices[1] + buy[0]);
        for (int i = 2; i < prices.length; i++){
            buy[i] = Math.max(buy[i-1],sell[i-2]-prices[i]);
            sell[i] = Math.max(sell[i-1],prices[i]+buy[i-1]);
        }
        return sell[prices.length-1];
    }
}


/////////////////////

// Time: O(n)
// Space: O(1)

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        if (prices.length < 2) return 0;
        // int [] buy = new int [prices.length];
        // int [] sell = new int [prices.length];
        // buy[0] = -prices[0];
        // sell[0] = 0;
        // buy[1] = Math.max(buy[0], 0-prices[1]);
        // sell[1] = Math.max(sell[0], prices[1] + buy[0]);
        // for (int i = 2; i < prices.length; i++){
        //     buy[i] = Math.max(buy[i-1],sell[i-2]-prices[i]);
        //     sell[i] = Math.max(sell[i-1],prices[i]+buy[i-1]);
        // }
        // return sell[prices.length-1];
        
        int b0 = -prices[0];
        int b1 = Math.max(b0, 0-prices[1]);
        int s0 = 0;
        int s1 = Math.max(s0, prices[1] + b0);
        
        for(int i = 2; i < prices.length; i++){
            int tempb1 = b1;
            b1 = Math.max(b1, s0-prices[i]);
            s0 = s1;
            s1 = Math.max(s1, prices[i]+tempb1);
        }
        
        return s1;
    }
}



