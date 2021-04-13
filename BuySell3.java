/*
method1:
brute force:O(n ^3)


method2:
calculate the effective price
will make 2 transactions and then take max of profit 
buy1 sell1, buy2 sell2

TC:O(n)
SC:O(n)

*/
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0)return 0;
        
        int buy1 = Integer.MAX_VALUE;
        int sell1 = Integer.MIN_VALUE;
        int buy2 = Integer.MAX_VALUE;
        int sell2 = Integer.MIN_VALUE;
        
        for(int i = 0;i < prices.length;i++){
            
            //max profit if only 1 transaction is allowed
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max(sell1, prices[i] - buy1);
            
           
            buy2 = Math.min(buy2, prices[i] - sell1); //better point to start the second transaction so that sell2 can be maximised
            sell2 = Math.max(sell2, prices[i]-buy2); 
        }
        
        return sell2;
        
    }
}