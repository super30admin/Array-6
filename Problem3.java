/*

This question is same as Buy and Sell Stock at Best Time III question, the only difference is that instead of atmost 2 , we need to find the best profit when given at most k transaction

We will use the same concept, we will do k transactions at each step and for each transaction , we will take the proifit intio the account of the previous transaction when buying i,e when buying we will take the minimum of prev buy and current price - the prev profit

Approach:

Since we will be dealing with buy and profit, create and array of buy and profit of size k

initialize all the buy with the 0 index of prices

Start iterating over the prices, calculate the buy1 (which is buy[0]) and profit 1 (which is profit[0]) first then itrate from 1 to k to keep calculating the profits which taking the previous profit into the account. Keep recording the max in the process, and return the max at the end

Time : O(n*k)
Space : O(k)
*/


class Solution {
    public int maxProfit(int k, int[] prices) {

        int[] buy = new int[k];
        int[] profit = new int[k];

        int max =0;

        // initializing the buy
        for(int i=0;i<k;i++){
            buy[i]= prices[0];
        }

        for(int i=1;i<prices.length;i++){
            buy[0] = Math.min(buy[0] , prices[i]);
            profit[0] = Math.max (profit[0] , prices[i] - buy[0]);
             max = Math.max(max , profit[0]);
            for(int j=1;j<k;j++){
            buy[j] = Math.min(buy[j] , prices[i] - profit[j-1]);
            profit[j] = Math.max (profit[j] , prices[i] - buy[j]);
            max = Math.max(max , profit[j]);
            }
        }
        

        return max;
    }
}