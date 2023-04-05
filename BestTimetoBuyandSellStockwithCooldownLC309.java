class Solution {


    //Approach 3
    //Time Complexity: O(n)
    //Space Complexity: O(1)

    public int maxProfit(int[] prices) {
        
        if(prices == null || prices.length < 2) return 0;

        int prevPrevSell = 0;                                               //create a variable to store the prevPrevSell
        int prevBuy = Math.max(-prices[0], -prices[1]);                     //create a variable to store prevBuy
        int prevSell = Math.max(prevPrevSell, prices[1] - prices[0]);       //create a variable to store prevSell

        for(int i=2; i<prices.length; i++){                                 //iterate through price array

            //here, we are taking max in both cases either buy, not buy case or sell and not sell case, because we are considering a profit in each case, and we have to maximize our profit, so

            int tempPrevSell = prevSell;                                    //store the prevSell value into tempPrevSell
            
            prevSell = Math.max(prevSell, prices[i] + prevBuy);             //update the prevSell value by taking maximum value between prevSell which is not sell case and prices[i] + prevBuy which is sell case
            
            prevBuy = Math.max(prevBuy, prevPrevSell - prices[i]);          //update the prevBuy value by taking the maximum value between prevBuy which is not buy case and other is prevPrevSell - prices[i] which is buy case, here we are taking profit from prevPrevSell because we have a cool down period for one day so if we sold today, then we can't buy tommorow
        
            prevPrevSell = tempPrevSell;                                    //update the prevPrevSell value to tempPrevSell which basically earlier prevSell value
        }
        return prevSell;
    }




    // //Approach 2
    // //Time Complexity: O(n)
    // //Space Complexity: O(n)

    // public int maxProfit(int[] prices) {
        
    //     if(prices == null || prices.length < 2) return 0;
        
    //     int[] buy = new int[prices.length];                          //create buy array in whoch we are storing profit
    //     int[] sell = new int[prices.length];                         //create a sell array in which we are storing profit

    //     buy[0] = -prices[0];                                         //update buy[0] value to -prices[0], as we are buying so profit till now is 0 and we buy the stock to profit becomes -prices[0]
    
    //     buy[1] = Math.max(buy[0], -prices[1]);                       //update the buy[1] to maximum between buy[0] and prices[1] which is basically not buy and buy case

    //     sell[1] = Math.max(0, prices[1] + buy[0]);                   //update the sell[1] to maximum between 0 and prices[1]+ buy[0], which is basically not sell and sell case

    //     for(int i=2; i<prices.length; i++){                          //itearate through prices array

    //         buy[i] = Math.max(buy[i-1], sell[i-2] - prices[i]);      //update buy[i] value by taking maximum between buy[i-1] which is not buy case and sell[i-2] - prices[i] which is buy case, here we are taking sell[i-2] because we have cooldown period of one day so we have to consider profit from the 2 days earlier sell and current buy price and subtract that values to get the current buy profit

    //         sell[i] = Math.max(sell[i-1], prices[i] + buy[i-1]);     //update the sell[i] value by taking maximum between sell[i-1] which is not sell case and prices[i]+buy[i-1] which is sell case 
    //     }
    //     return sell[prices.length-1];                                //return the last value of sell array which is profit
    // }



    //Approach 1, Time Limit Exceed error
    //Time Complexity:
    //Space Complexity:
    
    // public int maxProfit(int[] prices) {
        
    //     if(prices == null || prices.length == 0) return 0;
    //     return recurse(prices, 0, -1, 0);
    // }

    // private int recurse(int[] prices, int index, int prevBuy, int profit){

    //     if(index >= prices.length) return profit;

    //     if(prevBuy  == -1){

    //         //not buy
    //         int case1 = recurse(prices, index+1, prevBuy, profit);
            
    //         //buy
    //         int case2 = recurse(prices, index+1, prices[index], profit);

    //         return Math.max(case1, case2);
    //     }
    //     else{
            
    //         //not sell
    //         int case1 = recurse(prices, index+1, prevBuy, profit);
            
    //         //sell
    //         int case2 = recurse(prices, index+2, -1, profit + prices[index] - prevBuy);

    //         return Math.max(case1, case2);  
    //     }
    // }
}
