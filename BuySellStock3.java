//TC: O(n)
//SC: O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MAX_VALUE; int buy2 = Integer.MAX_VALUE;
        int sell1 = 0; int sell2 = 0;
        
        for(int price : prices){
            //for first transaction
            buy1 = Math.min(buy1, price);
            sell1 = Math.max(sell1, price - buy1);
            
            //profit of both transactions combined
            buy2 = Math.min(buy2, price - sell1); //adjusted price of second transaction (profit of first transaction included)
            sell2 = Math.max(sell2, price - buy2);
        }
        return sell2;
    }
}
