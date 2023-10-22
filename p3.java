// Time Complexity :O(nk)
// Space Complexity :O(k)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach


class Solution {
    public int maxProfit(int k, int[] prices) {
        int[] buy = new int[k];
        int[] sell = new int[k];
        int buy1 = prices[0];
        int buy2 = buy1;
        int sell1 = 0;
        int sell2 = 0;
        //go through all the prices
        for(int i=0; i<prices.length; i++){
            for(int j=0; j<k;j++){
                if(i ==0){
                    buy[j] = prices[i];
                    sell[j] = 0;
                }else{
                    if(j>0) buy[j] = Math.min(buy[j], prices[i] - sell[j-1]);
                    else buy[j] = Math.min(buy[j], prices[i]);
                    sell[j] = Math.max(sell[j], prices[i] - buy[j]);
                }
                // System.out.print(buy[j] + " " + sell[j] + " ");
            }
            //minimum amount at which we can buy
            // buy1 = Math.min(buy1, prices[i]);
            //max profit
            // sell1 = Math.max(sell1, prices[i] - buy1);
            //min amount to buy for second time considering the first profit
            // buy2 = Math.min(buy2, prices[i] - sell1);
            //max profit I can get
            // sell2 = Math.max(sell2, prices[i] - buy2);
            // System.out.println(" ");
        }
        return sell[k-1];
    }
}