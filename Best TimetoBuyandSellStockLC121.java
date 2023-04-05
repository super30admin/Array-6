class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    
    public int maxProfit(int[] prices) {
        
        int profit=0;                           //to store the maximum profit
        int min=prices[0];                      //to store the minimum stock price

        //if they ask about the buy and sell price
        // int buy = 0;
        // int sell = 0;
        
        for(int i=0;i<prices.length;i++)       //iterate through array
        {
            min = Math.min(min, prices[i]);                 //update the minimum stock price if current stock price is minimum
         
            // if(prices[i] - min > profit){
            //     buy = min;
            //     sell = prices[i];
            // }
         
            profit = Math.max(profit, prices[i] - min);     //update the profit if current profit is maximum than the earlier one
        }

        // System.out.println(buy);
        // System.out.println(sell);
        return profit;                          //return the profit       
    }


    //Time Complexity: O(n)
    //Space Complexity: O(1)

    // public int maxProfit(int[] prices) {
        
    //     int profit=0;                           //to store the maximum profit
    //     int min=prices[0];                      //to store the minimum stock price
        
    //     for(int i=0;i<prices.length;i++)       //iterate through array
    //     {
    //         if(min>prices[i])                   //check if current stock price is minimum than the current minimum
    //         {
    //             min=prices[i];                  //if yes, then update the minimum stock price
    //         }
    //         if(profit<prices[i]-min)            //check if profit is smaller than the current profit
    //         {
    //             profit=prices[i]-min;           //if yes, then update the profit
    //         }
    //     }
    //     return profit;                          //return the profit
        
    // }
}
