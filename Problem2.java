/*

The question is asking to get the max profit when we are allowed to have at most 2 transactions.

At each step, we will explore both option, that is what is the best profit I can get in one transaction 
and what is the best profit I can get when I do the 2nd transaction. At the end whichever is giving us the best output ,we will get that

We will try to reinvest the profit gained from transaction 1 in the price of 2nd transaction to get the max output

When buying we will always be taking min from previous buy and current price,
When profit, we will always taking the max from prev profit and current calculated profit

Approach:

we will maintain 4 variables, buy1 , buy2 , profit1 and profi2 .
The buy1 and buy2 would be initialized with the very first price and then we will itrate from the next index onwards

buy1 would be min of prev buy1 and current price
profit1 would be max of prev profi1 and currentprice minus buy1

since for second transaction we are re investing the profit in the price of buy2, 
buy2 would be min of prev buy2 and current price minus profi1
profit2 would be max of prev profi2 and currentprice minus buy2

Time: O(n)
Space : O(1)
*/

class Solution {
    public int maxProfit(int[] prices) {

        int finalProfit  =0;

        int buy1=prices[0],buy2=prices[0];
        int profit1=0, profit2 = 0;
        for(int i=1;i<prices.length;i++){
            // min between earlier buy1 and current
            buy1 = Math.min(buy1, prices[i]);
            profit1 = Math.max(profit1 ,prices[i] - buy1 );
            //min between earlier buy2 and currrent - profit of 1
            buy2 = Math.min(buy2, prices[i] - profit1); // reinvenst the profit earned from transaction1 into the price of 2nd stock 
            profit2 = Math.max(profit2, prices[i] - buy2);
        }
        finalProfit = Math.max (profit1, profit2);

        return finalProfit;
        
    }
}