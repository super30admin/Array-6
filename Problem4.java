/*

and a sell state, so we will look into both the states each day.


Buy State


In buy state we will calculate buy profit (buy profit is the profit left after subtracting the buy price from the selling profit) , we have two choices, however, we will stick with the choice which would give us the max profit:


 - Choose (buy):  we are looking to buy a stock price. Whenever we buy, we will subtract from the max selling profit we got day before yesterday, because, we 
have a cooldown so we must have sold something day before yesterday and then waited yesterday for the cooldown and then buying today.
 - Not Choose (not buy) : If we don't choose to buy, then the buy profit is the same as yesterday.


Formula : Max ( sell[i-2]  - prices[i] , buy[i-1])




Sell State


In sell state, we will calculate the best selling profit, we will have two choices and we will choose the choice which is giving us the best profit


- Choose (Sell) : If we decide to sell , then in order to calculate the selling profit we need to know the buy price. Since the buy profit we are actually subtracting from the profit the buy price, we can add the current value of the stock to yesterday's buy profit to calculate the selling profit. The intuition is to subtract the buy price right? but keep in mind that we are maintaining the buy profit as a subtraction of buy price from the profit, so only in this case we will add the current price with the yesterday's buy profit (not buy price)


- Not Choose (Not Sell) : If we decide that we do not sell, then the selling profit would be the same as yesterday's selling profit


Formula : Max( buy[i-1] + prices[i] , sell[i-1])


Algorithm:


1)Maintain two tables buy and sell. 
2) initially calculate the buy and sell for the first two values
3) the first buy would be 0 - price[0] and the first sell would be 0
4) the second buy would be the best of first and 0 - price[1]
5) the second sell would be the max between prev sell and prev buy + the price[1]
6) the above is same as filling the first two values of the dp table by using the formula
7) the table should be of same length as the prices
8) starting from the 2nd element of prices, keep filling the buy using the buy formula and sell using the sell formula
9) return the sell ‘s last value




Time : O(n)
Space : O(n)



*/



class Solution {
    public int maxProfit(int[] prices) {

        // we need create a dp table for buy and sell

        // the profit left after buying and profit earned after selling
        if(prices.length <=1) return 0;

        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];

        buy[0] = 0 - prices[0]; // since the initial profit would be 0 , so we will subtract the initial price by 0
        sell[0] = 0; // initial profit for selling is 0

        buy[1] = Math.max(buy[0], sell[0] - prices[1]); // Max between ( not choose, choose)
        sell[1] = Math.max(sell[0] , prices[1] + buy[0]);// Max between ( not choose, choose)

        for(int i=2 ; i< prices.length; i++){
            buy[i] = Math.max(
                // not choose , if I am not choosing to buy, then my buy profit till now would the same as of yesterday's'
                buy[i-1] , 
                //choose , if I choose to buy, then I must have sold something day before yestedfat, so taking the selling profit from that and then subtracting the buying price
                sell[i-2] - prices[i]
            ); 
            sell[i] = Math.max(
                // not choose , if I dont sell, then my selling profit is same as of yesterday
                sell[i-1] ,
                // choose
                buy[i-1] + prices[i]
            );
        }

        return sell[prices.length - 1];

        
    }
}s