class Solution {

    //Time Complexity: O(n*k)
    //Space Complexity: O(k)

    public int maxProfit(int k, int[] prices) {

        if(prices == null || prices.length == 0) return 0;              //check for null case

        if(k > prices.length/2){                                        //check if we are allowed to do more than half of price length transaction or not
            
            int result = 0;                                             //if yes, means at most we can do half of length of prices transaction, but here we are allowed to do more than that, then we are just iterating through price array and check if we make any profit in the next day, if yes, then just do that transaction, if we are going like this, we can at most do prices.length/2 transation, and we are allowed to do more than that, so, that's why we used this approach if we are allowed to do more than prices.length/2 transacations

            for(int i=0; i<prices.length-1; i++){

                if(prices[i+1] > prices[i]){
                    result += prices[i+1] - prices[i];
                }
            }
            return result;
        }

        int[] buy = new int[k+1];                                   //otherwise, create buy array
        int[] sell = new int[k+1];                                  //create a sell array which stores the profit at each transation

        Arrays.fill(buy, Integer.MAX_VALUE);                    //fill buy array with maximum value

        for(int i=0; i<prices.length; i++){                             //iterate through prices
            for(int j=1; j<=k; j++){                                    //iterate through all transaction
                
                buy[j] = Math.min(buy[j], prices[i]- sell[j-1]);            //take minimum between earlier buy and current price - earlier profit
                sell[j] = Math.max(sell[j], prices[i] - buy[j]);            //take maximum between earlier profit and current selll
            }
        }
        return sell[k];                                                 //return the last transation's profit
    }
}
