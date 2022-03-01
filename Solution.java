class Solution {
    public int maxProfit(int k, int[] prices) {
        //o(nK) time and o(n) space
        if(k == 0) return 0;
        int [] buy = new int[k];
        int [] sell = new int[k];
        Arrays.fill(buy, Integer.MAX_VALUE);
        for(int i = 0; i < prices.length; i++){
            for(int j = 0; j < k; j++){
                if(j > 0){
                    buy[j] = Math.min(buy[j], prices[i] - sell[j-1]);
                } else {
                    buy[j] = Math.min(buy[j], prices[i]);
                }
                sell[j] = Math.max(sell[j], prices[i] - buy[j]);
            }
        }
        return sell[k-1];
    }
}