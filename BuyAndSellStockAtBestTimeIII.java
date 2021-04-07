//TC:O(N)
//SC:O(1)
//Did it run successfully on Leetcode?:Yes
class Solution {
    public int maxProfit(int[] prices) {
            if ( prices == null || prices.length == 0)
                return 0;
            int buy1 = Integer.MAX_VALUE;  int sell1 = 0;
            int buy2 = Integer.MAX_VALUE;  int sell2 = 0;
            for ( int i = 0; i < prices.length; i++){
                //buy1 and sell1 for profit earned from single transaction
                buy1 = Math.min(buy1, prices[i]);
                sell1 = Math.max(sell1, prices[i] - buy1);
                // if there ia a profit from one transaction, that profit is combined with 2nd transcation
                buy2 = Math.min(buy2, prices[i] - sell1);  //buy2 represents effective profit  
                sell2 = Math.max(sell2, prices[i] - buy2);
            }
        return sell2;
        }
    }

