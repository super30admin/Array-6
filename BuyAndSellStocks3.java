//TC: O(N)
//SC: O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MAX_VALUE;
        int sell1 = 0;
        int buy2 = Integer.MAX_VALUE;
        int sell2 = 0;

        for(int price : prices){
            //System.out.println("price : "+price);
            buy1 = Math.min(buy1,price);
            sell1 = Math.max(sell1,price-buy1);

            buy2 = Math.min(buy2,price-sell1);
            sell2 = Math.max(sell2,price-buy2);
            // System.out.println("buy1 : "+buy1+" sell1 : "+sell1+" buy2 : "+buy2+" sell2 : "+sell2);
            //System.out.println();
        }

        return sell2;
    }
}