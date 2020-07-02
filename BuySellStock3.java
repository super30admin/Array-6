// 123.
// brute force - initially do only one transaction (best time to buy sell stock 1) and store it in result
// then for each day i try to sell on day j from i + 1 to n - 2 to get profit - do one mare transaction - time - O(n^2)
// time - O(n)
// space - constant
class Solution {
    public int maxProfit(int[] prices) {
        //buy1 tracks the min price on the left so far
        //sell1 tracks the largest profit earned so far (buying at the price tracked by buy1)
        int buy1 = Integer.MAX_VALUE;
        int sell1 = 0;
        //buy2 at a point is the effective price at that point (price - profit earned by making 1 transaction i.e sell1)
        //sell2 tracks is largest profit by making 2 transactions so far
        int buy2 = Integer.MAX_VALUE;
        int sell2 = 0;
        
        for(int price : prices)
        {
            buy1 = Math.min(buy1, price); //update the min on the left if it is larger than current price
            sell1 = Math.max(sell1, price - buy1); //sell at this price after buying at buy1, find profit and update sell1
            buy2 = Math.min(buy2, price - sell1); //the effective price at this point becomes actual price - profit so far
            sell2 = Math.max(sell2, price - buy2); //sell at this price after buying at effective price tracked by buy2
        }
        
        return sell2;
    }
}
