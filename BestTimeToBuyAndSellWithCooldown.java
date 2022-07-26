//Exhaustive Approach
class Solution {

    //Time Complexity: 0(2^n) where 2 is the buy and sell and n is the elements in prices array
    //Space Complexity : 0(2 ^n)

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }

        return helper(prices, -1, 0, 0) ;
    }

    public int helper(int [] prices, int prevBuy, int profit, int index){
        //base
        if(index >= prices.length){
            return profit;
        }
        //logic
        //Buy State
        if(prevBuy == -1){
            //Do not buy case
            int case1 = helper(prices, -1, profit, index + 1);  //as I don't buy, the status will remain -1, profit will remain as it is, I will move my index
            //Buy Case
            int case2= helper(prices, prices[index], profit, index + 1);    //If I buy, I will buy at the price where my recursion is in prices array

            return Math.max(case1, case2);  //I return the max of 2 to maximize profit
        }
        //Sell State
        else{
            //Do not sell
            int case3 = helper(prices, prevBuy, profit, index + 1); //I am not selling so no changes
            //Sell case
            int case4 = helper(prices, -1, profit + prices[index] - prevBuy, index + 2);    //i am selling so i need to change my state to -1 which indicates buy state, calculate the profit and move index +2 because +1 is cooldown

            return Math.max(case3, case4);
        }
    }
}

//DP
class Solution {

    //Time Complexity: 0(n) where n is the no. of elements in prices array
    //Space Complexity: 0(n)

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }

        int n = prices.length;
        int [] buy = new int[n];    //taking a buy array to compute not buy and buy state
        int [] sell = new int [n];  //sell array to compute no sell and sell state

        buy[0] = -prices[0];    //initially I am giving money out of my pocket so -the price at I bought
        buy[1] = Math.max(buy[0], 0 - prices[1]);   //1st index will have the max of 0 index and current buy
        sell[1] = Math.max(0, prices[1] +  buy[0]); //sell[0] is already initialized to 0, for sell[1], i compute max between 0 and prices[1] and buy[0]

        for(int i = 2; i < n; i++){
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]); //buy at any index will be the max between the prev buy and the difference between 2 sells backward(because of cooldown) and current price
            sell[i] = Math.max(sell[i - 1], prices[i] + buy[i - 1]);    //sell will be the max between prev sell and sum of current price and prev buy price
        }

        return Math.max(buy[n - 1], sell[n - 1]);   //at end i return max
    }
}