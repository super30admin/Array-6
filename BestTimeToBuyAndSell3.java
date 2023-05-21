class Solution {

    //Time Complexity: o(n) where n is the elements in the prices array
    //Space Complexity: 0(1)

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }

        int buy1 = Integer.MAX_VALUE;   //I use 4 variable to compute my total profit after performming 1 or 2 transactions
        int sell1 = Integer.MIN_VALUE;
        int buy2 = Integer.MAX_VALUE;   //this takes my previous profit from 1st transaction if any and reinvests to get my current buying price down
        int sell2 = Integer.MIN_VALUE;

        for(int i = 0; i < prices.length; i++){
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max(sell1, prices[i] - buy1);
            buy2 = Math.min(buy2, prices[i] - sell1);
            sell2 = Math.max(sell2, prices[i] - buy2);
        }

        return sell2;
    }
}