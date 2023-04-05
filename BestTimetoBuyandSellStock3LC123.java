class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(1)

    public int maxProfit(int[] prices) {

        if(prices == null || prices.length == 0) return 0;

        int buy1 = prices[0];                       //create buy1 which basically stores buy value for 1st transaction
        int sell1 = prices[0] - buy1;               //create sell1 which basically stores the profit from 1st transaction
        int buy2 = prices[0] - sell1;               //create buy2 which basically stores the buy value for 2nd transaction and from which we are subtraction 1st transaction profit to get the consolidate profit for 2 transaction in sell2
        int sell2 = prices[0] - buy2;               //create sell2 which basically stores the profit for 2 transation if required, it might be a case when only 1 transaction is getting us the maximum profit, and that's why we are sutracting the first trasaction profit from the buy2, so we can handle those scenarios as well

        for(int i=1; i<prices.length; i++){         //iterate through array

            buy1 = Math.min(buy1, prices[i]);               //take minimum between earlier buy1 and current price
            sell1 = Math.max(sell1, prices[i] - buy1);      //take maximum between earlier sell1 and current profit
            buy2 = Math.min(buy2, prices[i] - sell1);          //take minimum between earlier buy2 and current buy
            sell2 = Math.max(sell2, prices[i]-buy2);            //take maximum between earlier sell2 and current profit
        }
        return sell2;
    }
}
